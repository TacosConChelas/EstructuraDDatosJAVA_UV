package EjerciciosPractica.Dia1;

import java.util.Scanner;

/**
 * Ejer2
 * Escribe un programa en Java que solicite al usuario ingresar una serie de números enteros y calcule 
 * la suma y el promedio de esos números. El programa debe permitir al usuario finalizar la entrada de 
 * números ingresando un número negativo.
 */
public class Ejer2 {
    public static void main(String[] args) {
        float suma = 0; int contador = 0; boolean condition = true;
        
        Scanner leer = new Scanner(System.in);
        System.out.println("Deberas ingresar números, al final se va a calcular: \nEl total de la suma \nEl promedio ");
        System.out.println("Pero todo terminará cuando sea ingresado un número negativo");
        while (condition) { int num = leer.nextInt();   if (num < 0) {  condition = false;    } else {  suma += num; contador++;}  }
        System.out.println("La suma es: " + suma + "\nEl promedio es: " + (suma / contador));
        leer.close();
    }
}