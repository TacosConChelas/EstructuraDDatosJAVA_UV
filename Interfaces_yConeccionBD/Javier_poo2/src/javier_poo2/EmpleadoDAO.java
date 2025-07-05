/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javier_poo2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author tacosconchelas
 */
public class EmpleadoDAO {
    Conectar conect = new Conectar();
    Connection con = null;
    Statement st = null;

    public boolean guardarEmpleado(Empleado e) {
        try {
            con = conect.getConnection();
            st = con.createStatement();

            String sql = "INSERT INTO empleado (idEmpleado, nombre, fechaNacimiento, genero, correo, salario, puesto, funciones, fechaContratacion, gradoEstudios) VALUES (" +
                    e.getIdEmpleado() + ", '" +
                    e.getNombre() + "', '" +
                    e.getFechaNacimiento() + "', '" +
                    e.getGenero() + "', '" +
                    e.getCorreo() + "', " +
                    e.getSalario() + ", '" +
                    e.getPuesto() + "', '" +
                    e.getFunciones() + "', '" +
                    e.getFechaContratacion() + "', '" +
                    e.getGradoEstudios() + "')";

            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Empleado guardado correctamente.");
            return true;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar: " + ex.getMessage());
            return false;
        } finally {
            try {
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (Exception ex2) {
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + ex2.getMessage());
            }
        }
    }
    public boolean actualizarEmpleado(Empleado e) {
        Conectar conect = new Conectar();
        Connection con = null;
        Statement st = null;

        try {
            con = conect.getConnection();
            st = con.createStatement();

            String sql = "UPDATE empleado SET " +
                    "nombre = '" + e.getNombre() + "', " +
                    "fechaNacimiento = '" + e.getFechaNacimiento() + "', " +
                    "genero = '" + e.getGenero() + "', " +
                    "correo = '" + e.getCorreo() + "', " +
                    "salario = " + e.getSalario() + ", " +
                    "puesto = '" + e.getPuesto() + "', " +
                    "funciones = '" + e.getFunciones() + "', " +
                    "fechaContratacion = '" + e.getFechaContratacion() + "', " +
                    "gradoEstudios = '" + e.getGradoEstudios() + "' " +
                    "WHERE idEmpleado = " + e.getIdEmpleado();

            int filas = st.executeUpdate(sql);
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Empleado actualizado correctamente.");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró un empleado con ese ID.");
                return false;
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar: " + ex.getMessage());
            return false;
        } finally {
            try {
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (Exception ex2) {
                JOptionPane.showMessageDialog(null, "Error al cerrar conexión: " + ex2.getMessage());
            }
        }
    }
    public List<Empleado> obtenerTodosLosEmpleados() {
        List<Empleado> lista = new ArrayList<>();
        Conectar conect = new Conectar();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            con = conect.getConnection();
            st = con.createStatement();
            String sql = "SELECT * FROM empleado";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Empleado e = new Empleado(
                    rs.getInt("idEmpleado"),
                    rs.getString("nombre"),
                    rs.getDate("fechaNacimiento"),
                    rs.getString("genero"),
                    rs.getString("correo"),
                    rs.getDouble("salario"),
                    rs.getString("puesto"),
                    rs.getString("funciones"),
                    rs.getDate("fechaContratacion"),
                    rs.getString("gradoEstudios")
                );
                lista.add(e);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar empleados: " + ex.getMessage());
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (st != null) st.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }

        return lista;
    }


}
