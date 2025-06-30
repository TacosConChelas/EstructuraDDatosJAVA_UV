/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;


import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

public class Celular_OAD {

    public static boolean guardarTabla(Object[] datos) {
        Conectar conect = new Conectar(); Connection con = null; Statement st = null;
        int validacion = JOptionPane.showConfirmDialog(null, "¿Deseas realizar la accion?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (validacion == JOptionPane.YES_OPTION) {
            try {
                con = conect.getConnection(); st = con.createStatement();
                
                int id = Integer.parseInt(datos[0].toString());
                String nombre = datos[1].toString();
                String marca = datos[2].toString();
                double precio = Double.parseDouble(datos[3].toString());
                int cantidad = Integer.parseInt(datos[4].toString());
                double descuento = Double.parseDouble(datos[5].toString());
                double camaraPrincipal = Double.parseDouble(datos[6].toString());
                double camaraFrontal = Double.parseDouble(datos[7].toString());
                double memoriaRAM = Double.parseDouble(datos[8].toString());
                double almacenamientoGB = Double.parseDouble(datos[9].toString());

                String sql = "INSERT INTO celular (idCelular, nombreProducto, marcaProducto, precioProducto, cantidadExistencia, descuentoProducto, camaraPrincipal, camaraFrontal, memoriaRAM, almacenamientoGB) "
                        + "VALUES (" + id + ", '" + nombre + "', '" + marca + "', " + precio + ", " + cantidad + ", " + descuento + ", " + camaraPrincipal + ", " + camaraFrontal + ", " + memoriaRAM + ", " + almacenamientoGB + ");";

                st.executeUpdate(sql); JOptionPane.showMessageDialog(null, "Guardados."); return true;
                // st.executeBatch(); 
            } catch (SQLException e) { System.out.println("Error al guardar celulares: " + e); return false; } 
        }
        return false;
    }

    public static void traerDatos(JTable tabla) {
        Conectar conect = new Conectar(); Connection con = null; Statement st = null; ResultSet rs = null; DefaultTableModel modeloArticulo;
        modeloArticulo = (DefaultTableModel) tabla.getModel(); modeloArticulo.setRowCount(0); 
        String sql = "SELECT * FROM celular ORDER BY nombreProducto ASC;";

        try {
            con = conect.getConnection(); st = con.createStatement(); rs = st.executeQuery(sql); Object[] fila = new Object[10];

            while (rs.next()) {
                fila[0] = rs.getInt("idCelular"); fila[1] = rs.getString("nombreProducto"); fila[2] = rs.getString("marcaProducto"); fila[3] = rs.getDouble("precioProducto");
                fila[4] = rs.getInt("cantidadExistencia"); fila[5] = rs.getDouble("descuentoProducto"); fila[6] = rs.getDouble("camaraPrincipal");
                fila[7] = rs.getDouble("camaraFrontal"); fila[8] = rs.getDouble("memoriaRAM"); fila[9] = rs.getDouble("almacenamientoGB"); modeloArticulo.addRow(fila);
            }

        } catch (SQLException e) {    System.out.println("Error al obtener los celulares: " + e);        } 

    }

    public static boolean eliminarDatos(int id) {
        Conectar conect = new Conectar(); Connection con = null; Statement st = null; String sql = "DELETE FROM celular WHERE idCelular = " + id;

        try {
            con = conect.getConnection(); st = con.createStatement(); st.executeUpdate(sql); JOptionPane.showMessageDialog(null, "eliminado."); return true;

        } catch (SQLException e) { System.out.println("Error al eliminar celular: " + e); return false; } 
    }

    public static boolean modificar(Celular c) {
        Conectar conect = new Conectar(); Connection con = null;Statement st = null;

        String sql = "UPDATE celular SET " + "nombreProducto = '" + c.getNombreProducto() + "', " + "marcaProducto = '" + c.getMarcaProducto() + "', "
                + "precioProducto = " + c.getPrecioProductoBase() + ", " + "cantidadExistencia = " + c.getCantidadExistencia() + ", "
                + "descuentoProducto = " + c.getDescuentoProducto() + ", " + "camaraPrincipal = " + c.getCamaraPrincipal() + ", "
                + "camaraFrontal = " + c.getCamaraFrontal() + ", " + "memoriaRAM = " + c.getMemoriaRAM() + ", "
                + "almacenamientoGB = " + c.getAlmacenamientoGB() + " WHERE idCelular = " + c.getIdProducto() + ";";


        try {
            con = conect.getConnection(); st = con.createStatement();
            st.executeUpdate(sql);JOptionPane.showMessageDialog(null, "Modificado."); return true;

        } catch (SQLException e) { System.out.println("Error : " + e); return false; } 
    }

    public static void buscarCel(int id, JTable jTProductos) {
        Conectar conect = new Conectar(); Connection con = null; Statement st = null;ResultSet rs = null; DefaultTableModel modelo;
        String sql = "SELECT * FROM celular WHERE idCelular = " + id + ";";

        try {
            con = conect.getConnection();    st = con.createStatement(); rs = st.executeQuery(sql); modelo = (DefaultTableModel) jTProductos.getModel();
            modelo.setRowCount(0); Object[] fila = new Object[10];

            while (rs.next()) {
                fila[0] = rs.getInt("idCelular"); fila[1] = rs.getString("nombreProducto"); fila[2] = rs.getString("marcaProducto"); fila[3] = rs.getDouble("precioProducto");
                fila[4] = rs.getInt("cantidadExistencia"); fila[5] = rs.getDouble("descuentoProducto"); fila[6] = rs.getDouble("camaraPrincipal");
                fila[7] = rs.getDouble("camaraFrontal");  fila[8] = rs.getDouble("memoriaRAM"); fila[9] = rs.getDouble("almacenamientoGB"); modelo.addRow(fila);
            }   jTProductos.setModel(modelo);

        } catch (SQLException e) { System.out.println("Error : " + e); } 
    }
}
