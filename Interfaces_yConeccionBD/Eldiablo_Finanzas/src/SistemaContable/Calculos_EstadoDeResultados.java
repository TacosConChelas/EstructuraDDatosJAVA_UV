/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaContable;

import SistemaContable.Cuentas_balance.CuentaFinanciera;
import SistemaContable.Cuentas_balance.GestorBalanceFinanciero;
import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class Calculos_EstadoDeResultados {
    
    /**
    * Realiza el análisis horizontal absoluto sobre las cuentas del Estado de Resultados.
    * Procesa desde "Ventas" (primer ocurrencia, sin importar mayúsculas) hasta la última cuenta.
    *
    * @param cuentas Objeto GestorBalanceFinanciero con todas las cuentas cargadas.
    * @return HashMap donde la clave es el nombre de la cuenta y el valor es un arreglo double[4] con las diferencias absolutas año a año.
    *         Si no se encuentra "Ventas", retorna null.
    */
    public static LinkedHashMap<String, double[]> analisisHorizontalAbsolutoER(GestorBalanceFinanciero cuentas) {
     if (cuentas == null) return null;

     List<CuentaFinanciera> listaCuentas = cuentas.obtenerTodasLasCuentas();
     int indiceVentas = -1;

     // Buscar el índice de la primera cuenta llamada "Ventas" (sin case sensitive)
     for (int i = 0; i < listaCuentas.size(); i++) {
         String nombre = listaCuentas.get(i).getNombre();
         if (nombre != null && nombre.equalsIgnoreCase("Ventas")) {
             indiceVentas = i;
             break;
         }
     }
     if (indiceVentas == -1) {
         // No se encontró "Ventas"
         return null;
     }

     LinkedHashMap<String, double[]> resultado = new LinkedHashMap<>();

     // Procesar desde "Ventas" (inclusive) hasta el final
     for (int i = indiceVentas; i < listaCuentas.size(); i++) {
         CuentaFinanciera cuenta = listaCuentas.get(i);
         String nombreCuenta = cuenta.getNombre();
         double[] valoresOriginales = cuenta.getValoresAnuales();
         double[] diferencias = new double[4];

         // Primer año siempre es 0.0
         diferencias[0] = 0.0;

         // Calcular diferencias para años 2, 3, 4
         for (int j = 1; j < 4; j++) {
             double actual = (j < valoresOriginales.length) ? valoresOriginales[j] : 0.0;
             double anterior = (j - 1 < valoresOriginales.length) ? valoresOriginales[j - 1] : 0.0;
             diferencias[j] = actual - anterior;
         }
         resultado.put(nombreCuenta, diferencias);
     }
     return resultado;
 }


   

/**
 * Realiza el análisis horizontal relativo (porcentual) sobre las cuentas del Estado de Resultados.
 * Procesa desde "Ventas" (primer ocurrencia, sin importar mayúsculas) hasta la última cuenta.
 *
 * @param cuentas Objeto GestorBalanceFinanciero con todas las cuentas cargadas.
 * @return LinkedHashMap donde la clave es el nombre de la cuenta y el valor es un arreglo double[4] con los cambios relativos (en porcentaje, sin el símbolo %).
 *         Si no se encuentra "Ventas", retorna null.
 */
public static LinkedHashMap<String, double[]> analisisHorizontalRelativoER(GestorBalanceFinanciero cuentas) {
    if (cuentas == null) return null;

    List<CuentaFinanciera> listaCuentas = cuentas.obtenerTodasLasCuentas();
    int indiceVentas = -1;

    // Buscar el índice de la primera cuenta llamada "Ventas" (sin case sensitive)
    for (int i = 0; i < listaCuentas.size(); i++) {
        String nombre = listaCuentas.get(i).getNombre();
        if (nombre != null && nombre.equalsIgnoreCase("Ventas")) {
            indiceVentas = i;
            break;
        }
    }
    if (indiceVentas == -1) {
        // No se encontró "Ventas"
        return null;
    }

    LinkedHashMap<String, double[]> resultado = new LinkedHashMap<>();

    // Procesar desde "Ventas" (inclusive) hasta el final
    for (int i = indiceVentas; i < listaCuentas.size(); i++) {
        CuentaFinanciera cuenta = listaCuentas.get(i);
        String nombreCuenta = cuenta.getNombre();
        double[] valoresOriginales = cuenta.getValoresAnuales();
        double[] relativos = new double[4];

        // Primer año siempre es 0.0
        relativos[0] = 0.0;

        // Calcular cambios relativos para años 2, 3, 4
        for (int j = 1; j < 4; j++) {
            double actual = (j < valoresOriginales.length) ? valoresOriginales[j] : 0.0;
            double anterior = (j - 1 < valoresOriginales.length) ? valoresOriginales[j - 1] : 0.0;
            // Manejar 0/0 o x/0 como 0.0
            if (anterior == 0.0) {
                relativos[j] = 0.0;
            } else {
                relativos[j] = ((actual - anterior) / anterior) * 100.0;
            }
        }
        resultado.put(nombreCuenta, relativos);
    }
    return resultado;
}


  

    /**
     * Realiza el análisis vertical del Estado de Resultados.
     * Calcula el porcentaje que representa cada cuenta respecto a "Ventas" para cada año.
     * Procesa desde la primera "Ventas" (sin importar mayúsculas) hasta la última cuenta.
     *
     * @param cuentas Objeto GestorBalanceFinanciero con todas las cuentas cargadas.
     * @return LinkedHashMap donde la clave es el nombre de la cuenta y el valor es un arreglo double[4] con los porcentajes respecto a "Ventas" (sin el símbolo %).
     *         Si no se encuentra "Ventas", retorna null.
     */
    public static LinkedHashMap<String, double[]> analisisVerticalER(GestorBalanceFinanciero cuentas) {
        if (cuentas == null) return null;

        List<CuentaFinanciera> listaCuentas = cuentas.obtenerTodasLasCuentas();
        int indiceVentas = -1;

        // Buscar el índice de la primera cuenta llamada "Ventas" (sin case sensitive)
        for (int i = 0; i < listaCuentas.size(); i++) {
            String nombre = listaCuentas.get(i).getNombre();
            if (nombre != null && nombre.equalsIgnoreCase("Ventas")) {
                indiceVentas = i;
                break;
            }
        }
        if (indiceVentas == -1) {
            // No se encontró "Ventas"
            return null;
        }

        // Obtener los valores de "Ventas" para referencia
        double[] valoresVentas = listaCuentas.get(indiceVentas).getValoresAnuales();

        LinkedHashMap<String, double[]> resultado = new LinkedHashMap<>();

        // Procesar desde "Ventas" (inclusive) hasta el final
        for (int i = indiceVentas; i < listaCuentas.size(); i++) {
            CuentaFinanciera cuenta = listaCuentas.get(i);
            String nombreCuenta = cuenta.getNombre();
            double[] valoresCuenta = cuenta.getValoresAnuales();
            double[] porcentajes = new double[4];

            for (int j = 0; j < 4; j++) {
                double valorCuenta = (j < valoresCuenta.length) ? valoresCuenta[j] : 0.0;
                double totalVentas = (j < valoresVentas.length) ? valoresVentas[j] : 0.0;

                if (nombreCuenta != null && nombreCuenta.equalsIgnoreCase("Ventas")) {
                    porcentajes[j] = 100.0;
                } else if (totalVentas == 0.0) {
                    porcentajes[j] = 0.0;
                } else {
                    porcentajes[j] = (valorCuenta / totalVentas) * 100.0;
                }
            }
            resultado.put(nombreCuenta, porcentajes);
        }
        return resultado;
    }

   /**
     * Genera la gráfica del Estado de Resultados.
     * Incluye las cuentas: Ventas, Costo de Venta, Utilidad Neta, Utilidad Antes de Impuestos.
     * El fondo es gris claro [204,204,204], letras y líneas en negro.
     * Siempre muestra 4 años.
     *
     * @param cuentas GestorBalanceFinanciero con todas las cuentas cargadas.
     * @return Objeto JFreeChart con la gráfica lista para insertar en un JPanel.
     */
   public static JFreeChart graficaEstadoDeResultados(GestorBalanceFinanciero cuentas) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Cuentas a graficar en el mismo orden de colores
        String[] cuentasGraficar = {
            "Ventas", "Costo de Venta", "Utilidad Neta", "Utilidad Antes de Impuestos"
        };
        String[] nombreAnios = { "Año 1", "Año 2", "Año 3", "Año 4" };

        // Llenar dataset
        for (String nombreCuenta : cuentasGraficar) {
            CuentaFinanciera cuenta = cuentas.buscarPorNombre(nombreCuenta);
            if (cuenta != null) {
                double[] valores = cuenta.getValoresAnuales();
                for (int i = 0; i < 4; i++) {
                    dataset.addValue(
                        (i < valores.length ? valores[i] : 0.0),
                        nombreCuenta,
                        nombreAnios[i]
                    );
                }
            }
        }

        JFreeChart chart = ChartFactory.createLineChart(
                "Gráficas para mostrar del Estado de Resultados", // Título
                "Año",                                           // Eje X
                "Valor",                                         // Eje Y
                dataset
        );

        // Personalización de colores y fondo
        CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(new Color(204,204,204)); // Fondo gris claro

        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.BLACK);                  // Ventas
        renderer.setSeriesPaint(1, Color.RED);                    // Costo de Venta
        renderer.setSeriesPaint(2, Color.BLUE);                   // Utilidad Neta
        renderer.setSeriesPaint(3, Color.ORANGE);                 // Utilidad Antes de Impuestos

        // Mostrar puntos en cada serie
        for (int i = 0; i < cuentasGraficar.length; i++) {
            renderer.setSeriesShapesVisible(i, true);
            renderer.setSeriesShape(i, new java.awt.geom.Ellipse2D.Double(-3, -3, 6, 6));
        }

        // Mostrar los valores sobre los puntos
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelPaint(Color.BLACK); // Color de etiquetas de valor

        // Mejorar la visualización de las etiquetas (fuente más clara y negrita)
        renderer.setBaseItemLabelFont(new Font("Arial", Font.BOLD, 12));

        // Títulos y ejes en negro
        chart.getTitle().setPaint(Color.BLACK);
        plot.getDomainAxis().setTickLabelPaint(Color.BLACK);
        plot.getRangeAxis().setTickLabelPaint(Color.BLACK);
        plot.getDomainAxis().setLabelPaint(Color.BLACK);
        plot.getRangeAxis().setLabelPaint(Color.BLACK);

        chart.setBackgroundPaint(Color.WHITE);

        return chart;
    }
   
   
    
}
