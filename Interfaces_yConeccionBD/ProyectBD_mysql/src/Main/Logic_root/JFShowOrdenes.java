/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main.Logic_root;

import Main.Conexion;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TheOneAboveAll
 */
public class JFShowOrdenes extends javax.swing.JFrame {

    Conexion conect = new Conexion();
    Connection con;
    Statement st;
    DefaultTableModel modeloOrdenes;
    ResultSet rs;

    /**
     * Creates new form JFShowOrdenes
     */
    public JFShowOrdenes() {
        initComponents();
        this.showOrdenes();
    }

    public void showOrdenes() {
        //System.out.println("Entre al metodo");
        for (int i = 0; i < this.jTShowOrden.getRowCount(); i++) {
            modeloOrdenes.removeRow(i);
            i = i - 1;
        }
        String sql = "select * from detallev";
        try {
            con = conect.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            Object[] detallev = new Object[4];
            modeloOrdenes = (DefaultTableModel) this.jTShowOrden.getModel();
            while (rs.next()) {
                detallev[0] = rs.getInt("idProducto");
                detallev[1] = rs.getInt("folio");
                detallev[2] = rs.getFloat("cantidad");
                detallev[3] = rs.getFloat("subtotal");
                modeloOrdenes.addRow(detallev);
            }
            this.jTShowOrden.setModel(modeloOrdenes);

            //JOptionPane.showMessageDialog(null, "Registro exitoso a la base de datos");
        } catch (SQLException e) {
            System.out.println(" El error es " + e);
        } finally {
            //cerrar conecciones con la bd
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión " + e);
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTShowOrden = new javax.swing.JTable();
        jBExit = new javax.swing.JButton();
        jBImprimirPDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTShowOrden.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idProducto", "Folio", "Cantidad", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTShowOrden);

        jBExit.setText("Salir");
        jBExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExitActionPerformed(evt);
            }
        });

        jBImprimirPDF.setText("Generar PDF");
        jBImprimirPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBImprimirPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jBExit)
                .addGap(18, 18, 18)
                .addComponent(jBImprimirPDF)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBExit)
                    .addComponent(jBImprimirPDF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jBExitActionPerformed

    private void jBImprimirPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBImprimirPDFActionPerformed
        //Se crea un reporte de tipo pdf para el proyecto
        Document documento = new Document(PageSize.A4.rotate(), 10f, 10, 100f, 0f);

        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Downloads/Productos.pdf"));
            Image logo = Image.getInstance("src/Img/img1.jpg");

            logo.scaleToFit(100, 100);
            logo.setAlignment(Chunk.HEADER);

            Paragraph titulo = new Paragraph();
            titulo.setAlignment(Paragraph.HEADER);
            titulo.setFont(FontFactory.getFont("Arial", 15, Font.ITALIC, BaseColor.BLACK));
            titulo.add("Un perrito bonito y elegante ");

            Paragraph texto = new Paragraph();
            titulo.setAlignment(Paragraph.HEADER);
            titulo.setFont(FontFactory.getFont("Arial", 10, Font.ITALIC, BaseColor.BLACK));
            titulo.add("todo bonito todo hermoso ");

            documento.open();
            documento.add(logo);
            documento.add(titulo);
            documento.add(texto);

            PdfPTable tabla = new PdfPTable(4);
            tabla.addCell("idProducto");
            tabla.addCell("folio");
            tabla.addCell("cantidad");
            tabla.addCell("subtotal");

            for (int i = 0; i < this.jTShowOrden.getRowCount(); i++) {
                modeloOrdenes.removeRow(i);
                i = i - 1;
            }
            String sql = "select * from detallev";
            try {
                con = conect.getConnection();
                st = con.createStatement();
                rs = st.executeQuery(sql);

                //Object[] detallev = new Object[4];
                modeloOrdenes = (DefaultTableModel) this.jTShowOrden.getModel();
                while (rs.next()) {
                    tabla.addCell(String.valueOf(rs.getInt("idProducto")));
                    tabla.addCell(String.valueOf(rs.getInt("folio")));
                    tabla.addCell(String.valueOf(rs.getFloat("cantidad")));
                    tabla.addCell(String.valueOf(rs.getFloat("subtotal")));
                    //modeloOrdenes.addRow(detallev);    
                }
                //this.jTShowOrden.setModel(modeloOrdenes);

                //JOptionPane.showMessageDialog(null, "Registro exitoso a la base de datos");
            } catch (SQLException e) {
                System.out.println(" El error es " + e);
            }

            documento.add(tabla);

            documento.close();
        } catch (DocumentException e) {
            System.out.println("El error es " + e);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(JFShowOrdenes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JFShowOrdenes.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jBImprimirPDFActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFShowOrdenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFShowOrdenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFShowOrdenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFShowOrdenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFShowOrdenes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBExit;
    private javax.swing.JButton jBImprimirPDF;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTShowOrden;
    // End of variables declaration//GEN-END:variables
}