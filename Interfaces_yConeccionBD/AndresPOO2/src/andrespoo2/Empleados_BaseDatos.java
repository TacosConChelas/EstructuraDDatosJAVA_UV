/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package andrespoo2;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Empleados_BaseDatos {

    ConeccionBaseDeDatos conexion = new ConeccionBaseDeDatos();
    Connection enlace = null;
    Statement comando = null;

    // Insertar empleado
    public boolean insertarRegistro(Empleados emp) {
        try {
            enlace = conexion.getConnection();
            comando = enlace.createStatement();

            String sql = "INSERT INTO empleado (idEmpleado, nombre, fechaNacimiento, genero, correo, salario, puesto, funciones, fechaContratacion, gradoEstudios) " +
                    "VALUES (" + emp.getCodigoEmpleado() + ", '" + emp.getNombres() + "', '" + emp.getNacimiento() + "', '" +
                    emp.getSexo() + "', '" + emp.getEmail() + "', " + emp.getSueldo() + ", '" + emp.getCargo() + "', '" +
                    emp.getResponsabilidades() + "', '" + emp.getIngreso() + "', '" + emp.getNivelAcademico() + "')";

            comando.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Registro agregado exitosamente.");
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar: " + e.getMessage());
            return false;
        } finally {
            try { if (comando != null) comando.close(); } catch (Exception e) {}
            try { if (enlace != null) enlace.close(); } catch (Exception e) {}
        }
    }

    // Eliminar empleado por ID
    public boolean eliminarRegistro(int codigo) {
        try {
            enlace = conexion.getConnection();
            comando = enlace.createStatement();

            String sql = "DELETE FROM empleado WHERE idEmpleado = " + codigo;
            int filas = comando.executeUpdate(sql);

            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Registro eliminado.");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el registro.");
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar: " + e.getMessage());
            return false;
        } finally {
            try { if (comando != null) comando.close(); } catch (Exception e) {}
            try { if (enlace != null) enlace.close(); } catch (Exception e) {}
        }
    }

    // Actualizar empleado
    public boolean modificarRegistro(Empleados emp) {
        try {
            enlace = conexion.getConnection();
            comando = enlace.createStatement();

            String sql = "UPDATE empleado SET " +
                    "nombre = '" + emp.getNombres() + "', " +
                    "fechaNacimiento = '" + emp.getNacimiento() + "', " +
                    "genero = '" + emp.getSexo() + "', " +
                    "correo = '" + emp.getEmail() + "', " +
                    "salario = " + emp.getSueldo() + ", " +
                    "puesto = '" + emp.getCargo() + "', " +
                    "funciones = '" + emp.getResponsabilidades() + "', " +
                    "fechaContratacion = '" + emp.getIngreso() + "', " +
                    "gradoEstudios = '" + emp.getNivelAcademico() + "' " +
                    "WHERE idEmpleado = " + emp.getCodigoEmpleado();

            int filas = comando.executeUpdate(sql);
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Registro actualizado.");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el registro.");
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar: " + e.getMessage());
            return false;
        } finally {
            try { if (comando != null) comando.close(); } catch (Exception e) {}
            try { if (enlace != null) enlace.close(); } catch (Exception e) {}
        }
    }

    // Obtener todos los empleados
    public List<Empleados> listarEmpleados() {
        List<Empleados> lista = new ArrayList<>();
        ResultSet resultado = null;

        try {
            enlace = conexion.getConnection();
            comando = enlace.createStatement();
            String sql = "SELECT * FROM empleado";
            resultado = comando.executeQuery(sql);

            while (resultado.next()) {
                Empleados emp = new Empleados(
                    resultado.getInt("idEmpleado"),
                    resultado.getString("nombre"),
                    resultado.getDate("fechaNacimiento"),
                    resultado.getString("genero"),
                    resultado.getString("correo"),
                    resultado.getDouble("salario"),
                    resultado.getString("puesto"),
                    resultado.getString("funciones"),
                    resultado.getDate("fechaContratacion"),
                    resultado.getString("gradoEstudios")
                );
                lista.add(emp);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al consultar: " + e.getMessage());
        } finally {
            try { if (resultado != null) resultado.close(); } catch (Exception e) {}
            try { if (comando != null) comando.close(); } catch (Exception e) {}
            try { if (enlace != null) enlace.close(); } catch (Exception e) {}
        }

        return lista;
    }
}
