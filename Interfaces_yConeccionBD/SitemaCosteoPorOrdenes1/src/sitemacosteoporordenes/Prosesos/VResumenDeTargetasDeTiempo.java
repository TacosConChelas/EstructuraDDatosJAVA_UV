/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package sitemacosteoporordenes.Prosesos;

import sitemacosteoporordenes.VentaPrincipal;

/**
 *
 * @author monfi
 */
public class VResumenDeTargetasDeTiempo extends javax.swing.JFrame {

    /**
     * Creates new form VResumenDeTargetasDeTiempo
     */
    public VResumenDeTargetasDeTiempo() {
        initComponents();
    }
    
    public static String fecha1 = "";
    
    
    public static double t1 = 0;
    public static double t2 = 0;
    public static double t3 = 0;
    public static double t4 = 0;
    public static double t5 = 0;
    
    public static double t = 0;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JTNumeroOrden = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTFecha1 = new javax.swing.JTextField();
        jTFecha2 = new javax.swing.JTextField();
        jTFecha3 = new javax.swing.JTextField();
        jTFecha4 = new javax.swing.JTextField();
        jTNumerohoras1 = new javax.swing.JTextField();
        jTNumerohoras2 = new javax.swing.JTextField();
        jTNumerohoras3 = new javax.swing.JTextField();
        jTNumerohoras4 = new javax.swing.JTextField();
        jTTasahora = new javax.swing.JTextField();
        jTTasahora2 = new javax.swing.JTextField();
        jTTasahora3 = new javax.swing.JTextField();
        jTTasahora4 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jBVolver = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        jBNuevaTargeta = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 245, 225));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 30, 30));
        jLabel1.setText("Resumen tarjetas de Tiempo");

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(30, 30, 30));
        jLabel2.setText("Numero de orden:");

        JTNumeroOrden.setBackground(new java.awt.Color(255, 255, 255));
        JTNumeroOrden.setForeground(new java.awt.Color(30, 30, 30));

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(30, 30, 30));
        jLabel3.setText("Fecha");

        jTFecha1.setBackground(new java.awt.Color(255, 255, 255));
        jTFecha1.setForeground(new java.awt.Color(30, 30, 30));

        jTFecha2.setBackground(new java.awt.Color(255, 255, 255));
        jTFecha2.setForeground(new java.awt.Color(30, 30, 30));
        jTFecha2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFecha2ActionPerformed(evt);
            }
        });

        jTFecha3.setBackground(new java.awt.Color(255, 255, 255));
        jTFecha3.setForeground(new java.awt.Color(30, 30, 30));

        jTFecha4.setEditable(false);
        jTFecha4.setBackground(new java.awt.Color(255, 255, 255));
        jTFecha4.setForeground(new java.awt.Color(30, 30, 30));
        jTFecha4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFecha4ActionPerformed(evt);
            }
        });

        jTNumerohoras1.setBackground(new java.awt.Color(255, 255, 255));
        jTNumerohoras1.setForeground(new java.awt.Color(30, 30, 30));

        jTNumerohoras2.setBackground(new java.awt.Color(255, 255, 255));
        jTNumerohoras2.setForeground(new java.awt.Color(30, 30, 30));

        jTNumerohoras3.setBackground(new java.awt.Color(255, 255, 255));
        jTNumerohoras3.setForeground(new java.awt.Color(30, 30, 30));
        jTNumerohoras3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTNumerohoras3ActionPerformed(evt);
            }
        });

        jTNumerohoras4.setBackground(new java.awt.Color(255, 255, 255));
        jTNumerohoras4.setForeground(new java.awt.Color(30, 30, 30));

        jTTasahora.setBackground(new java.awt.Color(255, 255, 255));
        jTTasahora.setForeground(new java.awt.Color(30, 30, 30));

        jTTasahora2.setBackground(new java.awt.Color(255, 255, 255));
        jTTasahora2.setForeground(new java.awt.Color(30, 30, 30));

        jTTasahora3.setBackground(new java.awt.Color(255, 255, 255));
        jTTasahora3.setForeground(new java.awt.Color(30, 30, 30));

        jTTasahora4.setBackground(new java.awt.Color(255, 255, 255));
        jTTasahora4.setForeground(new java.awt.Color(30, 30, 30));

        jTextField14.setBackground(new java.awt.Color(255, 255, 255));
        jTextField14.setForeground(new java.awt.Color(30, 30, 30));

        jTextField15.setBackground(new java.awt.Color(255, 255, 255));
        jTextField15.setForeground(new java.awt.Color(30, 30, 30));

        jTextField16.setBackground(new java.awt.Color(255, 255, 255));
        jTextField16.setForeground(new java.awt.Color(30, 30, 30));

        jTextField17.setEditable(false);
        jTextField17.setBackground(new java.awt.Color(255, 255, 255));
        jTextField17.setForeground(new java.awt.Color(30, 30, 30));
        jTextField17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField17ActionPerformed(evt);
            }
        });

        jBVolver.setBackground(new java.awt.Color(139, 69, 19));
        jBVolver.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jBVolver.setForeground(new java.awt.Color(255, 255, 255));
        jBVolver.setText("Volver");
        jBVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBVolverActionPerformed(evt);
            }
        });

        jBGuardar.setBackground(new java.awt.Color(234, 178, 102));
        jBGuardar.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jBGuardar.setForeground(new java.awt.Color(255, 255, 255));
        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jBNuevaTargeta.setBackground(new java.awt.Color(195, 127, 61));
        jBNuevaTargeta.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jBNuevaTargeta.setForeground(new java.awt.Color(255, 255, 255));
        jBNuevaTargeta.setText("Nueva Targeta");
        jBNuevaTargeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNuevaTargetaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 30, 30));
        jLabel4.setText("Numero de horas");

        jLabel5.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 30, 30));
        jLabel5.setText("Tarifa por hora");

        jLabel6.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(30, 30, 30));
        jLabel6.setText("Total");

        jButton4.setText("jButton4");

        jLabel7.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(30, 30, 30));
        jLabel7.setText("Total");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jBVolver)
                        .addGap(56, 56, 56)
                        .addComponent(jBGuardar)
                        .addGap(69, 69, 69)
                        .addComponent(jBNuevaTargeta))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(JTNumeroOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTTasahora4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTTasahora3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTTasahora2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTTasahora, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFecha4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFecha3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTNumerohoras3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTNumerohoras4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTNumerohoras2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTNumerohoras1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(54, 54, 54))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(137, 137, 137))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(JTNumeroOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4)
                            .addComponent(jLabel7))
                        .addGap(48, 48, 48))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFecha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTNumerohoras1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTTasahora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFecha2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTNumerohoras2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTTasahora2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFecha3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTNumerohoras3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTTasahora3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFecha4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTNumerohoras4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTTasahora4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBVolver)
                    .addComponent(jBGuardar)
                    .addComponent(jBNuevaTargeta))
                .addContainerGap(36, Short.MAX_VALUE))
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

    private void jBVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBVolverActionPerformed
        // TODO add your handling code here:
        VentaPrincipal ventana = new VentaPrincipal();
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jBVolverActionPerformed

    private void jTFecha2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFecha2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFecha2ActionPerformed

    private void jTNumerohoras3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTNumerohoras3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTNumerohoras3ActionPerformed

    private void jTFecha4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFecha4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFecha4ActionPerformed

    private void jTextField17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField17ActionPerformed

    private void jBNuevaTargetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNuevaTargetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBNuevaTargetaActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
        // TODO add your handling code here:
        
        fecha1 = jTextField2.getText();
        
        
        Double nh1 = Double.parseDouble(jTextField6.getText());
        Double nh2 = Double.parseDouble(jTextField7.getText());
        Double nh3 = Double.parseDouble(jTextField8.getText());
        Double nh4 = Double.parseDouble(jTextField9.getText());
        
        Double th1 = Double.parseDouble(jTextField10.getText());
        Double th2 = Double.parseDouble(jTextField11.getText());
        Double th3 = Double.parseDouble(jTextField12.getText());
        Double th4 = Double.parseDouble(jTextField13.getText());
        
        t1=nh1*th1;
        t2=nh2*th2;
        t3=nh3*th3;
        t4=nh4*th4;
        
        jTextField14.setText(String.valueOf(t1));
        jTextField15.setText(String.valueOf(t2));
        jTextField16.setText(String.valueOf(t3));
        jTextField17.setText(String.valueOf(t4));
        
        t=t1+t2+t3+t4;
        
        jTextField1.setText(String.valueOf(t));
    }//GEN-LAST:event_jBGuardarActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JTNumeroOrden;
    private javax.swing.JButton jBGuardar;
    private javax.swing.JButton jBNuevaTargeta;
    private javax.swing.JButton jBVolver;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTFecha1;
    private javax.swing.JTextField jTFecha2;
    private javax.swing.JTextField jTFecha3;
    private javax.swing.JTextField jTFecha4;
    private javax.swing.JTextField jTNumerohoras1;
    private javax.swing.JTextField jTNumerohoras2;
    private javax.swing.JTextField jTNumerohoras3;
    private javax.swing.JTextField jTNumerohoras4;
    private javax.swing.JTextField jTTasahora;
    private javax.swing.JTextField jTTasahora2;
    private javax.swing.JTextField jTTasahora3;
    private javax.swing.JTextField jTTasahora4;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    // End of variables declaration//GEN-END:variables
}
