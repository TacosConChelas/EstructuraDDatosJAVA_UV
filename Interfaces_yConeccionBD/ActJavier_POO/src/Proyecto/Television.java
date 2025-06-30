/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

/**
 *
 * @author tacosconchelas
 */
public class Television extends Producto {
    public Object[] tele;
    
    private double pulgadasTelevision;
    private String tipoPantalla;
    private int numPuertosHDMI;
    private int numPuertosUSB;
    

    public Television() {
        super();
    }

    public Television(double descuento) {
        super(descuento);
    }
    public boolean guardarProducto(Television s){
        
        if (s instanceof Television) {
            // Empaquetar datos en Object[]
            Television c = (Television) s;
            Object[] datos = new Object[]{
                c.getIdProducto(),
                c.getNombreProducto(),
                c.getMarcaProducto(),
                c.getPrecioProductoBase(),
                c.getCantidadExistencia(),
                c.getDescuentoProducto(),
                c.getPulgadasTelevision(),
                c.getTipoPantalla(),
                c.getNumPuertosHDMI(),
                c.getNumPuertosUSB()
               
            };
            return Television_OAD.guardarTabla(datos);
        }
        return false;
    }

    

    @Override
    public double getPrecioProducto() {
        return this.precio * 1.16;
    }

    public double getPrecioProductoPadre() {
        return super.getPrecioProducto();
    }

    // Getters y setters
    public double getPulgadasTelevision() {
        return pulgadasTelevision;
    }

    public void setPulgadasTelevision(double pulgadasTelevision) {
        this.pulgadasTelevision = pulgadasTelevision;
    }

    public String getTipoPantalla() {
        return tipoPantalla;
    }

    public void setTipoPantalla(String tipoPantalla) {
        this.tipoPantalla = tipoPantalla;
    }

    public int getNumPuertosHDMI() {
        return numPuertosHDMI;
    }

    public void setNumPuertosHDMI(int numPuertosHDMI) {
        this.numPuertosHDMI = numPuertosHDMI;
    }

    public int getNumPuertosUSB() {
        return numPuertosUSB;
    }

    public void setNumPuertosUSB(int numPuertosUSB) {
        this.numPuertosUSB = numPuertosUSB;
    }

    @Override
    public boolean guardarProducto(Producto p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
