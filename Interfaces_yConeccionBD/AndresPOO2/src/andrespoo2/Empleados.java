/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package andrespoo2;

import java.sql.Date;
/**
 *
 * @author tacosconchelas
 */
public class Empleados {

    // Atributos privados renombrados
    private int codigoEmpleado;
    private String nombres;
    private Date nacimiento;
    private String sexo;
    private String email;
    private double sueldo;
    private String cargo;
    private String responsabilidades;
    private Date ingreso;
    private String nivelAcademico;

    // Constructor con todos los campos
    public Empleados(int codigoEmpleado, String nombres, Date nacimiento, String sexo, String email,
                     double sueldo, String cargo, String responsabilidades, Date ingreso, String nivelAcademico) {
        this.codigoEmpleado = codigoEmpleado;
        this.nombres = nombres;
        this.nacimiento = nacimiento;
        this.sexo = sexo;
        this.email = email;
        this.sueldo = sueldo;
        this.cargo = cargo;
        this.responsabilidades = responsabilidades;
        this.ingreso = ingreso;
        this.nivelAcademico = nivelAcademico;
    }

    // Getters y Setters renombrados

    public int getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(int codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getResponsabilidades() {
        return responsabilidades;
    }

    public void setResponsabilidades(String responsabilidades) {
        this.responsabilidades = responsabilidades;
    }

    public Date getIngreso() {
        return ingreso;
    }

    public void setIngreso(Date ingreso) {
        this.ingreso = ingreso;
    }

    public String getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(String nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }
}
