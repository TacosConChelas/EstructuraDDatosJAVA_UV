/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javier_poo2;

import java.util.Date;

/**
 *
 
 */
public class Empleado {

    // Atributos privados (encapsulados)
    private int idEmpleado;
    private String nombre;
    private Date fechaNacimiento;
    private String genero;
    private String correo;
    private double salario;
    private String puesto;
    private String funciones;
    private Date fechaContratacion;
    private String gradoEstudios;

    // Constructor que recibe todos los atributos
    public Empleado(int idEmpleado, String nombre, Date fechaNacimiento, String genero, String correo,
                    double salario, String puesto, String funciones, Date fechaContratacion, String gradoEstudios) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.correo = correo;
        this.salario = salario;
        this.puesto = puesto;
        this.funciones = funciones;
        this.fechaContratacion = fechaContratacion;
        this.gradoEstudios = gradoEstudios;
    }

    // Getters y Setters
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getFunciones() {
        return funciones;
    }

    public void setFunciones(String funciones) {
        this.funciones = funciones;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getGradoEstudios() {
        return gradoEstudios;
    }

    public void setGradoEstudios(String gradoEstudios) {
        this.gradoEstudios = gradoEstudios;
    }
}

