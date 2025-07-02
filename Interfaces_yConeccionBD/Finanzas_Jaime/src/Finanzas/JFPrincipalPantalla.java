
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Finanzas;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.JFreeChart;

/**
 *
 
 */
public class JFPrincipalPantalla extends javax.swing.JFrame {
    public boolean comprobar = false;
    File archivoSeleccionado;
    BalanceGeneral bg;
    Object[] cuentas = {
        "Activo Total", "Activo Circulante Total", "Activo Fijo Total", "Pasivo Total", "Pasivo Circulante Total", "Pasivo Fijo Total", "Capital Total", "Inventarios", 
        "Cargos Diferidos", "Cuentas por Pagar", "Gastos Totales de Operación", "Cuentas por Cobrar",  "Ventas", "Costo de Ventas", "Utilidad Bruta",
        "Utilidad de Operación", "Utilidad antes de Impuestos a la Utilidad", "Utilidad Neta", "Utilidad Antes de Intereses e Impuestos o Utilidad Operativa", 
        "Gasto de Interés o Gastos Financieros"
    };
    
    public Integer id;
    
    /**
     * Creates new form NewJFrame
     * 
     * (0) Activo Total
(1) Activo Circulante Total
(2) Activo Fijo Total
(3) Pasivo Total
(4) Pasivo Circulante Total
(5) Pasivo Fijo Total
(6) Capital Total
(7) Inventarios
(8) Cargos Diferidos
(9) Compañias Afiliadas / Cuentas por Pagar
(10) Gastos Totales de Operación
(11) Cuentas por Cobrar
* 
* (12) Ventas
(13) Costo de Ventas
(14) Utilidad Bruta
(15) Utilidad de Operación
(16) Utilidad antes de Impuestos a la Utilidad
(17) Utilidad Neta
(18) Utilidad Antes de Intereses e Impuestos o Utilidad Operativa
(19) Gasto de Interés o Gastos Financieros

     */
    public JFPrincipalPantalla() {
        
        initComponents();
        hacerPanelOpaco(jPanel2, Color.BLACK, 100); // ventana 1 se OPACA
        hacerPanelOpaco(jPanel3, Color.BLACK, 100); // ventana 2 SE OPACA
        hacerPanelOpaco(jPanel4, Color.BLACK, 100); // ventana 2 SE OPACA
        hacerPanelOpaco(jPanel5, Color.BLACK, 100); // ventana 2 SE OPACA
        hacerPanelOpaco(jPanel6, Color.BLACK, 100); // ventana 2 SE OPACA
        hacerPanelOpaco(jPanel7, Color.BLACK, 100); // ventana 2 SE OPACA
        hacerPanelOpaco(jPanel8, Color.BLACK, 120); // ventana 2 SE OPACA
        hacerPanelOpaco(jPanel10, Color.BLACK, 120); // ventana 2 SE OPACA
        hacerPanelOpaco(jPanel11, Color.BLACK, 120); // ventana 2 SE OPACA
        hacerPanelOpaco(jPanel12, Color.BLACK, 120); // ventana 2 SE OPACA
        hacerPanelOpaco(jPanel13, Color.BLACK, 120); // ventana 2 SE OPACA
        hacerPanelOpaco(jPanel14, Color.BLACK, 120); // ventana 2 SE OPACA
        hacerPanelOpaco(jPanel20, Color.BLACK, 120); // ventana 2 SE OPACA
        hacerPanelOpaco(jPanel21, Color.BLACK, 120); // ventana 2 SE OPACA
        
        
        if (this.bg == null){
            try {
                llenarTablaConCuentas(jTable1); 
            } catch(Exception e){
            
            }
        }
        
        
        
        comboCuentas.removeAllItems();

        for (Object cuenta : cuentas) {
            comboCuentas.addItem(cuenta.toString());
        }

        
    }
    public static boolean esArchivoXLSX(File archivo) {
        if (archivo == null) {
            return false;
        }

        String nombre = archivo.getName().toLowerCase();
        return nombre.endsWith(".xlsx");
    }

    public static File seleccionarArchivoXLSX() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Selecciona un archivo .xlsx");

        int resultado = fileChooser.showOpenDialog(null);

        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoSeleccionado = fileChooser.getSelectedFile();
            if (esArchivoXLSX(archivoSeleccionado)) {
                return archivoSeleccionado;
            } else {
                JOptionPane.showMessageDialog(null, "Por favor selecciona un archivo con extensión .xlsx", "Archivo inválido", JOptionPane.ERROR_MESSAGE);
            }
        }

        return null; // Si se canceló o no es válido
    }
    public void hacerPanelOpaco(JPanel panel, Color colorFondo, int alpha) {
        panel.setOpaque(false);

        // Reescribimos paintComponent con una clase anónima
        panel.setUI(new javax.swing.plaf.PanelUI() {
            @Override
            public void update(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setColor(new Color(
                    colorFondo.getRed(), 
                    colorFondo.getGreen(), 
                    colorFondo.getBlue(), 
                    alpha)); // canal alfa para opacidad

                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 20, 20);
                g2.dispose();

                super.update(g, c); // continúa con el pintado de componentes
            }
        });

        panel.repaint();
    }
    public void llenarTablaConCuentas(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); // Limpiar filas existentes

        for (Cuenta cuenta : this.bg.getCuentas()) {
            Object[] fila = new Object[5];
            fila[0] = cuenta.getNombreCuenta();
            fila[1] = cuenta.getValoresDeLosAnios()[0];
            fila[2] = cuenta.getValoresDeLosAnios()[1];
            fila[3] = cuenta.getValoresDeLosAnios()[2];

            Integer id = cuenta.getId();
            if (id != null && id >= 0 && id < this.cuentas.length) {
                fila[4] = this.cuentas[id];
            } else {
                fila[4] = ""; // Sin asignación
            }

            modelo.addRow(fila);
        }

        tabla.setModel(modelo); // refrescar tabla (opcional si ya está enlazada)
    }
    public boolean soloUnaLinea(JTable tabla) {
        int[] filasSeleccionadas = tabla.getSelectedRows();
        return filasSeleccionadas.length == 1;
    }

   public void remplazarIDCuenta(JTable tabla, JComboBox<String> combo) {
    int filaSeleccionada = tabla.getSelectedRow();

    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila de la tabla.");
        return;
    }

    if (!soloUnaLinea(tabla)) {
        JOptionPane.showMessageDialog(null, "Por favor, selecciona solo una fila.");
        return;
    }

    // Obtener el texto seleccionado del combo
    String textoAsignado = combo.getSelectedItem().toString();

    // Recorrer toda la tabla y eliminar el texto asignado duplicado en otras filas
    for (int i = 0; i < tabla.getRowCount(); i++) {
        if (i != filaSeleccionada) {
            Object valor = tabla.getValueAt(i, 4); // columna Asignado
            if (valor != null && valor.toString().equalsIgnoreCase(textoAsignado)) {
                tabla.setValueAt("", i, 4); // limpiar asignación duplicada
            }
        }
    }

    // Asignar el nuevo valor en la fila seleccionada
    tabla.setValueAt(textoAsignado, filaSeleccionada, 4);
}

    public void agregarCuenta(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        Object[] nuevaFila = {"NUEVA CUENTA", 0, 0, 0, null};
        modelo.addRow(nuevaFila);
    }
    public void moverCuenta(JTable tabla, int movimiento) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecciona una fila para mover.");
            return;
        }
        if (!soloUnaLinea(tabla)){
            JOptionPane.showMessageDialog(null, "Por favor, selecciona solo una fila de la tabla.");
            return;
        }

        int filaDestino = -1;

        if (movimiento == 1 && filaSeleccionada > 0) {
            filaDestino = filaSeleccionada - 1; // Mover arriba
        } else if (movimiento == 2 && filaSeleccionada < modelo.getRowCount() - 1) {
            filaDestino = filaSeleccionada + 1; // Mover abajo
        } else {
            return; // Movimiento no permitido
        }

        // Intercambiar los valores completos de ambas filas
        int columnas = modelo.getColumnCount();
        Object[] filaSeleccionadaDatos = new Object[columnas];
        Object[] filaDestinoDatos = new Object[columnas];

        for (int col = 0; col < columnas; col++) {
            filaSeleccionadaDatos[col] = modelo.getValueAt(filaSeleccionada, col);
            filaDestinoDatos[col] = modelo.getValueAt(filaDestino, col);
        }

        for (int col = 0; col < columnas; col++) {
            modelo.setValueAt(filaSeleccionadaDatos[col], filaDestino, col);
            modelo.setValueAt(filaDestinoDatos[col], filaSeleccionada, col);
        }

        tabla.setRowSelectionInterval(filaDestino, filaDestino); // mantener selección visual
    }
    public void guardarTabla(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        int filas = modelo.getRowCount();


        List<Cuenta> nuevasCuentas = new ArrayList<>();
        boolean existeCuentaVentasValida = false;

        for (int i = 0; i < filas; i++) {
            // Validación del nombre
            Object nombreObj = modelo.getValueAt(i, 0);
            if (nombreObj == null || nombreObj.toString().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Todas las cuentas deben tener un nombre válido.");
                return;
            }

            String nombreCuenta = nombreObj.toString().trim();
            double[] valores = new double[3];

            for (int j = 0; j < 3; j++) {
                Object valorObj = modelo.getValueAt(i, j + 1);
                if (valorObj == null || valorObj.toString().trim().isEmpty()) {
                    valores[j] = 0;
                } else {
                    try {
                        valores[j] = Double.parseDouble(valorObj.toString().replace(",", "").replace("$", ""));
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Todos los valores de los años deben ser numéricos.");
                        return;
                    }
                }
            }

            // Validación del campo "Asignado"
            Object asignadoObj = modelo.getValueAt(i, 4);
            Integer id = null;

            if (asignadoObj != null && !asignadoObj.toString().trim().isEmpty()) {
                String asignado = asignadoObj.toString().trim();
                for (int idx = 0; idx < this.cuentas.length; idx++) {
                    if (((String) this.cuentas[idx]).equalsIgnoreCase(asignado)) {
                        id = idx;
                        if (asignado.equalsIgnoreCase("Ventas") &&
                            valores[0] >= 0 && valores[1] >= 0 && valores[2] >= 0) {
                            existeCuentaVentasValida = true;
                        }
                        break;
                    }
                }
            }

            Cuenta cuenta = new Cuenta(null, nombreCuenta, valores);
            cuenta.setId(id);
            nuevasCuentas.add(cuenta);
        }

        // Validar existencia de cuenta asignada como "Ventas"
        if (!existeCuentaVentasValida) {
            JOptionPane.showMessageDialog(null, "Debe existir una cuenta con Asignado = 'Ventas' y con valores numéricos válidos.");
            return;
        }

        // Reemplazar las cuentas del objeto BalanceGeneral
        this.bg.getCuentas().clear();
        this.bg.getCuentas().addAll(nuevasCuentas);

        JOptionPane.showMessageDialog(null, "Datos guardados correctamente en el Balance General.");
    }
    public void eliminarCuenta(JTable tabla) {
        int filaSeleccionada = tabla.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Por favor selecciona una fila para eliminar.");
            return;
        }
        if (!soloUnaLinea(tabla)){
            JOptionPane.showMessageDialog(null, "Por favor, selecciona solo una fila de la tabla.");
            return;
        }

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.removeRow(filaSeleccionada);
    }
    public void calcularPorcentajeBalanceEnTabla(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); // Limpiar la tabla antes de llenarla

        // 1. Validar que el balance tenga cuentas
        List<Cuenta> cuentas = this.bg.getCuentas();
        if (cuentas == null || cuentas.isEmpty()) {
            System.out.println("Error: El balance no contiene cuentas para procesar.");
            return;
        }

        // 2. Buscar la cuenta con ID 0 (Activo Total)
        Cuenta totalActivo = null;
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getId() != null && cuenta.getId() == 0) {
                totalActivo = cuenta;
                break;
            }
        }

        if (totalActivo == null) {
            System.out.println("Error: No se encontró la cuenta con ID 0 (Activo Total).");
            return; // termina el metodo
        }

        double[] totales = totalActivo.getValoresDeLosAnios(); // debe ser de tamaño 3

        // 3. Procesar cada cuenta hasta encontrar "Ventas" (id == 12)
        for (Cuenta cuenta : cuentas) {
            Integer idCuenta = cuenta.getId();
            if (idCuenta != null && idCuenta == 12) {
                break; // detenerse al llegar a "Ventas"
            }

            double[] valores = cuenta.getValoresDeLosAnios();
            Object[] fila = new Object[4];
            fila[0] = cuenta.getNombreCuenta(); // columna 0: nombre

            for (int j = 0; j < 3; j++) {
                if (totales[j] == 0) {
                    fila[j + 1] = 0.0 + "%";
                } else {
                    double porcentaje = (valores[j] / totales[j]) * 100;
                    fila[j + 1] = porcentaje + "%";
                }
            }

            modelo.addRow(fila);
        }
    }
    public void calcularPorcentajeEstadoResultados(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); // Limpiar la tabla

        List<Cuenta> cuentas = this.bg.getCuentas();
        if (cuentas == null || cuentas.isEmpty()) {
            System.out.println("Error: El balance está vacío.");
            return;
        }

        Cuenta cuentaVentas = null;
        int indexVentas = -1;

        // Buscar cuenta con id 12 (Ventas) y su índice
        for (int i = 0; i < cuentas.size(); i++) {
            Cuenta c = cuentas.get(i);
            if (c.getId() != null && c.getId() == 12) {
                cuentaVentas = c;
                indexVentas = i;
                break;
            }
        }

        if (cuentaVentas == null) {
            System.out.println("Error: No se encontró una cuenta con id 12 (Ventas).");
            return;
        }

        double[] valoresVentas = cuentaVentas.getValoresDeLosAnios();

        // Recorrer desde la cuenta Ventas hasta el final
        for (int i = indexVentas; i < cuentas.size(); i++) {
            Cuenta cuenta = cuentas.get(i);
            double[] valoresCuenta = cuenta.getValoresDeLosAnios();
            Object[] fila = new Object[4];

            fila[0] = cuenta.getNombreCuenta(); // Nombre

            for (int j = 0; j < 3; j++) {
                if (valoresVentas[j] == 0.0) {
                    fila[j + 1] = "0.0%";
                } else {
                    double porcentaje = (valoresCuenta[j] / valoresVentas[j]) * 100;
                    fila[j + 1] = porcentaje + "%";
                }
            }

            modelo.addRow(fila);
        }
    }
    public void calcularComparacion(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); // Limpiar la tabla

        List<Cuenta> cuentas = this.bg.getCuentas();
        if (cuentas == null || cuentas.isEmpty()) {
            System.out.println("Error: El balance está vacío.");
            return;
        }

        // Buscar el índice donde comienza la cuenta Ventas (id == 12)
        int limiteIndex = -1;
        for (int i = 0; i < cuentas.size(); i++) {
            Cuenta c = cuentas.get(i);
            if (c.getId() != null && c.getId() == 12) {
                limiteIndex = i;
                break;
            }
        }

        if (limiteIndex == -1) {
            System.out.println("Error: No se encontró una cuenta con id 12 (Ventas).");
            return;
        }

        // Recorrer desde el inicio hasta antes de Ventas
        for (int i = 0; i < limiteIndex; i++) {
            Cuenta cuenta = cuentas.get(i);
            double[] valores = cuenta.getValoresDeLosAnios(); // tamaño 3
            Object[] fila = new Object[4];
            fila[0] = cuenta.getNombreCuenta();

            double base = 0.0;
            int baseIndex = -1;

            // Buscar primer valor no cero para usar como base
            for (int j = 0; j < 3; j++) {
                if (valores[j] != 0.0) {
                    base = valores[j];
                    baseIndex = j;
                    break;
                }
            }

            // Llenar la fila
            if (base == 0.0) {
                fila[1] = "0.0%";
                fila[2] = "0.0%";
                fila[3] = "0.0%";
            } else {
                for (int j = 0; j < 3; j++) {
                    if (valores[j] == 0.0 || j < baseIndex) {
                        fila[j + 1] = "0.0%";
                    } else {
                        double porcentaje = (valores[j] / base) * 100;
                        fila[j + 1] = porcentaje + "%";
                    }
                }
            }

            modelo.addRow(fila);
        }
    }
    public void calcularComparacion2(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); // Limpiar la tabla

        List<Cuenta> cuentas = this.bg.getCuentas();
        if (cuentas == null || cuentas.isEmpty()) {
            System.out.println("Error: El balance está vacío.");
            return;
        }

        // Buscar el índice donde comienza la cuenta Ventas (id == 12)
        int indexVentas = -1;
        for (int i = 0; i < cuentas.size(); i++) {
            Cuenta c = cuentas.get(i);
            if (c.getId() != null && c.getId() == 12) {
                indexVentas = i;
                break;
            }
        }

        if (indexVentas == -1) {
            System.out.println("Error: No se encontró una cuenta con id 12 (Ventas).");
            return;
        }

        // Recorrer desde la cuenta Ventas hasta el final
        for (int i = indexVentas; i < cuentas.size(); i++) {
            Cuenta cuenta = cuentas.get(i);
            double[] valores = cuenta.getValoresDeLosAnios(); // tamaño 3
            Object[] fila = new Object[4];
            fila[0] = cuenta.getNombreCuenta();

            double base = 0.0;
            int baseIndex = -1;

            // Buscar primer valor no cero como base
            for (int j = 0; j < 3; j++) {
                if (valores[j] != 0.0) {
                    base = valores[j];
                    baseIndex = j;
                    break;
                }
            }

            // Llenar fila con porcentajes o 0.0%
            if (base == 0.0) {
                fila[1] = "0.0%";
                fila[2] = "0.0%";
                fila[3] = "0.0%";
            } else {
                for (int j = 0; j < 3; j++) {
                    if (valores[j] == 0.0 || j < baseIndex) {
                        fila[j + 1] = "0.0%";
                    } else {
                        double porcentaje = (valores[j] / base) * 100;
                        fila[j + 1] = porcentaje + "%";
                    }
                }
            }

            modelo.addRow(fila);
        }
    }
    
    public void calcularRazonesLiquidez(JTable tablaDestino, int idActivoCirculante, int idPasivoCirculante, int idInventario) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaDestino.getModel();
        modeloTabla.setRowCount(0);  // Limpiar la tabla

        Cuenta cuentaAC = this.bg.buscarCuenta(idActivoCirculante);
        Cuenta cuentaPC = this.bg.buscarCuenta(idPasivoCirculante);
        Cuenta cuentaInv = this.bg.buscarCuenta(idInventario);

        double[] valoresAC = (cuentaAC != null) ? cuentaAC.getValoresDeLosAnios() : new double[]{0.0, 0.0, 0.0};
        double[] valoresPC = (cuentaPC != null) ? cuentaPC.getValoresDeLosAnios() : new double[]{0.0, 0.0, 0.0};
        double[] valoresINV = (cuentaInv != null) ? cuentaInv.getValoresDeLosAnios() : new double[]{0.0, 0.0, 0.0};

        if (cuentaAC == null) System.out.println("⚠️ Cuenta con ID de Activo Circulante no encontrada.");
        if (cuentaPC == null) System.out.println("⚠️ Cuenta con ID de Pasivo Circulante no encontrada.");
        if (cuentaInv == null) System.out.println("⚠️ Cuenta con ID de Inventario no encontrada.");

        // Capital Neto de Trabajo (AC - PC)
        Object[] filaCNT = new Object[4];
        filaCNT[0] = "Capital Neto de Trabajo";
        for (int i = 0; i < 3; i++) {
            filaCNT[i + 1] = valoresAC[i] - valoresPC[i];
        }
        modeloTabla.addRow(filaCNT);

        // Razón Circulante (AC / PC)
        Object[] filaRC = new Object[4];
        filaRC[0] = "Razón Circulante";
        for (int i = 0; i < 3; i++) {
            filaRC[i + 1] = (valoresPC[i] == 0) ? 0.0 : (valoresAC[i] / valoresPC[i]);
        }
        modeloTabla.addRow(filaRC);

        // Prueba Ácida ((AC - Inventario) / PC)
        Object[] filaPA = new Object[4];
        filaPA[0] = "Prueba Ácida";
        for (int i = 0; i < 3; i++) {
            
            filaPA[i + 1] = (valoresPC[i] == 0) ? 0.0 : ((valoresAC[i] - valoresINV[i]) / valoresPC[i]);
        }
        modeloTabla.addRow(filaPA);
    }
    
    public void calcularRazonesActividad(JTable tablaActividad) {
        DefaultTableModel modeloActividad = (DefaultTableModel) tablaActividad.getModel();
        modeloActividad.setRowCount(0);

        if (bg.getCuentas() == null || bg.getCuentas().isEmpty()) {
            System.out.println("[Error] El balance general está vacío.");
            return;
        }

        Cuenta cuentasPorCobrar = bg.buscarCuenta(11);
        Cuenta ventasTotales = bg.buscarCuenta(12);
        Cuenta inventarioGeneral = bg.buscarCuenta(7);
        Cuenta costoVentasTotal = bg.buscarCuenta(13);
        Cuenta cuentasPorPagar = bg.buscarCuenta(9);

        if (cuentasPorCobrar == null || ventasTotales == null || inventarioGeneral == null ||
            costoVentasTotal == null || cuentasPorPagar == null) {
            System.out.println("[Aviso] Una o más cuentas necesarias no fueron encontradas para el análisis de actividad.");
            return;
        }

        double[] datosCxC = cuentasPorCobrar.getValoresDeLosAnios();
        double[] datosVentas = ventasTotales.getValoresDeLosAnios();
        double[] datosInventario = inventarioGeneral.getValoresDeLosAnios();
        double[] datosCostoVentas = costoVentasTotal.getValoresDeLosAnios();
        double[] datosCxP = cuentasPorPagar.getValoresDeLosAnios();

        Object[] filaResultado = new Object[4];
        double[] rotaciones = new double[3];
        double[] cicloOperativo = new double[3];

        // Rotación de CxC
        filaResultado[0] = "Rotación CxC";
        for (int i = 0; i < 3; i++) {
            double resultado = (datosCxC[i] == 0.0) ? 0.0 : datosVentas[i] / datosCxC[i];
            filaResultado[i + 1] = resultado;
            rotaciones[i] = resultado;
        }
        modeloActividad.addRow(filaResultado.clone());

        // Días CxC
        filaResultado[0] = "Días CxC";
        for (int i = 0; i < 3; i++) {
            double dias = (rotaciones[i] == 0.0) ? 0.0 : 360 / rotaciones[i];
            filaResultado[i + 1] = dias;
            cicloOperativo[i] = dias;
        }
        modeloActividad.addRow(filaResultado.clone());

        // Rotación Inventario
        filaResultado[0] = "Rotación Inventarios";
        for (int i = 0; i < 3; i++) {
            double resultado = (datosInventario[i] == 0.0) ? 0.0 : datosCostoVentas[i] / datosInventario[i];
            filaResultado[i + 1] = resultado;
            rotaciones[i] = resultado;
        }
        modeloActividad.addRow(filaResultado.clone());

        // Días Inventario
        filaResultado[0] = "Días Inv.";
        for (int i = 0; i < 3; i++) {
            double dias = (rotaciones[i] == 0.0) ? 0.0 : 360 / rotaciones[i];
            filaResultado[i + 1] = dias;
            cicloOperativo[i] += dias;
        }
        modeloActividad.addRow(filaResultado.clone());

        // Ciclo de Operaciones
        filaResultado[0] = "Ciclo de Operaciones";
        for (int i = 0; i < 3; i++) filaResultado[i + 1] = cicloOperativo[i];
        modeloActividad.addRow(filaResultado.clone());

        // Rotación CxP
        filaResultado[0] = "Rotación CxP";
        for (int i = 0; i < 3; i++) {
            double resultado = (datosCxP[i] == 0.0) ? 0.0 : datosCostoVentas[i] / datosCxP[i];
            filaResultado[i + 1] = resultado;
            rotaciones[i] = resultado;
        }
        modeloActividad.addRow(filaResultado.clone());

        // Días CxP
        filaResultado[0] = "Días CxP";
        for (int i = 0; i < 3; i++) {
            double dias = (rotaciones[i] == 0.0) ? 0.0 : 360 / rotaciones[i];
            filaResultado[i + 1] = dias;
            cicloOperativo[i] -= dias;
        }
        modeloActividad.addRow(filaResultado.clone());

        // Ciclo de Conversión del Efectivo
        filaResultado[0] = "Ciclo de Conversión del Efectivo";
        for (int i = 0; i < 3; i++) filaResultado[i + 1] = cicloOperativo[i];
        modeloActividad.addRow(filaResultado.clone());
    } 

    public void calcularRazonesEndeudamiento(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);

        // Obtener cuentas directamente desde el BalanceGeneral
        Cuenta cuentaActivosTotales = bg.buscarCuenta(0);
        Cuenta cuentaPasivosTotales = bg.buscarCuenta(3);
        Cuenta cuentaCapitalTotal = bg.buscarCuenta(6);
        Cuenta cuentaVentas = bg.buscarCuenta(12); // esta no
        Cuenta cuentaUtilidadOperativa = bg.buscarCuenta(18);
        Cuenta cuentaGastosFinancieros = bg.buscarCuenta(19);

        if (cuentaActivosTotales == null || cuentaPasivosTotales == null || cuentaCapitalTotal == null ||
            cuentaVentas == null || cuentaUtilidadOperativa == null || cuentaGastosFinancieros == null) {
            System.out.println("Error: Una o más cuentas necesarias para razones de endeudamiento no fueron encontradas.");
            
        }
        double[] activos = this.obtenerValoresSeguros(cuentaActivosTotales);
        double[] pasivos = this.obtenerValoresSeguros(cuentaPasivosTotales);
        double[] capital = this.obtenerValoresSeguros(cuentaCapitalTotal);
        double[] uaii = this.obtenerValoresSeguros(cuentaUtilidadOperativa);
        double[] gastosf  = this.obtenerValoresSeguros(cuentaGastosFinancieros);
        double[] ventas = this.obtenerValoresSeguros(cuentaVentas);
        
        
        System.out.println("Se guardaron en 0 ");
        Object[] fila = new Object[4];

        // Índice de endeudamiento
        fila[0] = "Índice de Endeudamiento";
        for (int i = 1; i < 4; i++) {
            fila[i] = (activos[i - 1] == 0) ? 0.00 : (pasivos[i - 1] / activos[i - 1]) * 100;
        }
        modelo.addRow(fila);

        // Razón de capital
        fila = new Object[4];
        fila[0] = "Razón de Capital";
        for (int i = 1; i < 4; i++) {
            fila[i] = (activos[i - 1] == 0) ? 0.00 : (capital[i - 1] / activos[i - 1]) * 100;
        }
        modelo.addRow(fila);

        // Razón de deuda a capital
        fila = new Object[4];
        fila[0] = "Razón Deuda a Capital";
        for (int i = 1; i < 4; i++) {
            fila[i] = (capital[i - 1] == 0) ? 0.00 : (pasivos[i - 1] / capital[i - 1]) * 100;
        }
        modelo.addRow(fila);

        // Cobertura de interés
        fila = new Object[4];
        fila[0] = "Cobertura de Interés";
        for (int i = 1; i < 4; i++) {
            fila[i] = (gastosf[i - 1] == 0) ? 0.00 : (uaii[i - 1] / gastosf[i - 1]);
        }
        modelo.addRow(fila);
    }

    private double[] obtenerValoresSeguros(Cuenta cuenta) {
        return (cuenta != null) ? cuenta.getValoresDeLosAnios() : new double[]{0.0, 0.0, 0.0};
    }
    
    public void calcularIndicadoresRentabilidad(JTable tabla) {
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); // Limpiar tabla

        Cuenta cuentaVentas = bg.buscarCuenta(12);
        Cuenta cuentaUtilBruta = bg.buscarCuenta(14);
        Cuenta cuentaUtilOper = bg.buscarCuenta(15);
        Cuenta cuentaUtilAIU = bg.buscarCuenta(16);
        Cuenta cuentaUtilNeta = bg.buscarCuenta(17);
        Cuenta cuentaActivos = bg.buscarCuenta(0);
        Cuenta cuentaCapital = bg.buscarCuenta(6);

        if (cuentaVentas == null || cuentaUtilBruta == null || cuentaUtilOper == null ||
            cuentaUtilAIU == null || cuentaUtilNeta == null || cuentaActivos == null || cuentaCapital == null) {
            System.out.println("Error: Faltan cuentas necesarias para indicadores de rentabilidad.");
            
            return;
        }

        double[] datosVentas = cuentaVentas.getValoresDeLosAnios();
        double[] datosUtilBruta = cuentaUtilBruta.getValoresDeLosAnios();
        double[] datosUtilOper = cuentaUtilOper.getValoresDeLosAnios();
        double[] datosUtilAIU = cuentaUtilAIU.getValoresDeLosAnios();
        double[] datosUtilNeta = cuentaUtilNeta.getValoresDeLosAnios();
        double[] datosActivos = cuentaActivos.getValoresDeLosAnios();
        double[] datosCapital = cuentaCapital.getValoresDeLosAnios();

        Object[] fila = new Object[4];

        fila[0] = "Margen Bruto";
        for (int i = 1; i < 4; i++) {
            fila[i] = (datosVentas[i - 1] == 0) ? 0.00 : (datosUtilBruta[i - 1] / datosVentas[i - 1]) * 100;
        }
        modelo.addRow(fila);

        fila = new Object[4];
        fila[0] = "Margen de Operación";
        for (int i = 1; i < 4; i++) {
            fila[i] = (datosVentas[i - 1] == 0) ? 0.00 : (datosUtilOper[i - 1] / datosVentas[i - 1]) * 100;
        }
        modelo.addRow(fila);

        fila = new Object[4];
        fila[0] = "Margen Financiero";
        for (int i = 1; i < 4; i++) {
            fila[i] = (datosVentas[i - 1] == 0) ? 0.00 : (datosUtilAIU[i - 1] / datosVentas[i - 1]) * 100;
        }
        modelo.addRow(fila);

        fila = new Object[4];
        fila[0] = "Margen Neto";
        for (int i = 1; i < 4; i++) {
            fila[i] = (datosVentas[i - 1] == 0) ? 0.00 : (datosUtilNeta[i - 1] / datosVentas[i - 1]) * 100;
        }
        modelo.addRow(fila);

        fila = new Object[4];
        fila[0] = "ROA";
        for (int i = 1; i < 4; i++) {
            fila[i] = (datosActivos[i - 1] == 0) ? 0.00 : (datosUtilNeta[i - 1] / datosActivos[i - 1]) * 100;
        }
        modelo.addRow(fila);

        fila = new Object[4];
        fila[0] = "ROI";
        for (int i = 1; i < 4; i++) {
            fila[i] = (datosCapital[i - 1] == 0) ? 0.00 : (datosUtilNeta[i - 1] / datosCapital[i - 1]) * 100;
        }
        modelo.addRow(fila);
    }

    public void generarReporteFinancieroPDF(int idPractica) {
        try {
            String rutaBase = System.getProperty("user.home") + File.separator + "Documents" + File.separator + idPractica;
            File carpeta = new File(rutaBase);
            if (!carpeta.exists()) carpeta.mkdirs();

            String rutaPDF = rutaBase + File.separator + "ReporteFinanciero.pdf";
            Document documento = new Document(PageSize.A4, 50, 50, 50, 50);
            PdfWriter.getInstance(documento, new FileOutputStream(rutaPDF));
            documento.open();

            Font titulo = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
            Font subtitulo = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
            Font texto = new Font(Font.FontFamily.TIMES_ROMAN, 12);

            // Título principal
            Paragraph tituloPrincipal = new Paragraph("SISTEMA DE INFORMACIÓN DE ANÁLISIS FINANCIERO EMPRESARIAL Y GESTIÓN DE CAPITAL DE TRABAJO", titulo);
            tituloPrincipal.setAlignment(Element.ALIGN_CENTER);
            documento.add(tituloPrincipal);
            documento.add(new Paragraph(" "));

            // ---- Porcientos Integrales ----
            documento.add(new Paragraph("Porcientos Integrales", subtitulo));
            documento.add(new Paragraph("Balance General", texto));
            documento.add(tablaPdfDesdeJTable(jTable3));
            documento.add(new Paragraph("Estado de Resultados", texto));
            documento.add(tablaPdfDesdeJTable(jTable2));
            documento.add(new Paragraph("Balance General", texto));
            documento.add(tablaPdfDesdeJTable(jTable4));
            documento.add(new Paragraph("Estado de Resultados", texto));
            documento.add(tablaPdfDesdeJTable(jTable5));

            // ---- Análisis de tendencias ---- con imagenes al fondo
            documento.add(new Paragraph("Análisis de tendencias", subtitulo));

            documento.add(new Paragraph("Estructura Financiera", texto));
            documento.add(tablaPdfDesdeJTable(jTable6));
            

            documento.add(new Paragraph("Estructura del Activo", texto));
            documento.add(tablaPdfDesdeJTable(jTable7));
            

            documento.add(new Paragraph("Financiamiento", texto));
            documento.add(tablaPdfDesdeJTable(jTable8));
            

            documento.add(new Paragraph("Tabla de Operación", texto));
            documento.add(tablaPdfDesdeJTable(jTable9));
            

            documento.add(new Paragraph("Tabla de Actividad", texto));
            documento.add(tablaPdfDesdeJTable(jTable10));
            

            documento.add(new Paragraph("Tabla de Márgenes", texto));
            documento.add(tablaPdfDesdeJTable(jTable11));
            

            // ---- Razones Financieras ----
            documento.add(new Paragraph("Razones Financieras", subtitulo));

            documento.add(new Paragraph("Razones de Liquidez", texto));
            documento.add(tablaPdfDesdeJTable(jTable12));

            documento.add(new Paragraph("Razones de Actividad", texto));
            documento.add(tablaPdfDesdeJTable(jTable13));

            documento.add(new Paragraph("Razones de Endeudamiento", texto));
            documento.add(tablaPdfDesdeJTable(jTable14));

            documento.add(new Paragraph("Tabla de Rentabilidad", texto));
            documento.add(tablaPdfDesdeJTable(jTable15));
            
            documento.add(new Paragraph("Graficas del Análisis de tendencias", texto));
            agregarImagen(documento, rutaBase + File.separator + "grafica1.png");
            agregarImagen(documento, rutaBase + File.separator + "grafica2.png");
            agregarImagen(documento, rutaBase + File.separator + "grafica3.png");
            agregarImagen(documento, rutaBase + File.separator + "grafica4.png");
            agregarImagen(documento, rutaBase + File.separator + "grafica5.png");
            agregarImagen(documento, rutaBase + File.separator + "grafica6.png");
            
            documento.close();

            JOptionPane.showMessageDialog(null, "PDF generado exitosamente en:\n" + rutaPDF);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al generar el PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private PdfPTable tablaPdfDesdeJTable(JTable tabla) {
        PdfPTable pdfTable = new PdfPTable(tabla.getColumnCount());
        pdfTable.setWidthPercentage(100);
        pdfTable.setSpacingBefore(10f);

        // Encabezados
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            pdfTable.addCell(new PdfPCell(new Phrase(tabla.getColumnName(i))));
        }

        // Filas
        for (int fila = 0; fila < tabla.getRowCount(); fila++) {
            for (int col = 0; col < tabla.getColumnCount(); col++) {
                Object valor = tabla.getValueAt(fila, col);
                pdfTable.addCell(new PdfPCell(new Phrase(valor != null ? valor.toString() : "")));
            }
        }

        return pdfTable;
    }

    private void agregarImagen(Document doc, String ruta) {
        try {
            Image img = Image.getInstance(ruta);
            img.scaleToFit(400, 300);
            img.setAlignment(Element.ALIGN_CENTER);
            doc.add(img);
            doc.add(new Paragraph(" "));
        } catch (Exception e) {
            System.out.println("⚠️ Imagen no encontrada o error al agregar: " + ruta);
        }
    }




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        comboCuentas = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jPanel18 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        jPanel19 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel20 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable12 = new javax.swing.JTable();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable13 = new javax.swing.JTable();
        jPanel21 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jTable14 = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTable15 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(153, 153, 153));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("SISTEMA DE INFORMACIÓN DE ANÁLISIS FINANCIERO EMPRESARIAL Y GESTIÓN DE CAPITAL DE TRABAJO");
        jLabel3.setOpaque(true);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jLabel4.setBackground(new java.awt.Color(153, 153, 153));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Universidad Veracruzana, Facultad de Contaduría y Administración");
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        jLabel5.setBackground(new java.awt.Color(153, 153, 153));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Finanzas personales");
        jLabel5.setOpaque(true);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 40, -1, -1));

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel2.setPreferredSize(new java.awt.Dimension(1030, 720));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(153, 153, 153));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Finanzas/imagenes/paloma.png"))); // NOI18N
        jLabel6.setOpaque(true);
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 50, 50));

        jLabel7.setBackground(new java.awt.Color(153, 153, 153));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Colocale un id");
        jLabel7.setOpaque(true);
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 490, 50));

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, 150, 50));

        jLabel8.setBackground(new java.awt.Color(153, 153, 153));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText(" Seleccione un archivo de exel para guardar los datos:");
        jLabel8.setOpaque(true);
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 490, 50));

        jLabel9.setBackground(new java.awt.Color(153, 153, 153));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Finanzas/imagenes/paloma.png"))); // NOI18N
        jLabel9.setOpaque(true);
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 50, 50));

        jLabel10.setBackground(new java.awt.Color(153, 153, 153));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Finanzas/imagenes/paloma.png"))); // NOI18N
        jLabel10.setOpaque(true);
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 50, 50));

        jButton3.setText("Seleccionar archivo");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, 150, 50));

        jButton11.setText("Salir del sistema");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 640, 150, 50));

        jLabel27.setBackground(new java.awt.Color(153, 153, 153));
        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText(" Guardar datos");
        jLabel27.setOpaque(true);
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 490, 50));
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 490, 30));

        jButton13.setText("Guardar");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 230, 150, 50));

        jButton14.setText("Generar PDF de los resultados obtenidos");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 490, 50));

        jTabbedPane1.addTab("tab1", jPanel2);

        comboCuentas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setBackground(new java.awt.Color(153, 153, 153));
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText(" Asignar cuentas:");
        jLabel11.setOpaque(true);

        jButton4.setText("Asignar cuenta");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre de la cuenta", "Valor Año 1", "Valor año 2", "Valor año 3", "Asignado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton5.setText("Agregar cuenta");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Quitar cuenta");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(153, 153, 153));
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText(" Mover cuenta:");
        jLabel12.setOpaque(true);

        jButton7.setText("Arriba");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Abajo");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Guardar tabla");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
        });
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Traser datos a la tabla");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
        });
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton12.setText("Iniciar con los calculos");
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton12MouseClicked(evt);
            }
        });
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton12)))
                        .addGap(0, 44, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab2", jPanel3);

        jLabel13.setBackground(new java.awt.Color(153, 153, 153));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Porcientos integrales");
        jLabel13.setOpaque(true);

        jLabel14.setBackground(new java.awt.Color(153, 153, 153));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Balance General");
        jLabel14.setOpaque(true);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre de la cuenta", "Valor año 1", "Valor año 2", "Valor año 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel15.setBackground(new java.awt.Color(153, 153, 153));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Estado de Resultados");
        jLabel15.setOpaque(true);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre de la cuenta", "Valor año 1", "Valor año 2", "Valor año 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 1115, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 1115, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab3", jPanel4);

        jLabel16.setBackground(new java.awt.Color(153, 153, 153));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Porcientos integrales");
        jLabel16.setOpaque(true);

        jLabel17.setBackground(new java.awt.Color(153, 153, 153));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Balance General");
        jLabel17.setOpaque(true);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre de la cuenta", "Valor año 1", "Valor año 2", "Valor año 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jLabel18.setBackground(new java.awt.Color(153, 153, 153));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Estado de Resultados");
        jLabel18.setOpaque(true);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "nombre de la cuenta", "Valor año 1", "Valor año 2", "Valor año 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable5);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1115, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 1115, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addGap(3, 3, 3)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab4", jPanel5);

        jLabel19.setBackground(new java.awt.Color(153, 153, 153));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Análisis de tendencias");
        jLabel19.setOpaque(true);

        jTabbedPane2.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jLabel20.setBackground(new java.awt.Color(153, 153, 153));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Estructura Financiera");
        jLabel20.setOpaque(true);

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre de la cuenta", "Valor año 1", "Valor año 2", "Valor año 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTable6);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("tab1", jPanel8);

        jLabel22.setBackground(new java.awt.Color(153, 153, 153));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Estructura del Activo");
        jLabel22.setOpaque(true);

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre de la cuenta", "Valor año 1", "Valor año 2", "Valor año 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(jTable7);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
                    .addComponent(jScrollPane7))
                .addContainerGap())
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        jTabbedPane2.addTab("tab2", jPanel10);

        jLabel23.setBackground(new java.awt.Color(153, 153, 153));
        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 0, 0));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Financiamiento");
        jLabel23.setOpaque(true);

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre de la cuenta", "Valor año 1", "Valor año 2", "Valor año 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(jTable8);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
                    .addComponent(jScrollPane8))
                .addContainerGap())
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        jTabbedPane2.addTab("tab3", jPanel11);

        jLabel24.setBackground(new java.awt.Color(153, 153, 153));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Tabla de Operación");
        jLabel24.setOpaque(true);

        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre de la cuenta", "Valor año 1", "Valor año 2", "Valor año 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(jTable9);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("tab4", jPanel12);

        jLabel25.setBackground(new java.awt.Color(153, 153, 153));
        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 0, 0));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Tabla de Actividad");
        jLabel25.setOpaque(true);

        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre de la cuenta", "Valor año 1", "Valor año 2", "Valor año 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(jTable10);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
                    .addComponent(jScrollPane10))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("tab5", jPanel13);

        jLabel26.setBackground(new java.awt.Color(153, 153, 153));
        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Tabla de Márgenes");
        jLabel26.setOpaque(true);

        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre de la cuenta", "Valor año 1", "Valor año 2", "Valor año 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(jTable11);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 724, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 1068, Short.MAX_VALUE)
            .addComponent(jScrollPane11)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(162, 162, 162))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("tab6", jPanel14);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jTabbedPane2)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2))
        );

        jTabbedPane1.addTab("tab5", jPanel6);

        jLabel21.setBackground(new java.awt.Color(153, 153, 153));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Razones financieras");
        jLabel21.setOpaque(true);

        jTabbedPane3.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jLabel28.setBackground(new java.awt.Color(153, 153, 153));
        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Razones de Liquidez");
        jLabel28.setOpaque(true);

        jTable12.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre de la cuenta", "Valor año 1", "Valor año 2", "Valor año 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane12.setViewportView(jTable12);

        jLabel29.setBackground(new java.awt.Color(153, 153, 153));
        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 0));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Razones de Actividad");
        jLabel29.setOpaque(true);

        jTable13.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre de la cuenta", "Valor año 1", "Valor año 2", "Valor año 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane13.setViewportView(jTable13);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
                    .addComponent(jScrollPane12)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
                    .addComponent(jScrollPane13))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 80, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("tab1", jPanel20);

        jLabel30.setBackground(new java.awt.Color(153, 153, 153));
        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 0, 0));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Razones de endeudamiento");
        jLabel30.setOpaque(true);

        jTable14.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre de la cuenta", "Valor año 1", "Valor año 2", "Valor año 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane14.setViewportView(jTable14);

        jLabel31.setBackground(new java.awt.Color(153, 153, 153));
        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 0, 0));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Tabla de Rentabilidad");
        jLabel31.setOpaque(true);

        jTable15.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre de la cuenta", "Valor año 1", "Valor año 2", "Valor año 3"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane15.setViewportView(jTable15);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
                    .addComponent(jScrollPane14)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 86, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("tab2", jPanel21);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane3)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab6", jPanel7);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1180, 710));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Finanzas/imagenes/vladimir-solomianyi-rKPiuXLq29A-unsplash.jpg"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 790));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        if (this.comprobar){
            try {
                bg = LectorBalance.leerArchivoExcel(this.archivoSeleccionado);
                System.out.println("Se ha leido el archivo");

                List<Cuenta> cuentas = bg.getCuentas();
                JOptionPane.showMessageDialog(this, "Correctamente guardado");

                for (Cuenta c: cuentas){
                    System.out.println(c.getNombreCuenta() + "valores " + c.getValoresDeLosAnios());
                }

            } catch (Exception e){
                System.out.println("salio mal lectura exel");

            }
        } else {

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        System.out.println("todo bien"); this.comprobar = true;
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.archivoSeleccionado = seleccionarArchivoXLSX(); // se selecciona el achivo y se guarda;
        

        if (archivoSeleccionado != null) {
            System.out.println("Archivo seleccionado: " + archivoSeleccionado.getAbsolutePath()); this.comprobar = true;

            if(esArchivoXLSX(this.archivoSeleccionado) && this.comprobar){
                System.out.println("todo bien si es un .xlxs"); this.comprobar = true;
                JOptionPane.showMessageDialog(this, "Seleccion correcta");
            } else {
                this.comprobar = false;
                System.out.println("no es un archivo .xlxs");
            }
        } else {
            System.out.println("No se seleccionó ningún archivo."); this.comprobar = false;
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        remplazarIDCuenta(jTable1, comboCuentas);
        //guardarTabla
        //llenarTablaConCuentas(jTable1);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        agregarCuenta(jTable1);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        eliminarCuenta(jTable1);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        moverCuenta(jTable1, 1);
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        moverCuenta(jTable1, 2);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        guardarTabla(jTable1);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10MouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        
        if (this.bg != null){
            try {
                llenarTablaConCuentas(jTable1); 
            } catch(Exception e){
                System.out.println("Error al plasmar los datos en la tabla");
            }
        } else {System.out.println("El objeto balance está vacio");}
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11MouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12MouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        
        
        if (this.id == null){
            JOptionPane.showMessageDialog(this, "colque un número para el ID de la practica");
            return;
        }
        try {
            calcularPorcentajeBalanceEnTabla(jTable3); // Porcientos integrales
            calcularPorcentajeEstadoResultados(jTable2);
        } catch(Exception e){
    
        }
        try {
            calcularComparacion(jTable4);   //Segunda pantalla
            calcularComparacion2(jTable5);
        } catch(Exception e){
    
        }
        try { JFreeChart grafica1 = GeneradorGraficaFinanciera.crearGraficaEstructuraFinanciera(this.bg, jTable6, jPanel9);
        GeneradorGraficaFinanciera.exportarGraficaComoPNG(grafica1, this.id, "grafica1");
        
        JFreeChart grafica2 = GeneradorGraficaFinanciera.crearGraficaEstructuraActivo(this.bg, jTable7, jPanel15);
        GeneradorGraficaFinanciera.exportarGraficaComoPNG(grafica2, this.id, "grafica2");   
        
        } catch(Exception e){
            System.out.println("Error 1: " + e);
        }
        try {
            JFreeChart grafica3 = GeneradorGraficaFinanciera.crearGraficaEstructuraFinanciamiento(this.bg, jTable8, jPanel16);
        GeneradorGraficaFinanciera.exportarGraficaComoPNG(grafica3, this.id, "grafica3");   
        
        JFreeChart grafica4 = GeneradorGraficaFinanciera.crearGraficaEstructuraOperacion(this.bg, jTable9, jPanel17); ///
        GeneradorGraficaFinanciera.exportarGraficaComoPNG(grafica4, this.id, "grafica4");   
        
        } catch(Exception e){
                System.out.println("Error 2: " + e);
        }
        try {
            JFreeChart grafica5 = GeneradorGraficaFinanciera.crearGraficaEstructuraActividad(this.bg, jTable10, jPanel18); // no jala
        GeneradorGraficaFinanciera.exportarGraficaComoPNG(grafica5, this.id, "grafica5");   
   
        } catch(Exception e){
                System.out.println("Error 3: " + e);
        }
        try {
        
        }catch(Exception e) {
        }
        try {
            JFreeChart grafica6 = GeneradorGraficaFinanciera.crearGraficaEstructuraMargenes(this.bg, jTable11, jPanel19);
        GeneradorGraficaFinanciera.exportarGraficaComoPNG(grafica6, this.id, "grafica6");   
        }catch(Exception e) {
        }
        try {
            // JTable tablaDestino, int idActivoCirculante, int idPasivoCirculante, int idInventario
        calcularRazonesLiquidez(jTable12, 1, 4, 7);
        }catch(Exception e) {
        }
        try {
            //public void 
        calcularRazonesActividad(jTable13);
        }catch(Exception e) {
        }
        try {
            // calcularRazonesEndeudamiento(JTable tabla)
        calcularRazonesEndeudamiento(jTable14);
        }catch(Exception e) {   System.out.println("Error endeudamiento: " + e);
        }
        try {
            //calcularIndicadoresRentabilidad(JTable tabla)
        calcularIndicadoresRentabilidad(jTable15);
        }catch(Exception e) {
            System.out.println("Error rentabilidad");
        }
        
        
        
        
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        try {
            this.id = Integer.parseInt(jTextField1.getText()); JOptionPane.showMessageDialog(this, "Guardado correctamente");
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "colque un número valido para el ID de la practica");
        }
        
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        
        generarReporteFinancieroPDF(this.id);
        JOptionPane.showMessageDialog(null, " PDF generado correctamente.");
        
    }//GEN-LAST:event_jButton14ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFPrincipalPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFPrincipalPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFPrincipalPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFPrincipalPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFPrincipalPantalla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboCuentas;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable12;
    private javax.swing.JTable jTable13;
    private javax.swing.JTable jTable14;
    private javax.swing.JTable jTable15;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
