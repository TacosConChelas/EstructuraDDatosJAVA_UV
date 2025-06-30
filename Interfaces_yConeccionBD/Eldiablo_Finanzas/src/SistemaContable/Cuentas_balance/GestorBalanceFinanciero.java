package SistemaContable.Cuentas_balance;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Clase contenedora de todas las cuentas financieras.
 * Actúa como una "base de datos en memoria" utilizando un LinkedHashMap,
 * donde el nombre de la cuenta es la clave única y el orden de inserción se mantiene.
 */
public class GestorBalanceFinanciero {
    // LinkedHashMap que almacena las cuentas usando su nombre como clave (en minúsculas)
    private LinkedHashMap<String, CuentaFinanciera> cuentas;

    /**
     * Constructor: inicializa el contenedor vacío.
     */
    public GestorBalanceFinanciero() {
        this.cuentas = new LinkedHashMap<>();
    }

    /**
     * Agrega una nueva cuenta al gestor.
     * Si una cuenta con el mismo nombre ya existe, será reemplazada.
     * @param cuenta Cuenta financiera a agregar.
     */
    public void agregarCuenta(CuentaFinanciera cuenta) {
        if (cuenta != null && cuenta.getNombre() != null) {
            cuentas.put(cuenta.getNombre().toLowerCase(), cuenta); // clave en minúsculas
        }
    }

    /**
     * Busca una cuenta por nombre (ignorando mayúsculas/minúsculas).
     * @param nombre Nombre de la cuenta.
     * @return La cuenta correspondiente, o null si no se encuentra.
     */
    public CuentaFinanciera buscarPorNombre(String nombre) {
        if (nombre == null) return null;
        return cuentas.get(nombre.toLowerCase());
    }

    /**
     * Elimina una cuenta por nombre.
     * @param nombre Nombre de la cuenta a eliminar.
     * @return true si fue eliminada, false si no se encontró.
     */
    public boolean eliminarCuenta(String nombre) {
        if (nombre == null) return false;
        return cuentas.remove(nombre.toLowerCase()) != null;
    }

    /**
     * Actualiza los valores de una cuenta existente.
     * @param nombre Nombre de la cuenta a modificar.
     * @param nuevosValores Nuevos valores anuales (longitud 4).
     * @return true si se actualizó correctamente, false si no se encontró la cuenta.
     */
    public boolean actualizarValores(String nombre, double[] nuevosValores) {
        CuentaFinanciera cuenta = buscarPorNombre(nombre);
        if (cuenta != null) {
            cuenta.setValoresAnuales(nuevosValores);
            return true;
        }
        return false;
    }

    /**
     * Obtiene una lista ordenada (por orden de inserción) de todas las cuentas.
     * @return Lista de todas las cuentas en el orden en que fueron agregadas.
     */
    public List<CuentaFinanciera> obtenerTodasLasCuentas() {
        return new ArrayList<>(cuentas.values());
    }

    /**
     * Verifica si existen todas las cuentas indicadas en la lista.
     * @param nombres Lista de nombres de cuentas requeridas.
     * @return true si todas existen, false si falta alguna.
     */
    public boolean validarCuentasExistentes(String[] nombres) {
        for (String nombre : nombres) {
            if (!cuentas.containsKey(nombre.toLowerCase())) {
                return false;
            }
        }
        return true;
    }
}
