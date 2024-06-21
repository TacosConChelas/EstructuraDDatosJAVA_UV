package Main.Logic;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author josue
 */
import Main.Logic_root.*;
import Main.Conexion;
import Main.BitacoraUser;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFProvedores1 extends javax.swing.JFrame {

    //Se crea un objeto de la case Conexion para lograr la coneccion desde quí
    Conexion conect = new Conexion();
    Connection con;
    Statement st;
    DefaultTableModel modeloArticulo;
    ResultSet rs;
    public int idUser;
    
    BitacoraUser vitacora = new BitacoraUser();
    
    public JFProvedores1(int idu) {
        initComponents();
        
        this.idUser = idu;
        
    }
    
    public void showProveedores(){
        //System.out.println("Entre al metodo");
        
        
        for (int i = 0; i < this.jTProveedores.getRowCount(); i++){
            modeloArticulo.removeRow(i);
            i = i - 1;
        }
        String sql = "select * from proveedor";
        try{
            con = conect.getConnection();
            st = con.createStatement();
            rs= st.executeQuery(sql);
            
            
            Object[] proveedores = new Object[6];
            modeloArticulo = (DefaultTableModel)this.jTProveedores.getModel();
            while(rs.next()){
                proveedores[0] = rs.getInt("idProveedor");
                proveedores[1] = rs.getString("NombrePV");
                proveedores[2] = rs.getString("email");
                proveedores[3] = rs.getString("Direccion");
                proveedores[4] = rs.getString("Compañia");
                proveedores[5] = rs.getString("Mercancia");
                
                modeloArticulo.addRow(proveedores);    
            }
            this.jTProveedores.setModel(modeloArticulo);
            
            
            //JOptionPane.showMessageDialog(null, "Registro exitoso a la base de datos");
            
        }catch(SQLException e){
            System.out.println(" El error es " + e);
        }
        
        
    }
    
    public void actualizacionTablaUsers_AfterAction(int option){
        /*
            Metodo usado para actualizar la tabla usuarios dependiendo de la ultima accion que estos hayan realizado
        */
        Date fechaD = new Date();
        String sqlVitacoraU = "";
        switch(option){
            case 0: 
                //Se hace una insercion en el campo root si este inserto nuevos proveedores
                sqlVitacoraU = "update users set dateLastActualizacion = '" + fechaD.toString() + "', lastAction = 'Insercion de nuevos Proveedores', tablaActualizada = 'Tabla de Proveedores' where idUser = 9999;";
                break;
                
            case 1:
                //Se hace una insercion en el campo root si este inserto nuevos proveedores
                sqlVitacoraU = "update users set dateLastActualizacion = '" + fechaD.toString() + "', lastAction = 'Eliminacion de Proveedores', tablaActualizada = 'Tabla de Proveedores' where idUser = 9999;";
                break;
            
            case 2:
                //Se hace una insercion en el campo root si este inserto nuevos proveedores
                sqlVitacoraU = "update users set dateLastActualizacion = '" + fechaD.toString() + "', lastAction = 'Actualizacion de Proveedores', tablaActualizada = 'Tabla de Proveedores' where idUser = 9999;";
                break;
                
            case 3: 
                //Se hace una insercion en el campo root si este inserto nuevos proveedores
                sqlVitacoraU = "update users set dateLastActualizacion = '" + fechaD.toString() + "', lastAction = 'Visualizacion de Proveedores', tablaActualizada = 'Tabla de Proveedores' where idUser = 9999;";
                break;
            default:     System.out.println("Sucedio un error en la insercion de la ultima accion realizada en la tabla de usuarios");   break;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTFIdProveedor = new javax.swing.JTextField();
        jTFNombrePV = new javax.swing.JTextField();
        jTFEmail = new javax.swing.JTextField();
        jTFDireccion = new javax.swing.JTextField();
        jBEliminar = new javax.swing.JButton();
        jBottonUpdate = new javax.swing.JButton();
        jBMostrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTFCompania = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTFMercancia = new javax.swing.JTextField();
        jBExit = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProveedores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del provedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 15), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("id Proveedor:");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre del Proveedor: ");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Email:");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Dirección:");

        jTFIdProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFIdProveedorActionPerformed(evt);
            }
        });

        jBEliminar.setText("Limpiar campos");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jBottonUpdate.setText("update");
        jBottonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBottonUpdateActionPerformed(evt);
            }
        });

        jBMostrar.setText("Mostrar productos");
        jBMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMostrarActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Compañia:");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Mercancia: ");

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addComponent(jBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jBottonUpdate)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jBExit))
                                .addComponent(jBMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(18, 18, 18))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel2))
                                            .addGap(18, 18, 18)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTFIdProveedor, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                        .addComponent(jTFNombrePV)
                                        .addComponent(jTFEmail)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTFDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jTFMercancia, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jTFCompania, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFIdProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTFNombrePV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTFDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTFCompania, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTFMercancia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBMostrar)
                    .addComponent(jBEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBExit)
                    .addComponent(jBottonUpdate))
                .addContainerGap(63, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Proveedores"));

        jTProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idProveedor", "Nombre ", "Email", "Direccion", "Compañia", "Mercancia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTProveedores.setName(""); // NOI18N
        jTProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProveedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTProveedores);
        jTProveedores.getAccessibleContext().setAccessibleName("Proveedores");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTProveedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProveedoresMouseClicked
        int fila = this.jTProveedores.getSelectedRow();
        this.jTFIdProveedor.setText(this.jTProveedores.getValueAt(fila, 0).toString());
        this.jTFNombrePV.setText(this.jTProveedores.getValueAt(fila, 1).toString());
        this.jTFEmail.setText(this.jTProveedores.getValueAt(fila, 2).toString());
        this.jTFDireccion.setText(this.jTProveedores.getValueAt(fila, 3).toString());
        this.jTFCompania.setText(this.jTProveedores.getValueAt(fila, 4).toString());
        this.jTFMercancia.setText(this.jTProveedores.getValueAt(fila, 3).toString());
        
    }//GEN-LAST:event_jTProveedoresMouseClicked

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        // TODO add your handling code here:
        
        this.jTFIdProveedor.setText("");
        this.jTFNombrePV.setText("");
        this.jTFEmail.setText("");
        this.jTFDireccion.setText("");
        this.jTFCompania.setText("");
        this.jTFMercancia.setText("");
        
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBottonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBottonUpdateActionPerformed
        int fila = this.jTProveedores.getSelectedRow();
       
        int idProveedor = Integer.parseInt( this.jTFIdProveedor.getText());
        String nameP = this.jTFNombrePV.getText();
        String email = this.jTFEmail.getText();
        
        String direccion = this.jTFDireccion.getText();
        String compania = this.jTFCompania.getText();
        String mercancia = this.jTFMercancia.getText();
        String sql = "update proveedor set NombrePV = '" + nameP + "',  email = '" + email + "', Direccion = '" + direccion + "', Compañia = '" + compania + "', Mercancia = '" + mercancia + "' where idProveedor= " + idProveedor + ";"; 
        
        int validacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas actualizar este registro?", "Confirmar actualización del registro", JOptionPane.YES_NO_OPTION);
        
        if(validacion == JOptionPane.YES_OPTION) {
            try{
                con = conect.getConnection();
                con.setAutoCommit(false);
                
                st = con.createStatement();
                st.executeUpdate(sql);
                
                con.commit();
                con.setAutoCommit(true);
               
                JOptionPane.showMessageDialog(null, "Registro exitoso");
        
                //this.actualizacionTablaUsers_AfterAction(2);
                this.vitacora.vitacoraUsuarioProveedores(2, this.idUser);
                
            }catch(SQLException e){
                System.out.println(" El error es " + e);
                
            } finally {
                try {
                    if (st != null) st.close();
                    if (con != null) con.close();
                } catch (SQLException e) {  System.out.println("Error al cerrar la conexión: " + e);    }
            } 
        
        } else {    System.out.println("Opcion cancelada por el usuario");  }
        
    }//GEN-LAST:event_jBottonUpdateActionPerformed

    
    private void jBMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMostrarActionPerformed
        // TODO add your handling code here:
        this.showProveedores();
        
        //this.actualizacionTablaUsers_AfterAction(3);
        this.vitacora.vitacoraUsuarioProveedores(3, this.idUser);
        
        
        
        
    }//GEN-LAST:event_jBMostrarActionPerformed

    private void jTFIdProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFIdProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFIdProveedorActionPerformed

    private void jBExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExitActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jBExitActionPerformed

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
            java.util.logging.Logger.getLogger(JFProvedores1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFProvedores1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFProvedores1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFProvedores1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBExit;
    private javax.swing.JButton jBMostrar;
    private javax.swing.JButton jBottonUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFCompania;
    private javax.swing.JTextField jTFDireccion;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFIdProveedor;
    private javax.swing.JTextField jTFMercancia;
    private javax.swing.JTextField jTFNombrePV;
    private javax.swing.JTable jTProveedores;
    // End of variables declaration//GEN-END:variables
}
