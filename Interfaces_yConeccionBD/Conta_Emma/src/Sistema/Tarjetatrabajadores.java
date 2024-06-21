package Sistema;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Tarjetatrabajadores extends javax.swing.JFrame {
    Conexion conect = new Conexion();
    Statement statement;
    
    Connection coneccion;

    public Tarjetatrabajadores() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fecha2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        noHoras1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tarifa1 = new javax.swing.JTextField();
        Tot1 = new javax.swing.JLabel();
        fecha1 = new javax.swing.JTextField();
        noHoras2 = new javax.swing.JTextField();
        tarifa2 = new javax.swing.JTextField();
        Tot2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        noOrden = new javax.swing.JTextField();
        idT1 = new javax.swing.JTextField();
        idT2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(46, 46, 46));

        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 255, 204));
        jLabel2.setText("Tarjetas de tiempo");

        jPanel2.setBackground(new java.awt.Color(179, 229, 252));

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(30, 30, 30));
        jLabel3.setText("Numero de la orden:");

        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 30, 30));
        jLabel4.setText("Fecha:");

        fecha2.setBackground(new java.awt.Color(255, 255, 255));
        fecha2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fecha2.setForeground(new java.awt.Color(0, 0, 0));
        fecha2.setMinimumSize(new java.awt.Dimension(90, 34));

        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 30, 30));
        jLabel5.setText("Número de horas:");

        noHoras1.setBackground(new java.awt.Color(255, 255, 255));
        noHoras1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        noHoras1.setForeground(new java.awt.Color(0, 0, 0));
        noHoras1.setMinimumSize(new java.awt.Dimension(90, 34));

        jLabel6.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(30, 30, 30));
        jLabel6.setText("Tarifa por Hora");

        jLabel7.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(30, 30, 30));
        jLabel7.setText("Total:");

        tarifa1.setBackground(new java.awt.Color(255, 255, 255));
        tarifa1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tarifa1.setForeground(new java.awt.Color(0, 0, 0));
        tarifa1.setMinimumSize(new java.awt.Dimension(90, 34));

        Tot1.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        Tot1.setForeground(new java.awt.Color(30, 30, 30));
        Tot1.setText("0.00");

        fecha1.setBackground(new java.awt.Color(255, 255, 255));
        fecha1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fecha1.setForeground(new java.awt.Color(0, 0, 0));
        fecha1.setMinimumSize(new java.awt.Dimension(90, 34));

        noHoras2.setBackground(new java.awt.Color(255, 255, 255));
        noHoras2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        noHoras2.setForeground(new java.awt.Color(0, 0, 0));
        noHoras2.setMinimumSize(new java.awt.Dimension(90, 34));

        tarifa2.setBackground(new java.awt.Color(255, 255, 255));
        tarifa2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tarifa2.setForeground(new java.awt.Color(0, 0, 0));
        tarifa2.setMinimumSize(new java.awt.Dimension(90, 34));

        Tot2.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        Tot2.setForeground(new java.awt.Color(30, 30, 30));
        Tot2.setText("0.00");

        jLabel10.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(30, 30, 30));
        jLabel10.setText("Total de la suma:");

        Total.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        Total.setForeground(new java.awt.Color(30, 30, 30));
        Total.setText("0.00");

        jButton1.setBackground(new java.awt.Color(179, 229, 252));
        jButton1.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Calcular");
        jButton1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jButton1ComponentResized(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(179, 229, 252));
        jButton2.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Salir y regresar al menú");
        jButton2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jButton2ComponentResized(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(179, 229, 252));
        jButton3.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 0));
        jButton3.setText("Guardar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        noOrden.setBackground(new java.awt.Color(255, 255, 255));
        noOrden.setForeground(new java.awt.Color(0, 0, 0));

        idT1.setBackground(new java.awt.Color(255, 255, 255));
        idT1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idT1.setForeground(new java.awt.Color(0, 0, 0));
        idT1.setMinimumSize(new java.awt.Dimension(90, 34));

        idT2.setBackground(new java.awt.Color(255, 255, 255));
        idT2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        idT2.setForeground(new java.awt.Color(0, 0, 0));
        idT2.setMinimumSize(new java.awt.Dimension(90, 34));

        jLabel8.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 30, 30));
        jLabel8.setText("No. de identificación del trabajador");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(noOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Total)
                        .addGap(42, 42, 42)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(17, 17, 17)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4)
                            .addComponent(fecha1, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(fecha2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idT1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(idT2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(noHoras1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(noHoras2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tarifa1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tarifa2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Tot1)
                            .addComponent(jLabel7)
                            .addComponent(Tot2))
                        .addGap(34, 34, 34))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(noOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noHoras1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tarifa1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tot1)
                    .addComponent(fecha1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idT1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(noHoras2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tarifa2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tot2)
                    .addComponent(idT2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jButton2)
                        .addComponent(jButton3))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(Total)))
                .addGap(53, 53, 53))
        );

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sistema/file6.jpg"))); // NOI18N
        jLabel1.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(270, 270, 270))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jButton1ComponentResized
    }//GEN-LAST:event_jButton1ComponentResized

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String fe2;
        int H2;
        double tarif2;
        double T2 = 0;
        
        String fe1 = fecha1.getText();
        int H1 = Integer.parseInt(noHoras1.getText());
        double tarif1 = Double.parseDouble(tarifa1.getText());
        double T1 = H1 * tarif1;
        Tot1.setText(T1 + "");
        
        if(! noHoras2.getText().isEmpty()){
            fe2 = fecha2.getText();
            H2 = Integer.parseInt(noHoras2.getText());
            tarif2 = Double.parseDouble(tarifa2.getText());
            T2 = H2 * tarif2;
            Tot2.setText(T2 + "");
        }
        
        double total = T1 + T2;
        Total.setText(total + "");
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jButton2ComponentResized
    }//GEN-LAST:event_jButton2ComponentResized

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String fe2;
        String tarif2;
        String H2;
        String id2;
        double T2 = Double.parseDouble(Tot2.getText());
        
        //si nuestro total 2 es igual a 0, entonces los valores quedaran null (vacio)
        if(T2 == 0){
            fe2 = "null";
            tarif2 = "null";
            H2 = "0";
            id2 = "null";        
        } else{
            fe2 = fecha2.getText();
            H2 = noHoras2.getText();
            tarif2 = tarifa2.getText();
            id2 = idT2.getText();
        }
        double total = Double.parseDouble(Total.getText()); //Se guarda el total
        //Se guarda el numero de ordenm
        String noO = noOrden.getText();
        String id1 = idT1.getText();
        String fe1 = fecha1.getText();
        double tarif1 = Double.parseDouble(tarifa1.getText());
        int H1 = Integer.parseInt(noHoras1.getText());
       
        String sql;
        if(T2 == 0){
            sql = "insert into tarjetat values (" + noO + ", '" + fe1 + "', " + H1 + ", " + tarif1 + ", null , " + H2 + ", " + tarif2 + ", " + total + "," + id1 + "," + id2 +");";
        } else{
            sql = "insert into tarjetat values (" + noO + ", '" + fe1 + "', " + H1 + ", " + tarif1 + ", '" + fe2 + "', " + H2 + ", " + tarif2 + ", " + total + "," + id1 + "," + id2 +");";
        }
        
        try {
            coneccion = conect.getConnection();
            statement = coneccion.createStatement();
            statement.executeUpdate(sql);
    
            System.out.println("correcto");
        } catch (SQLException e) {  System.out.println("El error es " + e);
        }

        
        
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Tarjetatrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tarjetatrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tarjetatrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tarjetatrabajadores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tarjetatrabajadores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Tot1;
    private javax.swing.JLabel Tot2;
    private javax.swing.JLabel Total;
    private javax.swing.JTextField fecha1;
    private javax.swing.JTextField fecha2;
    private javax.swing.JTextField idT1;
    private javax.swing.JTextField idT2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField noHoras1;
    private javax.swing.JTextField noHoras2;
    private javax.swing.JTextField noOrden;
    private javax.swing.JTextField tarifa1;
    private javax.swing.JTextField tarifa2;
    // End of variables declaration//GEN-END:variables
}
