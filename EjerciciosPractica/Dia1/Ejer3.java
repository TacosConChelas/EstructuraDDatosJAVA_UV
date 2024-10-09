package EjerciciosPractica.Dia1;

import java.util.Scanner;

/**
 * Ejer3
 *  Desarrolla un programa en Java que encuentre el máximo y el mínimo de una lista de números enteros ingresados por el usuario. 
 * El número de elementos en la lista también debe ser proporcionado por el usuario.
 */

public class Ejer3 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in); int mayor = 0, menor = 0;
        System.out.println("Escribe la cantidad de números que vas a ingresar");    
        int cantidad = leer.nextInt();  
        System.out.println("Escribe los números: ");
        for (int i = 0; i < cantidad; i++) {
            int numero = leer.nextInt();
            mayor = (i == 0)? numero : mayor;
            menor = (i == 0)? numero : menor;
            if (numero >= mayor) {
                
                mayor = numero;
            } else if (numero <= menor){
                menor = numero;
            }
        }
        System.out.println("El mayor es: " + mayor + "\nEl menor es: " + menor);

    }
}
