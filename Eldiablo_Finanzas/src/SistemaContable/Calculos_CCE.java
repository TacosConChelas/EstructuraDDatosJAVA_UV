/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaContable;

import SistemaContable.Cuentas_balance.CuentaFinanciera;
import SistemaContable.Cuentas_balance.GestorBalanceFinanciero;
import java.util.LinkedHashMap;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;

/**
 * Clase utilitaria para calcular el Ciclo de Conversión de Efectivo (CCE) directamente desde el balance.
 */
public class Calculos_CCE {

    /**
     * Calcula el CCE y los componentes de días usando SOLO los valores del GestorBalanceFinanciero.
     * Fórmulas:
     *  Días de Inventario = (Inventarios / Costo de Venta) * 365
     *  Días de Cartera = (Cuentas por Cobrar / Ventas) * 365
     *  Días de Cuentas por Pagar = (Cuentas por Pagar / Costo de Venta) * 365
     *  CCE = Días de Inventario + Días de Cartera - Días de Cuentas por Pagar
     *
     * @param cuentas GestorBalanceFinanciero con todas las cuentas cargadas.
     * @return LinkedHashMap<String, double[]> con todas las filas del CCE (componentes y el CCE) para los 4 años.
     */
    public static LinkedHashMap<String, double[]> calcularCCE(GestorBalanceFinanciero cuentas) {
        LinkedHashMap<String, double[]> resultado = new LinkedHashMap<>();

        if (cuentas == null) return resultado;

        // Buscar las cuentas necesarias
        CuentaFinanciera inventarios = cuentas.buscarPorNombre("Inventarios");
        CuentaFinanciera costoDeVenta = cuentas.buscarPorNombre("Costo de Venta");
        CuentaFinanciera cuentasPorCobrar = cuentas.buscarPorNombre("Cuentas por Cobrar");
        CuentaFinanciera ventas = cuentas.buscarPorNombre("Ventas");
        CuentaFinanciera cuentasPorPagar = cuentas.buscarPorNombre("Cuentas por Pagar");

        // Preparar los arreglos de resultados para 4 años
        double[] diasInventario = new double[4];
        double[] diasCartera = new double[4];
        double[] diasCuentasPorPagar = new double[4];
        double[] cce = new double[4];

        for (int i = 0; i < 4; i++) {
            // Días de Inventario
            if (inventarios != null && costoDeVenta != null) {
                double costo = costoDeVenta.obtenerValorAnual(i);
                diasInventario[i] = (costo != 0.0) ? (inventarios.obtenerValorAnual(i) / costo) * 365.0 : 0.0;
            } else {
                diasInventario[i] = 0.0;
            }

            // Días de Cartera
            if (cuentasPorCobrar != null && ventas != null) {
                double vtas = ventas.obtenerValorAnual(i);
                diasCartera[i] = (vtas != 0.0) ? (cuentasPorCobrar.obtenerValorAnual(i) / vtas) * 365.0 : 0.0;
            } else {
                diasCartera[i] = 0.0;
            }

            // Días de Cuentas por Pagar
            if (cuentasPorPagar != null && costoDeVenta != null) {
                double costo = costoDeVenta.obtenerValorAnual(i);
                diasCuentasPorPagar[i] = (costo != 0.0) ? (cuentasPorPagar.obtenerValorAnual(i) / costo) * 365.0 : 0.0;
            } else {
                diasCuentasPorPagar[i] = 0.0;
            }

            // CCE
            cce[i] = diasInventario[i] + diasCartera[i] - diasCuentasPorPagar[i];
        }

        // Agregar al resultado (mismo orden que la hoja de Excel)
        resultado.put("Días de Inventario", diasInventario);
        resultado.put("Días de Cartera", diasCartera);
        resultado.put("Días de Cuentas por Pagar", diasCuentasPorPagar);
        resultado.put("CCE", cce);

        return resultado;
    }
    
    /**
     * Aplica un aumento porcentual sobre los valores originales de cada componente del CCE,
     * y recalcula el CCE usando los nuevos valores.
     *
     * @param cceOriginal LinkedHashMap con los datos originales ("Días de Inventario", "Días de Cartera", "Días de Cuentas por Pagar", "CCE").
     * @param aumentoDiasInventario Porcentaje de aumento para "Días de Inventario" (ej. 10 para +10%), si es nulo o vacío se ignora.
     * @param aumentoDiasCartera    Porcentaje de aumento para "Días de Cartera" (ej. 10 para +10%), si es nulo o vacío se ignora.
     * @param aumentoDiasCuentasPorPagar Porcentaje de aumento para "Días de Cuentas por Pagar" (ej. 10 para +10%), si es nulo o vacío se ignora.
     * @return Nuevo LinkedHashMap<String, double[]> con los valores ajustados y el nuevo CCE recalculado.
     */
    public static LinkedHashMap<String, double[]> calcularWhatIfCCE(
            LinkedHashMap<String, double[]> cceOriginal,
            double aumentoDiasInventario,
            double aumentoDiasCartera,
            double aumentoDiasCuentasPorPagar) {

        LinkedHashMap<String, double[]> resultado = new LinkedHashMap<>();

        // Validar datos de entrada
        if (cceOriginal == null) return resultado;

        // Copia defensiva de los arreglos originales
        double[] diasInventario = copiaArreglo(cceOriginal.get("Días de Inventario"));
        double[] diasCartera = copiaArreglo(cceOriginal.get("Días de Cartera"));
        double[] diasCuentasPorPagar = copiaArreglo(cceOriginal.get("Días de Cuentas por Pagar"));

        

        // Multiplicar solo si hay porcentaje ingresado (>0)
        for (int i = 0; i < 4; i++) {
            if (aumentoDiasInventario > 0)   diasInventario[i]      = diasInventario[i] * (1.0 + aumentoDiasInventario / 100.0);
            if (aumentoDiasCartera > 0)  diasCartera[i]         = diasCartera[i] * (1.0 + aumentoDiasCartera / 100.0);
            if (aumentoDiasCuentasPorPagar > 0)   diasCuentasPorPagar[i] = diasCuentasPorPagar[i] * (1.0 + aumentoDiasCuentasPorPagar / 100.0);
        }

        // Calcular el nuevo CCE
        double[] cce = new double[4];
        for (int i = 0; i < 4; i++) {
            cce[i] = diasInventario[i] + diasCartera[i] - diasCuentasPorPagar[i];
        }

        // Guardar en el resultado en el mismo orden
        resultado.put("Días de Inventario", diasInventario);
        resultado.put("Días de Cartera", diasCartera);
        resultado.put("Días de Cuentas por Pagar", diasCuentasPorPagar);
        resultado.put("CCE", cce);

        return resultado;
    }

    /**
     * Realiza una copia defensiva de un arreglo double[]. Si el arreglo es null, regresa uno de ceros.
     */
    private static double[] copiaArreglo(double[] original) {
        double[] copia = new double[4];
        if (original != null) {
            for (int i = 0; i < Math.min(4, original.length); i++) {
                copia[i] = original[i];
            }
        }
        return copia;
    }

   /**
     * Genera la gráfica del Ciclo de Conversión de Efectivo (CCE).
     * Incluye las series: Días de Inventario, Días de Cartera, Días de Cuentas por Pagar, y CCE.
     * El fondo es gris claro, letras y líneas personalizadas, muestra 4 años.
     *
     * @param resultadoCCE LinkedHashMap<String, double[]> con las series: "Días de Inventario", "Días de Cartera", "Días de Cuentas por Pagar", "CCE".
     * @return Objeto JFreeChart con la gráfica lista para insertar en un JPanel.
     */
    public static JFreeChart graficaCCE(LinkedHashMap<String, double[]> resultadoCCE) {
        // Dataset para la gráfica
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Series a graficar en el orden deseado (colores)
        String[] series = {
            "Días de Inventario",     // Serie 0: negro
            "Días de Cartera",        // Serie 1: azul
            "Días de Cuentas por Pagar", // Serie 2: rojo
            "CCE"                    // Serie 3: naranja
        };

        // Etiquetas para los años (categoría eje X)
        String[] nombreAnios = { "Año 1", "Año 2", "Año 3", "Año 4" };

        // Llenar el dataset con los valores de cada serie para cada año
        for (String nombreSerie : series) {
            double[] valores = resultadoCCE.get(nombreSerie);
            if (valores != null) {
                for (int i = 0; i < 4; i++) {
                    dataset.addValue(
                        (i < valores.length ? valores[i] : 0.0),
                        nombreSerie,      // Serie (nombre de la línea)
                        nombreAnios[i]    // Categoría (año)
                    );
                }
            }
        }

        // Crear la gráfica de líneas
        JFreeChart chart = ChartFactory.createLineChart(
                "CCE",      // Título
                "Año",      // Eje X
                "Valor",    // Eje Y
                dataset
        );

        // Personalización del área de datos (plot)
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(204,204,204)); // Fondo gris claro

        // Configuración de colores y estilos de las líneas
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.BLACK);           // Días de Inventario
        renderer.setSeriesPaint(1, Color.BLUE);            // Días de Cartera
        renderer.setSeriesPaint(2, Color.RED);             // Días de Cuentas por Pagar
        renderer.setSeriesPaint(3, Color.ORANGE);          // CCE

        // Mostrar puntos y etiquetas de valor en cada punto
        for (int i = 0; i < series.length; i++) {
            renderer.setSeriesShapesVisible(i, true);
            renderer.setSeriesShape(i, new java.awt.geom.Ellipse2D.Double(-3, -3, 6, 6));
        }
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelPaint(Color.BLACK);
        renderer.setBaseItemLabelFont(new Font("Arial", Font.BOLD, 12));

        // Títulos y ejes en negro
        chart.getTitle().setPaint(Color.BLACK);
        plot.getDomainAxis().setTickLabelPaint(Color.BLACK);
        plot.getRangeAxis().setTickLabelPaint(Color.BLACK);
        plot.getDomainAxis().setLabelPaint(Color.BLACK);
        plot.getRangeAxis().setLabelPaint(Color.BLACK);

        // Fondo general fuera del área de datos en blanco
        chart.setBackgroundPaint(Color.WHITE);

        // Retornar la gráfica lista para mostrar en JPanel
        return chart;
    }
}

