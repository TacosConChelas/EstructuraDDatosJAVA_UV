/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Finanzas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author tacosconchelas
 */
public class GeneradorGraficaFinanciera {
    public static JFreeChart crearGraficaEstructuraFinanciera(BalanceGeneral bg, JTable tabla, JPanel panel) {
        List<Cuenta> cuentas = bg.getCuentas();
        if (cuentas == null || cuentas.isEmpty()) {
            System.out.println("Error: El balance está vacío.");
            return null;
        }

        Cuenta activoTotal = null, pasivoTotal = null, capitalTotal = null;

        for (Cuenta cuenta : cuentas) {
            Integer id = cuenta.getId();
            if (id != null) {
                switch (id) {
                    case 0:  // Activo Total
                        activoTotal = cuenta;
                        break;
                    case 3:  // Pasivo Total
                        pasivoTotal = cuenta;
                        break;
                    case 6:  // Capital Total
                        capitalTotal = cuenta;
                        break;
                }
            }
        }

        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        model.setRowCount(0);

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        Cuenta[] especiales = {activoTotal, pasivoTotal, capitalTotal};
        String[] nombres = {"TOTAL DE ACTIVOS", "TOTAL DE PASIVOS", "TOTAL CAPITAL"};

        for (int i = 0; i < especiales.length; i++) {
            Cuenta cuenta = especiales[i];
            if (cuenta == null) {
                System.out.println("Error: No se encontró la cuenta " + nombres[i]);
                continue;
            }

            double[] valores = cuenta.getValoresDeLosAnios();
            double pivote = 0.0;
            for (double v : valores) {
                if (v != 0.0) {
                    pivote = v;
                    break;
                }
            }

            if (pivote == 0.0) {
                continue; // ignora cuenta sin base válida
            }

            Object[] fila = new Object[4];
            fila[0] = cuenta.getNombreCuenta();

            for (int j = 0; j < 3; j++) {
                double resultado = (valores[j] / pivote) * 100;
                fila[j + 1] = resultado + "%";
                dataset.addValue(resultado, nombres[i], "Año " + (j + 1));
            }

            model.addRow(fila);
        }

        JFreeChart chart = ChartFactory.createLineChart( "Estructura Financiera", "Año", "Porcentaje", dataset, PlotOrientation.VERTICAL, true, true, false);

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setBackgroundPaint(Color.WHITE);

        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        // new Color(255,102,102)
        renderer.setSeriesPaint(0, new Color(51,51,255));   
        renderer.setSeriesPaint(1, new Color(204,51,255));    
        renderer.setSeriesPaint(2, new Color(255,102,102));  
        plot.setRenderer(renderer);

        panel.removeAll();
        panel.setLayout(new BorderLayout());
        panel.add(new ChartPanel(chart), BorderLayout.CENTER);
        panel.validate();

        return chart;
    }
  
    public static JFreeChart crearGraficaEstructuraActivo(BalanceGeneral bg, JTable tablaVisual, JPanel panelGrafico) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaVisual.getModel();
        modeloTabla.setRowCount(0); // Limpiar la tabla

        List<Cuenta> cuentas = bg.getCuentas();
        if (cuentas == null || cuentas.isEmpty()) {
            System.out.println("Error: El balance está vacío.");
            return null;
        }

        // Buscar cuentas por ID
        Cuenta activoCirculante = null;
        Cuenta activoFijo = null;
        Cuenta activoCompleto = null;

        for (Cuenta cuenta : cuentas) {
            Integer id = cuenta.getId();
            if (id == null) continue;
            if (id == 1) activoCirculante = cuenta;
            else if (id == 2) activoFijo = cuenta;
            else if (id == 0) activoCompleto = cuenta;
        }

        List<Cuenta> cuentasAProcesar = new ArrayList<>();
        if (activoCirculante != null) cuentasAProcesar.add(activoCirculante);
        else System.out.println("Advertencia: No se encontró la cuenta con ID 1 (Activo Circulante).");

        if (activoFijo != null) cuentasAProcesar.add(activoFijo);
        else System.out.println("Advertencia: No se encontró la cuenta con ID 2 (Activo Fijo).");

        if (activoCompleto != null) cuentasAProcesar.add(activoCompleto);
        else System.out.println("Advertencia: No se encontró la cuenta con ID 0 (Activo Total).");

        DefaultCategoryDataset datos = new DefaultCategoryDataset();
        String[] etiquetasAnios = {"Año 1", "Año 2", "Año 3"};

        for (Cuenta cuenta : cuentasAProcesar) {
            double[] valores = cuenta.getValoresDeLosAnios();
            String nombre = cuenta.getNombreCuenta();

            // Buscar primer valor distinto de 0 como base
            double base = 0.0;
            for (double v : valores) {
                if (v != 0.0) {
                    base = v;
                    break;
                }
            }

            if (base == 0.0) continue; // Ignorar si todos son ceros

            Object[] fila = new Object[4];
            fila[0] = nombre;

            for (int i = 0; i < 3; i++) {
                double resultado = valores[i] / base;
                fila[i + 1] = resultado * 100 + "%";
                datos.addValue(resultado * 100, nombre, etiquetasAnios[i]);
            }

            modeloTabla.addRow(fila);
        }

        JFreeChart grafica = ChartFactory.createLineChart(
            "Estructura del Activo",
            "Año",
            "Porcentaje",
            datos,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );

        CategoryPlot plot = grafica.getCategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinePaint(Color.BLACK);

        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.BLUE);
        renderer.setSeriesPaint(1, Color.RED);
        renderer.setSeriesPaint(2, Color.BLACK);

        plot.setRenderer(renderer);

        panelGrafico.removeAll();
        panelGrafico.setLayout(new BorderLayout());
        panelGrafico.add(new ChartPanel(grafica), BorderLayout.CENTER);
        panelGrafico.validate();

        return grafica;
    }

    public static JFreeChart crearGraficaEstructuraFinanciamiento(BalanceGeneral bg, JTable tablaFinanciamiento, JPanel panelGrafico) {
        List<Cuenta> cuentas = bg.getCuentas();
        DefaultTableModel modelo = (DefaultTableModel) tablaFinanciamiento.getModel();
        modelo.setRowCount(0);

        if (cuentas == null || cuentas.isEmpty()) {
            System.out.println("Error: El balance está vacío.");
            return null;
        }

        Cuenta pasivoCirculante = null;
        Cuenta pasivoFijo = null;
        Cuenta pasivoTotal = null;

        for (Cuenta c : cuentas) {
            if (c.getId() == null) continue;
            switch (c.getId()) {
                case 3:
                    pasivoCirculante = c;
                    break;
                case 4:
                    pasivoFijo = c;
                    break;
                case 5:
                    pasivoTotal = c;
                    break;
            }
        }

        if (pasivoCirculante == null || pasivoFijo == null || pasivoTotal == null) {
            System.out.println("Error: Faltan cuentas requeridas (ID 3, 4, 5). No se puede generar la gráfica.");
            return null;
        }

        List<Cuenta> cuentasGraficar = List.of(pasivoCirculante, pasivoFijo, pasivoTotal);
        String[] categorias = {"Año 1", "Año 2", "Año 3"};
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Cuenta cuenta : cuentasGraficar) {
            double[] valores = cuenta.getValoresDeLosAnios();
            double base = 0.0;
            for (double v : valores) {
                if (v != 0.0) {
                    base = v;
                    break;
                }
            }

            if (base == 0.0) {
                modelo.addRow(new Object[]{cuenta.getNombreCuenta(), "0.0%", "0.0%", "0.0%"});
                continue;
            }

            Object[] fila = new Object[4];
            fila[0] = cuenta.getNombreCuenta();

            for (int j = 0; j < 3; j++) {
                double resultado = (valores[j] / base) * 100;
                fila[j + 1] = resultado + "%";
                dataset.addValue(resultado, cuenta.getNombreCuenta(), categorias[j]);
            }

            modelo.addRow(fila);
        }

        JFreeChart chart = ChartFactory.createLineChart(
            "Estructura del Financiamiento",
            "Año",
            "Porcentaje",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setBackgroundPaint(Color.WHITE);

        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        renderer.setSeriesPaint(0, new Color(51, 51, 255));   // Pasivo Circulante
        renderer.setSeriesPaint(1, new Color(204, 51, 255));  // Pasivo Fijo
        renderer.setSeriesPaint(2, new Color(255, 102, 102)); // Pasivo Total

        plot.setRenderer(renderer);

        panelGrafico.removeAll();
        panelGrafico.setLayout(new BorderLayout());
        panelGrafico.add(new ChartPanel(chart), BorderLayout.CENTER);
        panelGrafico.validate();

        return chart;
    }
    
    public static JFreeChart crearGraficaEstructuraOperacion(BalanceGeneral bg, JTable tablaOperacion, JPanel panelOperacion) {
        List<Cuenta> listaCuentas = bg.getCuentas();
        DefaultTableModel modelo = (DefaultTableModel) tablaOperacion.getModel();
        modelo.setRowCount(0);

        if (listaCuentas == null || listaCuentas.isEmpty()) {
            System.out.println("Error: El balance está vacío.");
            return null;
        }

        Cuenta cuentaVentas = null;
        Cuenta cuentaCostoVentas = null;
        Cuenta cuentaGastosf = null;

        for (Cuenta c : listaCuentas) {
            Integer id = c.getId();
            if (id == null) continue;
            switch (id) {
                case 12:
                    cuentaVentas = c;
                    break;
                case 13:
                    cuentaCostoVentas = c;
                    break;
                case 19:
                    cuentaGastosf = c; // Gasto de Interés o Gastos Financieros
                    break;
            }
        }
        System.out.println(cuentaGastosf.getValoresDeLosAnios()[0] + ", " + cuentaGastosf.getValoresDeLosAnios()[1] + ", "
                + cuentaGastosf.getValoresDeLosAnios()[2]
        );
        if (cuentaVentas == null || cuentaCostoVentas == null || cuentaGastosf == null) {
            System.out.println("Error: Faltan una o más cuentas necesarias (IDs 12, 13, 10).");
            
            return null;
            
        }

        List<Cuenta> cuentasGraficables = List.of(cuentaVentas, cuentaCostoVentas, cuentaGastosf);
        String[] etiquetas = {"Año 1", "Año 2", "Año 3"};
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        double[] respaldo = {0, 0, 0};
        for (Cuenta cuenta : cuentasGraficables) {
            if (cuenta == null) {cuenta.setValoresDeLosAnios(respaldo); }
            double[] valores = cuenta.getValoresDeLosAnios();
            double base = 0.0;

            for (double v : valores) {
                if (v != 0.0) {
                    base = v;
                    break;
                }
            }

            if (base == 0.0) {
                modelo.addRow(new Object[]{cuenta.getNombreCuenta(), "0.0%", "0.0%", "0.0%"});
                continue;
            }

            Object[] fila = new Object[4];
            fila[0] = cuenta.getNombreCuenta();

            for (int j = 0; j < 3; j++) {
                double porcentaje = (valores[j] / base) * 100;
                fila[j + 1] = porcentaje + "%";
                dataset.addValue(porcentaje, cuenta.getNombreCuenta(), etiquetas[j]);
            }

            modelo.addRow(fila);
        }

        JFreeChart grafica = ChartFactory.createLineChart(
            "Estructura de la Operación",
            "Año",
            "Porcentaje",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );

        CategoryPlot plot = grafica.getCategoryPlot();
        plot.setRangeGridlinePaint(Color.BLACK);
        plot.setBackgroundPaint(Color.WHITE);

        LineAndShapeRenderer renderer = new LineAndShapeRenderer();
        renderer.setSeriesPaint(0, new Color(51, 51, 255));     // Ventas
        renderer.setSeriesPaint(1, new Color(204, 51, 255));    // Costo de Ventas
        renderer.setSeriesPaint(2, new Color(255, 102, 102));   // Gastos de Operación
        plot.setRenderer(renderer);

        panelOperacion.removeAll();
        panelOperacion.setLayout(new BorderLayout());
        panelOperacion.add(new ChartPanel(grafica), BorderLayout.CENTER);
        panelOperacion.validate();

        return grafica;
    }

    public static JFreeChart crearGraficaEstructuraActividad(BalanceGeneral bg, JTable tablaActividad, JPanel panelActividad) {
        List<Cuenta> listaActividad = bg.getCuentas();
        DefaultTableModel modeloActividad = (DefaultTableModel) tablaActividad.getModel();
        modeloActividad.setRowCount(0);

        if (listaActividad == null || listaActividad.isEmpty()) {
            System.out.println("Error: El balance está vacío.");
            return null;
        }

        Cuenta cuentaCobrar = null;
        Cuenta cuentaInventario = null;
        Cuenta cuentaPagar = null;

        for (Cuenta cuenta : listaActividad) {
            Integer id = cuenta.getId();
            if (id == null) continue;
            switch (id) {
                case 11:
                    cuentaCobrar = cuenta;
                    break;
                case 7:
                    cuentaInventario = cuenta;
                    break;
                case 9:
                    cuentaPagar = cuenta;
                    break;
            }
        }
        System.out.println(cuentaCobrar.getValoresDeLosAnios()[0]);
        System.out.println(cuentaInventario.getValoresDeLosAnios()[0]);
        System.out.println(cuentaPagar.getValoresDeLosAnios()[0]);
        if (cuentaCobrar == null || cuentaInventario == null || cuentaPagar == null) {
            System.out.println("Error: Faltan cuentas necesarias (ID 11, 7, 9).");
            return null;
        }

        List<Cuenta> conjuntoActividad = List.of(cuentaCobrar, cuentaInventario, cuentaPagar);
        String[] etiquetasAnios = {"Año 1", "Año 2", "Año 3"};
        DefaultCategoryDataset datosActividad = new DefaultCategoryDataset();

        for (Cuenta dato : conjuntoActividad) {
            double[] anuales = dato.getValoresDeLosAnios();
            double base = 0.0;
            for (double valor : anuales) {
                if (valor != 0.0) {
                    base = valor;
                    break;
                }
            }

            if (base == 0.0) {
                modeloActividad.addRow(new Object[]{dato.getNombreCuenta(), "0.0%", "0.0%", "0.0%"});
                continue;
            }

            Object[] fila = new Object[4];
            fila[0] = dato.getNombreCuenta();

            for (int i = 0; i < 3; i++) {
                double porcentaje = (anuales[i] / base) * 100;
                fila[i + 1] = porcentaje + "%";
                datosActividad.addValue(porcentaje, dato.getNombreCuenta(), etiquetasAnios[i]);
            }

            modeloActividad.addRow(fila);
        }

        JFreeChart graficoActividad = ChartFactory.createLineChart(
            "Actividad",
            "Año",
            "Porcentaje",
            datosActividad,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );

        CategoryPlot areaGrafica = graficoActividad.getCategoryPlot();
        areaGrafica.setRangeGridlinePaint(Color.BLACK);
        areaGrafica.setBackgroundPaint(Color.WHITE);

        LineAndShapeRenderer colores = new LineAndShapeRenderer();
        colores.setSeriesPaint(0, new Color(51, 51, 255));     // Cuentas por Cobrar
        colores.setSeriesPaint(1, new Color(204, 51, 255));    // Inventarios
        colores.setSeriesPaint(2, new Color(255, 102, 102));   // Cuentas por Pagar
        areaGrafica.setRenderer(colores);

        panelActividad.removeAll();
        panelActividad.setLayout(new BorderLayout());
        panelActividad.add(new ChartPanel(graficoActividad), BorderLayout.CENTER);
        panelActividad.validate();

        return graficoActividad;
    }

    public static JFreeChart crearGraficaEstructuraMargenes(BalanceGeneral bg, JTable tablaDestino, JPanel panelDestino) {
            List<Cuenta> cuentasBase = bg.getCuentas();
            DefaultTableModel modeloTabla = (DefaultTableModel) tablaDestino.getModel();
            modeloTabla.setRowCount(0);

            if (cuentasBase == null || cuentasBase.isEmpty()) {
                System.out.println("vaicas margenes");
                return null;
            }

            Cuenta cuentaVentas = bg.buscarCuenta(12);
            Cuenta cuentaUtilidadBruta = bg.buscarCuenta(14);
            Cuenta cuentaUtilidadOperativa = bg.buscarCuenta(15);
            Cuenta cuentaUtilidadAntesImp = bg.buscarCuenta(16);
            Cuenta cuentaUtilidadNeta = bg.buscarCuenta(17);

            System.out.println("ventas: "+ cuentaVentas.getValoresDeLosAnios()[0] + ", " + cuentaVentas.getValoresDeLosAnios()[1] + ", " + cuentaVentas.getValoresDeLosAnios()[2]);
            System.out.println("utilidad bruta "+ cuentaUtilidadBruta.getValoresDeLosAnios()[0] + ", " + cuentaUtilidadBruta.getValoresDeLosAnios()[1] + ", " + cuentaUtilidadBruta.getValoresDeLosAnios()[2]);
            System.out.println("operativa"+ cuentaUtilidadOperativa.getValoresDeLosAnios()[0] + ", " + cuentaUtilidadOperativa.getValoresDeLosAnios()[1] + ", " + cuentaUtilidadOperativa.getValoresDeLosAnios()[2]);
            System.out.println("UAI"+ cuentaUtilidadAntesImp.getValoresDeLosAnios()[0] + ", " + cuentaUtilidadAntesImp.getValoresDeLosAnios()[1] + ", " + cuentaUtilidadAntesImp.getValoresDeLosAnios()[2]);
            System.out.println("utilidadneta"+cuentaUtilidadNeta.getValoresDeLosAnios()[0] + ", " + cuentaUtilidadNeta.getValoresDeLosAnios()[1] + ", " + cuentaUtilidadNeta.getValoresDeLosAnios()[2]);
            
            if (cuentaVentas == null || cuentaUtilidadBruta == null || cuentaUtilidadOperativa == null || cuentaUtilidadAntesImp == null || cuentaUtilidadNeta == null) {
                System.out.println("No se encontro alguna o todas las cuentas de MARGENES");
                return null;    
            }

            List<Cuenta> listaCuentas = List.of(cuentaVentas, cuentaUtilidadBruta, cuentaUtilidadOperativa, cuentaUtilidadAntesImp, cuentaUtilidadNeta);
            String[] etiquetasAnios = {"Año 1", "Año 2", "Año 3"};

            DefaultCategoryDataset dataset = new DefaultCategoryDataset();

            for (Cuenta cuentaActual : listaCuentas) {
                double[] valores = cuentaActual.getValoresDeLosAnios();
                double pivote = 0.0;
                for (double v : valores) {
                    if (v != 0.0) {
                        pivote = v;
                        break;
                    }
                }

                if (pivote == 0.0) {
                    modeloTabla.addRow(new Object[]{cuentaActual.getNombreCuenta(), "0.0%", "0.0%", "0.0%"});
                    continue;
                }

                Object[] fila = new Object[4];
                fila[0] = cuentaActual.getNombreCuenta();

                for (int i = 0; i < 3; i++) {
                    double resultado = (valores[i] / pivote) * 100;
                    String porcentajeTexto = String.format("%.2f%%", resultado);
                    fila[i + 1] = porcentajeTexto;
                    dataset.addValue(resultado, cuentaActual.getNombreCuenta(), etiquetasAnios[i]);
                }

                modeloTabla.addRow(fila);
            }

            JFreeChart grafica = ChartFactory.createLineChart(
                    "Márgenes", "Año", "Porcentaje", dataset,
                    PlotOrientation.VERTICAL, true, true, false
            );

            CategoryPlot configuracion = grafica.getCategoryPlot();
            configuracion.setBackgroundPaint(Color.WHITE);
            configuracion.setRangeGridlinePaint(Color.BLACK);

            LineAndShapeRenderer estilo = new LineAndShapeRenderer();
            estilo.setSeriesPaint(0, Color.BLUE);      // Ventas
            estilo.setSeriesPaint(1, Color.RED);       // UB
            estilo.setSeriesPaint(2, Color.BLACK);     // UO
            estilo.setSeriesPaint(3, new Color(128, 0, 128)); // Morado - UAI
            estilo.setSeriesPaint(4, new Color(255, 140, 0)); // Naranja - UN
            configuracion.setRenderer(estilo);

            panelDestino.removeAll();
            panelDestino.setLayout(new BorderLayout());
            panelDestino.add(new ChartPanel(grafica), BorderLayout.CENTER);
            panelDestino.validate();

            return grafica;
    }

    
    public static void exportarGraficaComoPNG(JFreeChart chart, int idPractica, String nombreGrafica) {
        if (chart == null) {
            JOptionPane.showMessageDialog(null, "No se generó la gráfica. El objeto está vacío.");
            return;
        }

        try {
            // Obtener ruta de la carpeta "Documentos" del usuario
            String rutaDocumentos = System.getProperty("user.home") + File.separator + "Documents";
            String rutaDestino = rutaDocumentos + File.separator + idPractica;

            File carpeta = new File(rutaDestino);
            if (!carpeta.exists()) {
                carpeta.mkdirs();
            }

            // Crear archivo PNG con nombre solicitado
            File archivoImagen = new File(carpeta, nombreGrafica + ".png");

            // Guardar imagen en tamaño estándar 800x600 (se sobrescribe si ya existe)
            ChartUtilities.saveChartAsPNG(archivoImagen, chart, 800, 600);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la imagen: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
    

