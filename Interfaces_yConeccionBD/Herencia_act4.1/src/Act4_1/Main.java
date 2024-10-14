/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act4_1;

import java.util.Scanner;

/**
 *
 * @author TheOneAboveAll
 */
public class Main {
    public static void main(String[] args){
        Scanner leer = new Scanner (System.in);
        CuentaAhorros cuentaAhorro = new CuentaAhorros((float) 30000.0, (float) 3.4);
        
        cuentaAhorro.imprimir();
        
        CuentaCorriente cuentaCorriente = new CuentaCorriente((float) 10000, (float) 3.4);
        
        cuentaCorriente.imprimir();
        
        
    }
     
}
