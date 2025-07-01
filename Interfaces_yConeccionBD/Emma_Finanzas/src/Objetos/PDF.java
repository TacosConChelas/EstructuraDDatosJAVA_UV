/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartUtilities;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;
import javax.imageio.ImageIO;

public class PDF {

    // Fuente base para títulos y texto
    private static final Font TITLE_FONT = new Font(Font.FontFamily.HELVETICA, 22, Font.BOLD);
    private static final Font SECTION_FONT = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
    private static final Font NORMAL_FONT = new Font(Font.FontFamily.HELVETICA, 11, Font.NORMAL);
    private static final Font TABLE_HEADER_FONT = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD);

    public static void cargarPDF(
        List<Object[]> calculos_BG_H_A,
        List<Object[]> calculos_BG_H_R,
        List<Object[]> calculos_BG_V,
        List<Object[]> calculos_ER_H_A,
        List<Object[]> calculos_ER_H_R,
        List<Object[]> calculos_ER_V,
        List<Object[]> razones,
        List<Object[]> cce,
        JFreeChart graficaCCE,
        JFreeChart graficaER,
        JFreeChart graficaBG,
        String rutaDestinoPDF
    ) throws Exception {
        Document document = new Document(PageSize.LETTER, 36, 36, 54, 36);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(rutaDestinoPDF));
        document.open();

        // 1. PORTADA
        Paragraph title = new Paragraph("Reporte Financiero", TITLE_FONT);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);

        Paragraph project = new Paragraph(
            "\nSISTEMA DE INFORMACIÓN DE ANÁLISIS FINANCIERO EMPRESARIAL Y GESTIÓN DE CAPITAL DE TRABAJO", SECTION_FONT
        );
        project.setAlignment(Element.ALIGN_CENTER);
        document.add(project);

        Paragraph team = new Paragraph(
            "\nINTEGRANTES:\nAngel Jarley Garzota Barrera\nJuan Pablo Velázquez Méndez\nJearim Obed Martinez Villalba\n", NORMAL_FONT
        );
        team.setAlignment(Element.ALIGN_CENTER);
        document.add(team);

        document.newPage();

        // 2. ÍNDICE (modificar si agregas/separas secciones)
        Paragraph indice = new Paragraph("Índice", SECTION_FONT);
        indice.setAlignment(Element.ALIGN_CENTER);
        document.add(indice);

        // Manual para saltar, puedes numerar las páginas si quieres (extra)
        document.add(new Paragraph("\n1. Análisis Horizontal (Relativo y Absoluto)", NORMAL_FONT));
        document.add(new Paragraph("2. Análisis Vertical", NORMAL_FONT));
        document.add(new Paragraph("3. Razones Financieras", NORMAL_FONT));
        document.add(new Paragraph("4. Ciclo de Conversión de Efectivo (CCE)", NORMAL_FONT));
        document.add(new Paragraph("5. Gráficas", NORMAL_FONT));
        document.newPage();

        // 3. Análisis Horizontal (Relativo y Absoluto)
        document.add(new Paragraph("Análisis Horizontal (Relativo y Absoluto)", SECTION_FONT));
        document.add(new Paragraph("\nBalance General (Absoluto)", NORMAL_FONT));
        agregarTablaDesdeLista(document, calculos_BG_H_A);

        document.add(new Paragraph("\nBalance General (Relativo)", NORMAL_FONT));
        agregarTablaDesdeLista(document, calculos_BG_H_R);

        document.add(new Paragraph("\nEstado de Resultados (Absoluto)", NORMAL_FONT));
        agregarTablaDesdeLista(document, calculos_ER_H_A);

        document.add(new Paragraph("\nEstado de Resultados (Relativo)", NORMAL_FONT));
        agregarTablaDesdeLista(document, calculos_ER_H_R);
        document.newPage();

        // 4. Análisis Vertical
        document.add(new Paragraph("Análisis Vertical", SECTION_FONT));
        document.add(new Paragraph("\nBalance General", NORMAL_FONT));
        agregarTablaDesdeLista(document, calculos_BG_V);

        document.add(new Paragraph("\nEstado de Resultados", NORMAL_FONT));
        agregarTablaDesdeLista(document, calculos_ER_V);
        document.newPage();

        // 5. Razones Financieras
        document.add(new Paragraph("Razones Financieras", SECTION_FONT));
        agregarTablaDesdeLista(document, razones);
        document.newPage();

        // 6. Ciclo de Conversión de Efectivo (CCE)
        document.add(new Paragraph("Ciclo de Conversión de Efectivo (CCE)", SECTION_FONT));
        agregarTablaDesdeLista(document, cce);
        document.newPage();

        // 7. Gráficas
        document.add(new Paragraph("Gráficas", SECTION_FONT));
        agregarGrafica(document, graficaCCE, "graficaCCE.png");
        agregarGrafica(document, graficaER, "graficaER.png");
        agregarGrafica(document, graficaBG, "graficaBG.png");

        document.close();
        writer.close();
    }

    // --- Utilitarios para tabla y gráficos ---

    // Convierte List<Object[]> en PdfPTable con formato automático
    private static void agregarTablaDesdeLista(Document doc, List<Object[]> lista) throws DocumentException {
        if (lista == null || lista.isEmpty()) {
            doc.add(new Paragraph("Sin datos para mostrar.", NORMAL_FONT));
            return;
        }
        int columnas = lista.get(0).length;
        PdfPTable tabla = new PdfPTable(columnas);
        tabla.setWidthPercentage(100);

        // Encabezado
        Object[] encabezado = lista.get(0);
        for (Object head : encabezado) {
            PdfPCell cell = new PdfPCell(new Phrase(head == null ? "" : head.toString(), TABLE_HEADER_FONT));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            tabla.addCell(cell);
        }

        // Resto de filas
        for (int i = 1; i < lista.size(); i++) {
            Object[] fila = lista.get(i);
            for (Object valor : fila) {
                tabla.addCell(new Phrase(valor == null ? "" : valor.toString(), NORMAL_FONT));
            }
        }
        doc.add(tabla);
        doc.add(new Paragraph("\n"));
    }

    // Inserta una gráfica JFreeChart como imagen en el PDF (con margen inferior)
    private static void agregarGrafica(Document doc, JFreeChart chart, String nombreArchivoTemp) throws Exception {
        if (chart == null) return;
        File temp = File.createTempFile(nombreArchivoTemp, ".png");
        BufferedImage image = chart.createBufferedImage(600, 400);
        ImageIO.write(image, "png", temp);
        Image img = Image.getInstance(temp.getAbsolutePath());
        img.scaleToFit(500, 350);
        img.setAlignment(Element.ALIGN_CENTER);
        doc.add(img);
        doc.add(new Paragraph("\n\n"));
        temp.delete(); // Borra el archivo temporal
    }
}

