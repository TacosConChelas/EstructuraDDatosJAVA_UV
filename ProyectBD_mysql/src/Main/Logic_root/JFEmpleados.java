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

public class JFEmpleados extends javax.swing.JFrame {

    //Se crea un objeto de la case Conexion para lograr la coneccion desde quí
    Conexion conect = new Conexion();
    Connection con;
    Statement st;
    DefaultTableModel modeloArticulo;
    ResultSet rs;
    public int idUser = 9999;
    
    BitacoraUser vitacora = new BitacoraUser();
    
    public JFEmpleados() {
        initComponents();
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
            //select idEmpleado, NombreE, ApellidoE, tipoEmpleado from empleado;
            
            //JOptionPane.showMessageDialog(null, "Registro exitoso a la base de datos");
            
        }catch(SQLException e){
            System.out.println(" El error es " + e);
        }
        
        
    }
    
   
    
    public void actualizacionTablaUser(int option){
        /*
            Metodo usado para actualizar la tabla usuarios dependiendo de la ultima accion que estos hayan realizado
        */
        Date fechaD = new Date();
        String sqlVitacoraU = "";
        switch(option){
            case 0: 
                sqlVitacoraU = "update users set dateLastActualizacion = '" + fechaD.toString() + "', lastAction = 'Insercion de nuevos Empleados', tablaActualizada = 'Tabla de Empleados' where idUser =  9999;";
                break;
                
            case 1:
                sqlVitacoraU = "update users set dateLastActualizacion = '" + fechaD.toString() + "', lastAction = 'Eliminacion de Empleados', tablaActualizada = 'Tabla de Empleados' where idUser = 9999;";
                break;
            
            case 2:
                sqlVitacoraU = "update users set dateLastActualizacion = '" + fechaD.toString() + "', lastAction = 'Actualizacion de Empleados', tablaActualizada = 'Tabla de Empleados' where idUser = 9999;";
                break;
                
            case 3: 
                sqlVitacoraU = "update users set dateLastActualizacion = '" + fechaD.toString() + "', lastAction = 'Visualizacion de Empleados', tablaActualizada = 'Tabla de Empleados' where idUser = 9999;";
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
                System.out.println("Se actualizo correctamente la tabla users");
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
        jTFidEmpleado = new javax.swing.JTextField();
        jTFNombreE = new javax.swing.JTextField();
        jTFLastNameEmp = new javax.swing.JTextField();
        jTFHorario = new javax.swing.JTextField();
        jBAgregar = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBottonUpdate = new javax.swing.JButton();
        jBMostrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jTFEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTFDateContrato = new javax.swing.JTextField();
        jBExit = new javax.swing.JButton();
        jBEliminarEmpleado = new javax.swing.JButton();
        jTFTypeEmpleado = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEmpleados = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos de los empleados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 15), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("id Empleado:");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nombre del empleado: ");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Apellido del empleado");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Horario");

        jTFidEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFidEmpleadoActionPerformed(evt);
            }
        });

        jBAgregar.setText("Agregar empleado");
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

        jBottonUpdate.setText("Actualizar");
        jBottonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBottonUpdateActionPerformed(evt);
            }
        });

        jBMostrar.setText("Mostrar empleados");
        jBMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMostrarActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Email");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("FechaContrato");

        jBExit.setText("Salir");
        jBExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBExitActionPerformed(evt);
            }
        });

        jBEliminarEmpleado.setText("Eliminar empleado");
        jBEliminarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarEmpleadoActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Tipo de empleado");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                    .addComponent(jTFidEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                    .addComponent(jTFNombreE)
                                    .addComponent(jTFLastNameEmp)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFDateContrato, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFTypeEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(jBEliminarEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jBEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBMostrar, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                            .addComponent(jBExit)
                            .addComponent(jBottonUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFidEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTFNombreE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFLastNameEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTFHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jTFDateContrato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTFTypeEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBEliminar)
                    .addComponent(jBMostrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBEliminarEmpleado)
                    .addComponent(jBottonUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAgregar)
                    .addComponent(jBExit))
                .addGap(22, 22, 22))
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
        jTableEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEmpleados);
        jTableEmpleados.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 882, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
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
                .addGap(0, 16, Short.MAX_VALUE))
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
        int idEmpleado = Integer.parseInt( this.jTFidEmpleado.getText());
        String nameE = this.jTFNombreE.getText();
        String lastNameE = this.jTFLastNameEmp.getText();
        //cast colocado
        int horario = Integer.parseInt(this.jTFHorario.getText());
        String emailE = this.jTFEmail.getText();
        
        String dateContrato = this.jTFDateContrato.getText();
        String typeE = this.jTFTypeEmpleado.getText();
        switch(typeE){
            case "almacen": typeE = "'almacen', 1, 0, 0, 0, 0";     break;
            case "administracion": typeE = "'administracion', 0, 1, 0, 0, 0";  break;
            case "direccionG":  typeE = "'direccion', 0, 0, 1, 0, 0";  break;
            case "ventas":   typeE = "'ventas', 0, 0, 0, 1, 0";  break;
            case "compras":  typeE = "'compras', 0, 0, 0, 0, 1";  break;
        }
        
        String sqlInsertar="insert into empleado values (" + idEmpleado + ", '" + nameE + "', '" + lastNameE + "', " + horario + ", '" + emailE  + "',  '" + dateContrato + "', " + typeE + ");";
        
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
                
               //this.actualizacionTablaUser(0);
               this.vitacora.vitacoraUsuarioEmpleados(0, this.idUser);
 
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

    private void jTableEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmpleadosMouseClicked
        int fila = this.jTableEmpleados.getSelectedRow();
        this.jTFidEmpleado.setText(this.jTableEmpleados.getValueAt(fila, 0).toString());
        this.jTFNombreE.setText(this.jTableEmpleados.getValueAt(fila, 1).toString());
        this.jTFLastNameEmp.setText(this.jTableEmpleados.getValueAt(fila, 2).toString());
        this.jTFHorario.setText(this.jTableEmpleados.getValueAt(fila, 3).toString());
        this.jTFEmail.setText(this.jTableEmpleados.getValueAt(fila, 4).toString());
        this.jTFDateContrato.setText(this.jTableEmpleados.getValueAt(fila, 3).toString());
        this.jTFTypeEmpleado.setText(this.jTableEmpleados.getValueAt(fila, 6).toString());
        
    }//GEN-LAST:event_jTableEmpleadosMouseClicked

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        // TODO add your handling code here:
        
        this.jTFidEmpleado.setText("");
        this.jTFNombreE.setText("");
        this.jTFLastNameEmp.setText("");
        this.jTFHorario.setText("");
        this.jTFEmail.setText("");
        this.jTFDateContrato.setText("");
        this.jTFTypeEmpleado.setText("");
        
    }//GEN-LAST:event_jBEliminarActionPerformed

    private void jBottonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBottonUpdateActionPerformed
        int idEmpleado = Integer.parseInt( this.jTFidEmpleado.getText());
        String nameE = this.jTFNombreE.getText();
        String lastNameE = this.jTFLastNameEmp.getText();
        //cast colocado
        int horario = Integer.parseInt(this.jTFHorario.getText());
        String emailE = this.jTFEmail.getText();
        
        String dateContrato = this.jTFDateContrato.getText();
        String typeE = this.jTFTypeEmpleado.getText();
        switch(typeE){
            case "almacen": typeE = "'almacen', almacen = 1, administracion = 0, direccionG = 0, ventas =  0, compras = 0";     break;
            case "administracion": typeE = "'administracion',  almacen = 0, administracion = 1, direccionG = 0, ventas =  0, compras = 0";  break;
            case "direccionG":  typeE = "'direccion',  almacen = 0, administracion = 0, direccionG = 1, ventas =  0, compras = 0";  break;
            case "ventas":   typeE = "'ventas',  almacen = 0, administracion = 0, direccionG = 0, ventas =  1, compras = 0";  break;
            case "compras":  typeE = "'compras',  almacen = 0, administracion = 0, direccionG = 0, ventas =  0, compras = 1";  break;
        }
        
        String sqlUpdate = "update empleado set NombreE = '" + nameE + "',  ApellidoE = '" + lastNameE + "', Horario = " + horario + ", Email  = '" + emailE + "', FechaContrato = '" + dateContrato + "', tipoEmpleado = " +   typeE + " where idEmpleado = " + idEmpleado + ";"; 
        
        int validacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas actualizar este registro?", "Confirmar actualización del registro", JOptionPane.YES_NO_OPTION);
        
        if(validacion == JOptionPane.YES_OPTION) {
            try{
                con = conect.getConnection();
                con.setAutoCommit(false);
                
                st = con.createStatement();
                st.executeUpdate(sqlUpdate);
                
                con.commit();
                con.setAutoCommit(true);
               
                JOptionPane.showMessageDialog(null, "Registro exitoso");
        
                //this.actualizacionTablaUser(2);
                this.vitacora.vitacoraUsuarioEmpleados(2, this.idUser);
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
        this.showEmpleados();
        
        //this.actualizacionTablaUser(3);
        this.vitacora.vitacoraUsuarioEmpleados(3, this.idUser);
        
        
        
        
        
        
    }//GEN-LAST:event_jBMostrarActionPerformed

    private void jTFidEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFidEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFidEmpleadoActionPerformed

    private void jBExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBExitActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jBExitActionPerformed

    private void jBEliminarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarEmpleadoActionPerformed
       
        int idE = Integer.parseInt(this.jTFidEmpleado.getText());
        
        String sqlDelete = "delete from empleado where idEmpleado = " + idE + ";" ;
        
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
                
                //this.actualizacionTablaUser(1);
                this.vitacora.vitacoraUsuarioEmpleados(1, this.idUser);
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
        
        
    }//GEN-LAST:event_jBEliminarEmpleadoActionPerformed

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
            java.util.logging.Logger.getLogger(JFEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFEmpleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBEliminarEmpleado;
    private javax.swing.JButton jBExit;
    private javax.swing.JButton jBMostrar;
    private javax.swing.JButton jBottonUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFDateContrato;
    private javax.swing.JTextField jTFEmail;
    private javax.swing.JTextField jTFHorario;
    private javax.swing.JTextField jTFLastNameEmp;
    private javax.swing.JTextField jTFNombreE;
    private javax.swing.JTextField jTFTypeEmpleado;
    private javax.swing.JTextField jTFidEmpleado;
    private javax.swing.JTable jTableEmpleados;
    // End of variables declaration//GEN-END:variables
}
