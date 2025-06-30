/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaContable;

import SistemaContable.Cuentas_balance.CuentaFinanciera;
import SistemaContable.Cuentas_balance.GestorBalanceFinanciero;
import java.util.LinkedHashMap;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import java.awt.*;
import java.util.LinkedHashMap;
import java.util.List;



public class Precicciones {
    

/**
 * Realiza la predicción lineal de las 10 cuentas financieras más importantes del BG y ER.
 * Usa la tendencia lineal de los últimos 4 años y proyecta X años hacia el futuro.
 * Si una cuenta no existe, simplemente la ignora.
 *
 * @param cuñosPredecir Número de años hacia adelante a predecir.
 * @return LinkedHashMap<String, double[]> donde la clave es el nombre de la cuenta y el arreglo contiene las predicciones año por año.
 */
public static LinkedHashMap<String, double[]> prediccionCuentasFinancieras(
        GestorBalanceFinanciero cuentas, int añosPredecir) {

        // Lista de las 10 cuentas clave a predecir (exactamente como las buscas en tu sistema)
        String[] cuentasClave = {
            "Ventas", "Costo de Venta", "Utilidad Neta", "Utilidad de Operación", "Utilidad Bruta",
            "TOTAL ACTIVO", "Cuentas por Cobrar", "Cuentas por Pagar", "Inventarios", "Capital Contable"
        };

        LinkedHashMap<String, double[]> resultado = new LinkedHashMap<>();

        for (String nombreCuenta : cuentasClave) {
            CuentaFinanciera cuenta = cuentas.buscarPorNombre(nombreCuenta);
            if (cuenta != null) {
                double[] valores = cuenta.getValoresAnuales();
                if (valores.length >= 4) { // Solo predecimos si hay al menos 4 valores
                    double v1 = valores[0];
                    double v4 = valores[3];
                    double m = (v4 - v1) / 3.0; // Pendiente anual

                    double[] predicciones = new double[4];
                    for (int n = 0; n < 4; n++) {
                        predicciones[n] = v4 + m * (añosPredecir + n);
                    }
                    resultado.put("New " + nombreCuenta, predicciones);
                }
            }
        }
        return resultado;
    }

    /**
    * Genera una gráfica comparativa para las 10 cuentas más importantes,
    * mostrando tanto los valores actuales (4 años) como los proyectados (X años) en la misma gráfica.
    *
    * @param cuentas Objeto GestorBalanceFinanciero con los datos actuales.
    * @param prediccion LinkedHashMap<String, double[]> con las proyecciones (mismos nombres de cuenta).
    * @param aniosPredichos Número de años que se predicen.
    * @return Objeto JFreeChart para mostrar en JPanel o exportar.
    */
   /**
 * Genera una gráfica comparativa entre los valores actuales (reales) y los 4 años futuros predichos
 * para las 10 cuentas clave, usando colores y estilos diferenciados.
 *
 * @param cuentas      Objeto GestorBalanceFinanciero con los datos actuales.
 * @param prediccion   Mapa con las cuentas predichas (clave: "New {Cuenta}", valores: double[4] futuros).
 * @param añosPredecir Cantidad de años que el usuario quiere proyectar (sirve para ajustar las etiquetas).
 * @return JFreeChart listo para mostrar en un JPanel o exportar a PDF.
 */
public static JFreeChart graficarComparativoPrediccion(
        GestorBalanceFinanciero cuentas,
        LinkedHashMap<String, double[]> prediccion,
        int añosPredecir
) {
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

    // Cuentas clave en orden fijo (recomendado)
    String[] cuentasClave = {
            "Ventas", "Costo de Venta", "Utilidad Neta", "Utilidad de Operación",
            "Utilidad Bruta", "TOTAL ACTIVO", "Cuentas por Cobrar",
            "Cuentas por Pagar", "Inventarios", "Capital Contable"
    };

    // Etiquetas para los años (actuales y proyectados)
    String[] etiquetasAniosActuales = {"Año 1", "Año 2", "Año 3", "Año 4"};
    String[] etiquetasAniosPrediccion = new String[4];
    for (int i = 0; i < 4; i++) {
        etiquetasAniosPrediccion[i] = "Año " + (4 + añosPredecir + i);
    }

    // --- 1. Cuentas Actuales (4 años actuales) ---
    for (String cuenta : cuentasClave) {
        CuentaFinanciera cf = cuentas.buscarPorNombre(cuenta);
        if (cf != null) {
            double[] vals = cf.getValoresAnuales();
            for (int i = 0; i < Math.min(4, vals.length); i++) {
                dataset.addValue(vals[i], cuenta + " (Actual)", etiquetasAniosActuales[i]);
            }
        }
    }

    // --- 2. Cuentas Predicción (solo los 4 años futuros generados) ---
    for (String cuenta : cuentasClave) {
        double[] pred = prediccion.get("New " + cuenta);
        if (pred != null) {
            for (int i = 0; i < pred.length; i++) {
                dataset.addValue(pred[i], cuenta + " (Predicción)", etiquetasAniosPrediccion[i]);
            }
        }
    }

    // Crear el gráfico de líneas
    JFreeChart chart = ChartFactory.createLineChart(
            "Comparativo Real vs. Proyección — 10 Cuentas Clave",
            "Año",
            "Valor",
            dataset
    );

    // Personalización visual básica (puedes extender igual que los otros métodos)
    CategoryPlot plot = chart.getCategoryPlot();
    plot.setBackgroundPaint(new Color(204,204,204));
    Object[] colores = {
        Color.BLACK, 
        Color.MAGENTA,
        Color.BLUE,
        Color.RED,
        Color.GREEN,
        Color.ORANGE,
        Color.PINK,
        Color.CYAN,
        Color.DARK_GRAY,
        new Color(0,153,0)
        
    };

    LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
    // Opcional: usa estilos de línea distintos (línea sólida para actuales, punteada para predicción)
    for (int serie = 0; serie < cuentasClave.length; serie++) {
            // Serie par: cuenta actual (sólida)
        renderer.setSeriesPaint(serie * 2, (Paint) colores[serie]);
        renderer.setSeriesStroke(serie * 2, new BasicStroke(2.5f));

        // Serie impar: predicción (misma cuenta, punteada, mismo color)
        renderer.setSeriesPaint(serie * 2 + 1, (Paint) colores[serie]);
        renderer.setSeriesStroke(serie * 2 + 1,
            new BasicStroke(2.5f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0,
                            new float[]{8.0f, 6.0f}, 0)
        );
        renderer.setSeriesShapesVisible(serie * 2, true);
        renderer.setSeriesShapesVisible(serie * 2 + 1, true);
    }

    chart.getTitle().setPaint(Color.BLACK);
    plot.getDomainAxis().setTickLabelPaint(Color.BLACK);
    plot.getRangeAxis().setTickLabelPaint(Color.BLACK);
    plot.getDomainAxis().setLabelPaint(Color.BLACK);
    plot.getRangeAxis().setLabelPaint(Color.BLACK);
    chart.setBackgroundPaint(Color.WHITE);

    return chart;
}

}
