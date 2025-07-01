/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CCE {

    /**
     * Calcula los indicadores del Ciclo de Conversión de Efectivo (CCE) para los 4 años.
     * Retorna una lista de Object[] para JTable: [nombre, año1, año2, año3, año4]
     */
    public static List<Object[]> calcularCCE(Balance balance) {
        List<Object[]> resultado = new ArrayList<>();

        // Buscar cuentas necesarias
        Cuenta inventarios      = balance.buscarPorCodigoUnico(103);
        Cuenta cuentasCobrar    = balance.buscarPorCodigoUnico(104);
        Cuenta cuentasPagar     = balance.buscarPorCodigoUnico(203);
        Cuenta costoVentas      = balance.buscarPorCodigoUnico(402);
        Cuenta ventasNetas      = balance.buscarPorCodigoUnico(400);

        // Calcular Días de Inventario
        resultado.add(calcularFilaDias(
            "Días de Inventario", inventarios, costoVentas, null, 365));

        // Calcular Días de Cartera
        resultado.add(calcularFilaDias(
            "Días de Cartera", cuentasCobrar, ventasNetas, null, 365));

        // Calcular Días de Cuentas por Pagar
        resultado.add(calcularFilaDias(
            "Días de Cuentas por Pagar", cuentasPagar, costoVentas, null, 365));

        // Calcular CCE: suma y resta de los anteriores
        Object[] filaInventario    = resultado.get(0);
        Object[] filaCartera       = resultado.get(1);
        Object[] filaPagar         = resultado.get(2);
        Object[] filaCCE           = new Object[5];
        filaCCE[0] = "CCE";

        for (int i = 1; i <= 4; i++) {
            try {
                if (filaInventario[i].equals("---") || filaCartera[i].equals("---") || filaPagar[i].equals("---")) {
                    filaCCE[i] = "---";
                } else {
                    int diasInventario = Integer.parseInt(filaInventario[i].toString());
                    int diasCartera    = Integer.parseInt(filaCartera[i].toString());
                    int diasPagar      = Integer.parseInt(filaPagar[i].toString());
                    int cce = diasInventario + diasCartera - diasPagar;
                    filaCCE[i] = cce;
                }
            } catch (Exception e) {
                filaCCE[i] = "---";
            }
        }
        resultado.add(filaCCE);

        return resultado;
    }

    /**
     * Calcula una fila de días (por ejemplo, Días de Inventario, Días de Cartera)
     * Si falta alguna cuenta, retorna ["nombre", "---", "---", "---", "---"]
     */
    private static Object[] calcularFilaDias(String nombre, Cuenta a, Cuenta b, Cuenta c, int multiplicadorDias) {
        Object[] fila = new Object[5];
        fila[0] = nombre;

        if (a == null || b == null) {
            for (int i = 1; i <= 4; i++) fila[i] = "---";
            return fila;
        }

        List<Double> valoresA = a.getRegistrosPeriodos();
        List<Double> valoresB = b.getRegistrosPeriodos();

        for (int i = 0; i < 4; i++) {
            double num = (valoresA.size() > i) ? valoresA.get(i) : 0.0;
            double den = (valoresB.size() > i) ? valoresB.get(i) : 0.0;

            // Si ambas son cero, resultado es 0
            if (num == 0.0 && den == 0.0) {
                fila[i + 1] = "0";
            } else if (den == 0.0) {
                fila[i + 1] = "0";
            } else {
                // Días = (num / den) * multiplicadorDias, redondeado hacia arriba
                double dias = (num / den) * multiplicadorDias;
                int diasRedondeado = (int) Math.ceil(dias);
                fila[i + 1] = String.valueOf(diasRedondeado);
            }
        }
        return fila;
    }
    
    
    
    /**
     * Devuelve solo los valores numéricos de los indicadores del CCE.
     * El orden es:
     *   0: Días de Inventario
     *   1: Días de Cartera
     *   2: Días de Cuentas por Pagar
     *   3: CCE
     * Si falta alguna cuenta, ese indicador será {0,0,0,0}
     */
    public static List<double[]> calcularCCEValores(Balance balance) {
        List<double[]> resultado = new ArrayList<>();

        Cuenta inventarios      = balance.buscarPorCodigoUnico(103);
        Cuenta cuentasCobrar    = balance.buscarPorCodigoUnico(104);
        Cuenta cuentasPagar     = balance.buscarPorCodigoUnico(203);
        Cuenta costoVentas      = balance.buscarPorCodigoUnico(402);
        Cuenta ventasNetas      = balance.buscarPorCodigoUnico(400);

        // Días de Inventario
        resultado.add(calcularValoresDias(inventarios, costoVentas, 365));
        // Días de Cartera
        resultado.add(calcularValoresDias(cuentasCobrar, ventasNetas, 365));
        // Días de Cuentas por Pagar
        resultado.add(calcularValoresDias(cuentasPagar, costoVentas, 365));

        // CCE = DI + DC - DCP
        double[] di = resultado.get(0);
        double[] dc = resultado.get(1);
        double[] dcp = resultado.get(2);
        double[] cce = new double[4];

        for (int i = 0; i < 4; i++) {
            cce[i] = di[i] + dc[i] - dcp[i];
        }
        resultado.add(cce);

        return resultado;
    }

    // Devuelve los valores de (a / b) * multiplicador para cada año (sin redondear)
    private static double[] calcularValoresDias(Cuenta a, Cuenta b, int multiplicadorDias) {
        double[] valores = new double[4];
        if (a == null || b == null) {
            // Si falta alguna cuenta, pon ceros
            return valores;
        }
        List<Double> valoresA = a.getRegistrosPeriodos();
        List<Double> valoresB = b.getRegistrosPeriodos();

        for (int i = 0; i < 4; i++) {
            double num = (valoresA.size() > i) ? valoresA.get(i) : 0.0;
            double den = (valoresB.size() > i) ? valoresB.get(i) : 0.0;

            if (num == 0.0 && den == 0.0) {
                valores[i] = 0.0;
            } else if (den == 0.0) {
                valores[i] = 0.0;
            } else {
                valores[i] = (num / den) * multiplicadorDias;
            }
        }
        return valores;
    }
    
    
    /**
     * Aplica el "What if?" al CCE con porcentajes de cambio y actualiza una JTable.
     * 
     * @param valoresBase        List<double[]> con los indicadores base (DI, DC, DP, CCE)
     * @param porcentajeCobro    % de aumento/dism. para días de cobro (ej: 10 para 10%)
     * @param porcentajePago     % de aumento/dism. para días de pago
     * @param porcentajeInventario % de aumento/dism. para días de inventario
     * @param tablaDestino       JTable donde se muestran los resultados
     */
    public static void calcularYMostrarWhatIfCCE(
            List<double[]> valoresBase,
            double porcentajeCobro,
            double porcentajePago,
            double porcentajeInventario,
            JTable tablaDestino
    ) {
        // Nombres para mostrar
        String[] nombres = {"Días de cobro", "Días de pago", "Días de inventario", "CCE"};

        // Si el jlist está vacío o nulo, poner todo en 0
        if (valoresBase == null || valoresBase.size() < 3) {
            DefaultTableModel modelo = (DefaultTableModel) tablaDestino.getModel();
            modelo.setRowCount(0);
            for (String nombre : nombres) {
                Object[] fila = new Object[5];
                fila[0] = nombre;
                for (int i = 1; i <= 4; i++) fila[i] = "0";
                modelo.addRow(fila);
            }
            return;
        }

        // Tomar los arrays base
        double[] diasCobroBase      = valoresBase.get(1); // Días de Cartera
        double[] diasPagoBase       = valoresBase.get(2); // Días de Cuentas por Pagar
        double[] diasInventarioBase = valoresBase.get(0); // Días de Inventario

        // Crear arrays para los nuevos valores
        double[] diasCobroNew      = new double[4];
        double[] diasPagoNew       = new double[4];
        double[] diasInventarioNew = new double[4];
        double[] cceNew            = new double[4];

        // Calcular multiplicadores
        double multCobro      = 1.0 + (porcentajeCobro / 100.0);
        double multPago       = 1.0 + (porcentajePago / 100.0);
        double multInventario = 1.0 + (porcentajeInventario / 100.0);

        // Calcular cada año
        for (int i = 0; i < 4; i++) {
            diasCobroNew[i]      = diasCobroBase != null && diasCobroBase.length > i ? diasCobroBase[i] * multCobro : 0.0;
            diasPagoNew[i]       = diasPagoBase != null && diasPagoBase.length > i ? diasPagoBase[i] * multPago : 0.0;
            diasInventarioNew[i] = diasInventarioBase != null && diasInventarioBase.length > i ? diasInventarioBase[i] * multInventario : 0.0;
            cceNew[i] = diasInventarioNew[i] + diasCobroNew[i] - diasPagoNew[i];
        }

        // Mostrar en la tabla (redondeando hacia arriba a entero)
        DefaultTableModel modelo = (DefaultTableModel) tablaDestino.getModel();
        modelo.setRowCount(0);

        // Días de cobro
        Object[] filaCobro = new Object[5];
        filaCobro[0] = nombres[0];
        for (int i = 0; i < 4; i++) filaCobro[i + 1] = String.valueOf((int) Math.ceil(diasCobroNew[i]));
        modelo.addRow(filaCobro);

        // Días de pago
        Object[] filaPago = new Object[5];
        filaPago[0] = nombres[1];
        for (int i = 0; i < 4; i++) filaPago[i + 1] = String.valueOf((int) Math.ceil(diasPagoNew[i]));
        modelo.addRow(filaPago);

        // Días de inventario
        Object[] filaInventario = new Object[5];
        filaInventario[0] = nombres[2];
        for (int i = 0; i < 4; i++) filaInventario[i + 1] = String.valueOf((int) Math.ceil(diasInventarioNew[i]));
        modelo.addRow(filaInventario);

        // CCE
        Object[] filaCCE = new Object[5];
        filaCCE[0] = nombres[3];
        for (int i = 0; i < 4; i++) filaCCE[i + 1] = String.valueOf((int) Math.ceil(cceNew[i]));
        modelo.addRow(filaCCE);
    }
}

