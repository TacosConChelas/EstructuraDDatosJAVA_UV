/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto.Calculos.DataBase;

import java.util.ArrayList;

/**
 * Clase que almacena una colección de registros de cuentas (mini base de datos en memoria).
 * Permite agregar, buscar (por id y por nombre), eliminar y actualizar cuentas.
 */
public class LibroBalance {
    // Lista con todas las cuentas/categorías financieras que forman parte del balance
    private ArrayList<RegistroCuenta> cuentas;

    // Constructor: inicializa la lista vacía
    public LibroBalance() {
        this.cuentas = new ArrayList<>();
    }

    // Método para agregar un nuevo registro/cuenta (no valida duplicados, el id puede repetirse)
    public void agregarRegistro(RegistroCuenta cuenta) {
        cuentas.add(cuenta);
    }

    // Método para buscar un registro/cuenta por su id (puede regresar null si no existe)
    public RegistroCuenta buscarPorId(Integer id) {
        for (RegistroCuenta cuenta : cuentas) {
            // Considera null == null como válido si así lo deseas
            if (id == null && cuenta.getId() == null) {
                return cuenta;
            } else if (id != null && id.equals(cuenta.getId())) {
                return cuenta;
            }
        }
        return null;
    }

    // Método para buscar la primera cuenta por su nombre exacto (ignorando mayúsculas/minúsculas)
    public RegistroCuenta buscarPorNombre(String nombre) {
        for (RegistroCuenta cuenta : cuentas) {
            if (cuenta.getNombre() != null && cuenta.getNombre().equalsIgnoreCase(nombre)) {
                return cuenta;
            }
        }
        return null;
    }

    // Método para eliminar un registro/cuenta (por objeto)
    public boolean eliminarRegistro(RegistroCuenta cuenta) {
        return cuentas.remove(cuenta);
    }

    // Método para actualizar los valores de una cuenta dada su posición en la lista (o por objeto)
    public boolean actualizarValoresRegistro(RegistroCuenta cuenta, ArrayList<Double> nuevosValores) {
        if (cuentas.contains(cuenta)) {
            cuenta.setValoresPorPeriodo(nuevosValores);
            return true;
        }
        return false;
    }

    // Devuelve la lista completa de cuentas (puedes hacer una copia si prefieres mayor encapsulamiento)
    public ArrayList<RegistroCuenta> obtenerTodos() {
        return cuentas;
    }

    // Método para validar que existan cuentas por una lista de IDs (regresa true si todas existen)
    public boolean validarIdsClave(Integer[] idsClave) {
        for (Integer id : idsClave) {
            if (buscarPorId(id) == null) {
                return false;
            }
        }
        return true;
    }

    
}
