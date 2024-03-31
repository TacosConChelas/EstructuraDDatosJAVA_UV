import java.util.Scanner;
/*
    * Hernández Ortega Adriel Xel Há       zS22015739     
Programa que lea dos caracteres y compruebe si son iguales.
 */
public class ProgramsC4 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        char a;
        char b;
        System.out.println("Escribe el primer caracter");
        a = leer.next().charAt(0);
        System.out.println("Escribe el segundo caracter");
        b = leer.next().charAt(0);
        if (a == b) {
            System.out.println("Son iguales");
        } else {
            System.out.println("No son iguales");
        }

        leer.close();
    }
}
