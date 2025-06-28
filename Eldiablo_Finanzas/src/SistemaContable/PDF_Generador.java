/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaContable;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtilities;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Clase utilitaria para la generación del PDF contable.
 */
public class PDF_Generador {

    /**
     * Genera el PDF profesional de reporte contable con todos los análisis y gráficas.
     *
     * @param resultado_bg_h_absoluto HashMap análisis horizontal absoluto BG
     * @param resultado_bg_h_relativo HashMap análisis horizontal relativo BG
     * @param resultado_bg_v          HashMap análisis vertical BG
     * @param resultado_er_h_absoluto HashMap análisis horizontal absoluto ER
     * @param resultado_er_h_relativo HashMap análisis horizontal relativo ER
     * @param resultado_er_v          HashMap análisis vertical ER
     * @param resultado_R             LinkedHashMap Razones Financieras
     * @param resultado_CCE           LinkedHashMap CCE
     * @param grafica1                JFreeChart Estado de Resultados
     * @param grafica2                JFreeChart Balance General
     * @param grafica3                JFreeChart CCE
     * @throws Exception              Si ocurre un error al generar el PDF
     */
    public static void generarPDF(
        HashMap<String, double[]> resultado_bg_h_absoluto,
        HashMap<String, double[]> resultado_bg_h_relativo,
        HashMap<String, double[]> resultado_bg_v,
        HashMap<String, double[]> resultado_er_h_absoluto,
        HashMap<String, double[]> resultado_er_h_relativo,
        HashMap<String, double[]> resultado_er_v,
        LinkedHashMap<String, double[]> resultado_R,
        LinkedHashMap<String, double[]> resultado_CCE,
        LinkedHashMap<String, double[]> prediccion,
        JFreeChart grafica1,
        JFreeChart grafica2,
        JFreeChart grafica3,
        JFreeChart grafica4
        
    ) throws Exception {

        // 1. Crear el documento PDF en la ruta deseada
        String ruta = System.getProperty("user.home") + "\\Desktop\\ReporteContable.pdf";

        Document documento = new Document(PageSize.LETTER, 40, 40, 40, 40);
        PdfWriter.getInstance(documento, new FileOutputStream(ruta));
        documento.open();
            System.out.println("todo bien pdf 1");
        // 2. Fuentes
        Font titulo = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
        Font subtitulo = new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD);
        Font normal = new Font(Font.FontFamily.HELVETICA, 11, Font.NORMAL);
        Font tablaCabecera = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD);
            System.out.println("todo bien pdf 2");
        // 3. Portada
        Paragraph pTitulo = new Paragraph("SISTEMA DE INFORMACIÓN DE ANÁLISIS FINANCIERO EMPRESARIAL Y GESTIÓN DE CAPITAL DE TRABAJO", titulo);
        pTitulo.setAlignment(Element.ALIGN_CENTER);
        pTitulo.setSpacingAfter(40f);
        documento.add(pTitulo);
            System.out.println("todo bien pdf 3");
        Paragraph pIntegrantes = new Paragraph(
            "Integrantes:\n\nMariana Ortega Lucido\nSantiago de Jesús Serrano Molar\nEstrella Zapata Castillo",
            normal);
        pIntegrantes.setAlignment(Element.ALIGN_CENTER);
        documento.add(pIntegrantes);

        // Salto de página para iniciar el primer apartado en hoja nueva
        documento.newPage();
            System.out.println("todo bien pdf 4");
        // 4. Apartados
        // Apartado: Análisis Horizontal Absoluto (BG)
        agregarSeccion(documento, "Análisis Horizontal Absoluto – Balance General", resultado_bg_h_absoluto, new String[]{"Cuenta", "Año 1", "Año 2", "Año 3", "Año 4"}, tablaCabecera, normal, grafica2);

        // Apartado: Análisis Horizontal Relativo (BG)
        documento.newPage();
        agregarSeccion(documento, "Análisis Horizontal Relativo – Balance General", resultado_bg_h_relativo, new String[]{"Cuenta", "Año 1", "Año 2", "Año 3", "Año 4"}, tablaCabecera, normal, null);

        // Apartado: Análisis Vertical (BG)
        documento.newPage();
        agregarSeccion(documento, "Análisis Vertical – Balance General", resultado_bg_v, new String[]{"Cuenta", "Año 1", "Año 2", "Año 3", "Año 4"}, tablaCabecera, normal, null);

        // Apartado: Análisis Horizontal Absoluto (ER)
        documento.newPage();
        agregarSeccion(documento, "Análisis Horizontal Absoluto – Estado de Resultados", resultado_er_h_absoluto, new String[]{"Cuenta", "Año 1", "Año 2", "Año 3", "Año 4"}, tablaCabecera, normal, grafica1);

        // Apartado: Análisis Horizontal Relativo (ER)
        documento.newPage();
        agregarSeccion(documento, "Análisis Horizontal Relativo – Estado de Resultados", resultado_er_h_relativo, new String[]{"Cuenta", "Año 1", "Año 2", "Año 3", "Año 4"}, tablaCabecera, normal, null);

        // Apartado: Análisis Vertical (ER)
        documento.newPage();
        agregarSeccion(documento, "Análisis Vertical – Estado de Resultados", resultado_er_v, new String[]{"Cuenta", "Año 1", "Año 2", "Año 3", "Año 4"}, tablaCabecera, normal, null);

        // Apartado: Razones Financieras
        documento.newPage();
        agregarSeccion(documento, "Razones Financieras", resultado_R, new String[]{"Concepto", "Año 1", "Año 2", "Año 3", "Año 4"}, tablaCabecera, normal, null);

        // Apartado: CCE
        documento.newPage();
        agregarSeccion(documento, "Ciclo de Conversión de Efectivo (CCE)", resultado_CCE, new String[]{"Concepto", "Año 1", "Año 2", "Año 3", "Año 4"}, tablaCabecera, normal, grafica3);
        
        documento.newPage();
        agregarSeccion(documento, "Comparativo Real vs. Proyección — 10 Cuentas Clave", prediccion, new String[]{"Concepto", "Año 1", "Año 2", "Año 3", "Año 4"}, tablaCabecera, normal, grafica4);

        documento.close();
    }

    /**
     * Agrega una sección al PDF: subtítulo, tabla y gráfica (opcional) en la página actual.
     */
    private static void agregarSeccion(
            Document doc,
            String tituloSeccion,
            Map<String, double[]> datos,
            String[] columnas,
            Font tablaCabecera,
            Font tablaCuerpo,
            JFreeChart grafica) throws Exception {

        // Subtítulo
        Paragraph subtitulo = new Paragraph(tituloSeccion, tablaCabecera);
        subtitulo.setSpacingAfter(12f);
        doc.add(subtitulo);

        // Tabla
        PdfPTable tabla = new PdfPTable(columnas.length);
        tabla.setWidthPercentage(100);
        tabla.setSpacingBefore(10f);
        tabla.setSpacingAfter(15f);

        // Encabezados
        for (String col : columnas) {
            PdfPCell cell = new PdfPCell(new Phrase(col, tablaCabecera));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabla.addCell(cell);
        }

        // Cuerpo (datos)
        if (datos != null) {
            for (Map.Entry<String, double[]> entry : datos.entrySet()) {
                tabla.addCell(new Phrase(entry.getKey(), tablaCuerpo));
                double[] vals = entry.getValue();
                for (int i = 0; i < 4; i++) {
                    tabla.addCell(new Phrase(String.format("%.2f", (i < vals.length ? vals[i] : 0.0)), tablaCuerpo));
                }
            }
        }

        doc.add(tabla);

        // Gráfica, si existe
        if (grafica != null) {
            //igual que en el jpanel
            int anchoPanel = 1099;
            int altoPanel = 571;
            BufferedImage chartImage = grafica.createBufferedImage(anchoPanel, altoPanel);
            Image img = Image.getInstance(org.jfree.chart.ChartUtilities.encodeAsPNG(chartImage));

            // Tamaño máximo permitido en el PDF (ajusta tus márgenes si usas otros)
            float maxAncho = PageSize.LETTER.getWidth() - 2 * 40;
            float maxAlto  = PageSize.LETTER.getHeight() - 2 * 40;

            // Calcula factor de escala
            float escalaAncho = maxAncho / img.getWidth();
            float escalaAlto  = maxAlto  / img.getHeight();
            float escalaFinal = Math.min(escalaAncho, escalaAlto);

            // Aplica la escala (si es menor a 1)
            if (escalaFinal < 1.0f) {
                img.scalePercent(escalaFinal * 100f);
            }

            img.setAlignment(Element.ALIGN_CENTER);
            img.setSpacingBefore(12f);
            doc.add(img);

        }


    }
}
