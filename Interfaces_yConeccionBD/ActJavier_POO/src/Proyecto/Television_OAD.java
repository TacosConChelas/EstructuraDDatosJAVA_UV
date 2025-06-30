/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
//  

public class Television_OAD {

    public static boolean guardarTabla(Object[] datos){
        Conectar conect = new Conectar(); Connection con = null; Statement st = null;
        int validacion = JOptionPane.showConfirmDialog(null, "¿Deceas realizar esta accions?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (validacion == JOptionPane.YES_OPTION) {
            try {
                con = conect.getConnection(); st = con.createStatement(); 

                int id = Integer.parseInt(datos[0].toString());
                String nombre = datos[1].toString();
                String marca = datos[2].toString();
                double precio = Double.parseDouble(datos[3].toString());
                int cantidad = Integer.parseInt(datos[4].toString());
                double descuento = Double.parseDouble(datos[5].toString());
                double pulgadas = Double.parseDouble(datos[6].toString());
                String tipo = datos[7].toString();
                int hdmi = Integer.parseInt(datos[8].toString());
                int usb = Integer.parseInt(datos[9].toString());

                String sql = "INSERT INTO television (idTelevision, nombreProducto, marcaProducto, precioProducto, cantidadExistencia, descuentoProducto, pulgadasTelevision, tipoPantalla, numPuertosHDMI, numPuertosUSB) "
                            + "VALUES (" + id + ", '" + nombre + "', '" + marca + "', " + precio + ", " + cantidad + ", " + descuento + ", "
                            + pulgadas + ", '" + tipo + "', " + hdmi + ", " + usb + ");";

                System.out.println(sql);
                st.executeUpdate(sql); JOptionPane.showMessageDialog(null, "Guardado"); return true;

            } catch (SQLException e) { System.out.println("Error al guardar televisores: " + e); return false; } 
        } return false;
    }
    
    public static void traerDatos(JTable tabla) {
        Conectar conect = new Conectar(); Connection con = null; Statement st = null; ResultSet rs = null; DefaultTableModel modeloArticulo;
        modeloArticulo = (DefaultTableModel) tabla.getModel(); modeloArticulo.setRowCount(0); 
        String sql = "SELECT * FROM television ORDER BY nombreProducto ASC";

        try {
            con = conect.getConnection(); st = con.createStatement(); rs = st.executeQuery(sql); Object[] fila = new Object[10];
            while (rs.next()) {
                fila[0] = rs.getInt("idTelevision"); fila[1] = rs.getString("nombreProducto"); fila[2] = rs.getString("marcaProducto");
                fila[3] = rs.getDouble("precioProducto"); fila[4] = rs.getInt("cantidadExistencia"); fila[5] = rs.getDouble("descuentoProducto");
                fila[6] = rs.getDouble("pulgadasTelevision"); fila[7] = rs.getString("tipoPantalla"); fila[8] = rs.getInt("numPuertosHDMI");
                fila[9] = rs.getInt("numPuertosUSB"); modeloArticulo.addRow(fila);
            }
    
        } catch (SQLException e) {
            System.out.println("Error al obtener los televisores: " + e);
        } 
        
    }
    
    public static boolean eliminarTelevisor(int id) {
        Conectar conect = new Conectar(); Connection con = null; Statement st = null; String sql = "DELETE FROM television WHERE idTelevision = " + id + ";";

        try {
            con = conect.getConnection(); st = con.createStatement(); st.executeUpdate(sql);

            JOptionPane.showMessageDialog(null, "Eliminado."); return true;

        } catch (SQLException e) { System.out.println("Error al eliminar el televisor: " + e); return false; } 
    }
    public static boolean modificarTelevisor(Television t) {
        Conectar conect = new Conectar(); Connection con = null; Statement st = null;

        String sql = "UPDATE television SET " + "nombreProducto = '" + t.getNombreProducto() + "', " + "marcaProducto = '" + t.getMarcaProducto() + "', "
                + "precioProducto = " + t.getPrecioProductoBase() + ", " + "cantidadExistencia = " + t.getCantidadExistencia() + ", " + "descuentoProducto = " + t.getDescuentoProducto() + ", "
                + "pulgadasTelevision = " + t.getPulgadasTelevision() + ", " + "tipoPantalla = '" + t.getTipoPantalla() + "', "
                + "numPuertosHDMI = " + t.getNumPuertosHDMI() + ", " + "numPuertosUSB = " + t.getNumPuertosUSB() + " WHERE idTelevision = " + t.getIdProducto();

        try {
            con = conect.getConnection(); st = con.createStatement(); st.executeUpdate(sql); JOptionPane.showMessageDialog(null, "Modificados"); return true;

        } catch (SQLException e) { System.out.println("Error al modificar televisor: " + e); return false; } 
    }
    
    public static void buscarTelevisorPorID(int id, JTable jTProductos) {
        Conectar conect = new Conectar(); Connection con = null; Statement st = null; ResultSet rs = null; DefaultTableModel modelo;

        String sql = "SELECT * FROM television WHERE idTelevision = " + id; 
        try {
            con = conect.getConnection(); st = con.createStatement(); rs = st.executeQuery(sql);

            modelo = (DefaultTableModel) jTProductos.getModel(); modelo.setRowCount(0); Object[] fila = new Object[10];

            while (rs.next()) {
                fila[0] = rs.getInt("idTelevision"); fila[1] = rs.getString("nombreProducto"); fila[2] = rs.getString("marcaProducto");
                fila[3] = rs.getDouble("precioProducto"); fila[4] = rs.getInt("cantidadExistencia"); fila[5] = rs.getDouble("descuentoProducto");
                fila[6] = rs.getDouble("pulgadasTelevision"); fila[7] = rs.getString("tipoPantalla"); fila[8] = rs.getInt("numPuertosHDMI");
                fila[9] = rs.getInt("numPuertosUSB"); modelo.addRow(fila);
            } jTProductos.setModel(modelo);

        } catch (SQLException e) {System.out.println("Error al buscar televisor por ID: " + e); } 
    }


}