/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto;

public abstract class Producto {

    // Atributos comunes protegidos
    protected int clave;
    protected String nombre;
    protected String marca;
    protected int cantidad;
    protected double precio;
    protected double descuento;


    public Producto() {
        this.descuento = 0;
    }


    public Producto(double descuento) {
        this.descuento = descuento;
    }

    public abstract boolean guardarProducto(Producto p);


    public double getPrecioProducto() {
        return this.precio;
    }
    public double getPrecioProductoBase() {
        return precio;
    }
    public int getIdProducto() {
        return clave;
    }

    public void setIdProducto(int clave) {
        this.clave = clave;
    }

    public String getNombreProducto() {
        return nombre;
    }

    public void setNombreProducto(String nombre) {
        this.nombre = nombre;
    }

    public String getMarcaProducto() {
        return marca;
    }

    public void setMarcaProducto(String marca) {
        this.marca = marca;
    }

    public int getCantidadExistencia() {
        return cantidad;
    }

    public void setCantidadExistencia(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioProducto(double precio) {
        this.precio = precio;
    }

    public double getDescuentoProducto() {
        return descuento;
    }

    public void setDescuentoProducto(double descuento) {
        this.descuento = descuento;
    }
}
