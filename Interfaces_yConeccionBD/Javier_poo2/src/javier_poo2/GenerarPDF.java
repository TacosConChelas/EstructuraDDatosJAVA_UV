/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javier_poo2;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author tacosconchelas
 */
public class GenerarPDF {

    public static void crearDesdeTabla(JTable tabla) {
        Document documento = new Document();

        try {
            String nombreArchivo = "Reporte_Empleados_" + System.currentTimeMillis() + ".pdf";
            PdfWriter.getInstance(documento, new FileOutputStream(nombreArchivo));
            documento.open();

            // Fuente
            Font fuenteTitulo = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Font fuenteSubtitulo = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL);

            // Nombre empresa
            Paragraph nombreEmpresa = new Paragraph("Muebles Troncoso", fuenteTitulo);
            nombreEmpresa.setAlignment(Element.ALIGN_CENTER);
            documento.add(nombreEmpresa);

            // Título del reporte
            Paragraph titulo = new Paragraph("Reporte de Empleados", fuenteSubtitulo);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(10);
            documento.add(titulo);

            // Fecha y hora
            LocalDateTime ahora = LocalDateTime.now();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            Paragraph fecha = new Paragraph("Emitido: " + ahora.format(formato));
            fecha.setAlignment(Element.ALIGN_RIGHT);
            fecha.setSpacingAfter(15);
            documento.add(fecha);

            // Tabla PDF
            TableModel model = tabla.getModel();
            PdfPTable pdfTabla = new PdfPTable(model.getColumnCount());
            pdfTabla.setWidthPercentage(100);

            // Encabezados
            for (int i = 0; i < model.getColumnCount(); i++) {
                pdfTabla.addCell(new PdfPCell(new Phrase(model.getColumnName(i))));
            }

            // Filas
            for (int row = 0; row < model.getRowCount(); row++) {
                for (int col = 0; col < model.getColumnCount(); col++) {
                    Object valor = model.getValueAt(row, col);
                    pdfTabla.addCell(valor != null ? valor.toString() : "");
                }
            }

            documento.add(pdfTabla);
            documento.close();

            javax.swing.JOptionPane.showMessageDialog(null, "PDF generado exitosamente:\n" + nombreArchivo);

        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error al generar PDF: " + e.getMessage());
        }
    }
}

