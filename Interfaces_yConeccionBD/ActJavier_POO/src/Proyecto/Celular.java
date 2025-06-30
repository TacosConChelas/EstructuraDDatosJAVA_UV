/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;


import Proyecto.Producto;

public class Celular extends Producto {

    private double camaraPrincipal;
    private double camaraFrontal;
    private double memoriaRAM;
    private double almacenamientoGB;

    public Celular() {
        super();
    }

    public Celular(double descuento) {
        super(descuento);
    }

    @Override
    public boolean guardarProducto(Producto p) {
        if (p instanceof Celular) {
            // Empaquetar datos en Object[]
            Celular c = (Celular) p;
            Object[] datos = new Object[]{
                c.getIdProducto(),
                c.getNombreProducto(),
                c.getMarcaProducto(),
                c.getPrecioProductoBase(),
                c.getCantidadExistencia(),
                c.getDescuentoProducto(),
                c.getCamaraPrincipal(),
                c.getCamaraFrontal(),
                c.getMemoriaRAM(),
                c.getAlmacenamientoGB()
            };
            return Celular_OAD.guardarTabla(datos);
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

    // Getters y Setters

    public double getCamaraPrincipal() {
        return camaraPrincipal;
    }

    public void setCamaraPrincipal(double camaraPrincipal) {
        this.camaraPrincipal = camaraPrincipal;
    }

    public double getCamaraFrontal() {
        return camaraFrontal;
    }

    public void setCamaraFrontal(double camaraFrontal) {
        this.camaraFrontal = camaraFrontal;
    }

    public double getMemoriaRAM() {
        return memoriaRAM;
    }

    public void setMemoriaRAM(double memoriaRAM) {
        this.memoriaRAM = memoriaRAM;
    }

    public double getAlmacenamientoGB() {
        return almacenamientoGB;
    }

    public void setAlmacenamientoGB(double almacenamientoGB) {
        this.almacenamientoGB = almacenamientoGB;
    }
}

