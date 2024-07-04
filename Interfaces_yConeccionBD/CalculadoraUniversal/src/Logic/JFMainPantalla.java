package Logic;

import Logic.BasicCalculator.JFBasicCalculator;
import Logic.CalculoDiferencial.JFCalculoDiferencial;
import Logic.CalculoIntegral.JFCalculoIntegral;
import Logic.Geometria.JFCalculatorGeometry;
import Logic.Trigonometria.JFCalculatorTrigonometry;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author TheOneAboveAll
 */
public class JFMainPantalla extends javax.swing.JFrame {

    /**
     * Creates new form JFMainPantalla
     */
    public JFMainPantalla() {
        initComponents();
        this.jLToday.setText("Date: " + this.date());   //Se muestra en el recuadro la fecha
        this.message(0);    //Se muestra el mensaje general
    }

    public static String date(){
        //Se crea un objeto apartir de la clase Date()
        Date date = new Date();     
        return date.toString(); //Se devuelve el objeto usando .toString() para convertir la fehca en un texto
    }
     private void message(int option){
        String mensaje = " ";
        switch(option){
                  case 0:   //mensaje general
                           
                           mensaje = "Este es una pequeño programa que recopila diferentes tipos de calculadoras, cada una cumpliendo con un proposito diferente. Al costado derecho podran encontrar las " 
                                   +        "\n  diferentes calculadoras que se encuentran recopiladas en el programa, al seleccionarlas aparecera una descripcion de las funcionalidades de cada una de ellas," 
                                   +        "\n  ademas de describir algunos aspectos importantes con los que podria contar cada, esto para mejorar su uso."
                                   +        "\n \nSi decea conocer el codigo fuente puede consultar el repositorio en el cual se encuentra, ademas de otros proyectos hechos por el mismo creador: "
                                   +        "\nRepositorio: https://github.com/TacosConChelas/EstructuraDDatosJAVA_UV/tree/main";
                           break;
                  case 1:   //mensaje para la calculadora basica
                           
                           mensaje = "Esta calculadora cuenta con las operaciones basicas, estas son: \n   1) Suma (+) \n   2) Resta (-) \n   3) Multiplicacion (x) \n   4) Divicion (÷) \nIncluimos 3 operaciones"
                                    +       " mas y la constante PI: \n   1) Raiz (√) \n   2) Porcentaje (%) \n   3) Potencia (^) \n   4) PI (π)";
                           break;
                  case 2:   //mensaje  para la calculadora de cientifica
                            
                            mensaje = "";
                           break;
                  case 3:  //mensaje paral a calculadora de trigonometria
                           
                           mensaje = "";
                           break;
                  case 4:   //mensaje paral a calculadora de geometria
                           
                           mensaje = "";
                           break;
                  case 5: 
                           //mensaje paral a calculadora de calculo diferencial
                           mensaje = "";
                           break;
                  case 6: 
                           //mensaje paral a calculadora de calculo integral
                           mensaje = "";
                           break;
                  case 7: 
                           //mensaje paral a calculadora de fisica
                           mensaje = "La calculadora de física avanzada que presentamos está diseñada para ser una herramienta integral para estudiantes, profesores e investigadores en diversas ramas de la" 
                                   +       "\n  física.Con funcionalidades que abarcan desde la mecánica clásica hasta la física moderna y la astrofísica, esta calculadora ofrece la capacidad de resolver problemas" 
                                   +       "\n  de cinemática y dinámica,calcular energía y momento, y analizar colisiones. En termodinámica, permite trabajar con la ley de los gases ideales y las leyes de la "   
                                   +       "\n  termodinámica,  mientras que en electromagnetismo incluye cálculos basados en la ley de Coulomb, campos eléctricos, la ley de Faraday y la ley de Ohm. Para óptica, " 
                                   +       "\n  la calculadora maneja la ley de Snell, la ecuación de lentes delgadas y magnificación. En el ámbito de la física moderna, aborda problemas de relatividad especial y" 
                                   +       "\n  mecánica cuántica, incluyendo la ecuación de Schrödinger. Finalmente, en astronomía y astrofísica, permite utilizar la ley de Hubble y calcular magnitudes estelares.Esta" 
                                   +       "\n  calculadora no solo facilita la resolución de complejos problemas físicos sino que también incluye herramientas adicionales como conversión de unidades y gráficos"  
                                   +       "\n  interactivos, siendo una buena herramientta para el estudio y la páctica en la física.";
                           break;
                  case 8: 
                           //mensaje paral a calculadora de quimica
                           mensaje = "";
                           break;
                  case 9: 
                           //mensaje paral a calculadora de
                           mensaje = "";
                           break;
                  default:      System.out.println("Error en la seleccion  del menaje");    break;
                  
        
        }       this.jTAMessage.setText(mensaje);   //dependiendo del valor del a variable option sera el mensaje que se muestre 
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
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLToday = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLBasicCalculadora = new javax.swing.JLabel();
        jLGeometria = new javax.swing.JLabel();
        jLTrigonometry = new javax.swing.JLabel();
        jLCalculoDiferencial = new javax.swing.JLabel();
        jLCalculoIntegral = new javax.swing.JLabel();
        jLCalculadoraCientifica = new javax.swing.JLabel();
        jLCalculadoraFisica = new javax.swing.JLabel();
        jLCalculadoraQuimica = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLExit = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAMessage = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(40, 40, 40));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLToday.setBackground(new java.awt.Color(0, 0, 0));
        jLToday.setFont(new java.awt.Font("Hack Nerd Font Mono", 0, 12)); // NOI18N
        jLToday.setForeground(new java.awt.Color(255, 255, 255));
        jLToday.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLToday.setText("Date: ");
        jLToday.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jLToday.setOpaque(true);
        jPanel4.add(jLToday, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 100, 280, -1));

        jLabel3.setFont(new java.awt.Font("Hack Nerd Font Mono", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Menú principal");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Hack Nerd Font Mono", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Bienvenido");
        jLabel8.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jLabel8.setOpaque(true);
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 120, -1));

        jLabel4.setFont(new java.awt.Font("Hack Nerd Font Mono", 0, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Menú principal");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 1040, 190));

        jPanel3.setBackground(new java.awt.Color(22, 22, 22));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Hack Nerd Font Mono", 0, 28)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Calculadora");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 215, -1));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Hack Nerd Font Mono", 0, 28)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Universal");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 215, -1));

        jLBasicCalculadora.setBackground(new java.awt.Color(22, 22, 22));
        jLBasicCalculadora.setFont(new java.awt.Font("Hack Nerd Font Mono", 0, 12)); // NOI18N
        jLBasicCalculadora.setForeground(new java.awt.Color(255, 255, 255));
        jLBasicCalculadora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLBasicCalculadora.setText("Calculadora Básica");
        jLBasicCalculadora.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLBasicCalculadora.setOpaque(true);
        jLBasicCalculadora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLBasicCalculadoraMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLBasicCalculadoraMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLBasicCalculadoraMouseExited(evt);
            }
        });
        jPanel3.add(jLBasicCalculadora, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 260, 36));

        jLGeometria.setBackground(new java.awt.Color(22, 22, 22));
        jLGeometria.setFont(new java.awt.Font("Hack Nerd Font Mono", 0, 12)); // NOI18N
        jLGeometria.setForeground(new java.awt.Color(255, 255, 255));
        jLGeometria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLGeometria.setText("Geometría");
        jLGeometria.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLGeometria.setOpaque(true);
        jLGeometria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLGeometriaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLGeometriaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLGeometriaMouseExited(evt);
            }
        });
        jPanel3.add(jLGeometria, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 227, 260, 36));

        jLTrigonometry.setBackground(new java.awt.Color(22, 22, 22));
        jLTrigonometry.setFont(new java.awt.Font("Hack Nerd Font Mono", 0, 12)); // NOI18N
        jLTrigonometry.setForeground(new java.awt.Color(255, 255, 255));
        jLTrigonometry.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLTrigonometry.setText("Trigonometría");
        jLTrigonometry.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLTrigonometry.setOpaque(true);
        jLTrigonometry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLTrigonometryMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLTrigonometryMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLTrigonometryMouseExited(evt);
            }
        });
        jPanel3.add(jLTrigonometry, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 260, 36));

        jLCalculoDiferencial.setBackground(new java.awt.Color(22, 22, 22));
        jLCalculoDiferencial.setFont(new java.awt.Font("Hack Nerd Font Mono", 0, 12)); // NOI18N
        jLCalculoDiferencial.setForeground(new java.awt.Color(255, 255, 255));
        jLCalculoDiferencial.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLCalculoDiferencial.setText("Cálculo Diferencial");
        jLCalculoDiferencial.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLCalculoDiferencial.setOpaque(true);
        jLCalculoDiferencial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLCalculoDiferencialMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLCalculoDiferencialMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLCalculoDiferencialMouseExited(evt);
            }
        });
        jPanel3.add(jLCalculoDiferencial, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 294, 260, 36));

        jLCalculoIntegral.setBackground(new java.awt.Color(22, 22, 22));
        jLCalculoIntegral.setFont(new java.awt.Font("Hack Nerd Font Mono", 0, 12)); // NOI18N
        jLCalculoIntegral.setForeground(new java.awt.Color(255, 255, 255));
        jLCalculoIntegral.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLCalculoIntegral.setText("Cálculo Integral");
        jLCalculoIntegral.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLCalculoIntegral.setOpaque(true);
        jLCalculoIntegral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLCalculoIntegralMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLCalculoIntegralMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLCalculoIntegralMouseExited(evt);
            }
        });
        jPanel3.add(jLCalculoIntegral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 328, 260, 36));

        jLCalculadoraCientifica.setBackground(new java.awt.Color(22, 22, 22));
        jLCalculadoraCientifica.setFont(new java.awt.Font("Hack Nerd Font Mono", 0, 12)); // NOI18N
        jLCalculadoraCientifica.setForeground(new java.awt.Color(255, 255, 255));
        jLCalculadoraCientifica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLCalculadoraCientifica.setText("Calculadora Científica");
        jLCalculadoraCientifica.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLCalculadoraCientifica.setOpaque(true);
        jLCalculadoraCientifica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLCalculadoraCientificaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLCalculadoraCientificaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLCalculadoraCientificaMouseExited(evt);
            }
        });
        jPanel3.add(jLCalculadoraCientifica, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 194, 260, 36));

        jLCalculadoraFisica.setBackground(new java.awt.Color(22, 22, 22));
        jLCalculadoraFisica.setFont(new java.awt.Font("Hack Nerd Font Mono", 0, 12)); // NOI18N
        jLCalculadoraFisica.setForeground(new java.awt.Color(255, 255, 255));
        jLCalculadoraFisica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLCalculadoraFisica.setText("Física");
        jLCalculadoraFisica.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLCalculadoraFisica.setOpaque(true);
        jLCalculadoraFisica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLCalculadoraFisicaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLCalculadoraFisicaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLCalculadoraFisicaMouseExited(evt);
            }
        });
        jPanel3.add(jLCalculadoraFisica, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 362, 260, 36));

        jLCalculadoraQuimica.setBackground(new java.awt.Color(22, 22, 22));
        jLCalculadoraQuimica.setFont(new java.awt.Font("Hack Nerd Font Mono", 0, 12)); // NOI18N
        jLCalculadoraQuimica.setForeground(new java.awt.Color(255, 255, 255));
        jLCalculadoraQuimica.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLCalculadoraQuimica.setText("Química");
        jLCalculadoraQuimica.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLCalculadoraQuimica.setOpaque(true);
        jLCalculadoraQuimica.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLCalculadoraQuimicaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLCalculadoraQuimicaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLCalculadoraQuimicaMouseExited(evt);
            }
        });
        jPanel3.add(jLCalculadoraQuimica, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 396, 260, 36));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 740));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Hack Nerd Font Mono", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Repositorio: https://github.com/TacosConChelas/EstructuraDDatosJAVA_UV/");
        jLabel5.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jLabel5.setOpaque(true);
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 470, -1));

        jLExit.setBackground(new java.awt.Color(40, 40, 40));
        jLExit.setFont(new java.awt.Font("Hack Nerd Font Mono", 0, 10)); // NOI18N
        jLExit.setForeground(new java.awt.Color(255, 255, 255));
        jLExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLExit.setText("Exit");
        jLExit.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jLExit.setOpaque(true);
        jLExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLExitMouseClicked(evt);
            }
        });
        jPanel2.add(jLExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 10, 60, 30));

        jTAMessage.setBackground(new java.awt.Color(41, 41, 41));
        jTAMessage.setColumns(20);
        jTAMessage.setFont(new java.awt.Font("Hack Nerd Font Mono", 0, 9)); // NOI18N
        jTAMessage.setForeground(new java.awt.Color(255, 255, 255));
        jTAMessage.setRows(5);
        jScrollPane1.setViewportView(jTAMessage);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 980, 240));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setFont(new java.awt.Font("Hack Nerd Font Mono", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Autor: Adriel Xel Há Hernández Ortega");
        jLabel7.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jLabel7.setOpaque(true);
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 270, -1));

        jLBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/im1.jpg"))); // NOI18N
        jPanel2.add(jLBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 1190, 740));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLBasicCalculadoraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBasicCalculadoraMouseEntered
        //Cuando el mouse este sobre este  recuadro se cambiara el color a [0, 0, 0] en el RGB
        this.jLBasicCalculadora.setBackground(new java.awt.Color(0, 0, 0));
        //se muestra la dscripcion correspondiente
        this.message(1);
    }//GEN-LAST:event_jLBasicCalculadoraMouseEntered

    private void jLBasicCalculadoraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBasicCalculadoraMouseExited
        //Cuando el mouse deje de estar sobre este  recuadro se cambiara el color a [22, 22, 22] en el RGB
        this.jLBasicCalculadora.setBackground(new java.awt.Color(22, 22, 22));
        
        //Ademas de esto, volvera a mostrar el mensaje general
        this.message(0);
        
    }//GEN-LAST:event_jLBasicCalculadoraMouseExited

    private void jLBasicCalculadoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLBasicCalculadoraMouseClicked
        //Se crea un objeto apartir de la clase JFBasicCalculator
        JFBasicCalculator basicC = new JFBasicCalculator();
        basicC.setVisible(true);    //Se hace visible
        basicC.setLocationRelativeTo(null);
        this.dispose(); //se cirran todas las ventanas actualles
        
    }//GEN-LAST:event_jLBasicCalculadoraMouseClicked

    private void jLExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLExitMouseClicked
        //Se ejecuta cuando el usuario da clic en el boton de salir
        System.exit(0);
    }//GEN-LAST:event_jLExitMouseClicked

    private void jLGeometriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLGeometriaMouseClicked
        JFCalculatorGeometry geometry = new JFCalculatorGeometry();
        geometry.setVisible(true);
        geometry.setLocationRelativeTo(null);   //coloca la ventana emergente exactamente en el centro de la pantalla
        this.dispose(); //se cirran todas las ventanas actualles
    }//GEN-LAST:event_jLGeometriaMouseClicked

    private void jLGeometriaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLGeometriaMouseEntered
         this.jLGeometria.setBackground(new java.awt.Color(0, 0, 0));
         
         
    }//GEN-LAST:event_jLGeometriaMouseEntered

    private void jLGeometriaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLGeometriaMouseExited
         this.jLGeometria.setBackground(new java.awt.Color(22, 22, 22));
         
         //Ademas de esto, volvera a mostrar el mensaje general
        this.message(0);
    }//GEN-LAST:event_jLGeometriaMouseExited

    private void jLTrigonometryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLTrigonometryMouseClicked
        JFCalculatorTrigonometry trigonometry = new JFCalculatorTrigonometry();
        trigonometry.setVisible(true);
        trigonometry.setLocationRelativeTo(null);   //coloca la ventana emergente exactamente en el centro de la pantalla
        this.dispose(); //se cirran todas las ventanas actualles
        
        
        
    }//GEN-LAST:event_jLTrigonometryMouseClicked

    private void jLTrigonometryMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLTrigonometryMouseEntered
        this.jLTrigonometry.setBackground(new java.awt.Color(0, 0, 0));
        
    }//GEN-LAST:event_jLTrigonometryMouseEntered

    private void jLTrigonometryMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLTrigonometryMouseExited
       this.jLTrigonometry.setBackground(new java.awt.Color(22,22,22));
       
        //Ademas de esto, volvera a mostrar el mensaje general
        this.message(0);
    }//GEN-LAST:event_jLTrigonometryMouseExited

    private void jLCalculoDiferencialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCalculoDiferencialMouseClicked
        JFCalculoDiferencial calculoD = new JFCalculoDiferencial();
        calculoD.setVisible(true);
        calculoD.setLocationRelativeTo(null);   //coloca la ventana emergente exactamente en el centro de la pantalla
        this.dispose(); //se cirran todas las ventanas actualles
    }//GEN-LAST:event_jLCalculoDiferencialMouseClicked

    private void jLCalculoDiferencialMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCalculoDiferencialMouseEntered
        this.jLCalculoDiferencial.setBackground(new java.awt.Color(0, 0, 0));
        
        
    }//GEN-LAST:event_jLCalculoDiferencialMouseEntered

    private void jLCalculoDiferencialMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCalculoDiferencialMouseExited
        this.jLCalculoDiferencial.setBackground(new java.awt.Color(22,22,22));
        
         
        this.message(0); //Ademas de esto, volvera a mostrar el mensaje general
    }//GEN-LAST:event_jLCalculoDiferencialMouseExited

    private void jLCalculoIntegralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCalculoIntegralMouseClicked
        JFCalculoIntegral calculoI = new JFCalculoIntegral();
        calculoI.setVisible(true);
        calculoI.setLocationRelativeTo(null);   //coloca la ventana emergente exactamente en el centro de la pantalla
        this.dispose(); //se cirran todas las ventanas actualles
    }//GEN-LAST:event_jLCalculoIntegralMouseClicked

    private void jLCalculoIntegralMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCalculoIntegralMouseEntered
        this.jLCalculoIntegral.setBackground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_jLCalculoIntegralMouseEntered

    private void jLCalculoIntegralMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCalculoIntegralMouseExited
        this.jLCalculoIntegral.setBackground(new java.awt.Color(22,22,22));
        
        
         this.message(0); //Ademas de esto, volvera a mostrar el mensaje general
    }//GEN-LAST:event_jLCalculoIntegralMouseExited

    private void jLCalculadoraCientificaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCalculadoraCientificaMouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jLCalculadoraCientificaMouseClicked

    private void jLCalculadoraCientificaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCalculadoraCientificaMouseEntered
        // TODO add your handling code here:
        this.jLCalculadoraCientifica.setBackground(new java.awt.Color(0, 0, 0));
        
         
    }//GEN-LAST:event_jLCalculadoraCientificaMouseEntered

    private void jLCalculadoraCientificaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCalculadoraCientificaMouseExited
        // TODO add your handling code here:
        this.jLCalculadoraCientifica.setBackground(new java.awt.Color(22,22,22));
        
        this.message(0); //Ademas de esto, volvera a mostrar el mensaje general
    }//GEN-LAST:event_jLCalculadoraCientificaMouseExited

    private void jLCalculadoraFisicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCalculadoraFisicaMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jLCalculadoraFisicaMouseClicked

    private void jLCalculadoraFisicaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCalculadoraFisicaMouseEntered
        // TODO add your handling code here:
        this.jLCalculadoraFisica.setBackground(new java.awt.Color(0, 0, 0));
        this.message(7);
    }//GEN-LAST:event_jLCalculadoraFisicaMouseEntered

    private void jLCalculadoraFisicaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCalculadoraFisicaMouseExited
        // TODO add your handling code here:
        this.jLCalculadoraFisica.setBackground(new java.awt.Color(22 ,22, 22));
        this.message(0); //Ademas de esto, volvera a mostrar el mensaje general
    }//GEN-LAST:event_jLCalculadoraFisicaMouseExited

    private void jLCalculadoraQuimicaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCalculadoraQuimicaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLCalculadoraQuimicaMouseClicked

    private void jLCalculadoraQuimicaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCalculadoraQuimicaMouseEntered
        // TODO add your handling code here:
        this.jLCalculadoraQuimica.setBackground(new java.awt.Color(0, 0, 0));
        
    }//GEN-LAST:event_jLCalculadoraQuimicaMouseEntered

    private void jLCalculadoraQuimicaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCalculadoraQuimicaMouseExited
        // TODO add your handling code here:
        this.jLCalculadoraQuimica.setBackground(new java.awt.Color(22, 22, 22));
        this.message(0); //Ademas de esto, volvera a mostrar el mensaje general
    }//GEN-LAST:event_jLCalculadoraQuimicaMouseExited

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
            java.util.logging.Logger.getLogger(JFMainPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFMainPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFMainPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFMainPantalla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFMainPantalla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLBackground;
    private javax.swing.JLabel jLBasicCalculadora;
    private javax.swing.JLabel jLCalculadoraCientifica;
    private javax.swing.JLabel jLCalculadoraFisica;
    private javax.swing.JLabel jLCalculadoraQuimica;
    private javax.swing.JLabel jLCalculoDiferencial;
    private javax.swing.JLabel jLCalculoIntegral;
    private javax.swing.JLabel jLExit;
    private javax.swing.JLabel jLGeometria;
    private javax.swing.JLabel jLToday;
    private javax.swing.JLabel jLTrigonometry;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTAMessage;
    // End of variables declaration//GEN-END:variables
}
