/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto.Calculos;
import Proyecto.Calculos.DataBase.LibroBalance;
import Proyecto.Calculos.DataBase.RegistroCuenta;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.Polygon;
import java.util.ArrayList;

import org.jfree.chart.renderer.category.*;


import java.awt.*;
import java.util.ArrayList;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
/**
 *
 * @author tacosconchelas
 */
public class CrearGraficas {
    
    private LibroBalance libroBalance;
    
    public CrearGraficas(LibroBalance lb){
        this.libroBalance = lb;
    }
    
    /**
    * Genera una gráfica de líneas del comportamiento del Balance General (JFreeChart),
    * con series para varias cuentas clave. Los datos se obtienen del libroBalance.
    * 
    * @return JFreeChart listo para mostrar en un ChartPanel
    */
   public JFreeChart graficaBalanceGeneral() {
       // Nombres y IDs de las cuentas a graficar
       String[] nombres = {"Cuentas por Cobrar", "Cuentas por Pagar", "Inventarios", "Efectivo y Equivalentes", "Pasivo a Largo Plazo"};
       int[] ids = {6, 10, 5, 4, 9};

       // Etiquetas para los años (eje X)
       String[] anios = {"Año 1", "Año 2", "Año 3"};

       // Crear el dataset para la gráfica
       DefaultCategoryDataset dataset = new DefaultCategoryDataset();

       // Recorrer cada cuenta a graficar
       for (int i = 0; i < nombres.length; i++) {
           RegistroCuenta cuenta = libroBalance.buscarPorId(ids[i]);
           if (cuenta != null) {
               ArrayList<Double> valores = cuenta.getValoresPorPeriodo();
               for (int j = 0; j < 3; j++) {
                   double valor = (valores != null && valores.size() > j && valores.get(j) != null) ? valores.get(j) : 0.0;
                   dataset.addValue(valor, nombres[i], anios[j]);
               }
           } else {
               System.out.println("cuentano encontrada grafica bg");
               // Si no existe la cuenta, pone ceros
               for (int j = 0; j < 3; j++) {
                   dataset.addValue(0.0, nombres[i], anios[j]);
               }
           }
       }

       // Crear el objeto JFreeChart
       JFreeChart chart = ChartFactory.createLineChart(
               "Comportamiento del Balance General",
               "Año",
               "Valor",
               dataset,
               PlotOrientation.VERTICAL,
               true,  // leyenda
               true,  // tooltips
               false  // URLs
       );

       // Personalizar fondo y colores
       CategoryPlot plot = chart.getCategoryPlot();
       plot.setBackgroundPaint(Color.WHITE);
       plot.setRangeGridlinePaint(Color.BLACK);
       plot.setDomainGridlinePaint(Color.BLACK);

       // Personalizar el renderizador para colores y etiquetas de valores
       LineAndShapeRenderer renderer = new LineAndShapeRenderer();

       // Definir los colores que quieres (verde, rojo, azul, morado, naranja)
       Color[] colores = {new Color(0, 128, 0), Color.RED, Color.BLUE, new Color(128, 0, 128), Color.ORANGE};

       for (int i = 0; i < nombres.length; i++) {
           renderer.setSeriesPaint(i, colores[i]);
           renderer.setSeriesStroke(i, new BasicStroke(2.0f));
           renderer.setSeriesShapesVisible(i, true); // círculos en los puntos
           renderer.setSeriesShape(i, new java.awt.geom.Ellipse2D.Double(-3, -3, 6, 6));
           renderer.setSeriesItemLabelsVisible(i, true);
           renderer.setSeriesItemLabelGenerator(i, new StandardCategoryItemLabelGenerator());
           renderer.setSeriesItemLabelPaint(i, Color.BLACK);
       }

       // Texto y líneas en negro
       chart.getTitle().setPaint(Color.BLACK);
       chart.getLegend().setItemPaint(Color.BLACK);
       plot.getDomainAxis().setTickLabelPaint(Color.BLACK);
       plot.getRangeAxis().setTickLabelPaint(Color.BLACK);
       plot.getDomainAxis().setLabelPaint(Color.BLACK);
       plot.getRangeAxis().setLabelPaint(Color.BLACK);

       plot.setRenderer(renderer);

       return chart;
   }
    
   
   
   /**
    * Genera una gráfica de líneas del Estado de Resultados con figuras y colores específicos en cada serie.
    * 
    * @return JFreeChart para mostrar en un ChartPanel.
    */
    public JFreeChart graficaEstadoResultados() {
       // Nombres y IDs de las cuentas a graficar
       String[] nombres = {"Ventas Netas", "Costo de Ventas", "Utilidad Neta", "Utilidad Antes de Impuestos"};
       int[] ids = {12, 13, 17, 16};

       // Etiquetas para los años (eje X)
       String[] anios = {"Año 1", "Año 2", "Año 3"};

       // Crear el dataset
       DefaultCategoryDataset dataset = new DefaultCategoryDataset();

       // Recorrer cada cuenta a graficar
       for (int i = 0; i < nombres.length; i++) {
           RegistroCuenta cuenta = libroBalance.buscarPorId(ids[i]);
           if (cuenta != null) {
               ArrayList<Double> valores = cuenta.getValoresPorPeriodo();
               for (int j = 0; j < 3; j++) {
                   double valor = (valores != null && valores.size() > j && valores.get(j) != null) ? valores.get(j) : 0.0;
                   dataset.addValue(valor, nombres[i], anios[j]);
               }
           } else {
               for (int j = 0; j < 3; j++) {
                   dataset.addValue(0.0, nombres[i], anios[j]);
               }
           }
       }

       // Crear el objeto JFreeChart
       JFreeChart chart = ChartFactory.createLineChart(
               "Gráficas para mostrar del Estado de Resultados",
               "Año",
               "Valor",
               dataset,
               PlotOrientation.VERTICAL,
               true,  // leyenda
               true,  // tooltips
               false  // URLs
       );

       // Personalización de fondo, ejes, etc.
       CategoryPlot plot = chart.getCategoryPlot();
       plot.setBackgroundPaint(Color.WHITE);
       plot.setRangeGridlinePaint(Color.BLACK);
       plot.setDomainGridlinePaint(Color.BLACK);

       // Crear las figuras para los puntos
       Shape circulo = new Ellipse2D.Double(-4, -4, 8, 8);    // Ventas Netas
       Shape cuadrado = new Rectangle2D.Double(-4, -4, 8, 8); // Costo de Ventas
       Shape triangulo = new Polygon(new int[]{-4, 4, 0}, new int[]{4, 4, -4}, 3); // Utilidad Neta
       Shape diamante = new Polygon(new int[]{0, 4, 0, -4}, new int[]{-4, 0, 4, 0}, 4); // Utilidad Antes de Impuestos

       // Colores para las series
       Color[] colores = {Color.BLUE, Color.RED, new Color(0, 153, 0), new Color(128, 0, 128)}; // azul, rojo, verde, morado

       // Renderizador para las líneas y formas
       LineAndShapeRenderer renderer = new LineAndShapeRenderer();

       // Asignar figura y color a cada serie
       renderer.setSeriesPaint(0, colores[0]);
       renderer.setSeriesShape(0, circulo);

       renderer.setSeriesPaint(1, colores[1]);
       renderer.setSeriesShape(1, cuadrado);

       renderer.setSeriesPaint(2, colores[2]);
       renderer.setSeriesShape(2, triangulo);

       renderer.setSeriesPaint(3, colores[3]);
       renderer.setSeriesShape(3, diamante);

       // Resto de configuraciones comunes para todas las series
       for (int i = 0; i < nombres.length; i++) {
           renderer.setSeriesStroke(i, new BasicStroke(2.0f));
           renderer.setSeriesShapesVisible(i, true);
           renderer.setSeriesItemLabelsVisible(i, true);
           renderer.setSeriesItemLabelGenerator(i, new StandardCategoryItemLabelGenerator());
           renderer.setSeriesItemLabelPaint(i, Color.BLACK);
       }

       // Texto y líneas en negro
       chart.getTitle().setPaint(Color.BLACK);
       chart.getLegend().setItemPaint(Color.BLACK);
       plot.getDomainAxis().setTickLabelPaint(Color.BLACK);
       plot.getRangeAxis().setTickLabelPaint(Color.BLACK);
       plot.getDomainAxis().setLabelPaint(Color.BLACK);
       plot.getRangeAxis().setLabelPaint(Color.BLACK);

       plot.setRenderer(renderer);

       return chart;
   }
    
    /**
    * Genera una gráfica de líneas del CCE con figuras y colores específicos en cada serie.
    * 
    * @return JFreeChart para mostrar en un ChartPanel.
    */
    public JFreeChart graficaCCE(ArrayList<Object[]> filasCCE) {
        // Obtener la fila del CCE del resultado de calcularCCE() (índice 3 normalmente)
        
        if (filasCCE == null || filasCCE.size() < 4) return null;
        Object[] filaCCE = filasCCE.get(3); // { "CCE", año1, año2, año3 }

        // Crear el dataset (como XY para suavizado tipo spline)
        XYSeries serieCCE = new XYSeries("CCE");
        for (int i = 1; i <= 3; i++) {
            double valor = filaCCE[i] instanceof Number ? ((Number) filaCCE[i]).doubleValue() : 0.0;
            serieCCE.add(i, valor); // x: 1,2,3 ; y: valor
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(serieCCE);

        // Crear la gráfica (XYPlot para suavizado)
        NumberAxis xAxis = new NumberAxis("Año");
        NumberAxis yAxis = new NumberAxis("CCE");
        xAxis.setAutoRangeIncludesZero(false);
        xAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        yAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, true);
        renderer.setSeriesPaint(0, new Color(0, 82, 155)); // Azul tipo Excel
        renderer.setSeriesStroke(0, new BasicStroke(3.0f));
        renderer.setSeriesShapesVisible(0, true);
        renderer.setSeriesShape(0, new Ellipse2D.Double(-6, -6, 12, 12));
        renderer.setSeriesItemLabelsVisible(0, true);
        renderer.setSeriesItemLabelGenerator(0, new org.jfree.chart.labels.StandardXYItemLabelGenerator());
        renderer.setSeriesItemLabelPaint(0, Color.BLACK);

        // Línea suavizada
        renderer.setDrawSeriesLineAsPath(true);

        XYPlot plot = new XYPlot(dataset, xAxis, yAxis, renderer);
        plot.setBackgroundPaint(Color.WHITE);
        plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);
        plot.getDomainAxis().setTickLabelPaint(Color.BLACK);
        plot.getRangeAxis().setTickLabelPaint(Color.BLACK);
        plot.getDomainAxis().setLabelPaint(Color.BLACK);
        plot.getRangeAxis().setLabelPaint(Color.BLACK);

        // Crear el objeto gráfico final
        JFreeChart chart = new JFreeChart("CCE", new Font("SansSerif", Font.BOLD, 22), plot, false);
        chart.setBackgroundPaint(Color.WHITE);

        return chart;
    }
}
