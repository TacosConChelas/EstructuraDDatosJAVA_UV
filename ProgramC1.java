import java.util.Scanner;
/*
 * * Hernández Ortega Adriel Xel Há       zS22015739
    Programa Java que lea un número entero por teclado y calcule si es par o impar.
Podemos saber si un número es par si el resto de dividir el número entre 2 es igual a cero. En caso contrario el número es impar
El operador Java que calcula el resto de la división entre dos números enteros o no es el operador %.
 */
public class ProgramC1 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int n;
        System.out.println("Escribe un numero");
        n = leer.nextInt();
        if ((n % 2) == 0) {
            System.out.println("El numeor es par");
        } else {
            System.out.println("El numeor es impar");
        }
        leer.close();
    }
}
