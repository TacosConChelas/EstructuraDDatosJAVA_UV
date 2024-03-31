import java.util.Scanner;

public class Recursividad_6 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
    
        System.out.println("Escribe la palabra que quieras invertir");
        String p = leer.nextLine();
        char[] palabra = p.toCharArray();
        char[] p2 = new char[palabra.length];
        for (int i = 0; i < palabra.length; i++) {
            p2[p2.length - i -1] = palabra[i];
        }
        for (int i = 0; i < p2.length; i++) {
            System.out.println(p2[i]);
        }
        leer.close();
    }
}
