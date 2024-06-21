package Interfaz;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Requisicion extends javax.swing.JFrame {
    BaseDatos conect = new BaseDatos();
    
    public double total;
   
    
    public Requisicion() {
        initComponents();
        this.setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTFnumeroR = new javax.swing.JTextField();
        jTFdepartamento = new javax.swing.JTextField();
        jTForden = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTFfecha = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTFtotal = new javax.swing.JTextField();
        jBcalcularRM = new javax.swing.JButton();
        jBguardar = new javax.swing.JButton();
        jBsalir = new javax.swing.JButton();
        jTFcantidad2 = new javax.swing.JTextField();
        jTFcantidad1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTFdescripcion2 = new javax.swing.JTextField();
        jTFdescripcion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTFcostoU = new javax.swing.JTextField();
        jTFcostoU2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTFcostoT = new javax.swing.JTextField();
        jTFcostoT2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTFcantidad3 = new javax.swing.JTextField();
        jTFcantidad4 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        jPanel3.setBackground(new java.awt.Color(255, 153, 0));

        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(30, 30, 30));
        jLabel2.setText("Número de requisición:");

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(30, 30, 30));
        jLabel3.setText("Departamento:");

        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 30, 30));
        jLabel4.setText("Número de la oden:");

        jTFnumeroR.setBackground(new java.awt.Color(255, 255, 255));
        jTFnumeroR.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jTFnumeroR.setForeground(new java.awt.Color(0, 0, 0));
        jTFnumeroR.setMinimumSize(new java.awt.Dimension(100, 35));

        jTFdepartamento.setBackground(new java.awt.Color(255, 255, 255));
        jTFdepartamento.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jTFdepartamento.setForeground(new java.awt.Color(0, 0, 0));
        jTFdepartamento.setMinimumSize(new java.awt.Dimension(100, 35));

        jTForden.setBackground(new java.awt.Color(255, 255, 255));
        jTForden.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jTForden.setForeground(new java.awt.Color(0, 0, 0));
        jTForden.setMinimumSize(new java.awt.Dimension(100, 35));

        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 30, 30));
        jLabel5.setText("Fecha:");

        jTFfecha.setBackground(new java.awt.Color(255, 255, 255));
        jTFfecha.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jTFfecha.setForeground(new java.awt.Color(0, 0, 0));
        jTFfecha.setText("dia-mes-año");

        jLabel8.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 30, 30));
        jLabel8.setText("Total:");

        jTFtotal.setBackground(new java.awt.Color(255, 255, 255));
        jTFtotal.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jTFtotal.setForeground(new java.awt.Color(0, 0, 0));
        jTFtotal.setText("0.00");

        jBcalcularRM.setBackground(new java.awt.Color(179, 229, 252));
        jBcalcularRM.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jBcalcularRM.setForeground(new java.awt.Color(0, 0, 0));
        jBcalcularRM.setText("Calcular los costos totales");
        jBcalcularRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcalcularRMActionPerformed(evt);
            }
        });

        jBguardar.setBackground(new java.awt.Color(179, 229, 252));
        jBguardar.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jBguardar.setForeground(new java.awt.Color(0, 0, 0));
        jBguardar.setText("Guardar información en la base de datos");
        jBguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBguardarActionPerformed(evt);
            }
        });

        jBsalir.setBackground(new java.awt.Color(179, 229, 252));
        jBsalir.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jBsalir.setForeground(new java.awt.Color(0, 0, 0));
        jBsalir.setText("Salir de la pantalla actual");
        jBsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalirActionPerformed(evt);
            }
        });

        jTFcantidad2.setBackground(new java.awt.Color(255, 255, 255));
        jTFcantidad2.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jTFcantidad2.setForeground(new java.awt.Color(0, 0, 0));
        jTFcantidad2.setMinimumSize(new java.awt.Dimension(90, 34));

        jTFcantidad1.setBackground(new java.awt.Color(255, 255, 255));
        jTFcantidad1.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jTFcantidad1.setForeground(new java.awt.Color(0, 0, 0));
        jTFcantidad1.setMinimumSize(new java.awt.Dimension(90, 34));

        jLabel10.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(30, 30, 30));
        jLabel10.setText("Cantidad:");

        jTFdescripcion2.setBackground(new java.awt.Color(255, 255, 255));
        jTFdescripcion2.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jTFdescripcion2.setForeground(new java.awt.Color(0, 0, 0));

        jTFdescripcion.setBackground(new java.awt.Color(255, 255, 255));
        jTFdescripcion.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jTFdescripcion.setForeground(new java.awt.Color(0, 0, 0));

        jLabel12.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(30, 30, 30));
        jLabel12.setText("Costo unitario:");

        jTFcostoU.setBackground(new java.awt.Color(255, 255, 255));
        jTFcostoU.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jTFcostoU.setForeground(new java.awt.Color(0, 0, 0));

        jTFcostoU2.setBackground(new java.awt.Color(255, 255, 255));
        jTFcostoU2.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jTFcostoU2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel15.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(30, 30, 30));
        jLabel15.setText("Costo total:");

        jTFcostoT.setBackground(new java.awt.Color(255, 255, 255));
        jTFcostoT.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jTFcostoT.setForeground(new java.awt.Color(0, 0, 0));
        jTFcostoT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFcostoTActionPerformed(evt);
            }
        });

        jTFcostoT2.setBackground(new java.awt.Color(255, 255, 255));
        jTFcostoT2.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jTFcostoT2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel11.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(30, 30, 30));
        jLabel11.setText("Descripción:");

        jTFcantidad3.setBackground(new java.awt.Color(255, 255, 255));
        jTFcantidad3.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jTFcantidad3.setForeground(new java.awt.Color(0, 0, 0));
        jTFcantidad3.setMinimumSize(new java.awt.Dimension(90, 34));

        jTFcantidad4.setBackground(new java.awt.Color(255, 255, 255));
        jTFcantidad4.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        jTFcantidad4.setForeground(new java.awt.Color(0, 0, 0));
        jTFcantidad4.setMinimumSize(new java.awt.Dimension(90, 34));

        jLabel13.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(30, 30, 30));
        jLabel13.setText("Unidad de medida del material");

        jLabel6.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(30, 30, 30));
        jLabel6.setText("Requisición de Materiales");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jBguardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBcalcularRM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(557, 557, 557)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTFdepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTFfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTFtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTForden, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTFnumeroR, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTFcantidad2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTFcantidad1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(158, 158, 158)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jTFdescripcion)
                                                    .addComponent(jTFdescripcion2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jTFcantidad4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTFcostoU2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel12))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jTFcantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTFcostoU, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTFcostoT)
                                        .addComponent(jTFcostoT2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(52, 52, 52))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTFnumeroR, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTForden, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFdepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jTFtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFcantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFcostoU, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFcantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFcostoU2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFcostoT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jTFcostoT2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTFdescripcion2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTFcantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBcalcularRM, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBcalcularRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcalcularRMActionPerformed
        try {
            String unidadMedida;
            String unidadMedida2;
            int cantidad1 = Integer.parseInt(jTFcantidad1.getText()); 
            int cantidad2 = 0;

            double costoUnitario1; 
            double costoUnitario2 = 0;
            
            double costoTotal1; 
            double costoTotal2 = 0;

            if (jTFcantidad2.getText().isEmpty() && jTFcostoU2.getText().isEmpty() && jTFcostoT2.getText().isEmpty()) {
                costoTotal2 = 0;
                jTFcostoT2.setText(costoTotal2 + "");
            } else if (!jTFcostoT2.getText().isEmpty()) {
                costoTotal2 = Double.parseDouble(jTFcostoT2.getText());
            } else {
                cantidad2 = Integer.parseInt(jTFcantidad2.getText());
                String descripcion2 = jTFdescripcion2.getText();

                if (jTFcostoU2.getText().isEmpty()) {
                    // Se analiza si no existe el costo unitario y se calcula
                    costoTotal2 = Double.parseDouble(jTFcostoT2.getText());
                    costoUnitario2 = costoTotal2 / cantidad2;
                    jTFcostoU2.setText(costoUnitario2 + "");
                } else {
                    costoUnitario2 = Double.parseDouble(jTFcostoU2.getText());
                }

                costoTotal2 = cantidad2 * costoUnitario2;
                jTFcostoT2.setText(costoTotal2 + "");
            }

            if (jTFcostoU.getText().isEmpty()) {
                // Se analiza si no existe el costo unitario y se calcula
                costoTotal1 = Double.parseDouble(jTFcostoT.getText());
                costoUnitario1 = costoTotal1 / cantidad1;
                jTFcostoU.setText(costoUnitario1 + "");
            } else {
                costoUnitario1 = Double.parseDouble(jTFcostoU.getText());
            }

            
            costoTotal1 = cantidad1 * costoUnitario1;
            
            
            jTFcostoT.setText(costoTotal1 + "");

            String numeroRe = jTFnumeroR.getText(); 
            String depa = jTFdepartamento.getText();
            String noOrden = jTForden.getText();
            String fechaD = jTFfecha.getText();

           
            total = costoTotal1 + costoTotal2;

            jTFtotal.setText(total + "");

        } catch (NumberFormatException e) {
            // Manejar excepciones de formato numérico
            javax.swing.JOptionPane.showMessageDialog(this, "Error en la conversión de datos numéricos: " + e.getMessage());
        } catch (Exception e) {
            // Manejar cualquier otra excepción
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error: " + e.getMessage());
        }
    }//GEN-LAST:event_jBcalcularRMActionPerformed

    private void jBguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBguardarActionPerformed
        try {
        double total2 = Double.parseDouble(jTFcostoT2.getText());
        String requisicion = jTFnumeroR.getText(); // Se guardan los datos de la requisición
        String depart = jTFdepartamento.getText();
        String orden = jTForden.getText();
        String total = jTFtotal.getText();
        String fecha = jTFfecha.getText();
        int cant1 = Integer.parseInt(jTFcantidad1.getText()); // Se guardan datos del primer material
        String desc1 = jTFdescripcion.getText();
        double costoU1 = Double.parseDouble(jTFcostoU.getText());
        double costoT1 = Double.parseDouble(jTFcostoT.getText());
        int cant2 = 0;
        String desc2 = "";
        double costoU2 = 0;
        double costoT2 = 0;

        
        if (!jTFcostoT2.getText().isEmpty()) {
            cant2 = Integer.parseInt(jTFcantidad2.getText());
            desc2 = jTFdescripcion2.getText();
            costoU2 = Double.parseDouble(jTFcostoU2.getText());
            costoT2 = Double.parseDouble(jTFcostoT2.getText());
        }

        // Construcción de la consulta SQL
        String sql = "INSERT INTO RequisicionM (numSolicitud, depto, numOrden, total, fecha, cantItem1, descItem1, costoUniItem1, costoTotItem1, cantItem2, descItem2, costoUniItem2, costoTotItem2) " +
                     "VALUES (" + requisicion + ", '" + depart + "', '" + orden + "', " + total + ", '" + fecha + "', " + cant1 + ", '" + desc1 + "', " + costoU1 + ", " + costoT1 + ", " + cant2 + ", '" + desc2 + "', " + costoU2 + ", " + costoT2 + ")";

        // Conexión y ejecución de la consulta
        Connection conex = conect.getConnection();
        Statement statement = conex.createStatement();
        statement.executeUpdate(sql);
        javax.swing.JOptionPane.showMessageDialog(this, "Datos guardados exitosamente");

    } catch (NumberFormatException e) {
        // Manejar excepciones de formato numérico
        javax.swing.JOptionPane.showMessageDialog(this, "Error en la conversión de datos numéricos: " + e.getMessage());
    } catch (HeadlessException | SQLException e) {
        // Manejar cualquier otra excepción
        javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error: " + e.getMessage());
    }
    }//GEN-LAST:event_jBguardarActionPerformed

    private void jBsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalirActionPerformed
        PantallaInicialDelSistema menu = new PantallaInicialDelSistema();            
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBsalirActionPerformed

    private void jTFcostoTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFcostoTActionPerformed
    }//GEN-LAST:event_jTFcostoTActionPerformed

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
            java.util.logging.Logger.getLogger(Requisicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Requisicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Requisicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Requisicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Requisicion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jBcalcularRM;
    private javax.swing.JButton jBguardar;
    private javax.swing.JButton jBsalir;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTFcantidad1;
    private javax.swing.JTextField jTFcantidad2;
    private javax.swing.JTextField jTFcantidad3;
    private javax.swing.JTextField jTFcantidad4;
    private javax.swing.JTextField jTFcostoT;
    private javax.swing.JTextField jTFcostoT2;
    private javax.swing.JTextField jTFcostoU;
    private javax.swing.JTextField jTFcostoU2;
    private javax.swing.JTextField jTFdepartamento;
    private javax.swing.JTextField jTFdescripcion;
    private javax.swing.JTextField jTFdescripcion2;
    private javax.swing.JTextField jTFfecha;
    private javax.swing.JTextField jTFnumeroR;
    private javax.swing.JTextField jTForden;
    private javax.swing.JTextField jTFtotal;
    // End of variables declaration//GEN-END:variables
}
