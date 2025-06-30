/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces.oad;

/**
 *

 */



import Interfaces.ConeccionBaseDeDatos;
import Interfaces.Celular;
import java.sql.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

public class OAD_Celular {

    public static boolean guardarCelularDesdeTabla(Object[] datos) {
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
                double camaraPrincipal = Double.parseDouble(datos[6].toString());
                double camaraFrontal = Double.parseDouble(datos[7].toString());
                double memoriaRAM = Double.parseDouble(datos[8].toString());
                double almacenamientoGB = Double.parseDouble(datos[9].toString());

                String insertarSQL = "INSERT INTO celular (idCelular, nombreProducto, marcaProducto, precioProducto, cantidadExistencia, descuentoProducto, camaraPrincipal, camaraFrontal, memoriaRAM, almacenamientoGB) "
                        + "VALUES (" + id + ", '" + nombre + "', '" + marca + "', " + precio + ", " + cantidad + ", " + descuento + ", "
                        + camaraPrincipal + ", " + camaraFrontal + ", " + memoriaRAM + ", " + almacenamientoGB + ");";

                st.addBatch(insertarSQL);
                st.executeBatch();
                con.commit();
                con.setAutoCommit(true);
                JOptionPane.showMessageDialog(null, "Datos guardados correctamente en la tabla celular.");
                return true;

            } catch (SQLException e) {
                System.out.println("Error al guardar celulares: " + e);
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

    public static void obtenerCelulares(JTable tabla) {
        ConeccionBaseDeDatos conect = new ConeccionBaseDeDatos();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        DefaultTableModel modeloArticulo;
        modeloArticulo = (DefaultTableModel) tabla.getModel();
        modeloArticulo.setRowCount(0); // Limpia la tabla
        String sql = "SELECT * FROM celular ORDER BY nombreProducto ASC";

        try {
            con = conect.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            Object[] fila = new Object[10];

            while (rs.next()) {
                fila[0] = rs.getInt("idCelular");
                fila[1] = rs.getString("nombreProducto");
                fila[2] = rs.getString("marcaProducto");
                fila[3] = rs.getDouble("precioProducto");
                fila[4] = rs.getInt("cantidadExistencia");
                fila[5] = rs.getDouble("descuentoProducto");
                fila[6] = rs.getDouble("camaraPrincipal");
                fila[7] = rs.getDouble("camaraFrontal");
                fila[8] = rs.getDouble("memoriaRAM");
                fila[9] = rs.getDouble("almacenamientoGB");
                
                modeloArticulo.addRow(fila);
            }

            

        } catch (SQLException e) {
            System.out.println("Error al obtener los celulares: " + e);
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

    public static boolean eliminarCelular(int id) {
        ConeccionBaseDeDatos conect = new ConeccionBaseDeDatos();
        Connection con = null;
        Statement st = null;

        String sqlEliminar = "DELETE FROM celular WHERE idCelular = " + id;

        try {
            con = conect.getConnection();
            con.setAutoCommit(false);

            st = con.createStatement();
            st.executeUpdate(sqlEliminar);

            con.commit();
            con.setAutoCommit(true);

            JOptionPane.showMessageDialog(null, "Celular eliminado correctamente.");
            return true;

        } catch (SQLException e) {
            System.out.println("Error al eliminar celular: " + e);
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

    public static boolean modificarCelular(Celular c) {
        ConeccionBaseDeDatos conect = new ConeccionBaseDeDatos();
        Connection con = null;
        Statement st = null;

        String sqlActualizar = "UPDATE celular SET "
                + "nombreProducto = '" + c.getNombreProducto() + "', "
                + "marcaProducto = '" + c.getMarcaProducto() + "', "
                + "precioProducto = " + c.getPrecioProductoBase() + ", "
                + "cantidadExistencia = " + c.getCantidadExistencia() + ", "
                + "descuentoProducto = " + c.getDescuentoProducto() + ", "
                + "camaraPrincipal = " + c.getCamaraPrincipal() + ", "
                + "camaraFrontal = " + c.getCamaraFrontal() + ", "
                + "memoriaRAM = " + c.getMemoriaRAM() + ", "
                + "almacenamientoGB = " + c.getAlmacenamientoGB()
                + " WHERE idCelular = " + c.getIdProducto();

        try {
            con = conect.getConnection();
            con.setAutoCommit(false);

            st = con.createStatement();
            st.executeUpdate(sqlActualizar);

            con.commit();
            con.setAutoCommit(true);

            JOptionPane.showMessageDialog(null, "Celular modificado correctamente.");
            return true;

        } catch (SQLException e) {
            System.out.println("Error al modificar celular: " + e);
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

    public static void buscarCelularPorID(int id, JTable jTProductos) {
        ConeccionBaseDeDatos conect = new ConeccionBaseDeDatos();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        DefaultTableModel modelo;

        String sqlBuscar = "SELECT * FROM celular WHERE idCelular = " + id;

        try {
            con = conect.getConnection();
            st = con.createStatement();
            rs = st.executeQuery(sqlBuscar);

            modelo = (DefaultTableModel) jTProductos.getModel();
            modelo.setRowCount(0); // Limpiar tabla antes de insertar

            Object[] fila = new Object[10];

            while (rs.next()) {
                fila[0] = rs.getInt("idCelular");
                fila[1] = rs.getString("nombreProducto");
                fila[2] = rs.getString("marcaProducto");
                fila[3] = rs.getDouble("precioProducto");
                fila[4] = rs.getInt("cantidadExistencia");
                fila[5] = rs.getDouble("descuentoProducto");
                fila[6] = rs.getDouble("camaraPrincipal");
                fila[7] = rs.getDouble("camaraFrontal");
                fila[8] = rs.getDouble("memoriaRAM");
                fila[9] = rs.getDouble("almacenamientoGB");

                modelo.addRow(fila);
            }

            jTProductos.setModel(modelo);

        } catch (SQLException e) {
            System.out.println("Error al buscar celular por ID: " + e);
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
