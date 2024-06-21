/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Main.Logic_root;

import Main.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TheOneAboveAll
 */
public class JFDetalleVenta extends javax.swing.JFrame {

    Conexion conect = new Conexion(); //Creamos un objeto apartir de la clase Conexion para poder usarla aqui
    Connection con;
    Statement st;
    DefaultTableModel modeloVenta;
    ResultSet rs;
    
    public float total;
    /**
     * Creates new form JFDetalleVenta
     */
    public JFDetalleVenta() {
        initComponents();
    }
    
    public void showVentasODetalleVenta(int opcion){
        //System.out.println("hola1");
        String sqlVentaODetalleVenta = "";
        switch(opcion){
            case 0:     for (int i = 0; i < this.jTDetalleVenta.getRowCount(); i++){  modeloVenta.removeRow(i);   i = i - 1;  }  
                sqlVentaODetalleVenta = "select * from detallev";   break;
            case 1:     for (int i = 0; i < this.jTVentas.getRowCount(); i++){  modeloVenta.removeRow(i);   i = i - 1;  }  
                sqlVentaODetalleVenta = "select * from venta";  break;
            default: System.out.println("Error al mostrar"); break;
        }
        try{
            con = conect.getConnection();
            st = con.createStatement();
            rs= st.executeQuery(sqlVentaODetalleVenta);
            
            Object[] venta = new Object[4]; 
            switch(opcion){
                case 0:     modeloVenta = (DefaultTableModel)this.jTDetalleVenta.getModel();
                    while(rs.next()){
                        venta[0] = rs.getInt("idProducto");
                        venta[1] = rs.getInt("folio");
                        venta[2] = rs.getFloat("cantidad");
                        venta[3] = rs.getFloat("subtotal");
                        modeloVenta.addRow(venta);    
                    }   this.jTDetalleVenta.setModel(modeloVenta);  break;
                case 1:     modeloVenta = (DefaultTableModel)this.jTVentas.getModel();
                    while(rs.next()){
                        venta[0] = rs.getInt("Folio");
                        venta[1] = rs.getString("fecha");
                        venta[2] = rs.getFloat("total");
                        venta[3] = rs.getInt("idempleado");
                        modeloVenta.addRow(venta);    
                    }   this.jTVentas.setModel(modeloVenta);    break;
                default:    System.out.println("Error al mostrar");    break;
            }
        }catch(SQLException e){     System.out.println(" El error es " + e);
        } finally {
            //cerrar conecciones con la bd
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {      System.out.println("Error al cerrar la conexión " + e);     }
        }
        
    }

    public void actualizarVentas(int idVenta, int opcion, int cantidad){
        String sqlUpdate;
        /*
        0) Actualizar detalle venta
        1) Actualizar ventas de manera normal
        2) actualizar ventas despues de haber hecho un detalle venta
        */
        switch(opcion){
            case 0:
                sqlUpdate = "update producto set cantidad = " + cantidad;
                break;
            case 1:
                
                break;
            case 2:
                
                break;
            default: System.out.println("error en el tipo de actualizacion");
                break;
        }
        
        
    
    }
    
    public float totalProductoDetalleVenta(int idproducto, int cantidad){
        float total = 0;
        
        String sqlBusqueda = "select * from producto where idProducto = " + idproducto + ";" ;
        
        String sqlCantidad;
        int cant;
        try{
            con = conect.getConnection();
            st = con.createStatement();
            rs= st.executeQuery(sqlBusqueda);
            //System.out.println("Se conectó correctamente a BD");
            
            
            //Evaluacion si contiene alguna columna por lo que le id del producto si existe
            if(rs.next()){
                total = rs.getFloat("PrecioVenta") * cantidad;
                
            } else {System.out.println("no se encontro el producto");}
            
        }   catch(SQLException e){  System.out.println(" El error es " + e);
            
        }  finally {
            //cerrar conecciones con la bd
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {  System.out.println("Error al cerrar la conexión " + e);
            }
        }
       
        return total;
    }
    
    public boolean buscarProductoYFolio(int opcion, int id, int cant){
        String sqlBusqueda = "";
        boolean x = false;
        
        switch(opcion){
            case 0:     //opcion para buscar el producto
                sqlBusqueda = "select * from producto where idProducto = " + id + ";" ;     break;
            case 1:     //opcion para buscar el folio de la venta
                sqlBusqueda = "select * from venta where Folio = " + id + ";" ;     break;
            case 2:     
                // opcion para verificar si la cantidad a vender es menor a la cantidad que ya existe
                sqlBusqueda = "select * from producto where idProducto = " + id + ";" ;     break;
                
            default: System.out.println("Error"); break;
        }
        try{
            con = conect.getConnection();
            st = con.createStatement();
            rs= st.executeQuery(sqlBusqueda);
            //System.out.println("Se conectó correctamente a BD");
           
            //Evaluacion si contiene alguna columna por lo que le id del producto o el folio de la venta si existe
            if(rs.next()){
               if(opcion == 2){
                   //Esta opcion es cuando se decee verificar si la cantidad colocada en el detalle venta es la misma cantidad en existencias en la tabla producto
                   if(cant <= rs.getInt("Cantidad")){
                       //Retornara true si la cantidad que se va a vender es mayor a la cantidad que ya existe
                       x = true;
                       //Sino regresara false
                   } else {    
                       JOptionPane.showMessageDialog(null, "Lo sentimos pero la cantidad colocada sobrepasa la cantidad del producto en existencias"); 
                       x = false;   
                   }
               } else { 
                   x = true;  //Si el id o folio se encontro va a devolver true
               }
            } else{
                x = false;
                switch(opcion){
                    case 0: JOptionPane.showMessageDialog(null, "Lo sentimos pero el id del producto no existe o esta incorrecto");         break;
                    case 1: JOptionPane.showMessageDialog(null, "Lo sentimos pero el folio de la venta no existe o esta incorrecto");      break;
                    case 2:      break;
                    default: System.out.println("Error"); break;
                } 
            } 
        }   catch(SQLException e){  System.out.println(" El error es " + e);
            
        }  finally {
            //cerrar conecciones con la bd
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {  System.out.println("Error al cerrar la conexión " + e);
            }
        }
        
        return x;
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
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTFIdProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTFFolio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTCantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jBAgregarDetalleV = new javax.swing.JButton();
        jBEliminarDetalleV = new javax.swing.JButton();
        jBMostarDetalleVenta = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLSubtotal = new javax.swing.JLabel();
        jBShowProductos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTDetalleVenta = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTVentas = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTFolioV = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTFFecha = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTFIdEmpleado = new javax.swing.JTextField();
        jLTotal = new javax.swing.JLabel();
        jBAgregarVenta = new javax.swing.JButton();
        jBEliminar = new javax.swing.JButton();
        jBMostrarVentas = new javax.swing.JButton();
        jBActualizar = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("  Detalle de Ventas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("idProducto:");

        jTFIdProducto.setBackground(new java.awt.Color(255, 255, 255));
        jTFIdProducto.setForeground(new java.awt.Color(0, 0, 0));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Folio:");

        jTFFolio.setBackground(new java.awt.Color(255, 255, 255));
        jTFFolio.setForeground(new java.awt.Color(0, 0, 0));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Cantidad:");

        jTCantidad.setBackground(new java.awt.Color(255, 255, 255));
        jTCantidad.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Subtotal:");

        jBAgregarDetalleV.setText("Agregar");
        jBAgregarDetalleV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarDetalleVActionPerformed(evt);
            }
        });

        jBEliminarDetalleV.setText("Eliminar");

        jBMostarDetalleVenta.setText("Mostrar");
        jBMostarDetalleVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMostarDetalleVentaActionPerformed(evt);
            }
        });

        jButton4.setText("Actualizar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLSubtotal.setForeground(new java.awt.Color(0, 0, 0));
        jLSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLSubtotal.setText("0.00");

        jBShowProductos.setText("Mostrar productos disponibles");
        jBShowProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBShowProductosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTFIdProducto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                .addComponent(jTFFolio, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTCantidad, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBShowProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jBMostarDetalleVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBAgregarDetalleV, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jBEliminarDetalleV, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTFIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTFFolio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLSubtotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBEliminarDetalleV)
                    .addComponent(jBAgregarDetalleV))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBMostarDetalleVenta)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBShowProductos)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jTDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idProducto", "folio", "cantidad", "subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTDetalleVenta);

        jTVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Folio", "Fecha", "Total", "idEmpleado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTVentas);

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("  Ventas");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Folio:");

        jTFolioV.setBackground(new java.awt.Color(255, 255, 255));
        jTFolioV.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Fecha:");

        jTFFecha.setBackground(new java.awt.Color(255, 255, 255));
        jTFFecha.setForeground(new java.awt.Color(0, 0, 0));

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Total:");

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("idEmpleado:");

        jTFIdEmpleado.setBackground(new java.awt.Color(255, 255, 255));
        jTFIdEmpleado.setForeground(new java.awt.Color(0, 0, 0));

        jLTotal.setForeground(new java.awt.Color(0, 0, 0));
        jLTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLTotal.setText("0.00");

        jBAgregarVenta.setText("Agregar");
        jBAgregarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarVentaActionPerformed(evt);
            }
        });

        jBEliminar.setText("Eliminar");

        jBMostrarVentas.setText("Mostrar");
        jBMostrarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBMostrarVentasActionPerformed(evt);
            }
        });

        jBActualizar.setText("Actualizar");
        jBActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBActualizarActionPerformed(evt);
            }
        });

        jButton10.setText("Salir");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Mostrar empleados");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFolioV, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTFIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jBAgregarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jBMostrarVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jBActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTFolioV, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTFFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLTotal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAgregarVenta)
                    .addComponent(jBEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBActualizar)
                    .addComponent(jBMostrarVentas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jButton10)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBMostarDetalleVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMostarDetalleVentaActionPerformed
        this.showVentasODetalleVenta(0);
       
    }//GEN-LAST:event_jBMostarDetalleVentaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jBMostrarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBMostrarVentasActionPerformed

        this.showVentasODetalleVenta(1);
    }//GEN-LAST:event_jBMostrarVentasActionPerformed

    private void jBActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBActualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBActualizarActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
       
        JFShowEmpleados showE = new JFShowEmpleados();
        showE.setVisible(true);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jBShowProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBShowProductosActionPerformed
        JFShowProductos showP = new JFShowProductos();
        showP.setVisible(true);
        
    }//GEN-LAST:event_jBShowProductosActionPerformed

    private void jBAgregarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarVentaActionPerformed
        //Se guardan los datos que se hayan ingresado, todos de tipo string ya que no hay problema solo se van a ocupar para ser insertados
        String folio = this.jTFolioV.getText();
        String fecha = this.jTFFecha.getText();
        String total = this.jLTotal.getText(); //El total lo guardamos como 0.00 ya que aun no se agregan productos a la tabla detalle venta
        String idEmpleado = this.jTFIdEmpleado.getText(); //se guarda erl id del empleado para despues ser buscado
        
        //Se crea la instruccion con sintaxis SQL para hacer la concatenacion con las variables
        String sqlInsertar = "insert into venta values (" + folio + ", '" + fecha + "', " + total + "," + idEmpleado + ");";
        
        //Se hace el sql para la busqueda y corroborar que el id del empleado que estan colocado verdaderamente exista
        String sqlBusqueda = "select idEmpleado from empleado where idEmpleado = " + idEmpleado + ";";
        
        //Se hace le primer TRYCATCH  para el idEmpleado
        try{
            con = conect.getConnection();
            st = con.createStatement();
            rs= st.executeQuery(sqlBusqueda);
            //System.out.println("Se conectó correctamente a BD");
            
            //Evaluacion si contiene alguna columna por lo que le id del empleado si existe
            if(rs.next()){
                // se pregunta si se decea hacer la insercion en la tabla de ventas
                int validacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas insertar este registro?", "Confirmar insersion registro", JOptionPane.YES_NO_OPTION);
                //si el usuario eligio la respuesta YES el sig codigo se va a ejecutar por lo que se va a hacer la insercion en la tabla ventas
                if(validacion == JOptionPane.YES_OPTION) {
                    //se hace el TRYCATCH  para ingresar los datos a la tabla de ventas usando el COMMIT 
                    try{
                        con=conect.getConnection();
                        st=con.createStatement();
                        con.setAutoCommit(false);
                        st.addBatch(sqlInsertar);
                        st.executeBatch();
                        con.commit();
                        con.setAutoCommit(true);
                        //Se manda un mensaje emergente al usario de que la insercion ocurrio de forma correcta
                        JOptionPane.showMessageDialog(null, "Registro exitoso a la base de datos");
                
                        
                    } catch(SQLException e){
                        //Si sucede algun error se muestra
                        System.out.println(" El error es: " + e);
                    }  finally {
                        //Se ocupa este finaly para cerrar de forma correcta todas las conecciones que se tengan con la BD
                        try {
                            if (st != null) st.close();
                            if (con != null) con.close();
                            //Si no se puece cerrar se manda al catch y muyestra el error 
                        } catch (SQLException e) {  System.out.println("Error al cerrar la conexión: " + e); }
                    } 
        
                } else {    System.out.println("Opcion cancelada por el usuario");  }
              
            } else {
                JOptionPane.showMessageDialog(null, "Lo sentimos pero el id del empleado no existe o esta incorrecto");
            }
        }   catch(SQLException e){      System.out.println(" El error es " + e);
        }  finally {
            //cerrar conecciones con la bd
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException e) {      System.out.println("Error al cerrar la conexión " + e);     }
        }
     
       
        
        
        
    }//GEN-LAST:event_jBAgregarVentaActionPerformed

    private void jBAgregarDetalleVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarDetalleVActionPerformed
        int cant;
        
        int idP = Integer.parseInt(this.jTFIdProducto.getText());
        int folio = Integer.parseInt(this.jTFFolio.getText());
        int cantidad = Integer.parseInt(jTCantidad.getText());
        
        //Estructuramos la instruccion sql para agregar el nuevo detalle venta
        String sqlInsertar;
        /*
        Evaluamos 3 cosas:
        1)Si el id del producto existe en la tabla de productos
        2)Si el folio de la venta existe en la tabla venta
        3) si la cantidad colocada es menor a la cantidad existente en la tabla producto
        */
        if(this.buscarProductoYFolio(0, idP, 0) && this.buscarProductoYFolio(1, folio, 0) && this.buscarProductoYFolio(2, idP, cantidad)){
            System.out.println("Todobieeeeeeeeeeeeeeeeeen");
            
            int validacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas insertar este registro?", "Confirmar insersion registro", JOptionPane.YES_NO_OPTION);
            if(validacion == JOptionPane.YES_OPTION) {
                //Calculamos el subtotal con el metodo
                
                float subtotal = this.totalProductoDetalleVenta(idP, cantidad);
                this.jLSubtotal.setText(subtotal + "");
                sqlInsertar = "insert into detallev values(" + idP + "," + folio + "," + cantidad + "," + subtotal + ");";
                try{
                    con=conect.getConnection();
                    st=con.createStatement();
                    con.setAutoCommit(false);
                    st.addBatch(sqlInsertar);
                    st.executeBatch();
                    con.commit();
                    con.setAutoCommit(true);
                    JOptionPane.showMessageDialog(null, "Registro exitoso a la base de datos");
                    
                }catch(SQLException e){
                    System.out.println(" El error es " + e);
                }  finally {
                    try {
                        if (st != null) st.close();
                        if (con != null) con.close();
                    } catch (SQLException e) {  System.out.println("Error al cerrar la conexión: " + e);    }
                } 
        } else {    System.out.println("Opcion cancelada por el usuario");  }
            
            
            
            
            
            
     
        } 
     
    }//GEN-LAST:event_jBAgregarDetalleVActionPerformed

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
            java.util.logging.Logger.getLogger(JFDetalleVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFDetalleVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFDetalleVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFDetalleVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFDetalleVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBActualizar;
    private javax.swing.JButton jBAgregarDetalleV;
    private javax.swing.JButton jBAgregarVenta;
    private javax.swing.JButton jBEliminar;
    private javax.swing.JButton jBEliminarDetalleV;
    private javax.swing.JButton jBMostarDetalleVenta;
    private javax.swing.JButton jBMostrarVentas;
    private javax.swing.JButton jBShowProductos;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLSubtotal;
    private javax.swing.JLabel jLTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTCantidad;
    private javax.swing.JTable jTDetalleVenta;
    private javax.swing.JTextField jTFFecha;
    private javax.swing.JTextField jTFFolio;
    private javax.swing.JTextField jTFIdEmpleado;
    private javax.swing.JTextField jTFIdProducto;
    private javax.swing.JTextField jTFolioV;
    private javax.swing.JTable jTVentas;
    // End of variables declaration//GEN-END:variables
}
