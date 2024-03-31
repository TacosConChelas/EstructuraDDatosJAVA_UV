import java.util.Scanner;
/*
Hernández Ortega Adriel Xel Há       zS22015739 
Programa que lea un número entero y muestre si el número es múltiplo de 10.
Podemos comprobar si un número entero es múltiplo de 10 si al dividirlo por 10 es resto de esta división es cero.
 */
public class ProgramC2 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int n;
        System.out.println("Escribe un numero");
        n = leer.nextInt();
        if ((n % 10) == 0) {
            System.out.println("el numero es multiplo de 10");
        } else {
            System.out.println("el numero no es multiplo de 10");
        }           

        leer.close();
    }
}
