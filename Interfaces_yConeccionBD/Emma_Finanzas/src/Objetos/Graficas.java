/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.Color;

public class Graficas {

    // Lista global de colores (puedes ajustar el orden si lo deseas)
    public static final Color[] COLORES = {
        new Color(34, 139, 34),   // Verde
        new Color(220, 20, 60),   // Rojo
        new Color(30, 144, 255),  // Azul
        new Color(148, 0, 211),   // Morado
        new Color(255, 140, 0),   // Naranja
        Color.BLACK               // Negro
    };

    /**
     * Genera una gráfica de líneas para el CCE con fondo blanco, líneas y etiquetas negras,
     * usando el primer color de la lista global COLORES. Retorna el objeto JFreeChart listo para usar.
     * 
     * @param cceValores arreglo double[4] con los valores de CCE de cada año.
     * @return JFreeChart con la gráfica de CCE o null si datos inválidos.
     */
    public static JFreeChart graficaCCE(double[] cceValores) {
        if (cceValores == null || cceValores.length != 4) {
            return null;
        }

        // Etiquetas fijas para los años
        String[] etiquetas = {"Año 1", "Año 2", "Año 3", "Año 4"};

        // Dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < 4; i++) {
            dataset.addValue(cceValores[i], "CCE", etiquetas[i]);
        }

        // Crear el gráfico
        JFreeChart chart = ChartFactory.createLineChart(
                "CCE",                // Título
                "Año",                // Eje X
                "CCE",                // Eje Y
                dataset,
                PlotOrientation.VERTICAL,
                false,                // No mostrar leyenda (solo una serie)
                false,
                false
        );

        // Fondo blanco
        chart.setBackgroundPaint(Color.WHITE);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setDomainGridlinePaint(Color.BLACK);

        // Ejes en negro
        plot.getDomainAxis().setTickLabelPaint(Color.BLACK);
        plot.getDomainAxis().setLabelPaint(Color.BLACK);
        plot.getRangeAxis().setTickLabelPaint(Color.BLACK);
        plot.getRangeAxis().setLabelPaint(Color.BLACK);

        // Línea y puntos (círculos) en el primer color de COLORES
        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        renderer.setSeriesPaint(0, COLORES[0]); // Primer color de la lista
        renderer.setSeriesShapesVisible(0, true); // Mostrar círculos
        renderer.setSeriesShape(0, new java.awt.geom.Ellipse2D.Double(-4, -4, 8, 8)); // Círculos tamaño 8px

        plot.setRenderer(renderer);

        return chart;
    }
    
    
    /**
     * Genera una gráfica de líneas para el Estado de Resultados.
     * Solo añade líneas para las cuentas encontradas.
     * 
     * @param balance el objeto Balance ya validado.
     * @return JFreeChart o null si balance nulo/vacío.
     */
    public static JFreeChart graficaER(Balance balance) {
        if (balance == null || balance.getCuentasRegistradas() == null || balance.getCuentasRegistradas().isEmpty()) {
            return null;
        }

        // Etiquetas para los años
        String[] etiquetas = {"Año 1", "Año 2", "Año 3", "Año 4"};

        // Nombres de las series y sus IDs correspondientes
        String[] nombresSeries = {
            "Ventas Netas", 
            "Costo de Ventas", 
            "Utilidad Neta", 
            "Utilidad Antes de Impuestos"
        };
        int[] idsSeries = {400, 402, 407, 406};

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Agregar al dataset las cuentas encontradas
        int colorIndex = 0;
        for (int i = 0; i < nombresSeries.length; i++) {
            Cuenta cuenta = balance.buscarPorCodigoUnico(idsSeries[i]);
            if (cuenta != null) {
                // Obtener los valores de los 4 años
                java.util.List<Double> valores = cuenta.getRegistrosPeriodos();
                for (int j = 0; j < 4; j++) {
                    double valor = (valores.size() > j) ? valores.get(j) : 0.0;
                    dataset.addValue(valor, nombresSeries[i], etiquetas[j]);
                }
            }
        }

        // Crear la gráfica de líneas
        JFreeChart chart = ChartFactory.createLineChart(
                "Gráficas para mostrar del Estado de Resultados",
                "Año",
                "Monto",
                dataset,
                PlotOrientation.VERTICAL,
                true,   // Mostrar leyenda
                false,
                false
        );

        // Personalización visual
        chart.setBackgroundPaint(Color.WHITE);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setDomainGridlinePaint(Color.BLACK);

        plot.getDomainAxis().setTickLabelPaint(Color.BLACK);
        plot.getDomainAxis().setLabelPaint(Color.BLACK);
        plot.getRangeAxis().setTickLabelPaint(Color.BLACK);
        plot.getRangeAxis().setLabelPaint(Color.BLACK);

        // Línea y puntos: cada serie con un color diferente
        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        int colorUsed = 0;
        for (int i = 0; i < nombresSeries.length; i++) {
            Cuenta cuenta = balance.buscarPorCodigoUnico(idsSeries[i]);
            if (cuenta != null) {
                renderer.setSeriesPaint(colorUsed, COLORES[colorUsed % COLORES.length]);
                renderer.setSeriesShapesVisible(colorUsed, true);
                renderer.setSeriesShape(colorUsed, new java.awt.geom.Ellipse2D.Double(-4, -4, 8, 8));
                colorUsed++;
            }
        }
        plot.setRenderer(renderer);

        return chart;
    }
    
    
    /**
     * Genera una gráfica de líneas para el Comportamiento del Balance General.
     * Añade una línea por cada cuenta encontrada.
     * 
     * @param balance el objeto Balance ya validado.
     * @return JFreeChart o null si balance nulo/vacío.
     */
    public static JFreeChart graficaBG(Balance balance) {
        if (balance == null || balance.getCuentasRegistradas() == null || balance.getCuentasRegistradas().isEmpty()) {
            return null;
        }

        // Etiquetas para los años
        String[] etiquetas = {"Año 1", "Año 2", "Año 3", "Año 4"};

        // Cuentas a graficar y sus IDs
        String[] nombresSeries = {
            "Cuentas por Cobrar",
            "Cuentas por Pagar",
            "Inventarios",
            "Efectivo y Equivalentes",
            "Deuda a Largo Plazo"
        };
        int[] idsSeries = {104, 203, 103, 410, 202};

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Solo añade las cuentas que existen
        int colorIndex = 0;
        for (int i = 0; i < nombresSeries.length; i++) {
            Cuenta cuenta = balance.buscarPorCodigoUnico(idsSeries[i]);
            if (cuenta != null) {
                java.util.List<Double> valores = cuenta.getRegistrosPeriodos();
                for (int j = 0; j < 4; j++) {
                    double valor = (valores.size() > j) ? valores.get(j) : 0.0;
                    dataset.addValue(valor, nombresSeries[i], etiquetas[j]);
                }
            }
        }

        // Crear la gráfica de líneas
        JFreeChart chart = ChartFactory.createLineChart(
                "Comportamiento del Balance General",
                "Año",
                "Monto",
                dataset,
                PlotOrientation.VERTICAL,
                true,   // Mostrar leyenda
                false,
                false
        );

        // Personalización visual
        chart.setBackgroundPaint(Color.WHITE);
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setDomainGridlinePaint(Color.BLACK);

        plot.getDomainAxis().setTickLabelPaint(Color.BLACK);
        plot.getDomainAxis().setLabelPaint(Color.BLACK);
        plot.getRangeAxis().setTickLabelPaint(Color.BLACK);
        plot.getRangeAxis().setLabelPaint(Color.BLACK);

        // Línea y puntos: cada serie con un color diferente
        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        int colorUsed = 0;
        for (int i = 0; i < nombresSeries.length; i++) {
            Cuenta cuenta = balance.buscarPorCodigoUnico(idsSeries[i]);
            if (cuenta != null) {
                renderer.setSeriesPaint(colorUsed, COLORES[colorUsed % COLORES.length]);
                renderer.setSeriesShapesVisible(colorUsed, true);
                renderer.setSeriesShape(colorUsed, new java.awt.geom.Ellipse2D.Double(-4, -4, 8, 8));
                colorUsed++;
            }
        }
        plot.setRenderer(renderer);

        return chart;
    }
    
    
    
}

