/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *INTEGRANTES:
 * Angel Jarley Garzota Barrera 
Juan Pablo Velázquez Méndez 
Jearim Obed Martinez Villalba
 * 
 */
import java.util.ArrayList;

public class Balance {
    // Lista de todas las cuentas registradas en este balance
    private ArrayList<Cuenta> cuentasRegistradas;

    // Constructor: crea un balance vacío
    public Balance() {
        this.cuentasRegistradas = new ArrayList<>();
    }

    // Agregar una nueva cuenta (no se permite duplicar nombre)
    public boolean registrarCuenta(Cuenta cuenta) {
        if (buscarPorDescripcion(cuenta.getDescripcion()) == null) {
            cuentasRegistradas.add(cuenta);
            return true;
        }
        return false; // Ya existe una cuenta con ese nombre
    }

    // Buscar cuenta por código especial
    public Cuenta buscarPorCodigoUnico(int codigoUnico) {
        for (Cuenta c : cuentasRegistradas) {
            if (c.getCodigoUnico() == codigoUnico) {
                return c;
            }
        }
        return null;
    }

    // Buscar cuenta por descripción (nombre)
    public Cuenta buscarPorDescripcion(String descripcion) {
        for (Cuenta c : cuentasRegistradas) {
            if (c.getDescripcion().equalsIgnoreCase(descripcion)) {
                return c;
            }
        }
        return null;
    }

    // Reasignar código especial a una cuenta:
    // Si otra cuenta ya tiene ese código, se le quita (se pone en 0).
    public void reasignarCodigoUnico(Cuenta cuentaDestino, int nuevoCodigo) {
        // Eliminar el código de cualquier otra cuenta que lo tenga
        for (Cuenta c : cuentasRegistradas) {
            if (c.getCodigoUnico() == nuevoCodigo) {
                c.removerCodigoUnico();
            }
        }
        // También eliminamos el código anterior de la cuenta destino (si tenía)
        cuentaDestino.asignarCodigoUnico(nuevoCodigo);
    }

    // Eliminar una cuenta
    public boolean eliminarCuenta(Cuenta cuenta) {
        return cuentasRegistradas.remove(cuenta);
    }

    // Actualizar valores de una cuenta (por nombre)
    public boolean actualizarValoresCuenta(String descripcion, ArrayList<Double> nuevosValores) {
        Cuenta cuenta = buscarPorDescripcion(descripcion);
        if (cuenta != null) {
            cuenta.setRegistrosPeriodos(nuevosValores);
            return true;
        }
        return false;
    }

    // Obtener lista de todas las cuentas
    public ArrayList<Cuenta> getCuentasRegistradas() {
        return cuentasRegistradas;
    }

    // Validar que estén presentes todas las cuentas clave (por lista de códigos esperados)
    public boolean validarCuentasClave(int[] codigosClave) {
        for (int codigo : codigosClave) {
            if (buscarPorCodigoUnico(codigo) == null) {
                return false;
            }
        }
        return true;
    }

    // Para debug/visualización
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Balance:\n");
        for (Cuenta c : cuentasRegistradas) {
            sb.append(c.toString()).append("\n");
        }
        return sb.toString();
    }
}