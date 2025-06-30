/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package SistemaContable;

import SistemaContable.Cuentas_balance.CuentaFinanciera;
import SistemaContable.Cuentas_balance.GestorBalanceFinanciero;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.util.LinkedHashMap;
/**
 * Clase utilitaria que contiene métodos de cálculo para el Balance General.
 */
public class Calculos_BalanceGeneral {

    /**
    * Realiza el análisis horizontal absoluto sobre las cuentas del Balance General.
    * Calcula la diferencia absoluta año-a-año de cada cuenta, dejando en cero el primer año.
    * Solo considera cuentas desde la primera hasta la cuenta anterior a "Ventas" (sin incluir "Ventas").
    *
    * @param cuentas Objeto GestorBalanceFinanciero con todas las cuentas cargadas.
    * @return HashMap donde la clave es el nombre de la cuenta y el valor es un arreglo double[4] con los incrementos absolutos año a año.
    *         Si una cuenta tiene menos de 4 valores, se rellena con ceros al final.
    *         Si no hay ninguna cuenta antes de "Ventas", retorna un mapa vacío.
    */
   public static LinkedHashMap<String, double[]> analisisHorizontalAbsolutoBG(GestorBalanceFinanciero cuentas) {
       LinkedHashMap<String, double[]> resultado = new LinkedHashMap<>();

       if (cuentas == null) return resultado;

       // Usamos la lista ordenada
       List<CuentaFinanciera> listaCuentas = cuentas.obtenerTodasLasCuentas();

       for (CuentaFinanciera cuenta : listaCuentas) {
           String nombreCuenta = cuenta.getNombre();

           // Cuando encontramos la cuenta "Ventas", terminamos el BG (no la incluimos)
           if ("Ventas".equals(nombreCuenta)) {
               break;
           }

           double[] valoresOriginales = cuenta.getValoresAnuales();
           double[] diferencias = new double[4];

           // Primer año siempre es 0
           diferencias[0] = 0.0;

           // Calcular diferencias para años 2, 3, 4
           for (int i = 1; i < 4; i++) {
               double actual = (i < valoresOriginales.length) ? valoresOriginales[i] : 0.0;
               double anterior = (i - 1 < valoresOriginales.length) ? valoresOriginales[i - 1] : 0.0;
               diferencias[i] = actual - anterior;
           }

           // Guardar el resultado en el HashMap
           resultado.put(nombreCuenta, diferencias);
       }

       return resultado;
   }

    
   /**
    * Realiza el análisis horizontal relativo (porcentual) sobre las cuentas del Balance General.
    * Solo considera las cuentas desde la primera hasta la cuenta anterior a "Ventas" (sin incluir "Ventas").
    *
    * El cálculo para cada año (excepto el primero) es:
    *   ((valor_anio - valor_anio_anterior) / valor_anio_anterior) * 100
    * 
    * Regla especial:
    *   - Si valor_año_anterior == 0 y valor_año == 0 -> resultado es 0.0
    *   - Si valor_año_anterior == 0 y valor_año != 0 -> resultado es 0.0 (por decisión de usuario)
    *   - Primer año siempre es 0.0 (sin cálculo)
    *   - Si hay menos de 4 valores, se rellena con 0.0 al final.
    *
    * @param cuentas Objeto GestorBalanceFinanciero con todas las cuentas cargadas.
    * @return HashMap donde la clave es el nombre de la cuenta y el valor es un arreglo double[4] con los cambios relativos año a año (en porcentaje, sin el símbolo %).
    *         Si no hay ninguna cuenta antes de "Ventas", retorna un mapa vacío.
    */
   public static LinkedHashMap<String, double[]> analisisHorizontalRelativoBG(GestorBalanceFinanciero cuentas) {
       LinkedHashMap<String, double[]> resultado = new LinkedHashMap<>();

       if (cuentas == null) return resultado;

       List<CuentaFinanciera> listaCuentas = cuentas.obtenerTodasLasCuentas();

       for (CuentaFinanciera cuenta : listaCuentas) {
           String nombreCuenta = cuenta.getNombre();

           // Cuando encontramos la cuenta "Ventas", terminamos el BG (no la incluimos ni posteriores)
           if ("Ventas".equals(nombreCuenta)) {
               break;
           }

           double[] valoresOriginales = cuenta.getValoresAnuales();
           double[] relativos = new double[4];

           // Primer año siempre es 0.0
           relativos[0] = 0.0;

           // Calcular cambios relativos para años 2, 3, 4
           for (int i = 1; i < 4; i++) {
               double actual = (i < valoresOriginales.length) ? valoresOriginales[i] : 0.0;
               double anterior = (i - 1 < valoresOriginales.length) ? valoresOriginales[i - 1] : 0.0;

               // Reglas de división por cero
               if (anterior == 0.0) {
                   relativos[i] = 0.0; // Ya sea que actual también sea 0 o no, siempre retorna 0.0 según tu regla
               } else {
                   relativos[i] = ((actual - anterior) / anterior) * 100.0;
               }
           }

           resultado.put(nombreCuenta, relativos);
       }

       return resultado;
   }

   /**
    * Realiza el análisis vertical del Balance General.
    * Calcula el porcentaje que representa cada cuenta respecto al "TOTAL ACTIVO" para cada año.
    * Solo considera cuentas desde la primera hasta la cuenta anterior a "Ventas" (sin incluir "Ventas").
    * Si no encuentra la cuenta "TOTAL ACTIVO", retorna null y no realiza cálculos.
    *
    * Reglas especiales:
    *   - Si el valor de "TOTAL ACTIVO" para un año es 0, el resultado para ese año es 0.0
    *   - Si la cuenta es "TOTAL ACTIVO", el resultado para todos los años es 100.0
    *   - Si una cuenta tiene menos de 4 valores, se rellena con 0.0 al final.
    *
    * @param cuentas Objeto GestorBalanceFinanciero con todas las cuentas cargadas.
    * @return HashMap donde la clave es el nombre de la cuenta y el valor es un arreglo double[4] con los porcentajes (sin el símbolo %).
    *         Si no se encuentra "TOTAL ACTIVO", retorna null.
    */
   public static LinkedHashMap<String, double[]> analisisVerticalBG(GestorBalanceFinanciero cuentas) {
       if (cuentas == null) return null;

       // Buscar la cuenta "TOTAL ACTIVO"
       CuentaFinanciera totalActivo = cuentas.buscarPorNombre("TOTAL ACTIVO");
       if (totalActivo == null) {
           // No existe la cuenta de referencia
           return null;
       }

       double[] valoresTotalActivo = totalActivo.getValoresAnuales();

       LinkedHashMap<String, double[]> resultado = new LinkedHashMap<>();

       // Usamos la lista ordenada
       List<CuentaFinanciera> listaCuentas = cuentas.obtenerTodasLasCuentas();

       // Procesar solo las cuentas antes de "Ventas" (sin incluir "Ventas")
       for (CuentaFinanciera cuenta : listaCuentas) {
           String nombreCuenta = cuenta.getNombre();

           // Detenernos antes de "Ventas"
           if ("Ventas".equals(nombreCuenta)) {
               break;
           }

           double[] valoresCuenta = cuenta.getValoresAnuales();
           double[] porcentajes = new double[4];

           for (int i = 0; i < 4; i++) {
               double valorCuenta = (i < valoresCuenta.length) ? valoresCuenta[i] : 0.0;
               double total = (i < valoresTotalActivo.length) ? valoresTotalActivo[i] : 0.0;

               if ("TOTAL ACTIVO".equals(nombreCuenta)) {
                   // El total siempre es el 100%
                   porcentajes[i] = 100.0;
               } else if (total == 0.0) {
                   // Evitar división por cero
                   porcentajes[i] = 0.0;
               } else {
                   porcentajes[i] = (valorCuenta / total) * 100.0;
               }
           }

           resultado.put(nombreCuenta, porcentajes);
       }

       return resultado;
   }
   

   /**
     * Genera la gráfica del Comportamiento del Balance General.
     * Incluye las cuentas: Cuentas por Cobrar, Cuentas por Pagar, Inventarios,
     * Caja y Bancos, y Pasivo No Corriente Total (como Deuda a Largo Plazo).
     * El fondo es gris claro, líneas y letras personalizadas.
     * Siempre muestra 4 años.
     *
     * @param cuentas GestorBalanceFinanciero con todas las cuentas cargadas.
     * @return Objeto JFreeChart con la gráfica lista para insertar en un JPanel.
     */
   public static JFreeChart graficaBalanceGeneral(GestorBalanceFinanciero cuentas) {
        // Dataset para la gráfica de líneas
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Nombres exactos de las cuentas a graficar (en orden de la leyenda y colores)
        String[] cuentasGraficar = {
            "Cuentas por Cobrar",      // Serie 0: negro
            "Cuentas por Pagar",       // Serie 1: rojo
            "Inventarios",             // Serie 2: azul
            "Caja y Bancos",           // Serie 3: verde oscuro
            "Pasivo No Corriente Total"// Serie 4: naranja
        };

        // Etiquetas de los años para el eje X
        String[] nombreAnios = { "Año 1", "Año 2", "Año 3", "Año 4" };

        // Llenar el dataset con los valores de cada cuenta para cada año
        for (String nombreCuenta : cuentasGraficar) {
            // Buscar la cuenta por nombre exacto
            CuentaFinanciera cuenta = cuentas.buscarPorNombre(nombreCuenta);
            if (cuenta != null) {
                double[] valores = cuenta.getValoresAnuales();
                // Para cada año, agregar el valor correspondiente (o 0 si falta)
                for (int i = 0; i < 4; i++) {
                    dataset.addValue(
                        (i < valores.length ? valores[i] : 0.0),
                        nombreCuenta,    // Serie (nombre de la cuenta)
                        nombreAnios[i]   // Categoría (año)
                    );
                }
            }
        }

        // Crear la gráfica de líneas múltiple
        JFreeChart chart = ChartFactory.createLineChart(
                "Comportamiento del Balance General", // Título principal
                "Año",                                // Etiqueta eje X
                "Valor",                              // Etiqueta eje Y
                dataset                              // Dataset de valores
        );

        // Personalización del área del gráfico
        CategoryPlot plot = chart.getCategoryPlot();
        // Establecer fondo gris claro para el área de los datos
        plot.setBackgroundPaint(new Color(204,204,204));

        // Configuración de colores y estilos de líneas
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, Color.BLACK);                  // Cuentas por Cobrar
        renderer.setSeriesPaint(1, Color.RED);                    // Cuentas por Pagar
        renderer.setSeriesPaint(2, Color.BLUE);                   // Inventarios
        renderer.setSeriesPaint(3, Color.GREEN.darker());         // Caja y Bancos
        renderer.setSeriesPaint(4, Color.ORANGE);                 // Pasivo No Corriente Total

        // Mostrar puntos y etiquetas de valor sobre cada punto de cada serie
        for (int i = 0; i < cuentasGraficar.length; i++) {
            renderer.setSeriesShapesVisible(i, true);
            renderer.setSeriesShape(i, new java.awt.geom.Ellipse2D.Double(-3, -3, 6, 6));
        }
        // Habilitar las etiquetas sobre los puntos
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        renderer.setBaseItemLabelPaint(Color.BLACK); // Color de las etiquetas de valor
        renderer.setBaseItemLabelFont(new Font("Arial", Font.BOLD, 12));

        // Personalización de títulos y ejes (todos en negro)
        chart.getTitle().setPaint(Color.BLACK);
        plot.getDomainAxis().setTickLabelPaint(Color.BLACK);   // Etiquetas de años (X)
        plot.getRangeAxis().setTickLabelPaint(Color.BLACK);    // Etiquetas de valor (Y)
        plot.getDomainAxis().setLabelPaint(Color.BLACK);       // Título eje X
        plot.getRangeAxis().setLabelPaint(Color.BLACK);        // Título eje Y

        // El fondo general del chart (fuera del área de los datos) es blanco
        chart.setBackgroundPaint(Color.WHITE);

        // Retornar el objeto JFreeChart para mostrar en un JPanel
        return chart;
    }

   
   
}    
