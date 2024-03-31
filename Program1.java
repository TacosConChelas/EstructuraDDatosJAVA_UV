/**
 * Hernández Ortega Adriel Xel Há       zS22015739
    Programa Java que lea dos números enteros por teclado y los muestre por pantalla
 */
import java.util.Scanner;
public class Program1 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int a, b;
        System.out.println("Escribe el primer numero");
        a = leer.nextInt();
        System.out.println("Escribe el segundo numero");
        b = leer.nextInt();
        System.out.println("Estos son los numeros que esribiste: " + a + " y " + b);

        leer.close();

    }
    
}