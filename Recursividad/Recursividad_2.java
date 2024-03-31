import java.util.Scanner;
/*
    Hernández Ortega Adriel Xel Há      zS22015739
    Factorial de un numero
 */
public class Recursividad_2 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int n, t = 1;
        System.out.println("Escribe el numero al que quieras sacar su factorial");
        n = leer.nextInt();
        for (int i = 1; i <= n; i++) {
            t *= i;
        }
        System.out.println("El resultado es: " + t);
        leer.close();
    }
}
