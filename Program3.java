import java.util.Scanner;
/*
 * Escribe un programa Java que lee un número entero por teclado y obtiene y muestra por pantalla el doble y el triple de ese número.
 * Hernández Ortega Adriel Xel Há       zS22015739
 * 
 */
public class Program3 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int a;
        System.out.println("Escribe un numero cualquiera");
        a = leer.nextInt();
        System.out.println("El doble de tu numero es: " + (a * 2) + "\nEl triple de tu numero es " + (a * 3));
        

        leer.close();
    }   
}
