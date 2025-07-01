/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 * Clase utilitaria para herramientas financieras.
 */
public class HerramientasFinancieras {

    /**
     * Redondea un número decimal a dos decimales.
     * @param valor El número a redondear.
     * @return El número redondeado a dos decimales.
     */
    public static double redondearADosDecimales(double valor) {
        // Multiplica por 100, redondea al entero más cercano, luego divide entre 100.0
        return Math.round(valor * 100.0) / 100.0;
    }
}
