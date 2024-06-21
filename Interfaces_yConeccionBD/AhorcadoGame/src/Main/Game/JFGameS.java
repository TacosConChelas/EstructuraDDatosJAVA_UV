/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main.Game;

import Main.*;
import javax.swing.JOptionPane;

/**
 *
 * @author TheOneAboveAll
 */
public class JFGameS extends javax.swing.JFrame {
    private String player1; //Nombre de los jugadores
    private String player2;
    
    private int player1Points = 0;
    private int player2Points = 0;
    public int intentosP1 = 6;
    public int intentosP2 = 6;
    public int turno = 0; //Si es 0 le toca adivinar al jugador 2 e insertar al jugador 1
    
    public boolean permiso = true; //Permite si se insertan una nueva pista y una nueva palabra secreta
    public int count = 2; //Cuenta los errores para navegar en el arreglo de cada jugador
    /*
    El primer espacio del arreglo se encuentra la pala que el jugador eligio como la pista, 
    los siguientes 6 espacios se encuentran las 6 palabras que el jugador va escribiendo en cada uno de sus 
    intentos
    i = 0 es la palabra secreta
    i = 1 es la pista para el otro jugador
    1 = 2, 3, 4, 5, 6, 7 son las 6 palabras de los 6 intentos del jugador
    */
    public String[] wordsPlayer1 = new String[8];
    public String[] wordsPlayer2 = new String[8];
    
    //GETTERS Y SETTERSSS
    public void setPlayer1(String n){   this.player1 = n;  }
    public void setPlayer2(String n){   this.player2 = n;  }
    
    public void setPlayer1Points(int x){   this.player1Points += x;  }
    public void setPlayer2Points(int x){   this.player2Points += x;  }
    
    
    public String getPlayer1(){   return this.player1;  }
    public String getPlayer2(){   return this.player2;  }
    
    public int getPlayer1Points(){   return this.player1Points;  }
    public int getPlayer2Points(){   return this.player2Points;  }
    /**
     * Creates new form JFGameS
     */
    public JFGameS(String p1, String p2) {
        initComponents();
        
        this.setPlayer1(p1);
        this.setPlayer2(p2);
        
        //System.out.println("jugador 1: " + this.getPlayer1());
        
        jTFShowNameP1.setText(p1);
        jTFShowNameP2.setText(p2);
        
        //Se colocan los puntajes de cada uno de los jugadores
        //int n = this.getPlayer1Points();
        //System.out.println(n);
        jTFShowPointsP1.setText(this.getPlayer1Points() + "");
        jTFShowPointsP2.setText(this.getPlayer2Points() + "");
        
        //Se coloca el nombre del jugador en turno
        jTFShowPlayerTurn.setText(this.getPlayer2());
        
    }
    public void ganadorP (int p1, int p2){
        if(p1 == 3){
            this.permiso = false; //se niega el permiso de insertar 
            this.turno = 2; //Se cambia a valor 2 indicando que ya no se encuentra en ningun turno
          
            jTFShowResultado.setText(this.getPlayer1() + " WIN");
            JOptionPane.showMessageDialog(null, "INCREIBLE el jugador ganador es " + this.getPlayer1());
            
        } else if (p2 == 3){ 
            
            this.permiso = false;
            this.turno = 2;
            jTFShowResultado.setText(this.getPlayer2() + " WIN");
            JOptionPane.showMessageDialog(null, "INCREIBLE el jugador ganador es " + this.getPlayer2());
            
        } else {
            this.permiso = true; //Se concede permiso para poder insertar
            this.count = 2; //Se reinician los contadores para navegar en el arreglo
            
            if(this.turno == 0){
                this.turno = 1;//Se cambia turno
                this.intentosP2 = 6; //Se reinician los intentos del jugador 2
                jTFShowResultado.setText("Correcto"); //Se afirma que está correcto
                jTFShowPlayerTurn.setText(this.getPlayer1());
                JOptionPane.showMessageDialog(null, "Felicitaciones \nAhora es turno de " + this.getPlayer1()); 
                
            } else {
                this.turno = 0; //Se cambia turno
                this.intentosP1 = 6;
                //Se manda un mensaje del cmabio de turno
                jTFShowResultado.setText("Correcto"); //Se afirma que está correcto
                jTFShowPlayerTurn.setText(this.getPlayer2());
                JOptionPane.showMessageDialog(null, "Felicitaciones \nAhora es turno de " + this.getPlayer2());
            }
           
        }
        
    }
    
    public void losePlayer(int a){
        //Si algun jugador no adivina la palabra secreta del otro se añade uno a la variable count para navegar en el siguiente indice de us respectivo arreglo
        this.count++; 
        jTFShowResultado.setText("Incorrecto"); //SE muestra el mensaje de incorrecto
        switch(a){
            case 0:
                //Si el jugador 2 no acierta la palabra del jugadpr 1 :
                this.intentosP2--; //Se le quita un intento
                jTFIntentosRestantes.setText(this.intentosP2 + ""); //Se muestran los intentos restantes 
                
                break;
            case 1:
                //Si el jugador 1 no acierta la palabra del jugadpr 2 :
                this.intentosP1--; //Se le quita un intento
                jTFIntentosRestantes.setText(this.intentosP1 + ""); //Se muestran los intentos restantes 
               
                break;
        
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

        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jBShowManual = new javax.swing.JButton();
        jTFShowNameP1 = new javax.swing.JLabel();
        jTFShowNameP2 = new javax.swing.JLabel();
        jTFShowPointsP2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTFShowPointsP1 = new javax.swing.JLabel();
        jBPlayGame = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTFShowPlayerTurn = new javax.swing.JLabel();
        jTFShowPista = new javax.swing.JLabel();
        jPFPista = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPFSecretWord = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        jBAdivinar = new javax.swing.JButton();
        jTFAdivinarW = new javax.swing.JTextField();
        jTFShowResultado = new javax.swing.JLabel();
        jTFIntentosRestantes = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAShowWordsP2 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTAShowWordsP1 = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 204, 153));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User1.jpg"))); // NOI18N
        jLabel8.setOpaque(true);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/User2.jpg"))); // NOI18N
        jLabel7.setOpaque(true);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("JUGADOR 1");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("JUGADOR 2");

        jBShowManual.setText("Mostrar el manual");

        jTFShowNameP1.setBackground(new java.awt.Color(255, 51, 51));
        jTFShowNameP1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTFShowNameP1.setForeground(new java.awt.Color(0, 0, 0));
        jTFShowNameP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTFShowNameP1.setOpaque(true);

        jTFShowNameP2.setBackground(new java.awt.Color(255, 51, 51));
        jTFShowNameP2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTFShowNameP2.setForeground(new java.awt.Color(0, 0, 0));
        jTFShowNameP2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTFShowNameP2.setOpaque(true);

        jTFShowPointsP2.setBackground(new java.awt.Color(255, 255, 255));
        jTFShowPointsP2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTFShowPointsP2.setForeground(new java.awt.Color(0, 0, 0));
        jTFShowPointsP2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTFShowPointsP2.setOpaque(true);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Puntos:");

        jTFShowPointsP1.setBackground(new java.awt.Color(255, 255, 255));
        jTFShowPointsP1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTFShowPointsP1.setForeground(new java.awt.Color(0, 0, 0));
        jTFShowPointsP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTFShowPointsP1.setOpaque(true);

        jBPlayGame.setText("Ingresar palabra secreta y pista");
        jBPlayGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBPlayGameActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Jugador que tiene que adivinar:");

        jTFShowPlayerTurn.setBackground(new java.awt.Color(255, 255, 255));
        jTFShowPlayerTurn.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTFShowPlayerTurn.setForeground(new java.awt.Color(0, 0, 0));
        jTFShowPlayerTurn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTFShowPlayerTurn.setOpaque(true);

        jTFShowPista.setBackground(new java.awt.Color(255, 255, 255));
        jTFShowPista.setForeground(new java.awt.Color(0, 0, 0));
        jTFShowPista.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTFShowPista.setOpaque(true);
        jTFShowPista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTFShowPistaMouseClicked(evt);
            }
        });

        jPFPista.setText("jPasswordField1");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Palabra secreta:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Pista:");

        jPFSecretWord.setText("jPasswordField1");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Pista:");

        jBAdivinar.setText("Intentar adivinar");
        jBAdivinar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAdivinarActionPerformed(evt);
            }
        });

        jTFAdivinarW.setBackground(new java.awt.Color(255, 255, 255));
        jTFAdivinarW.setForeground(new java.awt.Color(0, 0, 0));

        jTFShowResultado.setBackground(new java.awt.Color(255, 255, 255));
        jTFShowResultado.setForeground(new java.awt.Color(0, 0, 0));
        jTFShowResultado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTFShowResultado.setOpaque(true);

        jTFIntentosRestantes.setBackground(new java.awt.Color(255, 255, 255));
        jTFIntentosRestantes.setForeground(new java.awt.Color(0, 0, 0));
        jTFIntentosRestantes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jTFIntentosRestantes.setOpaque(true);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Intentos disponibles:");

        jTAShowWordsP2.setBackground(new java.awt.Color(255, 255, 255));
        jTAShowWordsP2.setColumns(20);
        jTAShowWordsP2.setForeground(new java.awt.Color(0, 0, 0));
        jTAShowWordsP2.setRows(5);
        jTAShowWordsP2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTAShowWordsP2MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTAShowWordsP2);

        jTAShowWordsP1.setBackground(new java.awt.Color(255, 255, 255));
        jTAShowWordsP1.setColumns(20);
        jTAShowWordsP1.setForeground(new java.awt.Color(0, 0, 0));
        jTAShowWordsP1.setRows(5);
        jTAShowWordsP1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTAShowWordsP1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTAShowWordsP1);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Da click para ver las palabras");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Da click para ver las palabras");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(jLabel3)
                .addGap(233, 233, 233)
                .addComponent(jBPlayGame)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(116, 116, 116))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTFShowNameP1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jPFPista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(122, 122, 122))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(123, 123, 123)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jBAdivinar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTFAdivinarW))
                                        .addGap(211, 211, 211))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11)
                                        .addGap(161, 161, 161))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jTFIntentosRestantes, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jTFShowPista, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(102, 102, 102)))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFShowNameP2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(jBShowManual))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(241, 241, 241)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(125, 125, 125)
                                        .addComponent(jTFShowPointsP1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(51, 51, 51)
                                        .addComponent(jTFShowPointsP2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(174, 174, 174)
                                        .addComponent(jTFShowPlayerTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(141, 141, 141)
                                        .addComponent(jLabel6)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)))
                        .addGap(38, 38, 38))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jTFShowResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addGap(65, 65, 65))))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(390, 390, 390)
                    .addComponent(jPFSecretWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(648, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(76, 76, 76)
                    .addComponent(jLabel14)
                    .addContainerGap(879, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jBShowManual)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFShowPointsP1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFShowPointsP2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTFShowPlayerTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBPlayGame)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jTFShowNameP1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jTFShowNameP2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(34, 34, 34))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGap(6, 6, 6)
                            .addComponent(jLabel9)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jPFPista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTFShowPista, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFIntentosRestantes, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addComponent(jBAdivinar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTFAdivinarW, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTFShowResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(59, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(375, 375, 375)
                    .addComponent(jPFSecretWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(435, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(712, Short.MAX_VALUE)
                    .addComponent(jLabel14)
                    .addGap(113, 113, 113)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBPlayGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBPlayGameActionPerformed
        
        switch(this.turno){
            //Si es 0 es turno del jugador 1, si es 1 es turno del jugador 2
            case 0:
                
                //Se valida el permiso para que se active la case SecretWords y se inserte la palaba secreta y la pista 
                if(this.permiso){
                    this.intentosP2 = 6;
                    this.wordsPlayer1[0] = jPFSecretWord.getText();
                    this.wordsPlayer1[1] = jPFPista.getText();
                    
                    jTFIntentosRestantes.setText(this.intentosP2 + "");
                    this.permiso = false;
                    
                } else {    JOptionPane.showMessageDialog(null, "Accion invalida, espere a la conclución del turno del jugador");    }
                break;
            
            case 1: 
                 if(this.permiso){
                    this.intentosP1 = 6;
                    this.wordsPlayer2[0] = jPFSecretWord.getText(); //Se inserta la palabra secreta
                    this.wordsPlayer2[1] = jPFPista.getText();//Se inserta la pista
                    
                    jTFIntentosRestantes.setText(this.intentosP1 + "");
                    this.permiso = false;
                } else {    JOptionPane.showMessageDialog(null, "Accion invalida, espere a la conclución del turno del jugador");    }
                break;
            default: 
                JOptionPane.showMessageDialog(null, "Error de ejecución");
                break;
        }
        
    }//GEN-LAST:event_jBPlayGameActionPerformed

    private void jTFShowPistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTFShowPistaMouseClicked
        //Dependiendo del turno en el que se esté se va a colocar la pista que le corresponde al jugador en turno
        if(this.turno == 0){
            jTFShowPista.setText(this.wordsPlayer1[1]);
        } else {
            jTFShowPista.setText(this.wordsPlayer2[1]);
        }
        
        //jTFShowPista.setText("funciona");
        
    }//GEN-LAST:event_jTFShowPistaMouseClicked

    private void jBAdivinarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAdivinarActionPerformed
        //System.out.println(this.permiso);
        if(this.turno == 0 && (! this.permiso)){
            this.wordsPlayer2[this.count] = jTFAdivinarW.getText(); //Se agrega el intento del jugador 2 a su array 
            //System.out.println(wordsPlayer2[this.count]);     System.out.println(wordsPlayer1[0]);
            //System.out.println(this.count);
            //String a = jTFAdivinarW.getText(); System.out.println("\n_" + a+ "_");
            //String b = this.wordsPlayer1[0]; System.out.println("_" + b+ "_");
            //int a = 1;    int b = 1;
            /*
           if(this.wordsPlayer2[this.count].equals(this.wordsPlayer1[0])) {
                System.out.println("ajajjaj nmms otra ves????");
                
            } else {    System.out.println("Vaya vaya jajajajj que chistoso");  }
            
            
            Se usa el método .equals() ya que para las variables de tipo String estas al ser objetos y usar == para compararlas 
            va a dar falso ya que este == no está comparando su valor en si, sino su ubicacion en memoria ya que son objetos, por lo que 
            si queremos comparar su valor y no su ubicacion en memoria debemos de usar este método, esto para objetos.
            
            */
            System.out.println("Es turno de " + this.getPlayer1() + " Con intentos: " + this.intentosP1);
            if(this.wordsPlayer2[this.count].equals(this.wordsPlayer1[0])){
                
                System.out.println("Entro en el primer if del jugador 2");
                //Si el jugador 2 acierta la palabra del jugadpr 1 se le agrega un punto a su puntaje
                this.setPlayer2Points(1);
                jTFShowPointsP2.setText(this.getPlayer2Points() + ""); //Se coloca el puntaje del jugador 2
                
                this.ganadorP(this.getPlayer1Points(), this.getPlayer2Points());
               
            } else {
                System.out.println("Entro en el primer else del jugador 2");
                
                this.losePlayer(0); //Se ejecuta el método para evaluar la variable contador y los intentos del jugador 
                
                //Si el jugador 2 ha superado los intentos disponibles (es decir 6)
                if(this.count == 8 && this.intentosP2 == 0){
                    this.turno = 1;//SE le pasa el turno al otro jugadr
                    this.count = 2; //Se reinician los contadores
                    this.intentosP2 = 6; //Re reinician los intentos de jugador 2 para el siguiente turno
                    this.permiso = true; //Se concede permiso para incresar nueva palabra secreta y nueva pista
                    jTFShowResultado.setText("Game Lose"); //Se muestra mensaje de que ha perdido
                    
                    jTFShowPlayerTurn.setText(this.getPlayer1());
                    JOptionPane.showMessageDialog(null, "Que lástima \nAhora es turno de " + this.getPlayer1());
                    //Se muestra mensaje que se pasa turno
                }
            }
        //Turno cuando el jugador 1 adivina la palabra secreta del jug 2:
        } else if (this.turno == 1 && (! this.permiso)){
            System.out.println("Es turno de " + this.getPlayer1() + "Con intentos: " + this.intentosP1);
            
            this.wordsPlayer1[this.count] = jTFAdivinarW.getText();
            
            if(this.wordsPlayer1[this.count].equals(this.wordsPlayer2[0])){
             
                System.out.println("Entro en el primer if del jugador 1");
                //Si el jugador 1 acierta la palabra del jugadpr 2 se le agrega un punto a su puntaje
                this.setPlayer1Points(1);
                jTFShowPointsP1.setText(this.getPlayer1Points() + ""); //Se coloca el puntaje del jugador 1
                
               
                this.ganadorP(this.getPlayer1Points(), this.getPlayer2Points());
                
            } else {
                System.out.println("Entro en el primer else del jugador 1");
                
                this.losePlayer(1); //Se ejecuta el método para evaluar la variable contador y los intentos del jugador 
                
                //Si el jugador 1 ha superado los intentos disponibles (es decir 6) este pierde y sucede lo siguiente:
                if(this.count == 8 && this.intentosP1 == 0){
                    this.turno = 0;//SE le pasa el turno al otro jugadr
                    this.count = 2; //Se reinician los contadores
                    this.permiso = true;
                    this.intentosP1 = 6;
                    
                    jTFShowResultado.setText("Game Lose"); //Se muestra mensaje de que ha perdido
                    
                    jTFShowPlayerTurn.setText(this.getPlayer2());
                    JOptionPane.showMessageDialog(null, "Que lástima \nAhora es turno de " + this.getPlayer2());
                    //Se muestra mensaje que se pasa turno
                }
            }
        }
        
        
    }//GEN-LAST:event_jBAdivinarActionPerformed

    private void jTAShowWordsP2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTAShowWordsP2MouseClicked
        jTAShowWordsP2.setText("");//Limpia el area para colocar las palabras q ha usado el jugadr 2
        
        //Recorre todo el arreglo de las palabras del jugador 2
        for (int i = 2; i < this.wordsPlayer2.length; i++){
            if(this.wordsPlayer2[i] != null){
                jTAShowWordsP2.setText(jTAShowWordsP2.getText() + this.wordsPlayer2[i] + "\n");
            }
        }
    }//GEN-LAST:event_jTAShowWordsP2MouseClicked

    private void jTAShowWordsP1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTAShowWordsP1MouseClicked
        // TODO add your handling code here:
        jTAShowWordsP1.setText("");//Limpia el area para colocar las palabras q ha usado el jugadr 1
        
        //Recorre todo el arreglo de las palabras del jugador 2
       for (int i = 2; i < this.wordsPlayer1.length; i++){
            if(this.wordsPlayer1[i] != null){
                jTAShowWordsP1.setText(jTAShowWordsP1.getText() + this.wordsPlayer1[i] + "\n");
            }
        }
        
        
    }//GEN-LAST:event_jTAShowWordsP1MouseClicked

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
            java.util.logging.Logger.getLogger(JFGameS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFGameS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFGameS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFGameS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAdivinar;
    private javax.swing.JButton jBPlayGame;
    private javax.swing.JButton jBShowManual;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPFPista;
    private javax.swing.JPasswordField jPFSecretWord;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTAShowWordsP1;
    private javax.swing.JTextArea jTAShowWordsP2;
    private javax.swing.JTextField jTFAdivinarW;
    private javax.swing.JLabel jTFIntentosRestantes;
    private javax.swing.JLabel jTFShowNameP1;
    private javax.swing.JLabel jTFShowNameP2;
    private javax.swing.JLabel jTFShowPista;
    private javax.swing.JLabel jTFShowPlayerTurn;
    private javax.swing.JLabel jTFShowPointsP1;
    private javax.swing.JLabel jTFShowPointsP2;
    private javax.swing.JLabel jTFShowResultado;
    // End of variables declaration//GEN-END:variables
}
