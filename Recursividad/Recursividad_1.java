import java.util.Scanner;

/*
Hernández Ortega Adriel Xel Há      zS22015739
    Sumar los números números naturales hasta N (ingresados por teclado) de forma recursiva.
 */
public class Recursividad_1 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int n, t = 0;
        System.out.println("Escribe un numero (se sumaran todos los números desde le numero que elegiste hasta 1)");
        n = leer.nextInt(); 
        for (int i = 1; i <= n; i++) {
            t += i;
        }
        System.out.println("El resultado es: " + t);
        leer.close();
    }
}
