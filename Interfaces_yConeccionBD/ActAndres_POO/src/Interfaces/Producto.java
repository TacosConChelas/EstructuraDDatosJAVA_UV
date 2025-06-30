/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

public abstract class Producto {

    // Atributos comunes protegidos
    protected int idProducto;
    protected String nombreProducto;
    protected String marcaProducto;
    protected int cantidadExistencia;
    protected double precioProducto;
    protected double descuentoProducto;

    // Constructor sin descuento
    public Producto() {
        this.descuentoProducto = 0.0;
    }

    // Constructor con descuento
    public Producto(double descuento) {
        this.descuentoProducto = descuento;
    }

    // Método abstracto que debe implementar cada subclase
    public abstract boolean guardarProducto(Producto p);

    // Método que devuelve el precio base (sin IVA ni modificaciones)
    public double getPrecioProducto() {
        return this.precioProducto;
    }

    // Getters y Setters
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getMarcaProducto() {
        return marcaProducto;
    }

    public void setMarcaProducto(String marcaProducto) {
        this.marcaProducto = marcaProducto;
    }

    public int getCantidadExistencia() {
        return cantidadExistencia;
    }

    public void setCantidadExistencia(int cantidadExistencia) {
        this.cantidadExistencia = cantidadExistencia;
    }

    public double getPrecioProductoBase() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public double getDescuentoProducto() {
        return descuentoProducto;
    }

    public void setDescuentoProducto(double descuentoProducto) {
        this.descuentoProducto = descuentoProducto;
    }
}
