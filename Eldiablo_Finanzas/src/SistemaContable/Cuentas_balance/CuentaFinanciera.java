package SistemaContable.Cuentas_balance;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Arrays;

/**
 * Representa una cuenta financiera individual dentro del balance.
 * Cada cuenta tiene un nombre único y un arreglo de 4 valores numéricos
 * correspondientes a los años analizados.
 */
public class CuentaFinanciera {
    // Nombre de la cuenta (identificador único, no puede repetirse en el gestor)
    private String nombre;

    // Arreglo de tamaño fijo que contiene los valores financieros por año
    // valoresAnuales[0] = Año 1, valoresAnuales[1] = Año 2, etc.
    private double[] valoresAnuales;

    /**
     * Constructor que inicializa la cuenta con un nombre y sus 4 valores anuales.
     * @param nombre Nombre de la cuenta (clave única).
     * @param valores Vector de 4 valores financieros (uno por año).
     * @throws IllegalArgumentException si el arreglo no tiene exactamente 4 elementos.
     */
    public CuentaFinanciera(String nombre, double[] valores) {
        if (valores == null || valores.length != 4) {
            throw new IllegalArgumentException("La cuenta debe tener exactamente 4 valores anuales.");
        }
        this.nombre = nombre;
        this.valoresAnuales = Arrays.copyOf(valores, 4); // copia defensiva
    }

    // Getter del nombre de la cuenta
    public String getNombre() {
        return nombre;
    }

    // Setter del nombre (poco usado, ya que el nombre es la clave de identificación)
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para el arreglo completo de valores
    public double[] getValoresAnuales() {
        return Arrays.copyOf(valoresAnuales, 4);
    }

    // Setter para el arreglo completo de valores (debe tener 4 elementos)
    public void setValoresAnuales(double[] nuevosValores) {
        if (nuevosValores == null || nuevosValores.length != 4) {
            throw new IllegalArgumentException("Se requieren exactamente 4 valores anuales.");
        }
        this.valoresAnuales = Arrays.copyOf(nuevosValores, 4);
    }

    // Actualiza el valor de un año específico (0 = Año 1, 3 = Año 4)
    public void actualizarValorAnual(int indice, double nuevoValor) {
        if (indice >= 0 && indice < 4) {
            this.valoresAnuales[indice] = nuevoValor;
        }
    }

    // Retorna el valor correspondiente a un año (por índice)
    public double obtenerValorAnual(int indice) {
        if (indice >= 0 && indice < 4) {
            return valoresAnuales[indice];
        }
        return 0.0; // o lanzar excepción según la lógica del sistema
    }
}
