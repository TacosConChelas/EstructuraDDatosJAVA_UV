/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Finanzas;

import Finanzas.Cuenta;

/**
 *
 * @author tacosconchelas
 */
import java.util.ArrayList;
import java.util.List;

public class BalanceGeneral {
    private String ruta;
    private List<Cuenta> cuentas; //lista de cuentas

    public BalanceGeneral(String ruta, List<Cuenta> cuentas) {
        this.ruta = ruta;
        this.cuentas = cuentas;
    }


    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public Cuenta buscarCuenta(Integer id) {
        for (Cuenta c : cuentas) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null; // No encontrada
    }
    public Cuenta buscarCuentaPorNombre(String nombreCuenta) {
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getNombreCuenta().equalsIgnoreCase(nombreCuenta)) {
                return cuenta;
            }
        }
        return null; // No encontrada
    }


    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public String getRuta() {
        return ruta;
    }

    @Override
    public String toString() {
        return "BalanceGeneral [ruta=" + ruta + ", totalCuentas=" + cuentas.size() + "]";
    }
}

