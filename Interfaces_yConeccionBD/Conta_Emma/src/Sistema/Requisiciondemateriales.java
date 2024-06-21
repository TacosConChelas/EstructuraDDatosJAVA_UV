package Sistema;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Requisiciondemateriales extends javax.swing.JFrame {
    Conexion conectar = new Conexion();
    Statement statement;
    
    public double total;
    Connection conex;
    public Requisiciondemateriales() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        numeroR = new javax.swing.JTextField();
        Departamento = new javax.swing.JTextField();
        nOrden = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fecha = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        Total = new javax.swing.JTextField();
        calcularRM = new javax.swing.JButton();
        jBguardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        c2 = new javax.swing.JTextField();
        c1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        d2 = new javax.swing.JTextField();
        d1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        CU1 = new javax.swing.JTextField();
        CU2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        CT1 = new javax.swing.JTextField();
        CT2 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        unidad1 = new javax.swing.JTextField();
        unidad2 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        jPanel1.setBackground(new java.awt.Color(46, 46, 46));

        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 204));
        jLabel1.setText("Requisición");

        jLabel6.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 204));
        jLabel6.setText("de");

        jLabel7.setFont(new java.awt.Font("Rockwell", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 204));
        jLabel7.setText("Materiales");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sistema/file3.jpg"))); // NOI18N
        jLabel9.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel6))
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jPanel3.setBackground(new java.awt.Color(179, 229, 252));

        jLabel2.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(30, 30, 30));
        jLabel2.setText("Numero de requisición:");

        jLabel3.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(30, 30, 30));
        jLabel3.setText("Departamento:");

        jLabel4.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 30, 30));
        jLabel4.setText("Numero de Orden:");

        numeroR.setBackground(new java.awt.Color(255, 255, 255));
        numeroR.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        numeroR.setForeground(new java.awt.Color(0, 0, 0));
        numeroR.setMinimumSize(new java.awt.Dimension(100, 35));

        Departamento.setBackground(new java.awt.Color(255, 255, 255));
        Departamento.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        Departamento.setForeground(new java.awt.Color(0, 0, 0));
        Departamento.setMinimumSize(new java.awt.Dimension(100, 35));

        nOrden.setBackground(new java.awt.Color(255, 255, 255));
        nOrden.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        nOrden.setForeground(new java.awt.Color(0, 0, 0));
        nOrden.setMinimumSize(new java.awt.Dimension(100, 35));

        jLabel5.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 30, 30));
        jLabel5.setText("Fecha:");

        fecha.setBackground(new java.awt.Color(255, 255, 255));
        fecha.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        fecha.setForeground(new java.awt.Color(0, 0, 0));
        fecha.setText("DD/MM/AAAA");

        jLabel8.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 30, 30));
        jLabel8.setText("Total:");

        Total.setBackground(new java.awt.Color(255, 255, 255));
        Total.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        Total.setForeground(new java.awt.Color(0, 0, 0));
        Total.setText("0.00");

        calcularRM.setBackground(new java.awt.Color(179, 229, 252));
        calcularRM.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        calcularRM.setForeground(new java.awt.Color(0, 0, 0));
        calcularRM.setText("Calcular");
        calcularRM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calcularRMActionPerformed(evt);
            }
        });

        jBguardar.setBackground(new java.awt.Color(179, 229, 252));
        jBguardar.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jBguardar.setForeground(new java.awt.Color(0, 0, 0));
        jBguardar.setText("Guardar");
        jBguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBguardarActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(179, 229, 252));
        jButton2.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Salir y regresar al menú");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        c2.setBackground(new java.awt.Color(255, 255, 255));
        c2.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        c2.setForeground(new java.awt.Color(0, 0, 0));
        c2.setMinimumSize(new java.awt.Dimension(90, 34));

        c1.setBackground(new java.awt.Color(255, 255, 255));
        c1.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        c1.setForeground(new java.awt.Color(0, 0, 0));
        c1.setMinimumSize(new java.awt.Dimension(90, 34));

        jLabel10.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(30, 30, 30));
        jLabel10.setText("Cantidad:");

        d2.setBackground(new java.awt.Color(255, 255, 255));
        d2.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        d2.setForeground(new java.awt.Color(0, 0, 0));

        d1.setBackground(new java.awt.Color(255, 255, 255));
        d1.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        d1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel12.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(30, 30, 30));
        jLabel12.setText("Costo unitario:");

        CU1.setBackground(new java.awt.Color(255, 255, 255));
        CU1.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        CU1.setForeground(new java.awt.Color(0, 0, 0));

        CU2.setBackground(new java.awt.Color(255, 255, 255));
        CU2.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        CU2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel15.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(30, 30, 30));
        jLabel15.setText("Costo total:");

        CT1.setBackground(new java.awt.Color(255, 255, 255));
        CT1.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        CT1.setForeground(new java.awt.Color(0, 0, 0));
        CT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CT1ActionPerformed(evt);
            }
        });

        CT2.setBackground(new java.awt.Color(255, 255, 255));
        CT2.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        CT2.setForeground(new java.awt.Color(0, 0, 0));

        jLabel11.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(30, 30, 30));
        jLabel11.setText("Descripción:");

        unidad1.setBackground(new java.awt.Color(255, 255, 255));
        unidad1.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        unidad1.setForeground(new java.awt.Color(0, 0, 0));
        unidad1.setMinimumSize(new java.awt.Dimension(90, 34));

        unidad2.setBackground(new java.awt.Color(255, 255, 255));
        unidad2.setFont(new java.awt.Font("Rockwell", 0, 14)); // NOI18N
        unidad2.setForeground(new java.awt.Color(0, 0, 0));
        unidad2.setMinimumSize(new java.awt.Dimension(90, 34));

        jLabel13.setFont(new java.awt.Font("Rockwell", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(30, 30, 30));
        jLabel13.setText("Unidades:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numeroR, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(189, 189, 189)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(76, 76, 76)
                                        .addComponent(jLabel8))
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(unidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(unidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(d1)
                                        .addComponent(d2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(CU1)
                                    .addComponent(CU2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CT1)
                                    .addComponent(CT2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(calcularRM)
                                .addGap(18, 18, 18)
                                .addComponent(jBguardar)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(nOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(Total, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(numeroR, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Departamento, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CT1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CU2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel10)
                                        .addComponent(jLabel13))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(unidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(unidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel12))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(d1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(CU1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(d2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addComponent(CT2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBguardar)
                    .addComponent(jButton2)
                    .addComponent(calcularRM))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void calcularRMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calcularRMActionPerformed
        try {
            int cantidad1 = Integer.parseInt(c1.getText()); // cantidad de cada material
            int cantidad2 = 0;

            double costoUnitario1; // costo unitario de cada material
            double costoUnitario2 = 0;
            double costoTotal1; // costos totales
            double costoTotal2 = 0;

            if (c2.getText().isEmpty() && CU2.getText().isEmpty() && CT2.getText().isEmpty()) {
                costoTotal2 = 0;
                CT2.setText(costoTotal2 + "");
            } else if (!CT2.getText().isEmpty()) {
                costoTotal2 = Double.parseDouble(CT2.getText());
            } else {
                cantidad2 = Integer.parseInt(c2.getText());
                String descripcion2 = d2.getText();

                if (CU2.getText().isEmpty()) {
                    // Se analiza si no existe el costo unitario y se calcula
                    costoTotal2 = Double.parseDouble(CT2.getText());
                    costoUnitario2 = costoTotal2 / cantidad2;
                    CU2.setText(costoUnitario2 + "");
                } else {
                    costoUnitario2 = Double.parseDouble(CU2.getText());
                }

                costoTotal2 = cantidad2 * costoUnitario2;
                CT2.setText(costoTotal2 + "");
            }

           
            // todo bien

            if (CU1.getText().isEmpty()) {
                // Se analiza si no existe el costo unitario y se calcula
                costoTotal1 = Double.parseDouble(CT1.getText());
                costoUnitario1 = costoTotal1 / cantidad1;
                CU1.setText(costoUnitario1 + "");
            } else {
                costoUnitario1 = Double.parseDouble(CU1.getText());
            }

          

            costoTotal1 = cantidad1 * costoUnitario1; // cálculo de los costos totales

            CT1.setText(costoTotal1 + ""); // Se colocan los costos totales

            String numeroRe = numeroR.getText();  // Se guardan los datos de la requisición
            String depa = Departamento.getText();
            String noOrden = nOrden.getText();

            String fechaD = fecha.getText();

            
            total = costoTotal1 + costoTotal2;

            Total.setText(total + "");

        } catch (NumberFormatException e) {
            // Manejar excepciones de formato numérico
            javax.swing.JOptionPane.showMessageDialog(this, "Error en la conversión de datos numéricos: " + e.getMessage());
        } catch (Exception e) {
            // Manejar cualquier otra excepción
            javax.swing.JOptionPane.showMessageDialog(this, "Ocurrió un error: " + e.getMessage());
        }
    }//GEN-LAST:event_calcularRMActionPerformed

    private void jBguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBguardarActionPerformed
        try {
        double tot2 = Double.parseDouble(CT2.getText());
        
        String noR = numeroR.getText(); 
        String d = Departamento.getText();
        String noO = nOrden.getText();
        String tot = Total.getText();
        String f = fecha.getText();
        
        String u1 = unidad1.getText();
        String u2 = unidad2.getText();

        int cant1 = Integer.parseInt(c1.getText()); 
        String desc1 = d1.getText();
        double cu1 = Double.parseDouble(CU1.getText());
        double ct1 = Double.parseDouble(CT1.getText());

        String cant2 = null;
        String desc2 = null;
        String cu2 = null;
       
        if (tot2 == 0) {
            cant2 = "null";
            desc2 = "null";
            cu2 = "null";
        } else {
            cant2 = c2.getText();
            desc2 = d2.getText();
            cu2 = CU2.getText();
        }

        // Construcción de la consulta SQL
        String sql;
        if (tot2 == 0) {
            sql = "INSERT INTO requisicion VALUES ("
                    + noR + ", '"
                    + d + "', "
                    + noO + ", "
                    + tot + ", '"
                    + f + "', "
                    + cant1 + ", '"
                    + desc1 + "', "
                    + cu1 + ", "
                    + ct1 + ", null, null, null, null, '" 
                    + u1 + "', null);" ;
        } else {
            sql = "INSERT INTO requisicion VALUES ("
                    + noR + ", '"
                    + d + "', '"
                    + noO + "', '"
                    + tot + "', '"
                    + f + "', "
                    + cant1 + ", '"
                    + desc1 + "', "
                    + cu1 + ", "
                    + ct1 + ", "
                    + cant2 + ", '"
                    + desc2 + "', "
                    + cu2 + ","
                    + tot2 + ",'"
                    + u1 + "' , '"
                    + u2 + "');" ;
        }

        // Conexión y ejecución de la consulta
        Connection conex = conectar.getConnection();
        Statement statement = conex.createStatement();
        statement.executeUpdate(sql);
        javax.swing.JOptionPane.showMessageDialog(this, "Datos guardados exitosamente");

        } catch (NumberFormatException e) {
            // Manejar excepciones de formato numérico
            javax.swing.JOptionPane.showMessageDialog(this, "Error en la conversión de datos numéricos: " + e.getMessage());
        } catch (HeadlessException | SQLException e) {
            // Manejar cualquier otra excepción
            System.out.println("Erro: " + e);
        }
    }//GEN-LAST:event_jBguardarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void CT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CT1ActionPerformed
    }//GEN-LAST:event_CT1ActionPerformed

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
            java.util.logging.Logger.getLogger(Requisiciondemateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Requisiciondemateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Requisiciondemateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Requisiciondemateriales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Requisiciondemateriales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CT1;
    private javax.swing.JTextField CT2;
    private javax.swing.JTextField CU1;
    private javax.swing.JTextField CU2;
    private javax.swing.JTextField Departamento;
    private javax.swing.JTextField Total;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JTextField c1;
    private javax.swing.JTextField c2;
    private javax.swing.JButton calcularRM;
    private javax.swing.JTextField d1;
    private javax.swing.JTextField d2;
    private javax.swing.JTextField fecha;
    private javax.swing.JButton jBguardar;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField nOrden;
    private javax.swing.JTextField numeroR;
    private javax.swing.JTextField unidad1;
    private javax.swing.JTextField unidad2;
    // End of variables declaration//GEN-END:variables
}
