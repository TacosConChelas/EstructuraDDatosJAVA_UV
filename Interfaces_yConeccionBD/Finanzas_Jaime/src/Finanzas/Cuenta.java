/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Finanzas;

/**
 *
 * @author tacosconchelas
 */
public class Cuenta {
    private Integer id;
    private String nombreCuenta;
    private double[] valoresDeLosAnios; // Tamaño 3

    public Cuenta(Integer id, String nombreCuenta, double[] valoresDeLosAnios) {
        this.id = id;
        this.nombreCuenta = nombreCuenta;
        if (valoresDeLosAnios.length == 3) {
            this.valoresDeLosAnios = valoresDeLosAnios;
        } else {
            throw new IllegalArgumentException("El arreglo debe tener exactamente 3 valores.");
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCuenta() {
        return nombreCuenta;
    }

    public double[] getValoresDeLosAnios() {
        return valoresDeLosAnios;
    }

    public void setValoresDeLosAnios(double[] nuevosValores) {
        if (nuevosValores.length == 3) {
            this.valoresDeLosAnios = nuevosValores;
        } else {
            throw new IllegalArgumentException("El arreglo debe tener exactamente 3 valores.");
        }
    }

    @Override
    public String toString() {
        return "Cuenta [id=" + id + ", nombre=" + nombreCuenta +
               ", valores=" + valoresDeLosAnios[0] + ", " + valoresDeLosAnios[1] + ", " + valoresDeLosAnios[2] + "]";
    }
}

