/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TheOneAboveAll
 */
public class BitacoraUser {
    public int idUsuario;
    
    Conexion conect = new Conexion();
    Connection con;
    Statement st;
    DefaultTableModel modeloArticulo;
    ResultSet rs;
    
    
    //setters y getters
   
    
    
    
    public BitacoraUser(){
        
    
    }
    
            
    public void vitacoraUsuarioArticulos(int opcion, int idU){
        /**0 Agregar algo a una tabla
         * 1 Eliminar algo de una tabla
         * 2 Actualizar algo de una tabla
         * 3 Mostrar los elementos de una tabla
        */
        Date fechaD = new Date();
        String sqlVitacoraU = "";
        switch(opcion){
            
            case 0: 
                sqlVitacoraU = "insert into vitacora values (" + idU + ", '" + fechaD.toString() + "', 'Insercion de nuevos Articulos', 'Tabla de Articulos');";
                break;
            case 1:
                sqlVitacoraU = "insert into vitacora values (" + idU + ", '" + fechaD.toString() + "', 'Eliminacion Articulos', 'Tabla de Articulos');";
                break;
            case 2:
                sqlVitacoraU = "insert into vitacora values (" + idU + ", '" + fechaD.toString() + "', 'Actualizacion de Articulos', 'Tabla de Articulos');";
                break;
            case 3: 
                sqlVitacoraU = "insert into vitacora values (" + idU + ", '" + fechaD.toString() + "', 'Visualizacion de  Articulos', 'Tabla de Articulos');";
                break;
            default:     System.out.println("Sucedio un error en la insercion de la ultima accion realizada en la tabla de usuarios");
                break;
        }
        try{
                con=conect.getConnection();
                st=con.createStatement();
                con.setAutoCommit(false);
                st.addBatch(sqlVitacoraU);
                st.executeBatch();
                con.commit();
                con.setAutoCommit(true);
            
                //JOptionPane.showMessageDialog(null, "Registro exitoso a la base de datos");
                
            }catch(SQLException e){
                System.out.println(" El error es " + e);
            }  finally {
                try {
                    if (st != null) st.close();
                    if (con != null) con.close();
                } catch (SQLException e) {  System.out.println("Error al cerrar la conexión: " + e);    }
            } 
    
    }
    
    
    public void vitacoraUsuarioEmpleados(int opcion, int idU){
        /**0 Agregar algo a una tabla
         * 1 Eliminar algo de una tabla
         * 2 Actualizar algo de una tabla
         * 3 Mostrar los elementos de una tabla
        */
        Date fechaD = new Date();
        String sqlVitacoraU = "";
        
        switch(opcion){
            case 0: 
                sqlVitacoraU = "insert into vitacora values (" + idU + ", '" + fechaD.toString() + "', 'Insercion de nuevos Empleados', 'Tabla de Empleados');";
                break;
            case 1:
                sqlVitacoraU = "insert into vitacora values (" + idU + ", '" + fechaD.toString() + "', 'Eliminacion de Empleados', 'Tabla de Empleados');";
                break;
            case 2:
                sqlVitacoraU = "insert into vitacora values (" + idU + ", '" + fechaD.toString() + "', 'Actualizacion de Empleados', 'Tabla de Empleados');";
                break;
            case 3: 
                sqlVitacoraU = "insert into vitacora values (" + idU + ", '" + fechaD.toString() + "', 'Visualizacion de  Empleados', 'Tabla de Empleados');";
                break;
            default:     System.out.println("Sucedio un error en la insercion de la ultima accion realizada en la tabla de usuarios");
                break;
        }
        try{
                con=conect.getConnection();
                st=con.createStatement();
                con.setAutoCommit(false);
                st.addBatch(sqlVitacoraU);
                st.executeBatch();
                con.commit();
                con.setAutoCommit(true);
            
                //JOptionPane.showMessageDialog(null, "Registro exitoso a la base de datos");
                
            }catch(SQLException e){
                System.out.println(" El error es " + e);
            }  finally {
                try {
                    if (st != null) st.close();
                    if (con != null) con.close();
                } catch (SQLException e) {  System.out.println("Error al cerrar la conexión: " + e);    }
            } 
        
        
    }
    
    public void vitacoraUsuarioProveedores(int opcion, int idU){
        /**0 Agregar algo a una tabla
         * 1 Eliminar algo de una tabla
         * 2 Actualizar algo de una tabla
         * 3 Mostrar los elementos de una tabla
        */
        Date fechaD = new Date();
        String sqlVitacoraU = "";
        
        switch(opcion){
            case 0: 
                sqlVitacoraU = "insert into vitacora values (" + idU + ", '" + fechaD.toString() + "', 'Insercion de nuevos Proveedores', 'Tabla de Proveedores');";
                break;
            case 1:
                sqlVitacoraU = "insert into vitacora values (" + idU + ", '" + fechaD.toString() + "', 'Eliminacion de Proveedores', 'Tabla de Proveedores');";
                break;
            case 2:
                sqlVitacoraU = "insert into vitacora values (" + idU + ", '" + fechaD.toString() + "', 'Actualizacion de Proveedores', 'Tabla de Proveedores');";
                break;
            case 3: 
                sqlVitacoraU = "insert into vitacora values (" + idU + ", '" + fechaD.toString() + "', 'Visualizacion de  Proveedores', 'Tabla de Proveedores');";
                break;
            default:     System.out.println("Sucedio un error en la insercion de la ultima accion realizada en la tabla de usuarios");
                break;
        }
        try{
                con=conect.getConnection();
                st=con.createStatement();
                con.setAutoCommit(false);
                st.addBatch(sqlVitacoraU);
                st.executeBatch();
                con.commit();
                con.setAutoCommit(true);
            
                //JOptionPane.showMessageDialog(null, "Registro exitoso a la base de datos");
                
            }catch(SQLException e){
                System.out.println(" El error es " + e);
            }  finally {
                try {
                    if (st != null) st.close();
                    if (con != null) con.close();
                } catch (SQLException e) {  System.out.println("Error al cerrar la conexión: " + e);    }
            } 
        
        
    }
    
    
    public void vitacoraUsuarioSistema(int idUser, int opcion){
        /*
        0 creacion del perfil
        1 ingreso al sistema
        2 respaldo bd
        3 entrar a la vitacora
        4 imprecion de vitacora
        */
        
        Date fechaD = new Date();
        String sqlVitacoraU = "";
        
        switch(opcion){
            case 0: 
                sqlVitacoraU = "insert into vitacora values (" + idUser + ", '" + fechaD.toString() + "', 'Creacion del perfil del usuario', 'Ninguna');";
                break;
            case 1:
                sqlVitacoraU = "insert into vitacora values (" + idUser + ", '" + fechaD.toString() + "', 'El usuario ingreso al sistema', 'Ninguna');";
                break;
            case 2:
                sqlVitacoraU = "insert into vitacora values (" + idUser + ", '" + fechaD.toString() + "', 'El usuario realizo un respaldo de la base de datos', 'Ninguna');";
                break;
            case 3: 
                sqlVitacoraU = "insert into vitacora values (" + idUser + ", '" + fechaD.toString() + "', 'El usuario entro a la bitacora de usuarios', 'Ninguna');";
                break;
            case 4: 
                sqlVitacoraU = "insert into vitacora values (" + idUser + ", '" + fechaD.toString() + "', 'El usuario imprimio una bitacora de usuarios', 'Ninguna');";
                break;
            default:     System.out.println("Sucedio un error en la insercion de la ultima accion realizada en la tabla de usuarios");
                break;
        }
        try{
                con=conect.getConnection();
                st=con.createStatement();
                con.setAutoCommit(false);
                st.addBatch(sqlVitacoraU);
                st.executeBatch();
                con.commit();
                con.setAutoCommit(true);
            
                //JOptionPane.showMessageDialog(null, "Registro exitoso a la base de datos");
                
            }catch(SQLException e){
                System.out.println(" El error es " + e);
            }  finally {
                try {
                    if (st != null) st.close();
                    if (con != null) con.close();
                } catch (SQLException e) {  System.out.println("Error al cerrar la conexión: " + e);    }
            } 
    
    }
}
