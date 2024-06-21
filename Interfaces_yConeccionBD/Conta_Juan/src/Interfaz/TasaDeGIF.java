package Interfaz;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TasaDeGIF extends javax.swing.JFrame {
    BaseDatos c = new BaseDatos();
    
    
    public TasaDeGIF() {
        initComponents();
        this.setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTFgastosPresupuestados = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTFbaseA = new javax.swing.JTextField();
        jBcalcular = new javax.swing.JButton();
        jBsalir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTFtasaGIF = new javax.swing.JTextField();
        jBguardar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTFnOrden = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 255, 102));

        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 30, 30));
        jLabel4.setText("Gastos presupuestados");

        jTFgastosPresupuestados.setBackground(new java.awt.Color(255, 255, 255));
        jTFgastosPresupuestados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTFgastosPresupuestados.setForeground(new java.awt.Color(0, 0, 0));
        jTFgastosPresupuestados.setMinimumSize(new java.awt.Dimension(90, 34));

        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 30, 30));
        jLabel5.setText("Base de actividad:");

        jTFbaseA.setBackground(new java.awt.Color(255, 255, 255));
        jTFbaseA.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTFbaseA.setForeground(new java.awt.Color(0, 0, 0));
        jTFbaseA.setMinimumSize(new java.awt.Dimension(90, 34));

        jBcalcular.setBackground(new java.awt.Color(204, 204, 204));
        jBcalcular.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jBcalcular.setForeground(new java.awt.Color(0, 0, 0));
        jBcalcular.setText("Calcular los costos totales");
        jBcalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcalcularActionPerformed(evt);
            }
        });

        jBsalir.setBackground(new java.awt.Color(204, 204, 204));
        jBsalir.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jBsalir.setForeground(new java.awt.Color(0, 0, 0));
        jBsalir.setText("Salir de la pantalla actual");
        jBsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalirActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(30, 30, 30));
        jLabel7.setText("Tasa del Gif");

        jTFtasaGIF.setBackground(new java.awt.Color(255, 255, 255));
        jTFtasaGIF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTFtasaGIF.setForeground(new java.awt.Color(0, 0, 0));
        jTFtasaGIF.setMinimumSize(new java.awt.Dimension(90, 34));

        jBguardar.setBackground(new java.awt.Color(204, 204, 204));
        jBguardar.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jBguardar.setForeground(new java.awt.Color(0, 0, 0));
        jBguardar.setText("Guardar información en la base de datos");
        jBguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBguardarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(30, 30, 30));
        jLabel6.setText("Tasa del GIF");

        jTFnOrden.setBackground(new java.awt.Color(255, 255, 255));
        jTFnOrden.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTFnOrden.setForeground(new java.awt.Color(0, 0, 0));
        jTFnOrden.setMinimumSize(new java.awt.Dimension(90, 34));

        jLabel8.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 30, 30));
        jLabel8.setText("Número de la orden:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTFgastosPresupuestados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTFbaseA, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTFtasaGIF, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFnOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBcalcular)
                    .addComponent(jBguardar)
                    .addComponent(jBsalir))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTFnOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jBcalcular)
                        .addGap(7, 7, 7)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFgastosPresupuestados, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFbaseA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFtasaGIF, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jBguardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBsalir)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBcalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcalcularActionPerformed
        double gastosP = Double.parseDouble(jTFgastosPresupuestados.getText());
        double bA;
        double tgif;
        
        if(jTFbaseA.getText().isEmpty()){
            tgif = Double.parseDouble(jTFtasaGIF.getText());
            bA = gastosP / tgif; 
            jTFbaseA.setText(bA + "");
        } else { 
            bA  = Double.parseDouble(jTFbaseA.getText());
        }
        tgif = gastosP / bA;
        jTFtasaGIF.setText(tgif + "");
    }//GEN-LAST:event_jBcalcularActionPerformed

    private void jBsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalirActionPerformed
        PantallaInicialDelSistema menu = new PantallaInicialDelSistema();            
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBsalirActionPerformed

    private void jBguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBguardarActionPerformed
        String numO = jTFnOrden.getText();
        
        double gastosP = Double.parseDouble(jTFgastosPresupuestados.getText());
        double tasaGIF = Double.parseDouble(jTFtasaGIF.getText());
        double baseA = Double.parseDouble(jTFbaseA.getText());
        
        String sql = "INSERT INTO tasagif VALUES(" + numO + "," + gastosP + "," + baseA + "," + tasaGIF + ");";
        
        try {
            Connection conex = c.getConnection();
            Statement statement = conex.createStatement();
            statement.executeUpdate(sql);
            javax.swing.JOptionPane.showMessageDialog(this, "Datos guardados exitosamente");

        } catch (SQLException e) { 
            System.out.println("Hay un error en: " + e);
        }
        
    }//GEN-LAST:event_jBguardarActionPerformed

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
            java.util.logging.Logger.getLogger(TasaDeGIF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TasaDeGIF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TasaDeGIF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TasaDeGIF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TasaDeGIF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBcalcular;
    private javax.swing.JButton jBguardar;
    private javax.swing.JButton jBsalir;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTFbaseA;
    private javax.swing.JTextField jTFgastosPresupuestados;
    private javax.swing.JTextField jTFnOrden;
    private javax.swing.JTextField jTFtasaGIF;
    // End of variables declaration//GEN-END:variables
}
