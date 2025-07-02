/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto.Calculos;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.jfree.chart.JFreeChart;
//import org.jfree.chart.ChartUtils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
 *
 * @author tacosconchelas
 */
public class InformeFinanciero {
    /**
    * Genera un PDF profesional con índice, tablas y gráficas, a partir de los resultados del sistema financiero.
    * Utiliza iText 5.5.13.2.
    *
    * @param filasVertical             Tablas del análisis vertical (BG y ER)
    * @param filasHorizontalAyR        Tablas del análisis horizontal (BG)
    * @param filasResultadosHorizontalAyR Tablas del análisis horizontal (ER)
    * @param filas_razonesFinancieras  Tablas de razones financieras
    * @param filasCCE                  Tabla del CCE
    * @param balanceGeneral            Gráfica Balance General (JFreeChart)
    * @param estadoDResultados         Gráfica Estado de Resultados (JFreeChart)
    * @param calculado_CCE             Gráfica de CCE (JFreeChart)
    * @param rutaDestino               Ruta donde guardar el PDF
    */
   public static void generarReporteFinancieroPDF(
           ArrayList<Object[]> filasVertical,
           ArrayList<Object[]> filasHorizontalAyR,
           ArrayList<Object[]> filasResultadosHorizontalAyR,
           ArrayList<Object[]> filas_razonesFinancieras,
           ArrayList<Object[]> filasCCE,
           JFreeChart balanceGeneral,
           JFreeChart estadoDResultados,
           JFreeChart calculado_CCE,
           String rutaDestino
   ) {
       try {
           // 1. Documento y fuente base
           Document document = new Document(PageSize.LETTER, 45, 45, 85, 55);
           PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(rutaDestino));

           // 2. Pie de página personalizado con nombres de los integrantes
           writer.setPageEvent(new PdfPageEventHelper() {
               public void onEndPage(PdfWriter writer, Document document) {
                   Font footerFont = new Font(Font.FontFamily.HELVETICA, 8, Font.NORMAL, BaseColor.DARK_GRAY);
                   Phrase footer = new Phrase("Integrantes: GONZALEZ ALVARADO ANGEL RODRIGO, "
                           + "HERNANDEZ SANCHEZ MAXIMILIANO, "
                           + "SARMIENTO BAUTISTA TRISTAN DAVID", footerFont);
                   ColumnText.showTextAligned(writer.getDirectContent(),
                           Element.ALIGN_CENTER, footer,
                           (document.right() + document.left()) / 2,
                           document.bottom() - 10, 0);
               }
           });

           // 3. Abrir documento
           document.open();

           // 4. Portada
           Font titleFont = new Font(Font.FontFamily.HELVETICA, 22, Font.BOLD);
           Font subFont = new Font(Font.FontFamily.HELVETICA, 13, Font.NORMAL, BaseColor.DARK_GRAY);
           Font sysFont = new Font(Font.FontFamily.HELVETICA, 15, Font.BOLD, BaseColor.DARK_GRAY);

           Paragraph portada = new Paragraph("Reporte Integral de Análisis Financiero Empresarial", titleFont);
           portada.setAlignment(Element.ALIGN_CENTER);
           document.add(portada);

           document.add(new Paragraph(" "));
           Paragraph sistema = new Paragraph("SISTEMA DE INFORMACIÓN DE ANÁLISIS FINANCIERO EMPRESARIAL Y GESTIÓN DE CAPITAL DE TRABAJO", sysFont);
           sistema.setAlignment(Element.ALIGN_CENTER);
           document.add(sistema);

           document.add(new Paragraph(" "));
           Paragraph autores = new Paragraph(
                   "Integrantes:\n"
                           + "GONZALEZ ALVARADO ANGEL RODRIGO zs22021208\n"
                           + "HERNANDEZ SANCHEZ MAXIMILIANO zs22021205\n"
                           + "SARMIENTO BAUTISTA TRISTAN DAVID zs22015740", subFont);
           autores.setAlignment(Element.ALIGN_CENTER);
           document.add(autores);

           document.add(new Paragraph(" "));
           Paragraph fecha = new Paragraph("Fecha de generación: " + new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm").format(new java.util.Date()), subFont);
           fecha.setAlignment(Element.ALIGN_CENTER);
           document.add(fecha);

           document.newPage();

           // 5. Índice (tabla de contenido con referencias)
           Font idxTitle = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD);
           Font idxFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);

           document.add(new Paragraph("Índice", idxTitle));
           PdfPTable tablaIndice = new PdfPTable(new float[]{5, 1});
           tablaIndice.setWidthPercentage(80);
           tablaIndice.setSpacingBefore(20);
           tablaIndice.setSpacingAfter(20);

           // Nombres y marcas para el índice
           String[] secciones = {
                   "Análisis Vertical",
                   "Análisis Horizontal (BG)",
                   "Análisis Horizontal (Estado de Resultados)",
                   "Razones Financieras",
                   "Ciclo de Conversión de Efectivo (CCE)",
                   "Gráficas"
           };
           String[] marcas = {
                   "vertical", "horizBG", "horizER", "razones", "cce", "graficas"
           };

           for (int i = 0; i < secciones.length; i++) {
               Anchor anchor = new Anchor(secciones[i], idxFont);
               anchor.setReference("#" + marcas[i]);
               PdfPCell celdaTitulo = new PdfPCell(anchor);
               celdaTitulo.setBorder(Rectangle.NO_BORDER);
               tablaIndice.addCell(celdaTitulo);

               PdfPCell celdaPag = new PdfPCell(new Phrase(" "));
               celdaPag.setBorder(Rectangle.NO_BORDER);
               tablaIndice.addCell(celdaPag);
           }
           document.add(tablaIndice);

           // 6. Contenido principal

           // ======= 1. Análisis Vertical =======
           document.newPage();
           Anchor vanchor = new Anchor("Análisis Vertical", titleFont);
           vanchor.setName("vertical");
           document.add(vanchor);
           document.add(new Paragraph(" "));

           agregarTablaGenerica(document, filasVertical, "Análisis Vertical (BG y ER)");

           // ======= 2. Análisis Horizontal (BG) =======
           document.newPage();
           Anchor hanchor = new Anchor("Análisis Horizontal (BG)", titleFont);
           hanchor.setName("horizBG");
           document.add(hanchor);
           document.add(new Paragraph(" "));

           agregarTablaGenerica(document, filasHorizontalAyR, "Análisis Horizontal Absoluto y Relativo (BG)");

           // ======= 3. Análisis Horizontal (ER) =======
           document.newPage();
           Anchor hanchor2 = new Anchor("Análisis Horizontal (Estado de Resultados)", titleFont);
           hanchor2.setName("horizER");
           document.add(hanchor2);
           document.add(new Paragraph(" "));

           agregarTablaGenerica(document, filasResultadosHorizontalAyR, "Análisis Horizontal Absoluto y Relativo (ER)");

           // ======= 4. Razones Financieras =======
           document.newPage();
           Anchor razonanchor = new Anchor("Razones Financieras", titleFont);
           razonanchor.setName("razones");
           document.add(razonanchor);
           document.add(new Paragraph(" "));

           agregarTablaGenerica(document, filas_razonesFinancieras, "Razones Financieras");

           // ======= 5. CCE =======
           document.newPage();
           Anchor cceanchor = new Anchor("Ciclo de Conversión de Efectivo (CCE)", titleFont);
           cceanchor.setName("cce");
           document.add(cceanchor);
           document.add(new Paragraph(" "));

           agregarTablaGenerica(document, filasCCE, "Ciclo de Conversión de Efectivo (CCE)");

           // ======= 6. Gráficas =======
           document.newPage();
           Anchor ganchor = new Anchor("Gráficas", titleFont);
           ganchor.setName("graficas");
           document.add(ganchor);
           document.add(new Paragraph(" "));

           agregarGrafica(document, balanceGeneral, "Comportamiento del Balance General");
           document.add(new Paragraph(" "));
           agregarGrafica(document, estadoDResultados, "Gráfica del Estado de Resultados");
           document.add(new Paragraph(" "));
           agregarGrafica(document, calculado_CCE, "Gráfica del CCE");

           // 7. Cerrar documento
           document.close();

       } catch (Exception e) {
           e.printStackTrace();
           System.out.println("Error al crear el PDF: " + e.getMessage());
       }
   }

   /**
    * Agrega una tabla al documento PDF a partir de un ArrayList<Object[]>
    */
   private static void agregarTablaGenerica(Document document, ArrayList<Object[]> filas, String titulo) throws DocumentException {
       if (filas == null || filas.isEmpty()) return;
       Font headerFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, BaseColor.WHITE);
       Font normalFont = new Font(Font.FontFamily.HELVETICA, 11, Font.NORMAL);

       Paragraph ptitle = new Paragraph(titulo, new Font(Font.FontFamily.HELVETICA, 15, Font.BOLD));
       ptitle.setSpacingAfter(10);
       document.add(ptitle);

       int columnas = filas.get(0).length;
       PdfPTable table = new PdfPTable(columnas);
       table.setWidthPercentage(100);

       // Header
       Object[] header = {"Cuentas", "Año 1", "Año 2", "Año 3"};
       for (Object obj : header) {
           PdfPCell cell = new PdfPCell(new Phrase(obj != null ? obj.toString() : "", headerFont));
           cell.setBackgroundColor(new BaseColor(70, 130, 180));
           cell.setHorizontalAlignment(Element.ALIGN_CENTER);
           cell.setPadding(5);
           table.addCell(cell);
       }

       // Rest of rows
       for (int i = 0; i < filas.size(); i++) {
           Object[] row = filas.get(i);
           for (Object obj : row) {
               PdfPCell cell = new PdfPCell(new Phrase(obj != null ? obj.toString() : "", normalFont));
               cell.setHorizontalAlignment(Element.ALIGN_CENTER);
               cell.setPadding(5);
               table.addCell(cell);
           }
       }
       document.add(table);
   }

   /**
    * Agrega una gráfica JFreeChart al documento PDF
    */
   private static void agregarGrafica(Document document, JFreeChart chart, String titulo) throws Exception {
       if (chart == null) return;
       Paragraph ptitle = new Paragraph(titulo, new Font(Font.FontFamily.HELVETICA, 15, Font.BOLD));
       ptitle.setSpacingAfter(8);
       document.add(ptitle);

       int width = 520;
       int height = 330;
       BufferedImage image = chart.createBufferedImage(width, height);
       Image img = Image.getInstance(image, null);
       img.setAlignment(Image.ALIGN_CENTER);
       img.scaleToFit(width, height);
       document.add(img);
   }
}
