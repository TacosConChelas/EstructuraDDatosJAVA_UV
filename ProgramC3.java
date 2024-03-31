import java.util.Scanner;
/*
 * Hernández Ortega Adriel Xel Há       zS22015739 
 Programa que lea un carácter por teclado y compruebe si es una letra mayúscula
 */
public class ProgramC3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una letra: ");
            char letra = scanner.next().charAt(0);
            
            if (Character.isUpperCase(letra)) {
                //Este metodo Character.isUpperCase() permite idientificar si lo que tiene dentro de los 
                //Parentesis es una letra mayuscula o minuscula
                
                System.out.println("La letra ingresada es mayúscula.");
            } else if (Character.isLowerCase(letra)) {
                System.out.println("La letra ingresada es minuscula.");
            } else {
                System.out.println("El carácter ingresado no es una letra.");
            }
            scanner.close();
    }
}
