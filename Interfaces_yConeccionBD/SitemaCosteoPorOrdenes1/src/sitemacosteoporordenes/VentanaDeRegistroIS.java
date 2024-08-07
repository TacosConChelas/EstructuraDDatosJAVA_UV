/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sitemacosteoporordenes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author monfi
 */
public class VentanaDeRegistroIS extends javax.swing.JFrame {

    /**
     * Creates new form VentanaDeRegistroIS
     */
    public VentanaDeRegistroIS() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPResgirtroIS = new javax.swing.JPanel();
        jBRegistrar = new javax.swing.JButton();
        jBCanselar = new javax.swing.JButton();
        jLNombreStstic = new javax.swing.JLabel();
        jLContrasenastatic = new javax.swing.JLabel();
        jTNombre = new javax.swing.JTextField();
        jTContrasena = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPResgirtroIS.setBackground(new java.awt.Color(255, 245, 225));
        jPResgirtroIS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jBRegistrar.setBackground(new java.awt.Color(139, 69, 19));
        jBRegistrar.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jBRegistrar.setText("Registrar");
        jPResgirtroIS.add(jBRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, -1));

        jBCanselar.setBackground(new java.awt.Color(120, 68, 68));
        jBCanselar.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jBCanselar.setText("Cancelar");
        jBCanselar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBCanselarActionPerformed(evt);
            }
        });
        jPResgirtroIS.add(jBCanselar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, -1, -1));

        jLNombreStstic.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLNombreStstic.setForeground(new java.awt.Color(30, 30, 30));
        jLNombreStstic.setText("Nombre:");
        jPResgirtroIS.add(jLNombreStstic, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 56, 74, 30));

        jLContrasenastatic.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLContrasenastatic.setForeground(new java.awt.Color(30, 30, 30));
        jLContrasenastatic.setText("Contrasena:");
        jPResgirtroIS.add(jLContrasenastatic, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 154, 74, 30));

        jTNombre.setBackground(new java.awt.Color(255, 245, 225));
        jTNombre.setForeground(new java.awt.Color(30, 30, 30));
        jTNombre.setText("Nuevo Nombre");
        jTNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNombreActionPerformed(evt);
            }
        });
        jPResgirtroIS.add(jTNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 209, 30));

        jTContrasena.setBackground(new java.awt.Color(255, 245, 225));
        jTContrasena.setForeground(new java.awt.Color(30, 30, 30));
        jTContrasena.setText("Nueva Contrasena");
        jTContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTContrasenaActionPerformed(evt);
            }
        });
        jPResgirtroIS.add(jTContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 190, 207, 30));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 30, 30));
        jLabel1.setText("Registro");
        jPResgirtroIS.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(246, 214, 162));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 3));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPResgirtroIS.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 210, 3));

        jPanel2.setBackground(new java.awt.Color(246, 214, 162));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3, Short.MAX_VALUE)
        );

        jPResgirtroIS.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 210, 3));

        jLabel2.setForeground(new java.awt.Color(30, 30, 30));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Grafica2.jpg"))); // NOI18N
        jPResgirtroIS.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 280, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPResgirtroIS, javax.swing.GroupLayout.PREFERRED_SIZE, 546, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPResgirtroIS, javax.swing.GroupLayout.PREFERRED_SIZE, 296, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTContrasenaActionPerformed
        // TODO add your handling code here:
        // Obtener el texto del campo de entrada de la contraseña
        String contrasenaUsuario = jTContrasena.getText();
    }//GEN-LAST:event_jTContrasenaActionPerformed


    // Método para guardar el nombre de usuario y la contraseña en una base de datos MySQL
    private void guardarNombreYContrasenaEnBaseDeDatos(String nombreUsuario, String contrasenaUsuario) {
       

        
    }

    private void jTNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNombreActionPerformed
        // TODO add your handling code here:
        // Obtener el texto del campo de entrada
        String nombreUsuario = jTNombre.getText();
    }//GEN-LAST:event_jTNombreActionPerformed


    private void jBCanselarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBCanselarActionPerformed
        // TODO add your handling code here:
        // Ocultar la ventana actual (ventana de registro)
        this.setVisible(false);

        // Mostrar la ventana de inicio de sesión
        VentanaInicioSecion inicioSecion = new VentanaInicioSecion();
        inicioSecion.setVisible(true);
        inicioSecion.setLocationRelativeTo(null);
    }//GEN-LAST:event_jBCanselarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBCanselar;
    private javax.swing.JButton jBRegistrar;
    private javax.swing.JLabel jLContrasenastatic;
    private javax.swing.JLabel jLNombreStstic;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPResgirtroIS;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTContrasena;
    private javax.swing.JTextField jTNombre;
    // End of variables declaration//GEN-END:variables
}
