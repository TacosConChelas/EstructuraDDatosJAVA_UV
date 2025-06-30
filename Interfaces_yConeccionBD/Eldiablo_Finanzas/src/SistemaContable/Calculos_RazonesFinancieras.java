/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SistemaContable;


import SistemaContable.Cuentas_balance.CuentaFinanciera;
import SistemaContable.Cuentas_balance.GestorBalanceFinanciero;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Clase utilitaria para el cálculo de razones financieras.
 */
public class Calculos_RazonesFinancieras {

    /**
     * Calcula las razones financieras año a año, usando SOLO los nombres exactos de cuentas.
     * Si falta una cuenta para alguna razón en un año, se coloca 0.
     *
     * @param cuentas Objeto GestorBalanceFinanciero con todas las cuentas cargadas.
     * @return LinkedHashMap con la razón como clave y los resultados para cada año como valor.
     */
    public static LinkedHashMap<String, double[]> calcularRazonesFinancieras(GestorBalanceFinanciero cuentas) {
        LinkedHashMap<String, double[]> resultado = new LinkedHashMap<>();

        if (cuentas == null) return resultado;

        // Obtener todas las cuentas necesarias una sola vez (por nombre exacto)
        CuentaFinanciera cajaYBancos = cuentas.buscarPorNombre("Caja y Bancos");
        CuentaFinanciera cuentasPorCobrar = cuentas.buscarPorNombre("Cuentas por Cobrar");
        CuentaFinanciera inventarios = cuentas.buscarPorNombre("Inventarios");
        CuentaFinanciera activoCorriente = cuentas.buscarPorNombre("Activo Corriente Total");
        CuentaFinanciera totalActivo = cuentas.buscarPorNombre("TOTAL ACTIVO");
        CuentaFinanciera cuentasPorPagar = cuentas.buscarPorNombre("Cuentas por Pagar");
        CuentaFinanciera pasivoCorriente = cuentas.buscarPorNombre("Pasivo Corriente Total");
        CuentaFinanciera totalPasivo = cuentas.buscarPorNombre("TOTAL PASIVO");
        CuentaFinanciera capitalContable = cuentas.buscarPorNombre("Capital Contable");
        CuentaFinanciera ventas = cuentas.buscarPorNombre("Ventas");
        CuentaFinanciera costoDeVenta = cuentas.buscarPorNombre("Costo de Venta");

        // Para cada razón, calcula el resultado año a año (0...3)
        // 1. Razón Circulante = Activo Corriente Total / Pasivo Corriente Total
        double[] razonCirculante = new double[4];
        for (int i = 0; i < 4; i++) {
            if (activoCorriente != null && pasivoCorriente != null) {
                double pasivo = pasivoCorriente.obtenerValorAnual(i);
                razonCirculante[i] = pasivo != 0.0 ? activoCorriente.obtenerValorAnual(i) / pasivo : 0.0;
            } else {
                razonCirculante[i] = 0.0;
            }
        }
        resultado.put("Razón Circulante", razonCirculante);

        // 2. Prueba Ácida = (Activo Corriente Total - Inventarios) / Pasivo Corriente Total
        double[] razonAcida = new double[4];
        for (int i = 0; i < 4; i++) {
            if (activoCorriente != null && inventarios != null && pasivoCorriente != null) {
                double pasivo = pasivoCorriente.obtenerValorAnual(i);
                razonAcida[i] = pasivo != 0.0
                        ? (activoCorriente.obtenerValorAnual(i) - inventarios.obtenerValorAnual(i)) / pasivo
                        : 0.0;
            } else {
                razonAcida[i] = 0.0;
            }
        }
        resultado.put("Razón Ácida", razonAcida);

        // 3. Razón de Efectivo = Caja y Bancos / Pasivo Corriente Total
        double[] razonEfectivo = new double[4];
        for (int i = 0; i < 4; i++) {
            if (cajaYBancos != null && pasivoCorriente != null) {
                double pasivo = pasivoCorriente.obtenerValorAnual(i);
                razonEfectivo[i] = pasivo != 0.0 ? cajaYBancos.obtenerValorAnual(i) / pasivo : 0.0;
            } else {
                razonEfectivo[i] = 0.0;
            }
        }
        resultado.put("Razón de Efectivo", razonEfectivo);

        // 4. Rotación de Inventarios = Costo de Venta / Inventarios
        double[] rotInventarios = new double[4];
        for (int i = 0; i < 4; i++) {
            if (costoDeVenta != null && inventarios != null) {
                double invent = inventarios.obtenerValorAnual(i);
                rotInventarios[i] = invent != 0.0 ? costoDeVenta.obtenerValorAnual(i) / invent : 0.0;
            } else {
                rotInventarios[i] = 0.0;
            }
        }
        resultado.put("Rotación de Inventarios", rotInventarios);

        // 5. Días de Inventario = 365 / Rotación de Inventarios
        double[] diasInventario = new double[4];
        for (int i = 0; i < 4; i++) {
            diasInventario[i] = rotInventarios[i] != 0.0 ? 365.0 / rotInventarios[i] : 0.0;
        }
        resultado.put("Días de Inventario", diasInventario);

        // 6. Rotación de Cuentas por Cobrar = Ventas / Cuentas por Cobrar
        double[] rotCuentasPorCobrar = new double[4];
        for (int i = 0; i < 4; i++) {
            if (ventas != null && cuentasPorCobrar != null) {
                double cxc = cuentasPorCobrar.obtenerValorAnual(i);
                rotCuentasPorCobrar[i] = cxc != 0.0 ? ventas.obtenerValorAnual(i) / cxc : 0.0;
            } else {
                rotCuentasPorCobrar[i] = 0.0;
            }
        }
        resultado.put("Rotación de Cuentas por Cobrar", rotCuentasPorCobrar);

        // 7. Días de Cartera = 365 / Rotación de Cuentas por Cobrar
        double[] diasCartera = new double[4];
        for (int i = 0; i < 4; i++) {
            diasCartera[i] = rotCuentasPorCobrar[i] != 0.0 ? 365.0 / rotCuentasPorCobrar[i] : 0.0;
        }
        resultado.put("Días de Cartera", diasCartera);

        // 8. Rotación de Cuentas por Pagar = Costo de Venta / Cuentas por Pagar
        double[] rotCuentasPorPagar = new double[4];
        for (int i = 0; i < 4; i++) {
            if (costoDeVenta != null && cuentasPorPagar != null) {
                double cxp = cuentasPorPagar.obtenerValorAnual(i);
                rotCuentasPorPagar[i] = cxp != 0.0 ? costoDeVenta.obtenerValorAnual(i) / cxp : 0.0;
            } else {
                rotCuentasPorPagar[i] = 0.0;
            }
        }
        resultado.put("Rotación de Cuentas por Pagar", rotCuentasPorPagar);

        // 9. Días de Cuentas por Pagar = 365 / Rotación de Cuentas por Pagar
        double[] diasCuentasPorPagar = new double[4];
        for (int i = 0; i < 4; i++) {
            diasCuentasPorPagar[i] = rotCuentasPorPagar[i] != 0.0 ? 365.0 / rotCuentasPorPagar[i] : 0.0;
        }
        resultado.put("Días de Cuentas por Pagar", diasCuentasPorPagar);

        // 10. Razón de Deuda = TOTAL PASIVO / TOTAL ACTIVO
        double[] razonDeuda = new double[4];
        for (int i = 0; i < 4; i++) {
            if (totalPasivo != null && totalActivo != null) {
                double ta = totalActivo.obtenerValorAnual(i);
                razonDeuda[i] = ta != 0.0 ? totalPasivo.obtenerValorAnual(i) / ta : 0.0;
            } else {
                razonDeuda[i] = 0.0;
            }
        }
        resultado.put("Razón de Deuda", razonDeuda);

        // 11. Razón de Deuda a Capital = TOTAL PASIVO / Capital Contable
        double[] razonDeudaCapital = new double[4];
        for (int i = 0; i < 4; i++) {
            if (totalPasivo != null && capitalContable != null) {
                double cc = capitalContable.obtenerValorAnual(i);
                razonDeudaCapital[i] = cc != 0.0 ? totalPasivo.obtenerValorAnual(i) / cc : 0.0;
            } else {
                razonDeudaCapital[i] = 0.0;
            }
        }
        resultado.put("Razón de Deuda a Capital", razonDeudaCapital);

        return resultado;
    }
}

