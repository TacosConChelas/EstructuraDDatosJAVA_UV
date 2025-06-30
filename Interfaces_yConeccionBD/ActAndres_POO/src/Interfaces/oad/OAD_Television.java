/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces.oad;

/**
 *

 */
import Interfaces.ConeccionBaseDeDatos;
import Interfaces.Television;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
//  

public class OAD_Television {

    public static boolean guardarTelevisionDesdeTabla(Object[] datos){
        ConeccionBaseDeDatos conect = new ConeccionBaseDeDatos();
        Connection con = null;
        Statement st = null;
        int validacion = JOptionPane.showConfirmDialog(null, "¿Deseas guardar los datos en la base de datos?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (validacion == JOptionPane.YES_OPTION) {
            try {
                con = conect.getConnection();
                st = con.createStatement();
                con.setAutoCommit(false);

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

                String insertarSQL = "INSERT INTO television (idTelevision, nombreProducto, marcaProducto, precioProducto, cantidadExistencia, descuentoProducto, pulgadasTelevision, tipoPantalla, numPuertosHDMI, numPuertosUSB) "
                            + "VALUES (" + id + ", '" + nombre + "', '" + marca + "', " + precio + ", " + cantidad + ", " + descuento + ", "
                            + pulgadas + ", '" + tipo + "', " + hdmi + ", " + usb + ");";

                st.addBatch(insertarSQL);
             

                st.executeBatch();
                con.commit();
                con.setAutoCommit(true);
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente en la tabla televisión.");
                return true;

            } catch (SQLException e) {
                System.out.println("Error al guardar televisores: " + e);
                return false;
            } finally {
                try {
                    if (st != null) st.close();
                    if (con != null) con.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar conexión: " + e);
                }
            }
        }
        return false;
    }
    
    public static void obtenerTelevisores(JTable tabla) {
        ConeccionBaseDeDatos conect = new ConeccionBaseDeDatos();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        

        DefaultTableModel modeloArticulo;
        modeloArticulo = (DefaultTableModel) tabla.getModel();
        modeloArticulo.setRowCount(0); // Limpia la tabla
        String sql = "SELECT * FROM television ORDER BY nombreProducto ASC";

        try {
            con = conect.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            Object[] fila = new Object[10];
            

            while (rs.next()) {
                fila[0] = rs.getInt("idTelevision");
                fila[1] = rs.getString("nombreProducto");
                fila[2] = rs.getString("marcaProducto");
                fila[3] = rs.getDouble("precioProducto");
                fila[4] = rs.getInt("cantidadExistencia");
                fila[5] = rs.getDouble("descuentoProducto");
                fila[6] = rs.getDouble("pulgadasTelevision");
                fila[7] = rs.getString("tipoPantalla");
                fila[8] = rs.getInt("numPuertosHDMI");
                fila[9] = rs.getInt("numPuertosUSB");

                modeloArticulo.addRow(fila);
            }
            
           

        } catch (SQLException e) {
            System.out.println("Error al obtener los televisores: " + e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e);
            }
        }
        
    }
    
    public static boolean eliminarTelevisor(int id) {
        ConeccionBaseDeDatos conect = new ConeccionBaseDeDatos();
        Connection con = null;
        Statement st = null;
        System.out.println("Metodo eliminar");

        String sqlEliminar = "DELETE FROM television WHERE idTelevision = " + id;

        try {
            con = conect.getConnection();
            con.setAutoCommit(false);

            st = con.createStatement();
            st.executeUpdate(sqlEliminar);

            con.commit();
            con.setAutoCommit(true);

            JOptionPane.showMessageDialog(null, "Televisor eliminado correctamente.");
            return true;

        } catch (SQLException e) {
            System.out.println("Error al eliminar el televisor: " + e);
            return false;

        } finally {
            try {
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e);
            }
        }
    }
    public static boolean modificarTelevisor(Television t) {
        ConeccionBaseDeDatos conect = new ConeccionBaseDeDatos();
        Connection con = null;
        Statement st = null;

        String sqlActualizar = "UPDATE television SET "
                + "nombreProducto = '" + t.getNombreProducto() + "', "
                + "marcaProducto = '" + t.getMarcaProducto() + "', "
                + "precioProducto = " + t.getPrecioProductoBase() + ", "
                + "cantidadExistencia = " + t.getCantidadExistencia() + ", "
                + "descuentoProducto = " + t.getDescuentoProducto() + ", "
                + "pulgadasTelevision = " + t.getPulgadasTelevision() + ", "
                + "tipoPantalla = '" + t.getTipoPantalla() + "', "
                + "numPuertosHDMI = " + t.getNumPuertosHDMI() + ", "
                + "numPuertosUSB = " + t.getNumPuertosUSB()
                + " WHERE idTelevision = " + t.getIdProducto();

        try {
            con = conect.getConnection();
            con.setAutoCommit(false);

            st = con.createStatement();
            st.executeUpdate(sqlActualizar);

            con.commit();
            con.setAutoCommit(true);

            JOptionPane.showMessageDialog(null, "Televisor modificado correctamente.");
            return true;

        } catch (SQLException e) {
            System.out.println("Error al modificar televisor: " + e);
            return false;

        } finally {
            try {
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e);
            }
        }
    }
    
    public static void buscarTelevisorPorID(int id, JTable jTProductos) {
        ConeccionBaseDeDatos conect = new ConeccionBaseDeDatos();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        DefaultTableModel modelo;

        String sqlBuscar = "SELECT * FROM television WHERE idTelevision = " + id;

        try {
            con = conect.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sqlBuscar);

            modelo = (DefaultTableModel) jTProductos.getModel();
            modelo.setRowCount(0); // Limpiar tabla antes de insertar

            Object[] fila = new Object[10];

            while (rs.next()) {
                fila[0] = rs.getInt("idTelevision");
                fila[1] = rs.getString("nombreProducto");
                fila[2] = rs.getString("marcaProducto");
                fila[3] = rs.getDouble("precioProducto");
                fila[4] = rs.getInt("cantidadExistencia");
                fila[5] = rs.getDouble("descuentoProducto");
                fila[6] = rs.getDouble("pulgadasTelevision");
                fila[7] = rs.getString("tipoPantalla");
                fila[8] = rs.getInt("numPuertosHDMI");
                fila[9] = rs.getInt("numPuertosUSB");

                modelo.addRow(fila);
            }

            jTProductos.setModel(modelo);

        } catch (SQLException e) {
            System.out.println("Error al buscar televisor por ID: " + e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar conexión: " + e);
            }
        }
    }


}