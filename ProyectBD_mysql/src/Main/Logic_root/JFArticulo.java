package Main.Logic_root;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author josue
 */
import Main.Conexion;
import Main.BitacoraUser;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class JFArticulo extends javax.swing.JFrame {

    //Se crea un objeto de la case Conexion para lograr la coneccion desde quí
    Conexion conect = new Conexion();
    Connection con;
    Statement st;
    DefaultTableModel modeloArticulo;
    ResultSet rs;
    public int idUser = 9999;
    
    BitacoraUser vitacora = new BitacoraUser();
    
    
    public JFArticulo() {
        initComponents();
        
        
    }
    
    public void showProductos(){
        //System.out.println("Entre al metodo");
        
        
        for (int i = 0; i < this.jTProductos.getRowCount(); i++){
            modeloArticulo.removeRow(i);
            i = i - 1;
        }
        String sqlProducto = "select * from producto";
        try{
            con = conect.getConnection();
            st = con.createStatement();
            rs= st.executeQuery(sqlProducto);
            
            
            Object[] detallev = new Object[6];
            modeloArticulo = (DefaultTableModel)this.jTProductos.getModel();
            while(rs.next()){
                detallev[0] = rs.getInt("idProducto");
                detallev[1] = rs.getString("NombreP");
                detallev[2] = rs.getString("Descripcion");
                detallev[3] = rs.getInt("PrecioCompra");
                detallev[4] = rs.getInt("PrecioVenta");
                detallev[5] = rs.getInt("Cantidad");
                
                modeloArticulo.addRow(detallev);    
            }
            this.jTProductos.setModel(modeloArticulo);
            
            
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
                sqlVitacoraU = "update users set dateLastActualizacion = '" + fechaD.toString() + "', lastAction = 'Insercion de nuevos Articulos', tablaActualizada = 'Tabla de Articulos' where idUser = 9999;";
                break;
            case 1:
                sqlVitacoraU = "update users set dateLastActualizacion = '" + fechaD.toString() + "', lastAction = 'Eliminacion de Articulos', tablaActualizada = 'Tabla de Articulos' where idUser = 9999;";
                break;
            case 2:
                sqlVitacoraU = "update users set dateLastActualizacion = '" + fechaD.toString() + "', lastAction = 'Actualizacion de Articulos', tablaActualizada = 'Tabla de Articulos' where idUser = 9999;";
                break;
            case 3: 
                sqlVitacoraU = "update users set dateLastActualizacion = '" + fechaD.toString() + "', lastAction = 'Visualizacion de Articulos', tablaActualizada = 'Tabla de Articulos' where idUser = 9999;";
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTFidProduct = new javax.swing.JTextField();
        jTFNombreP = new javax.swing.JTextField();
        jTFDescription = new javax.swing.JTextField();
        jTFPrecioCompra = new javax.swing.JTextField();
        jBAgregar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBUpdate = new javax.swing.JButton();
        jBMostrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTFPrecioVenta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTFCantidad = new javax.swing.JTextField();
        jBExit = new javax.swing.JButton();
        jBEliminarP = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProductos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos del producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 15), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("id Producto:");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre Producto: ");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Descripcion:");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Precio de Compra:");

        jTFidProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFidProductActionPerformed(evt);
            }
        });

        jBAgregar.setText("Agregar");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        jBEliminar.setText("Limpiar campos");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        jBUpdate.setText("Actualizar");
        jBUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBUpdateActionPerformed(evt);
            }
        });

        jBMostrar.setText("Mostrar productos");
        jBMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMostrarActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Precio de Venta:");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Cantidad: ");

        jBExit.setText("Salir");
        jBExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExitActionPerformed(evt);
            }
        });

        jBEliminarP.setText("Eliminar producto");
        jBEliminarP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarPActionPerformed(evt);
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
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jBEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBEliminarP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jBMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                .addComponent(jBUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBExit)))
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
                                        .addComponent(jTFidProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                        .addComponent(jTFNombreP)
                                        .addComponent(jTFDescription)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTFPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jTFCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jTFPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFidProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTFNombreP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTFPrecioCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTFPrecioVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTFCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBMostrar)
                    .addComponent(jBEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAgregar)
                    .addComponent(jBUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBEliminarP)
                    .addComponent(jBExit))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos"));

        jTProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idProducto", "Nombre", "Descripcion", "PrecioCompa", "PrecioVenta", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTProductos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
        
        ////////////////////////////////////////////////////////////////////////////////////////
        int idProducto = Integer.parseInt( this.jTFidProduct.getText());
        String nameP = this.jTFNombreP.getText();
        String description = this.jTFDescription.getText();
        //cast colocado
        Double precioCompra = Double.parseDouble(this.jTFPrecioCompra.getText());
        Double precioVenta = Double.parseDouble(this.jTFPrecioVenta.getText());
        int cantidad = Integer.parseInt(this.jTFCantidad.getText());
        
        String sqlInsertar="insert into producto values (" + idProducto + ", '" + nameP + "', '" + description + "', " + precioVenta + ", " + precioCompra + ", " + cantidad + ");";
        
        int validacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas insertar este registro?", "Confirmar insersion registro", JOptionPane.YES_NO_OPTION);
        if(validacion == JOptionPane.YES_OPTION) {
            try{
                con=conect.getConnection();
                st=con.createStatement();
                con.setAutoCommit(false);
                st.addBatch(sqlInsertar);
                st.executeBatch();
                con.commit();
                con.setAutoCommit(true);
            
                JOptionPane.showMessageDialog(null, "Registro exitoso a la base de datos");
                //this.actualizacionTablaUsers_AfterAction(0);
                this.vitacora.vitacoraUsuarioArticulos(0, this.idUser);
         
            }catch(SQLException e){
                System.out.println(" El error es " + e);
            }  finally {
                try {
                    if (st != null) st.close();
                    if (con != null) con.close();
                } catch (SQLException e) {  System.out.println("Error al cerrar la conexión: " + e);    }
            } 
        
        } else {    System.out.println("Opcion cancelada por el usuario");  }
   
    }//GEN-LAST:event_jBAgregarActionPerformed

    private void jTProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTProductosMouseClicked
        int fila = this.jTProductos.getSelectedRow();
        this.jTFidProduct.setText(this.jTProductos.getValueAt(fila, 0).toString());
        this.jTFNombreP.setText(this.jTProductos.getValueAt(fila, 1).toString());
        this.jTFDescription.setText(this.jTProductos.getValueAt(fila, 2).toString());
        this.jTFPrecioCompra.setText(this.jTProductos.getValueAt(fila, 3).toString());
        this.jTFPrecioVenta.setText(this.jTProductos.getValueAt(fila, 4).toString());
        this.jTFCantidad.setText(this.jTProductos.getValueAt(fila, 3).toString());
        
    }//GEN-LAST:event_jTProductosMouseClicked

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        // TODO add your handling code here:
        
        this.jTFidProduct.setText("");
        this.jTFNombreP.setText("");
        this.jTFDescription.setText("");
        this.jTFPrecioCompra.setText("");
        this.jTFPrecioVenta.setText("");
        this.jTFCantidad.setText("");
        
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBUpdateActionPerformed
        int fila = this.jTProductos.getSelectedRow();
       
        String nameP = this.jTFNombreP.getText();
        String description = this.jTFDescription.getText();
        int idProducto = Integer.parseInt(this.jTFidProduct.getText());
        
        double precioCompra = Double.parseDouble(this.jTFPrecioCompra.getText());
        double precioVenta = Double.parseDouble(this.jTFPrecioVenta.getText());
        int cantidad = Integer.parseInt(this.jTFCantidad.getText());
        String sql = "update producto set NombreP = '" + nameP + "',  Descripcion = '" + description + "', PrecioCompra = " + precioCompra + ", PrecioVenta = " + precioVenta + ", Cantidad = " +  cantidad + " where idProducto = " + idProducto + ";"; 
        
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
        
                //this.actualizacionTablaUsers_AfterAction(2
                this.vitacora.vitacoraUsuarioArticulos(2, this.idUser);
            }catch(SQLException e){     System.out.println(" El error es " + e);
            } finally {
                try {
                    if (st != null) st.close();
                    if (con != null) con.close();
                } catch (SQLException e) {  System.out.println("Error al cerrar la conexión: " + e);    }
            } 
        } else {    System.out.println("Opcion cancelada por el usuario");  }
        
    }//GEN-LAST:event_jBUpdateActionPerformed

    
    private void jBMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMostrarActionPerformed
        // TODO add your handling code here:
        this.showProductos();
        
        //this.actualizacionTablaUsers_AfterAction(3);
        this.vitacora.vitacoraUsuarioArticulos(3, this.idUser);
        
        
        
        
    }//GEN-LAST:event_jBMostrarActionPerformed

    private void jTFidProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFidProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFidProductActionPerformed

    private void jBExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExitActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jBExitActionPerformed

    private void jBEliminarPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarPActionPerformed
        
        
        int idProducto = Integer.parseInt(this.jTFidProduct.getText());
        
        String sqlDelete = "delete from producto where idProducto = " + idProducto + ";" ;
        
        int option = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar el registro?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
       
        if (option == JOptionPane.YES_OPTION) {
          
            try{
                con=conect.getConnection();
                st=con.createStatement();
                con.setAutoCommit(false);
                st.addBatch(sqlDelete);
                st.executeBatch();
                con.commit();
                con.setAutoCommit(true);
            
                JOptionPane.showMessageDialog(null, "Registro exitoso a la base de datos");
                
                //this.actualizacionTablaUsers_AfterAction(1);
                this.vitacora.vitacoraUsuarioArticulos(1, this.idUser);
            } catch(SQLException e){
                System.out.println(" El error es " + e);
                
            } finally {
                try {
                    if (st != null) st.close();
                    if (con != null) con.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e);
                }
            } 
            
        } else {
           System.out.println("Opcion cancelada por el usuario");
       
       }
       
         
        
    }//GEN-LAST:event_jBEliminarPActionPerformed

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
            java.util.logging.Logger.getLogger(JFArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFArticulo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFArticulo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBEliminarP;
    private javax.swing.JButton jBExit;
    private javax.swing.JButton jBMostrar;
    private javax.swing.JButton jBUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFCantidad;
    private javax.swing.JTextField jTFDescription;
    private javax.swing.JTextField jTFNombreP;
    private javax.swing.JTextField jTFPrecioCompra;
    private javax.swing.JTextField jTFPrecioVenta;
    private javax.swing.JTextField jTFidProduct;
    private javax.swing.JTable jTProductos;
    // End of variables declaration//GEN-END:variables
}
