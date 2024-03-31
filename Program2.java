import java.util.Scanner;
/*
    Hernández Ortega Adriel Xel Há       zS22015739
    Programa Java que lea un nombre y muestre por pantalla: Buenos dias nombre_introducido
 */
public class Program2 {
    public static void main(String[] args) {
        String name;
        Scanner leer = new Scanner(System.in);
        System.out.println("Escribe tu nombre");
        name = leer.nextLine();
        System.out.println("Buenos dias " + name);
        leer.close();
    }
    
}
