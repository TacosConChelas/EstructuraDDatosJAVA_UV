import java.util.Scanner;
/*
 * Hernández Ortega Adriel Xel Há       zS22015739

Programa que lea una cantidad de grados centígrados y la pase a grados Fahrenheit.
 La fórmula correspondiente para pasar de grados centígrados a fahrenheit es: F = 32 + ( 9 * C / 5)
 * 
 */

public class Program4 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        float g; 
        System.out.println("Escribe la temperatura en grados centigrados");
        g = leer.nextFloat();
        g = (float)( 32 + 9 * (g / 5));
        System.out.println("La temperatura que ingresante en grados Fahrenheit es " + g);

        leer.close();
    }
}
