import java.util.Scanner;

/*
 * Hernández Ortega Adriel Xel Há       zS22015739
 * Programa que lee por teclado el valor del radio de una circunferencia y calcula y 
 * muestra por pantalla la longitud y el área de la circunferencia.
 */

public class Program5 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        float r, l;
        System.out.println("Escribe el radio del circulo");
        r = leer.nextFloat();
        l = (float)(Math.PI * r);
        r = (float)(Math.PI * Math.pow(2, r));
        System.out.println("La longitud de tu circunferencia es: " + l + "\nEl area de tu circulo es: " + r);

        leer.close();
    }
}
