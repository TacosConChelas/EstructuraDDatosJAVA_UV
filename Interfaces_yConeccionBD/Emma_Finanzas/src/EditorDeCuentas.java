
import Objetos.Balance;
import Objetos.Cuenta;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author tacosconchelas
 */
public class EditorDeCuentas extends javax.swing.JFrame {
    public Balance balanceActual;
    public int idPractica = 0;
    /**
     * Creates new form EditorDeCuentas
     */
    public EditorDeCuentas(Balance b, int i) {
        initComponents();
        this.balanceActual = b;
        this.idPractica = i;
        mostrarDatos();
    }
    
    /**
 * Muestra en la tabla todas las cuentas del balance actual,
 * colocando en la columna "Asignado" el nombre correspondiente si el id es especial,
 * o "Sin asignar" en cualquier otro caso.
 */
    public void mostrarDatos() {
        // Suponiendo que usas DefaultTableModel para tu tabla
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

        // Limpiar todas las filas actuales de la tabla
        modelo.setRowCount(0);

        // Recorrer todas las cuentas registradas en el balance actual
        for (Cuenta cuenta : balanceActual.getCuentasRegistradas()) {
            // Preparar arreglo para la fila de la tabla
            Object[] fila = new Object[6];

            // Columna 0: Nombre/Descripción de la cuenta
            fila[0] = cuenta.getDescripcion();

            // Columnas 1-4: Valores de cada año
            ArrayList<Double> valores = cuenta.getRegistrosPeriodos();
            fila[1] = valores.size() > 0 ? valores.get(0) : 0.0;
            fila[2] = valores.size() > 1 ? valores.get(1) : 0.0;
            fila[3] = valores.size() > 2 ? valores.get(2) : 0.0;
            fila[4] = valores.size() > 3 ? valores.get(3) : 0.0;

            // Columna 5: Nombre especial si el id es válido, o "Sin asignar" si no
            fila[5] = obtenerNombreCuentaEspecial(cuenta.getCodigoUnico());

            // Añadir la fila a la tabla
            modelo.addRow(fila);
        }
    }

    /**
     * Devuelve el nombre especial correspondiente a un id de cuenta,
     * o "Sin asignar" si el id no es uno de los predefinidos.
     */
    private String obtenerNombreCuentaEspecial(int codigoUnico) {
        switch (codigoUnico) {
            case 100: return "Total de activo";
            case 101: return "Activo circulante";
            case 102: return "Activo no circulante";
            case 103: return "Inventarios";
            case 104: return "Cuentas por Cobrar";
            case 105: return "Cargos Diferidos";
            case 200: return "Total de pasivo";
            case 201: return "Pasivo circulante";
            case 202: return "Pasivo no circulante";
            case 203: return "Cuentas por pagar";
            case 300: return "Total de capital";
            case 400: return "Ventas";
            case 402: return "Costo de Ventas";
            case 403: return "Gastos Totales de Operación";
            case 404: return "Utilidad Bruta";
            case 405: return "Utilidad de Operación";
            case 406: return "Utilidad antes de Impuestos a la Utilidad";
            case 407: return "Utilidad Neta";
            case 408: return "Utilidad Antes de Intereses e Impuestos o Utilidad Operativa";
            case 409: return "Gasto de Interés o Gastos Financieros";
            case 410: return "Efectivo y Equivalentes";
            default:  return "Sin asignar";
        }
    }

    /**
 * Actualiza el balanceActual con los datos actuales de la tabla.
 * Valida que:
 * - Todas las cuentas tengan nombre.
 * - Todos los valores de los 4 años sean numéricos (o al menos 0).
 * - No haya ids de cuentas especiales repetidos.
 * - Exista al menos una cuenta con id 400 ("Ventas").
 * Si alguna validación falla, muestra un mensaje y no realiza ningún cambio.
 * @return Mensaje de éxito o error según el resultado.
 */
    public String pasarDatosABalance() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        int filas = modelo.getRowCount();

        // Lista temporal para las nuevas cuentas
        ArrayList<Cuenta> nuevasCuentas = new ArrayList<>();
        // Set para asegurar unicidad de ids especiales
        HashSet<Integer> idsEspecialesUsados = new HashSet<>();
        boolean existeCuentaVentas = false;

        for (int i = 0; i < filas; i++) {
            // Validar nombre de la cuenta
            Object nombreObj = modelo.getValueAt(i, 0);
            if (nombreObj == null || nombreObj.toString().trim().isEmpty()) {
                return "Error: Todas las cuentas deben tener nombre. Fila: " + (i + 1);
            }
            String nombreCuenta = nombreObj.toString().trim();

            // Validar y obtener los 4 valores anuales
            ArrayList<Double> valores = new ArrayList<>();
            for (int j = 1; j <= 4; j++) {
                Object valorObj = modelo.getValueAt(i, j);
                double valor;
                if (valorObj == null || valorObj.toString().trim().isEmpty()) {
                    valor = 0.0;
                } else {
                    try {
                        valor = Double.parseDouble(valorObj.toString().replace(",", "").replace("$", ""));
                    } catch (NumberFormatException e) {
                        return "Error: Todos los valores de los años deben ser numéricos. Fila: " + (i + 1) + ", Columna: " + (j + 1);
                    }
                }
                valores.add(valor);
            }

            // Traducir texto de la columna "Asignado" a id especial
            Object asignadoObj = modelo.getValueAt(i, 5); // Columna 6
            int codigoEspecial = traducirNombreAId(asignadoObj != null ? asignadoObj.toString().trim() : "");

            // Validar unicidad de id especial (excepto 0/"Sin asignar")
            if (codigoEspecial != 0) {
                if (idsEspecialesUsados.contains(codigoEspecial)) {
                    return "Error: No puede haber cuentas duplicadas con el mismo tipo especial. Id repetido: " + codigoEspecial + " en la fila: " + (i + 1);
                }
                idsEspecialesUsados.add(codigoEspecial);
            }

            // Verificar existencia de cuenta Ventas (id 400)
            if (codigoEspecial == 400) {
                existeCuentaVentas = true;
            }

            // Crear el objeto Cuenta y agregarlo a la lista temporal
            Cuenta cuenta = new Cuenta(nombreCuenta, valores);
            cuenta.asignarCodigoUnico(codigoEspecial);
            nuevasCuentas.add(cuenta);
        }

        // Validar existencia de cuenta de Ventas
        if (!existeCuentaVentas) {
            return "Error: Debe existir al menos una cuenta identificada como 'Ventas'.";
        }

        // Si todo es válido, actualizar el balance con la nueva lista de cuentas
        balanceActual.getCuentasRegistradas().clear();
        balanceActual.getCuentasRegistradas().addAll(nuevasCuentas);

        return "Datos guardados correctamente en el Balance.";
    }

    /**
     * Traduce el texto de la columna "Asignado" al id especial correspondiente.
     * Si el texto no coincide con ningún nombre, regresa 0.
     */
    private int traducirNombreAId(String nombre) {
        switch (nombre) {
            case "Total de activo": return 100;
            case "Activo circulante": return 101;
            case "Activo no circulante": return 102;
            case "Inventarios": return 103;
            case "Cuentas por Cobrar": return 104;
            case "Cargos Diferidos": return 105;
            case "Total de pasivo": return 200;
            case "Pasivo circulante": return 201;
            case "Pasivo no circulante": return 202;
            case "Cuentas por pagar": return 203;
            case "Total de capital": return 300;
            case "Ventas": return 400;
            case "Costo de Ventas": return 402;
            case "Gastos Totales de Operación": return 403;
            case "Utilidad Bruta": return 404;
            case "Utilidad de Operación": return 405;
            case "Utilidad antes de Impuestos a la Utilidad": return 406;
            case "Utilidad Neta": return 407;
            case "Utilidad Antes de Intereses e Impuestos o Utilidad Operativa": return 408;
            case "Gasto de Interés o Gastos Financieros": return 409;
            case "Efectivo y Equivalentes": return 410;
            default: return 0; // Para "Sin asignar" o cualquier otro texto
        }
    }
    
    /**
 * Agrega una nueva fila a la tabla de cuentas, con valores por defecto.
 * Los valores son: 
 * Nombre: "----"
 * Año 1-4: 0
 * Asignado: "Sin asignar"
 */
    public void agregarCuentaNueva() {
        // Preparar los valores por defecto en el orden de las columnas de la tabla
        Object[] nuevaFila = new Object[] { 
            "----",     // Nombre/Descripción de la cuenta
            0,          // Año 1
            0,          // Año 2
            0,          // Año 3
            0,          // Año 4
            "Sin asignar" // Asignado (tipo de cuenta especial)
        };

        // Obtener el modelo de la tabla y agregar la nueva fila al final
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.addRow(nuevaFila);

        // (Opcional) Seleccionar la nueva fila para edición inmediata
        int nuevaFilaIndex = modelo.getRowCount() - 1;
        jTable1.setRowSelectionInterval(nuevaFilaIndex, nuevaFilaIndex);
    }

    /**
 * Elimina la fila actualmente seleccionada de la tabla de cuentas.
 * Si no hay ninguna fila seleccionada, muestra un mensaje de error.
 * Solo afecta la tabla visual; no elimina del balance hasta que se guarden los cambios.
 */
    public void eliminarCuentaSeleccionada() {
        // Obtener el índice de la fila seleccionada
        int filaSeleccionada = jTable1.getSelectedRow();

        // Verificar si hay una fila seleccionada
        if (filaSeleccionada == -1) {
            // No hay selección, mostrar mensaje de advertencia y salir
            JOptionPane.showMessageDialog(
                this, 
                "Por favor, selecciona una cuenta para eliminar.", 
                "Advertencia", 
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // Obtener el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

        // Eliminar la fila seleccionada
        modelo.removeRow(filaSeleccionada);

        // (Opcional) Seleccionar automáticamente la fila siguiente (si existe)
        int totalFilas = modelo.getRowCount();
        if (totalFilas > 0) {
            int nuevaSeleccion = Math.min(filaSeleccionada, totalFilas - 1);
            jTable1.setRowSelectionInterval(nuevaSeleccion, nuevaSeleccion);
        }
    }
    
    
    /**
 * Asigna el nombre de cuenta especial seleccionado del JList a la columna "Asignado"
 * de la fila seleccionada en la tabla de cuentas.
 * Si otra fila ya tenía ese nombre, se le quita ("Sin asignar").
 * Si la fila seleccionada ya tenía otro nombre especial, se sobreescribe.
 * No modifica el objeto balance; solo la tabla.
 */
    public void identificarCuenta() {
        // Obtener la fila seleccionada de la tabla
        int filaSeleccionada = jTable1.getSelectedRow();
        // Obtener el nombre seleccionado del JList (debe ser un String)
        String nombreEspecial = (String) jList1.getSelectedValue();

        // Validar que haya selección en ambos controles
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona una cuenta en la tabla.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (nombreEspecial == null || nombreEspecial.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, selecciona un tipo de cuenta especial en la lista.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Obtener el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

        // Recorrer todas las filas para quitar el nombre especial anterior (si lo tenía otra fila)
        int totalFilas = modelo.getRowCount();
        for (int i = 0; i < totalFilas; i++) {
            String asignadoActual = modelo.getValueAt(i, 5).toString();
            if (asignadoActual.equals(nombreEspecial)) {
                modelo.setValueAt("Sin asignar", i, 5);
            }
        }

        // Asignar el nombre especial seleccionado a la fila seleccionada
        modelo.setValueAt(nombreEspecial, filaSeleccionada, 5);
    }

    
    /**
 * Elimina la asignación especial de la cuenta seleccionada en la tabla,
 * colocando "Sin asignar" en la columna "Asignado" de esa fila.
 * Si no hay ninguna fila seleccionada, muestra un mensaje de advertencia.
 * Solo afecta la tabla visual; no modifica el objeto balance.
 */
    public void eliminarAsignacionCuenta() {
        // Obtener la fila seleccionada de la tabla
        int filaSeleccionada = jTable1.getSelectedRow();

        // Verificar que haya una selección válida
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(
                this, 
                "Por favor, selecciona una cuenta en la tabla para eliminar su asignación.", 
                "Advertencia", 
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // Obtener el modelo de la tabla
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

        // Colocar "Sin asignar" en la columna Asignado de la fila seleccionada
        modelo.setValueAt("Sin asignar", filaSeleccionada, 5); // Columna 5 = "Asignado"
    }

    /**
 * Mueve la fila seleccionada en la tabla de cuentas una posición arriba o abajo,
 * según el JRadioButton seleccionado (Arriba o Abajo).
 * Si no hay selección, si ambos o ninguno de los radio están seleccionados, 
 * o si la fila está en el límite, muestra un mensaje y no realiza la acción.
 * Solo afecta la tabla visual.
 */
    public void moverCuentaSeleccionada() {
        // Verificar cuál JRadioButton está seleccionado
        boolean moverArriba = jRadioButton1.isSelected();
        boolean moverAbajo  = jRadioButton2.isSelected();

        // Validar selección de radio buttons (solo uno debe estar seleccionado)
        if (moverArriba == moverAbajo) { // Ambos o ninguno
            JOptionPane.showMessageDialog(
                this, 
                "Selecciona solo una opción: Arriba o Abajo.", 
                "Advertencia", 
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // Obtener fila seleccionada
        int filaSeleccionada = jTable1.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(
                this, 
                "Por favor, selecciona una cuenta de la tabla para mover.", 
                "Advertencia", 
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // Calcular fila destino
        int filaDestino = moverArriba ? filaSeleccionada - 1 : filaSeleccionada + 1;
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        int totalFilas = modelo.getRowCount();

        // Verificar que el destino está dentro de los límites de la tabla
        if (filaDestino < 0 || filaDestino >= totalFilas) {
            JOptionPane.showMessageDialog(
                this, 
                "No se puede mover más " + (moverArriba ? "arriba." : "abajo."), 
                "Advertencia", 
                JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // Intercambiar los valores de todas las columnas entre la fila actual y la de destino
        int columnas = modelo.getColumnCount();
        for (int col = 0; col < columnas; col++) {
            Object temp = modelo.getValueAt(filaSeleccionada, col);
            modelo.setValueAt(modelo.getValueAt(filaDestino, col), filaSeleccionada, col);
            modelo.setValueAt(temp, filaDestino, col);
        }

        // Seleccionar la fila destino para que el usuario vea el cambio
        jTable1.setRowSelectionInterval(filaDestino, filaDestino);
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
        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Editor de cuentas");

        jButton3.setText("Identificar cuenta");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Total de activo", "Activo circulante", "Activo no circulante", "Inventarios ", "Cuentas por Cobrar", "Cargos Diferidos", "Total de pasivo", "Pasivo circulante", "Pasivo no circulante", "Cuentas por pagar", "Total de capital", "Ventas", "Costo de Ventas", "Gastos Totales de Operación", "Utilidad Bruta", "Utilidad de Operación", "Utilidad antes de Impuestos a la Utilidad", "Utilidad Neta", "Utilidad Antes de Intereses e Impuestos o Utilidad Operativa", "Gasto de Interés o Gastos Financieros", "Efectivo y Equivalentes" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jButton4.setText("Cuenta nueva");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Eliminar cuenta");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Actualziar tabla");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Guardar tabla");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton9.setText("Mover");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jRadioButton1.setText("Arriba");

        jRadioButton2.setText("Abajo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jButton9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jButton8.setText("Todo listo");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cuenta", "Año 1", "Año 2", "Año 3", "Año 4", "Asignado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane2.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        jButton10.setText("No identificar");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4)
                            .addComponent(jButton6)
                            .addComponent(jButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton5)
                            .addComponent(jButton8)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                .addContainerGap())
        );

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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        identificarCuenta();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        agregarCuentaNueva();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        eliminarCuentaSeleccionada();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        mostrarDatos();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        pasarDatosABalance();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        Menu2 m2 = new Menu2(this.balanceActual, this.idPractica);
        m2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        moverCuentaSeleccionada();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        eliminarAsignacionCuenta();
    }//GEN-LAST:event_jButton10ActionPerformed

    /**
     * @param args the command line arguments
     * 
     *  Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditorDeCuentas().setVisible(true);
            }
        });
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
            java.util.logging.Logger.getLogger(EditorDeCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditorDeCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditorDeCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditorDeCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
