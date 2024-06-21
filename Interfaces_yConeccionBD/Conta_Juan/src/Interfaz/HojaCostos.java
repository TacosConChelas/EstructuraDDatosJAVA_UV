package Interfaz;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HojaCostos extends javax.swing.JFrame {
    
    BaseDatos conex = new BaseDatos();
    Statement statement;
    ResultSet resultset;
    Connection coneccion;

    public HojaCostos() {
        initComponents();
        this.setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTFcliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTFnumeroOrden = new javax.swing.JTextField();
        jTFnumeroArticulos = new javax.swing.JTextField();
        jTFdescripcion = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTFfechaI = new javax.swing.JTextField();
        jTFfechaF = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTFnomeroR = new javax.swing.JTextField();
        jTFCostoTM = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTFfechaM1 = new javax.swing.JTextField();
        jTFnomeroR1 = new javax.swing.JTextField();
        jTFCostoTM1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTFfechaM = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTFCostoTMO1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTFnOrdenMOD = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTFHorasM = new javax.swing.JTextField();
        jTFTasaMO = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTFCostoTMO = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jTFnOrdenMOD1 = new javax.swing.JTextField();
        jTFHorasM1 = new javax.swing.JTextField();
        jTFTasaMO1 = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTFnumOrdenGIF1 = new javax.swing.JTextField();
        jTFHorasGIF1 = new javax.swing.JTextField();
        jTFTasaGIF1 = new javax.swing.JTextField();
        jTFcostoTotGIF1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTFnumOrdenGIF = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTFHorasGIF = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTFTasaGIF = new javax.swing.JTextField();
        jTFcostoTotGIF = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jTFmaterialesD = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jTFmanoO = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jTFGIF = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTFcostoTotal = new javax.swing.JTextField();
        jTFcostoUnitario = new javax.swing.JTextField();
        jBmostrarD = new javax.swing.JButton();
        jBsalir = new javax.swing.JButton();
        jBguardarD = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(30, 30, 30));
        jLabel2.setText("Cliente:");

        jTFcliente.setBackground(new java.awt.Color(255, 255, 255));
        jTFcliente.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFcliente.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(30, 30, 30));
        jLabel3.setText("Número de orden :");

        jLabel4.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(30, 30, 30));
        jLabel4.setText("Descripcion:");

        jLabel5.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(30, 30, 30));
        jLabel5.setText("No. articulos:");

        jTFnumeroOrden.setBackground(new java.awt.Color(255, 255, 255));
        jTFnumeroOrden.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFnumeroOrden.setForeground(new java.awt.Color(0, 0, 0));

        jTFnumeroArticulos.setBackground(new java.awt.Color(255, 255, 255));
        jTFnumeroArticulos.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFnumeroArticulos.setForeground(new java.awt.Color(0, 0, 0));

        jTFdescripcion.setBackground(new java.awt.Color(255, 255, 255));
        jTFdescripcion.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFdescripcion.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(30, 30, 30));
        jLabel6.setText("Fecha de inicio:");

        jLabel7.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(30, 30, 30));
        jLabel7.setText("Fecha de termino:");

        jTFfechaI.setBackground(new java.awt.Color(255, 255, 255));
        jTFfechaI.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFfechaI.setForeground(new java.awt.Color(0, 0, 0));
        jTFfechaI.setText("dia-mes-año");

        jTFfechaF.setBackground(new java.awt.Color(255, 255, 255));
        jTFfechaF.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFfechaF.setForeground(new java.awt.Color(0, 0, 0));
        jTFfechaF.setText("dia-mes-año");

        jLabel15.setBackground(new java.awt.Color(46, 46, 46));
        jLabel15.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Hoja de costos");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTFnumeroOrden, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(jTFcliente))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTFdescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                    .addComponent(jTFnumeroArticulos))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTFfechaF)
                    .addComponent(jTFfechaI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTFcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jTFdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jTFfechaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTFnumeroOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jTFnumeroArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jTFfechaI, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jPanel1.setBackground(new java.awt.Color(255, 153, 0));

        jTFnomeroR.setBackground(new java.awt.Color(255, 255, 255));
        jTFnomeroR.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFnomeroR.setForeground(new java.awt.Color(0, 0, 0));

        jTFCostoTM.setBackground(new java.awt.Color(255, 255, 255));
        jTFCostoTM.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFCostoTM.setForeground(new java.awt.Color(0, 0, 0));

        jLabel12.setBackground(new java.awt.Color(46, 46, 46));
        jLabel12.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Materiales Directos");

        jTFfechaM1.setBackground(new java.awt.Color(255, 255, 255));
        jTFfechaM1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFfechaM1.setForeground(new java.awt.Color(0, 0, 0));

        jTFnomeroR1.setBackground(new java.awt.Color(255, 255, 255));
        jTFnomeroR1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFnomeroR1.setForeground(new java.awt.Color(0, 0, 0));

        jTFCostoTM1.setBackground(new java.awt.Color(255, 255, 255));
        jTFCostoTM1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFCostoTM1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(30, 30, 30));
        jLabel8.setText("Fecha:");

        jTFfechaM.setBackground(new java.awt.Color(255, 255, 255));
        jTFfechaM.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFfechaM.setForeground(new java.awt.Color(0, 0, 0));

        jLabel9.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(30, 30, 30));
        jLabel9.setText("No. de requisición");

        jLabel10.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(30, 30, 30));
        jLabel10.setText("Costo total:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTFfechaM)
                    .addComponent(jTFfechaM1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTFnomeroR)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTFnomeroR1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTFCostoTM)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTFCostoTM1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel12)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFfechaM, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFnomeroR, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFCostoTM, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFfechaM1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFnomeroR1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFCostoTM1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 0));

        jTFCostoTMO1.setBackground(new java.awt.Color(255, 255, 255));
        jTFCostoTMO1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFCostoTMO1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel11.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(30, 30, 30));
        jLabel11.setText("Periodo de tiempo:");

        jTFnOrdenMOD.setBackground(new java.awt.Color(255, 255, 255));
        jTFnOrdenMOD.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFnOrdenMOD.setForeground(new java.awt.Color(0, 0, 0));

        jLabel13.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(30, 30, 30));
        jLabel13.setText("Tasa");

        jTFHorasM.setBackground(new java.awt.Color(255, 255, 255));
        jTFHorasM.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFHorasM.setForeground(new java.awt.Color(0, 0, 0));

        jTFTasaMO.setBackground(new java.awt.Color(255, 255, 255));
        jTFTasaMO.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFTasaMO.setForeground(new java.awt.Color(0, 0, 0));

        jLabel14.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(30, 30, 30));
        jLabel14.setText("Horas");

        jTFCostoTMO.setBackground(new java.awt.Color(255, 255, 255));
        jTFCostoTMO.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFCostoTMO.setForeground(new java.awt.Color(0, 0, 0));

        jLabel16.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(30, 30, 30));
        jLabel16.setText("Costo total:");

        jTFnOrdenMOD1.setBackground(new java.awt.Color(255, 255, 255));
        jTFnOrdenMOD1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFnOrdenMOD1.setForeground(new java.awt.Color(0, 0, 0));

        jTFHorasM1.setBackground(new java.awt.Color(255, 255, 255));
        jTFHorasM1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFHorasM1.setForeground(new java.awt.Color(0, 0, 0));

        jTFTasaMO1.setBackground(new java.awt.Color(255, 255, 255));
        jTFTasaMO1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFTasaMO1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel27.setBackground(new java.awt.Color(46, 46, 46));
        jLabel27.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Mano de obra");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFnOrdenMOD1)
                            .addComponent(jTFnOrdenMOD)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 12, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTFHorasM)
                            .addComponent(jTFHorasM1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTFTasaMO)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTFTasaMO1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFCostoTMO, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFCostoTMO1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel27)
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFnOrdenMOD, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFHorasM, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFTasaMO, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFCostoTMO, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFnOrdenMOD1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFHorasM1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFTasaMO1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFCostoTMO1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(204, 255, 0));

        jTFnumOrdenGIF1.setBackground(new java.awt.Color(255, 255, 255));
        jTFnumOrdenGIF1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFnumOrdenGIF1.setForeground(new java.awt.Color(0, 0, 0));

        jTFHorasGIF1.setBackground(new java.awt.Color(255, 255, 255));
        jTFHorasGIF1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFHorasGIF1.setForeground(new java.awt.Color(0, 0, 0));

        jTFTasaGIF1.setBackground(new java.awt.Color(255, 255, 255));
        jTFTasaGIF1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFTasaGIF1.setForeground(new java.awt.Color(0, 0, 0));

        jTFcostoTotGIF1.setBackground(new java.awt.Color(255, 255, 255));
        jTFcostoTotGIF1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFcostoTotGIF1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel17.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(30, 30, 30));
        jLabel17.setText("Número de la orden:");

        jTFnumOrdenGIF.setBackground(new java.awt.Color(255, 255, 255));
        jTFnumOrdenGIF.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFnumOrdenGIF.setForeground(new java.awt.Color(0, 0, 0));

        jLabel18.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(30, 30, 30));
        jLabel18.setText("Horas");

        jTFHorasGIF.setBackground(new java.awt.Color(255, 255, 255));
        jTFHorasGIF.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFHorasGIF.setForeground(new java.awt.Color(0, 0, 0));

        jLabel19.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(30, 30, 30));
        jLabel19.setText("Tasa ");

        jTFTasaGIF.setBackground(new java.awt.Color(255, 255, 255));
        jTFTasaGIF.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFTasaGIF.setForeground(new java.awt.Color(0, 0, 0));

        jTFcostoTotGIF.setBackground(new java.awt.Color(255, 255, 255));
        jTFcostoTotGIF.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFcostoTotGIF.setForeground(new java.awt.Color(0, 0, 0));

        jLabel20.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(30, 30, 30));
        jLabel20.setText("Costo total:");

        jLabel21.setBackground(new java.awt.Color(46, 46, 46));
        jLabel21.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 0, 0));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Gif");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(6, 12, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTFnumOrdenGIF, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFHorasGIF, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTFTasaGIF)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTFcostoTotGIF, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jTFnumOrdenGIF1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFHorasGIF1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFTasaGIF1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFcostoTotGIF1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFnumOrdenGIF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFHorasGIF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFTasaGIF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFcostoTotGIF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFnumOrdenGIF1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFHorasGIF1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFTasaGIF1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTFcostoTotGIF1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        jLabel22.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(30, 30, 30));
        jLabel22.setText("Materiales directos:");

        jTFmaterialesD.setBackground(new java.awt.Color(255, 255, 255));
        jTFmaterialesD.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFmaterialesD.setForeground(new java.awt.Color(0, 0, 0));

        jLabel23.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(30, 30, 30));
        jLabel23.setText("Mano de obra directa:");

        jTFmanoO.setBackground(new java.awt.Color(255, 255, 255));
        jTFmanoO.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFmanoO.setForeground(new java.awt.Color(0, 0, 0));

        jLabel24.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(30, 30, 30));
        jLabel24.setText("Gif:");

        jTFGIF.setBackground(new java.awt.Color(255, 255, 255));
        jTFGIF.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFGIF.setForeground(new java.awt.Color(0, 0, 0));

        jLabel25.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(30, 30, 30));
        jLabel25.setText("Costo total:");

        jLabel26.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(30, 30, 30));
        jLabel26.setText("Costo unitario:");

        jTFcostoTotal.setBackground(new java.awt.Color(255, 255, 255));
        jTFcostoTotal.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFcostoTotal.setForeground(new java.awt.Color(0, 0, 0));

        jTFcostoUnitario.setBackground(new java.awt.Color(255, 255, 255));
        jTFcostoUnitario.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jTFcostoUnitario.setForeground(new java.awt.Color(0, 0, 0));

        jBmostrarD.setBackground(new java.awt.Color(179, 229, 252));
        jBmostrarD.setForeground(new java.awt.Color(0, 0, 0));
        jBmostrarD.setText("Mostar todos los datos recabados");
        jBmostrarD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBmostrarDActionPerformed(evt);
            }
        });

        jBsalir.setBackground(new java.awt.Color(179, 229, 252));
        jBsalir.setForeground(new java.awt.Color(0, 0, 0));
        jBsalir.setText("Salir de la pantalla actual");
        jBsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalirActionPerformed(evt);
            }
        });

        jBguardarD.setBackground(new java.awt.Color(179, 229, 252));
        jBguardarD.setForeground(new java.awt.Color(0, 0, 0));
        jBguardarD.setText("Guardar información en la base de datos");
        jBguardarD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBguardarDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTFmaterialesD, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBmostrarD)
                        .addGap(18, 18, 18)
                        .addComponent(jBguardarD))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFmanoO, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTFGIF, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTFcostoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTFcostoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jBsalir)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel23)
                        .addComponent(jTFmanoO, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22)
                        .addComponent(jTFmaterialesD, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTFGIF, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel24))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTFcostoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTFcostoUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBsalir)
                            .addComponent(jBguardarD)
                            .addComponent(jBmostrarD))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBmostrarDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBmostrarDActionPerformed
        int numeroO = Integer.parseInt(jTFnumeroOrden.getText());
        String sqlRequisicion = "SELECT * FROM RequisicionM WHERE numOrden = " + numeroO;
        String sqlRegistroHoras = "SELECT * FROM RegistroHoras WHERE ordenNum = " + numeroO;
        String sqlTasaGIF = "SELECT * FROM TasaGIF WHERE numOrden = " + numeroO;
        float total1 = 0;
        float total2 = 0;
        float total3 = 0;

        try {
            coneccion = conex.getConnection();
            statement = coneccion.createStatement();

            // Consultar datos de RequisicionM
            resultset = statement.executeQuery(sqlRequisicion);
            if (resultset.next()) {
                // Datos del primer material
                jTFfechaM.setText(resultset.getString("fecha"));
                jTFnomeroR.setText(resultset.getString("numSolicitud"));
                jTFCostoTM.setText(resultset.getFloat("costoTotItem1") + "");

                // Datos del segundo material
                jTFfechaM1.setText(resultset.getString("fecha"));
                jTFnomeroR1.setText(resultset.getString("numSolicitud"));
                jTFCostoTM1.setText(resultset.getFloat("costoTotItem2") + "");

                total1 = resultset.getFloat("total");
            }

            // Consultar datos de RegistroHoras
            resultset = statement.executeQuery(sqlRegistroHoras);
            if (resultset.next()) {
                // Datos del primer registro de horas
                jTFnOrdenMOD.setText(resultset.getString("fechaRegistro"));
                jTFHorasM.setText(resultset.getInt("horasTrabajadas") + "");
                jTFTasaMO.setText(resultset.getFloat("tarifaHora") + "");
                jTFCostoTMO.setText((resultset.getInt("horasTrabajadas") * resultset.getFloat("tarifaHora")) + "");

                // Datos del segundo registro de horas
                jTFnOrdenMOD1.setText(resultset.getString("fechaRegistro2"));
                jTFHorasM1.setText(resultset.getInt("horasTrabajadas2") + "");
                jTFTasaMO1.setText(resultset.getFloat("tarifaHora2") + "");
                jTFCostoTMO1.setText((resultset.getInt("horasTrabajadas2") * resultset.getFloat("tarifaHora2")) + "");

                total2 = (resultset.getInt("horasTrabajadas") * resultset.getFloat("tarifaHora")) + (resultset.getInt("horasTrabajadas2") * resultset.getFloat("tarifaHora2"));
            }

            // Consultar datos de TasaGIF
            resultset = statement.executeQuery(sqlTasaGIF);
            if (resultset.next()) {
                // Datos del primer GIF
                jTFnumOrdenGIF.setText(resultset.getInt("numOrden") + "");
                jTFHorasGIF.setText(resultset.getInt("baseActividad") + "");
                jTFTasaGIF.setText(resultset.getFloat("tasaGIF") + "");
                jTFcostoTotGIF.setText((resultset.getInt("baseActividad") * resultset.getFloat("tasaGIF")) + "");
                total3 = resultset.getInt("baseActividad") * resultset.getFloat("tasaGIF");
            }

            // Colocar datos finales
            jTFmaterialesD.setText(total1 + "");
            jTFmanoO.setText(total2 + "");
            jTFGIF.setText(total3 + "");
            jTFcostoTotal.setText((total3 + total2 + total1) + ""); // Sumar los totales anteriores
            int cantidad = Integer.parseInt(jTFnumeroArticulos.getText());
            float unitario = (total3 + total2 + total1) / cantidad;
            jTFcostoUnitario.setText(unitario + "");

        } catch (SQLException e) {
            System.out.println("El error es: " + e);
        } 
    }//GEN-LAST:event_jBmostrarDActionPerformed

    private void jBsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalirActionPerformed
        PantallaInicialDelSistema menu = new PantallaInicialDelSistema();            
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBsalirActionPerformed

    private void jBguardarDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBguardarDActionPerformed
        String cliente = jTFcliente.getText();
        String numeroO = jTFnumeroOrden.getText();
        String descrip = jTFdescripcion.getText();
        String numeroA = jTFnumeroArticulos.getText();
        String fechaI = jTFfechaI.getText();
        String fechaF = jTFfechaF.getText();

        float materialesD = Float.parseFloat(jTFmaterialesD.getText());
        float manoObra = Float.parseFloat(jTFmanoO.getText());
        float gif = Float.parseFloat(jTFGIF.getText());
        float costoT = Float.parseFloat(jTFcostoTotal.getText());
        float costoU = Float.parseFloat(jTFcostoUnitario.getText());

        // Construir la consulta SQL con todos los campos de la tabla
        String sql = "INSERT INTO RegistroContable (ordenNum, nombreCliente, descripcion, articuloNum, inicioFecha, finFecha, costoDirecto, costoOperativo, gastos, costoTotal, costoUnitario) " +
                     "VALUES (" + numeroO + ", '" + cliente + "', '" + descrip + "', " + numeroA + ", '" 
                    + fechaI + "', '" + fechaF + "', " + materialesD + ", " + manoObra + ", " + gif + ", " + costoT + ", " + costoU + ");";

        try {
            coneccion = conex.getConnection();
            statement = coneccion.createStatement();
            statement.addBatch(sql);
            statement.executeBatch();

            System.out.println("Guardado");
        } catch (SQLException e) {
            System.out.println("El error es: " + e);
        }
    }//GEN-LAST:event_jBguardarDActionPerformed

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
            java.util.logging.Logger.getLogger(HojaCostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HojaCostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HojaCostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HojaCostos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HojaCostos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBguardarD;
    private javax.swing.JButton jBmostrarD;
    private javax.swing.JButton jBsalir;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTFCostoTM;
    private javax.swing.JTextField jTFCostoTM1;
    private javax.swing.JTextField jTFCostoTMO;
    private javax.swing.JTextField jTFCostoTMO1;
    private javax.swing.JTextField jTFGIF;
    private javax.swing.JTextField jTFHorasGIF;
    private javax.swing.JTextField jTFHorasGIF1;
    private javax.swing.JTextField jTFHorasM;
    private javax.swing.JTextField jTFHorasM1;
    private javax.swing.JTextField jTFTasaGIF;
    private javax.swing.JTextField jTFTasaGIF1;
    private javax.swing.JTextField jTFTasaMO;
    private javax.swing.JTextField jTFTasaMO1;
    private javax.swing.JTextField jTFcliente;
    private javax.swing.JTextField jTFcostoTotGIF;
    private javax.swing.JTextField jTFcostoTotGIF1;
    private javax.swing.JTextField jTFcostoTotal;
    private javax.swing.JTextField jTFcostoUnitario;
    private javax.swing.JTextField jTFdescripcion;
    private javax.swing.JTextField jTFfechaF;
    private javax.swing.JTextField jTFfechaI;
    private javax.swing.JTextField jTFfechaM;
    private javax.swing.JTextField jTFfechaM1;
    private javax.swing.JTextField jTFmanoO;
    private javax.swing.JTextField jTFmaterialesD;
    private javax.swing.JTextField jTFnOrdenMOD;
    private javax.swing.JTextField jTFnOrdenMOD1;
    private javax.swing.JTextField jTFnomeroR;
    private javax.swing.JTextField jTFnomeroR1;
    private javax.swing.JTextField jTFnumOrdenGIF;
    private javax.swing.JTextField jTFnumOrdenGIF1;
    private javax.swing.JTextField jTFnumeroArticulos;
    private javax.swing.JTextField jTFnumeroOrden;
    // End of variables declaration//GEN-END:variables
}
