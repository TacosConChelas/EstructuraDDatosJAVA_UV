/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import java.util.ArrayList;
import java.util.List;

public class Razones {

    /**
     * Calcula todas las razones financieras del balance.
     * Retorna una lista de Object[] lista para mostrar en JTable.
     */
    public static List<Object[]> calcularRazonesFinancieras(Balance balance) {
        List<Object[]> resultado = new ArrayList<>();

        // Utilidad: Método utilitario para redondear
        // HerramientasFinancieras.redondearADosDecimales(double valor);

        // Obtener las cuentas necesarias por ID
        Cuenta activoCirculante = balance.buscarPorCodigoUnico(101);
        Cuenta pasivoCirculante = balance.buscarPorCodigoUnico(201);
        Cuenta inventarios      = balance.buscarPorCodigoUnico(103);
        Cuenta cuentasCobrar    = balance.buscarPorCodigoUnico(104);
        Cuenta pasivoTotal      = balance.buscarPorCodigoUnico(200);
        Cuenta activoTotal      = balance.buscarPorCodigoUnico(100);
        Cuenta capitalTotal     = balance.buscarPorCodigoUnico(300);
        Cuenta ventas           = balance.buscarPorCodigoUnico(400);
        Cuenta costoVentas      = balance.buscarPorCodigoUnico(402);
        Cuenta cuentasPagar     = balance.buscarPorCodigoUnico(203);

        // Títulos de bloques
        resultado.add(new Object[]{"Razón de Liquidez", "--", "--", "--", "--"});
        // --- Razón circulante
        resultado.add(calcularFila("Razón Circulante", 
            activoCirculante, pasivoCirculante, null, null, "dividir", true));
        // --- Razón ácida
        resultado.add(calcularFila("Razón Ácida",
            activoCirculante, pasivoCirculante, inventarios, null, "acida", true));
        // --- Razón de efectivo
        resultado.add(calcularFila("Razón de Efectivo",
            activoCirculante, pasivoCirculante, inventarios, cuentasCobrar, "efectivo", true));

        // --- Razones de actividad
        resultado.add(new Object[]{"Razón de Actividad", "--", "--", "--", "--"});
        // Rotación de inventarios: Costo de ventas / Inventarios
        resultado.add(calcularFila("Rotación de Inventarios",
            costoVentas, inventarios, null, null, "dividir", true));
        // Días de inventario: 360 / Rotación de Inventarios
        resultado.add(calcularFila("Días de Inventario",
            costoVentas, inventarios, null, null, "diasInventario", false));
        // Rotación de cuentas por cobrar: Ventas / Cuentas por cobrar
        resultado.add(calcularFila("Rotación de Cuentas por Cobrar",
            ventas, cuentasCobrar, null, null, "dividir", true));
        // Días de cartera: 360 / Rotación de Cuentas por Cobrar
        resultado.add(calcularFila("Días de Cartera",
            ventas, cuentasCobrar, null, null, "diasCartera", false));
        // Rotación de cuentas por pagar: (costo de ventas o compras) / cuentas por pagar
        resultado.add(calcularFila("Rotación de Cuentas por Pagar",
            costoVentas, cuentasPagar, null, null, "dividir", true));

        // --- Razones de apalancamiento
        resultado.add(new Object[]{"Razón de Apalancamiento", "--", "--", "--", "--"});
        // Razón de deuda: Pasivo total / Activo total
        resultado.add(calcularFila("Razón de Deuda",
            pasivoTotal, activoTotal, null, null, "dividir", true));
        // Razón de deuda a capital: Pasivo total / Capital total
        resultado.add(calcularFila("Razón de Deuda a Capital",
            pasivoTotal, capitalTotal, null, null, "dividir", true));

        return resultado;
    }

    // Métodos auxiliares para simplificar el cálculo y formato
    // tipoOperacion: "dividir", "acida", "efectivo", "diasInventario", "diasCartera"
    private static Object[] calcularFila(String nombre, Cuenta a, Cuenta b, Cuenta c, Cuenta d, String tipoOperacion, boolean redondear2decimales) {
        String[] fila = new String[5];
        fila[0] = nombre;

        // Si falta alguna cuenta necesaria, coloca '---'
        if (a == null || b == null || 
            ("acida".equals(tipoOperacion) && c == null) ||
            ("efectivo".equals(tipoOperacion) && (c == null || d == null))) {
            for (int i = 1; i <= 4; i++) fila[i] = "---";
            return fila;
        }

        // Tomar valores de los 4 años
        List<Double> valoresA = a.getRegistrosPeriodos();
        List<Double> valoresB = b.getRegistrosPeriodos();
        List<Double> valoresC = c != null ? c.getRegistrosPeriodos() : null;
        List<Double> valoresD = d != null ? d.getRegistrosPeriodos() : null;

        for (int i = 0; i < 4; i++) {
            double val = 0;
            boolean error = false;
            switch (tipoOperacion) {
                case "dividir":
                    if (valoresA.size() > i && valoresB.size() > i) {
                        double num = valoresA.get(i);
                        double den = valoresB.get(i);
                        if (den == 0) {
                            val = 0; // 0/0 = 0 y x/0 = 0
                        } else {
                            val = num / den;
                        }
                        fila[i + 1] = redondearMostrar(val, redondear2decimales);
                    } else {
                        fila[i + 1] = "---";
                    }
                    break;
                case "acida":
                    if (valoresA.size() > i && valoresB.size() > i && valoresC.size() > i) {
                        double num = valoresA.get(i) - valoresC.get(i);
                        double den = valoresB.get(i);
                        if (den == 0) val = 0;
                        else val = num / den;
                        fila[i + 1] = redondearMostrar(val, redondear2decimales);
                    } else {
                        fila[i + 1] = "---";
                    }
                    break;
                case "efectivo":
                    if (valoresA.size() > i && valoresB.size() > i && valoresC.size() > i && valoresD.size() > i) {
                        double num = valoresA.get(i) - valoresC.get(i) - valoresD.get(i);
                        double den = valoresB.get(i);
                        if (den == 0) val = 0;
                        else val = num / den;
                        fila[i + 1] = redondearMostrar(val, redondear2decimales);
                    } else {
                        fila[i + 1] = "---";
                    }
                    break;
                case "diasInventario":
                    // Días de inventario = 360 / (Costo de ventas / Inventarios)
                    if (valoresA.size() > i && valoresB.size() > i) {
                        double rotacion = (valoresB.get(i) == 0) ? 0 : valoresA.get(i) / valoresB.get(i);
                        double dias = (rotacion == 0) ? 0 : 360.0 / rotacion;
                        fila[i + 1] = Integer.toString((int)Math.round(dias));
                    } else {
                        fila[i + 1] = "---";
                    }
                    break;
                case "diasCartera":
                    // Días de cartera = 360 / (Ventas / Cuentas por cobrar)
                    if (valoresA.size() > i && valoresB.size() > i) {
                        double rotacion = (valoresB.get(i) == 0) ? 0 : valoresA.get(i) / valoresB.get(i);
                        double dias = (rotacion == 0) ? 0 : 360.0 / rotacion;
                        fila[i + 1] = Integer.toString((int)Math.round(dias));
                    } else {
                        fila[i + 1] = "---";
                    }
                    break;
                default:
                    fila[i + 1] = "---";
                    break;
            }
        }
        return fila;
    }

    // Utilidad para redondear y mostrar como String
    private static String redondearMostrar(double val, boolean dosDecimales) {
        if (dosDecimales) {
            return String.valueOf(HerramientasFinancieras.redondearADosDecimales(val));
        } else {
            return Integer.toString((int)Math.round(val));
        }
    }
   

}

