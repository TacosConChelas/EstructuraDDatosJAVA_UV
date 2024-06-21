
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class JFArticulo extends javax.swing.JFrame {

    Conexion conect = new Conexion();
    Connection con;
    Statement st;
    ResultSet rs;
    DefaultTableModel ModeloArticulo;
    
    public JFArticulo() {
        initComponents();
        this.actualizarJTableArticulo();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTFidArticulo = new javax.swing.JTextField();
        jTFNombre = new javax.swing.JTextField();
        jTFMarca = new javax.swing.JTextField();
        jTFPrecio = new javax.swing.JTextField();
        jBAgregar = new javax.swing.JButton();
        jBSalir = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del artículo"));

        jLabel1.setText("id Articulo:");

        jLabel2.setText("Nombre: ");

        jLabel3.setText("Marca:");

        jLabel4.setText("Precio:");

        jBAgregar.setText("Agregar");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        jBSalir.setText("Salir");
        jBSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalirActionPerformed(evt);
            }
        });

        jBEliminar.setText("Eliminar");
        jBEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jBAgregar)
                        .addGap(10, 10, 10)
                        .addComponent(jBEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(jBSalir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTFidArticulo, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(jTFNombre)
                            .addComponent(jTFMarca)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jTFPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTFidArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTFPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAgregar)
                    .addComponent(jBSalir)
                    .addComponent(jBEliminar))
                .addGap(28, 28, 28))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Articulos"));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idArticulo", "Nombre", "Marca", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void limpiarJTFArticulo(){
        this.jTFidArticulo.setText("");
        this.jTFMarca.setText("");
        this.jTFNombre.setText("");
        this.jTFPrecio.setText("");
    }
    
    public void actualizarJTableArticulo(){
        //Esto limpia la table antes de agregar un articulo nuevo 
        for (int i = 0; i < this.jTable1.getRowCount(); i++) {
            ModeloArticulo.removeRow(i);
            i=i-1;
        }
        try{
            String consulta="Select * from Articulo";
            con=conect.getConnection();
            st=con.createStatement();
            rs=st.executeQuery(consulta);
            Object[] articulos = new Object[4];
            ModeloArticulo=(DefaultTableModel) this.jTable1.getModel();
            while(rs.next()){
                articulos[0] = rs.getInt("idArticulo");
                articulos[1] = rs.getString("NombreA");
                articulos[2] = rs.getString("marca");
                articulos[3] = rs.getFloat("Precio");
                ModeloArticulo.addRow(articulos);
            }
            this.jTable1.setModel(ModeloArticulo);
            
        }catch(Exception e){
            System.out.println("El error es " + e);
        }
    }
    
    
    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
        int idArticulo= Integer.parseInt( this.jTFidArticulo.getText());
        String Nombre=this.jTFNombre.getText();
        String Marca = this.jTFMarca.getText();
        //cast
        Double Precio = Double.parseDouble(this.jTFPrecio.getText());
        String sqlInsertar="insert into Articulo values ("+idArticulo+","+"'"+Nombre+"'"+","+"'"+Marca+"'"+","+Precio+");";
        try{
            con=conect.getConnection();
            st=con.createStatement();
            st.executeUpdate(sqlInsertar);
            JOptionPane.showMessageDialog(null, "Registro exitoso a la base de datos");
            
        }catch(SQLException e){
            System.out.println(" El error es " + e);
        }
        this.limpiarJTFArticulo();
        this.actualizarJTableArticulo();
    }//GEN-LAST:event_jBAgregarActionPerformed

    private void jBSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jBSalirActionPerformed

    private void jBEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEliminarActionPerformed
        int fila = this.jTable1.getSelectedRow();
        int idArticulo = Integer.parseInt(this.jTable1.getValueAt(fila,0).toString());
        try{
            String sql = "delete from Articulo where idArticulo=" + idArticulo;
            con=conect.getConnection();
            st=con.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Registro Eliminado");
            this.actualizarJTableArticulo();
        }catch(Exception  e){
            System.out.println("El error es: " + e);
        }
    }//GEN-LAST:event_jBEliminarActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFArticulo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFMarca;
    private javax.swing.JTextField jTFNombre;
    private javax.swing.JTextField jTFPrecio;
    private javax.swing.JTextField jTFidArticulo;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
