package Interfaz;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TarjetasDTiempo extends javax.swing.JFrame {
    BaseDatos c = new BaseDatos();
    

    public TarjetasDTiempo() {
        initComponents();
        this.setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTFfecha2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTFhoras1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTFtarifa1 = new javax.swing.JTextField();
        jLTotal1 = new javax.swing.JLabel();
        jTFfecha1 = new javax.swing.JTextField();
        jTFhoras2 = new javax.swing.JTextField();
        jTFtarifa2 = new javax.swing.JTextField();
        jLTotal2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();
        jBcalcular = new javax.swing.JButton();
        jBsalir = new javax.swing.JButton();
        jBguardar = new javax.swing.JButton();
        jTFnumeroO = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTFnumeroO1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 51));

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(30, 30, 30));
        jLabel3.setText("Número de la orden:");

        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 30, 30));
        jLabel4.setText("Periodo de tiempo:");

        jTFfecha2.setBackground(new java.awt.Color(255, 255, 255));
        jTFfecha2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTFfecha2.setForeground(new java.awt.Color(0, 0, 0));
        jTFfecha2.setMinimumSize(new java.awt.Dimension(90, 34));

        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 30, 30));
        jLabel5.setText("Número de horas:");

        jTFhoras1.setBackground(new java.awt.Color(255, 255, 255));
        jTFhoras1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTFhoras1.setForeground(new java.awt.Color(0, 0, 0));
        jTFhoras1.setMinimumSize(new java.awt.Dimension(90, 34));

        jLabel6.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(30, 30, 30));
        jLabel6.setText("Tarifa por Hora");

        jLabel7.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(30, 30, 30));
        jLabel7.setText("Total:");

        jTFtarifa1.setBackground(new java.awt.Color(255, 255, 255));
        jTFtarifa1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTFtarifa1.setForeground(new java.awt.Color(0, 0, 0));
        jTFtarifa1.setMinimumSize(new java.awt.Dimension(90, 34));

        jLTotal1.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLTotal1.setForeground(new java.awt.Color(30, 30, 30));
        jLTotal1.setText("0.00");

        jTFfecha1.setBackground(new java.awt.Color(255, 255, 255));
        jTFfecha1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTFfecha1.setForeground(new java.awt.Color(0, 0, 0));
        jTFfecha1.setMinimumSize(new java.awt.Dimension(90, 34));

        jTFhoras2.setBackground(new java.awt.Color(255, 255, 255));
        jTFhoras2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTFhoras2.setForeground(new java.awt.Color(0, 0, 0));
        jTFhoras2.setMinimumSize(new java.awt.Dimension(90, 34));

        jTFtarifa2.setBackground(new java.awt.Color(255, 255, 255));
        jTFtarifa2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTFtarifa2.setForeground(new java.awt.Color(0, 0, 0));
        jTFtarifa2.setMinimumSize(new java.awt.Dimension(90, 34));

        jLTotal2.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLTotal2.setForeground(new java.awt.Color(30, 30, 30));
        jLTotal2.setText("0.00");

        jLabel10.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(30, 30, 30));
        jLabel10.setText("TOTAL:");

        Total.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        Total.setForeground(new java.awt.Color(30, 30, 30));
        Total.setText("0.00");

        jBcalcular.setBackground(new java.awt.Color(204, 204, 204));
        jBcalcular.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jBcalcular.setForeground(new java.awt.Color(0, 0, 0));
        jBcalcular.setText("Calcular los costos totales");
        jBcalcular.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jBcalcularComponentResized(evt);
            }
        });
        jBcalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcalcularActionPerformed(evt);
            }
        });

        jBsalir.setBackground(new java.awt.Color(204, 204, 204));
        jBsalir.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jBsalir.setForeground(new java.awt.Color(0, 0, 0));
        jBsalir.setText("Salir de la pantalla actual");
        jBsalir.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jBsalirComponentResized(evt);
            }
        });
        jBsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalirActionPerformed(evt);
            }
        });

        jBguardar.setBackground(new java.awt.Color(204, 204, 204));
        jBguardar.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jBguardar.setForeground(new java.awt.Color(0, 0, 0));
        jBguardar.setText("Guardar información en la base de datos");
        jBguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBguardarActionPerformed(evt);
            }
        });

        jTFnumeroO.setBackground(new java.awt.Color(255, 255, 255));
        jTFnumeroO.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 30, 30));
        jLabel8.setText("Número de la targeta de tiempo:");

        jTFnumeroO1.setBackground(new java.awt.Color(255, 255, 255));
        jTFnumeroO1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel9.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(30, 30, 30));
        jLabel9.setText("Targeta de tiempo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jTFnumeroO1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTFnumeroO, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(Total))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4)
                                    .addComponent(jTFfecha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTFfecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jTFhoras1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFhoras2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFtarifa1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFtarifa2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLTotal2)
                                    .addComponent(jLTotal1)
                                    .addComponent(jLabel7))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBcalcular, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBguardar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBsalir, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFnumeroO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jTFnumeroO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel9)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFhoras1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFtarifa1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLTotal1)
                            .addComponent(jTFfecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFfecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFhoras2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFtarifa2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLTotal2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(Total)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jBcalcular)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBguardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBsalir)))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBcalcularComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jBcalcularComponentResized
    }//GEN-LAST:event_jBcalcularComponentResized

    private void jBcalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcalcularActionPerformed
        String fecha2;
        int hora2;
        double tarifa2;
        double Total2 = 0;
        
        String fecha1 = jTFfecha1.getText();
        int hora1 = Integer.parseInt(jTFhoras1.getText());
        double tarifa1 = Double.parseDouble(jTFtarifa1.getText());
        double total1 = hora1 * tarifa1;
        jLTotal1.setText(total1 + "");
        
        if(! jTFhoras2.getText().isEmpty()){
            fecha2 = jTFfecha2.getText();
            hora2 = Integer.parseInt(jTFhoras2.getText());
            tarifa2 = Double.parseDouble(jTFtarifa2.getText());
            Total2 = hora2 * tarifa2;
            jLTotal2.setText(Total2 + "");
        }
        
        double total = total1 + Total2;
        Total.setText(total + "");
      
    }//GEN-LAST:event_jBcalcularActionPerformed

    private void jBsalirComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jBsalirComponentResized
    }//GEN-LAST:event_jBsalirComponentResized

    private void jBsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalirActionPerformed
        PantallaInicialDelSistema menu = new PantallaInicialDelSistema();            
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBsalirActionPerformed

    private void jBguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBguardarActionPerformed
        String fecha2;
        String tarifa2;
        String hora2;
        double Total2 = Double.parseDouble(jLTotal2.getText());

        // Si nuestro Total2 es igual a 0, entonces los valores quedarán null (vacío)
        if(Total2 == 0){
            fecha2 = null;
            tarifa2 = "null";
            hora2 = "null";
        } else {
            fecha2 = jTFfecha2.getText();
            hora2 = jTFhoras2.getText();
            tarifa2 = jTFtarifa2.getText();
        }

        double total = Double.parseDouble(Total.getText()); // Se guarda el total
        // Se guarda el número de orden
        String numeroOrden = jTFnumeroO.getText();

        String fecha1 = jTFfecha1.getText();
        double tarifa1 = Double.parseDouble(jTFtarifa1.getText());
        int hora1 = Integer.parseInt(jTFhoras1.getText());

        String sql;
        if(Total2 == 0){
            sql = "INSERT INTO RegistroHoras " +
                  "VALUES (" + numeroOrden + ", '" + fecha1 + "', " + hora1 + ", " + tarifa1 + ", null, null, null, " + total + ");";
        } else {
            sql = "INSERT INTO RegistroHoras  " +
                  "VALUES (" + numeroOrden + ", '" + fecha1 + "', " + hora1 + ", " + tarifa1 + ", '" + fecha2 + "', " + hora2 + ", " + tarifa2 + ", " + total + ");";
        }

        try {
            Connection conex = c.getConnection();
            Statement statement = conex.createStatement();
            statement.executeUpdate(sql);
            javax.swing.JOptionPane.showMessageDialog(this, "Datos guardados exitosamente");
            
        } catch (SQLException e) { 
            System.out.println("El error es: " + e);
        }
    }//GEN-LAST:event_jBguardarActionPerformed

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
            java.util.logging.Logger.getLogger(TarjetasDTiempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TarjetasDTiempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TarjetasDTiempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TarjetasDTiempo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TarjetasDTiempo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Total;
    private javax.swing.JButton jBcalcular;
    private javax.swing.JButton jBguardar;
    private javax.swing.JButton jBsalir;
    private javax.swing.JLabel jLTotal1;
    private javax.swing.JLabel jLTotal2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTFfecha1;
    private javax.swing.JTextField jTFfecha2;
    private javax.swing.JTextField jTFhoras1;
    private javax.swing.JTextField jTFhoras2;
    private javax.swing.JTextField jTFnumeroO;
    private javax.swing.JTextField jTFnumeroO1;
    private javax.swing.JTextField jTFtarifa1;
    private javax.swing.JTextField jTFtarifa2;
    // End of variables declaration//GEN-END:variables
}
