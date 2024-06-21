package Main.Logic;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author josue
 */
import Main.BitacoraUser;
import Main.Logic_root.*;
import Main.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFEmpleados1 extends javax.swing.JFrame {

    //Se crea un objeto de la case Conexion para lograr la coneccion desde quí
    Conexion conect = new Conexion();
    Connection con;
    Statement st;
    DefaultTableModel modeloArticulo;
    ResultSet rs;
    public int idUser;
    
    BitacoraUser vitacora = new BitacoraUser();
    
    public JFEmpleados1(int idu) {
       initComponents();
        
        this.idUser = idu;
        System.out.println("el id en epleados es " + this.idUser  );
        vitacora.idUsuario = idu;
        
    }
    
    public void showEmpleados(){
        //System.out.println("Entre al metodo");
        
        
        for (int i = 0; i < this.jTableEmpleados.getRowCount(); i++){
            modeloArticulo.removeRow(i);
            i = i - 1;
        }
        String sql = "select idEmpleado, NombreE, ApellidoE, Horario, Email, FechaContrato, tipoEmpleado from empleado;" ;
        try{
            con = conect.getConnection();
            st = con.createStatement();
            rs= st.executeQuery(sql);
            
            
            Object[] detallev = new Object[7];
            modeloArticulo = (DefaultTableModel)this.jTableEmpleados.getModel();
            while(rs.next()){
                detallev[0] = rs.getInt("idEmpleado");
                detallev[1] = rs.getString("NombreE");
                detallev[2] = rs.getString("ApellidoE");
                detallev[3] = rs.getInt("Horario");
                detallev[4] = rs.getString("Email");
                detallev[5] = rs.getString("FechaContrato");
                detallev[6] = rs.getString("tipoEmpleado");
                
                modeloArticulo.addRow(detallev);    
            }
            this.jTableEmpleados.setModel(modeloArticulo);
            
            
            //JOptionPane.showMessageDialog(null, "Registro exitoso a la base de datos");
            
        }catch(SQLException e){
            System.out.println(" El error es " + e);
        }
        
        
    }
    
   
    
    public void actualizacionTablaUser(int option, int idu){
        /*
            Metodo usado para actualizar la tabla usuarios dependiendo de la ultima accion que estos hayan realizado
        */
        Date fechaD = new Date();
        String sqlVitacoraU = "";
        switch(option){
            
            case 3: 
                sqlVitacoraU = "update users set dateLastActualizacion = '" + fechaD.toString() + "', lastAction = 'Visualizacion de Empleados', tablaActualizada = 'Tabla de Empleados' where idUser = " + idu + ";";
                break;
            default:     System.out.println("Sucedio un error en la insercion de la ultima accion realizada en la tabla de usuarios");
                break;
        }
        
       try{
                con = conect.getConnection();
                con.setAutoCommit(false);
                
                st = con.createStatement();
                st.executeUpdate(sqlVitacoraU);
                
                con.commit();
                con.setAutoCommit(true);
               
                //JOptionPane.showMessageDialog(null, "Registro exitoso");
                System.out.println("Se actualizo correctamente la abla users");
            }catch(SQLException e){
                System.out.println(" El error es " + e);
                
            } finally {
                try {
                    if (st != null) st.close();
                    if (con != null) con.close();
                } catch (SQLException e) {  System.out.println("Error al cerrar la conexión: " + e);    }
            } 
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jBMostrar = new javax.swing.JButton();
        jBExit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEmpleados = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 15), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        jBMostrar.setText("Mostrar empleados");
        jBMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMostrarActionPerformed(evt);
            }
        });

        jBExit.setText("Salir");
        jBExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jBExit))
                    .addComponent(jBMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jBMostrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBExit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Empleados"));

        jTableEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idEmpleado", "Nombre", "Apellido", "Horario", "Email", "FechaContrato", "Tipo Empleado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableEmpleados);
        jTableEmpleados.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExitActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jBExitActionPerformed

    private void jBMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMostrarActionPerformed
        // TODO add your handling code here:
        this.showEmpleados();

        //this.actualizacionTablaUser(3, this.idUser  );
        this.vitacora.vitacoraUsuarioEmpleados(3, this.idUser); System.out.println("El id del usuario e en la clase empleados  " + this.idUser);

    }//GEN-LAST:event_jBMostrarActionPerformed

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
            java.util.logging.Logger.getLogger(JFEmpleados1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFEmpleados1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFEmpleados1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFEmpleados1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBExit;
    private javax.swing.JButton jBMostrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEmpleados;
    // End of variables declaration//GEN-END:variables
}
