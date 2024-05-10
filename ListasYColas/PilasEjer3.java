package ListasYColas;
import java.util.Stack;
import java.util.Scanner;

public class PilasEjer3 {
    public static void main(String[] args) {
        Stack<Character> pila = new Stack<>();
        Scanner tacoScanner = new Scanner(System.in);
        System.out.println("Ingresa el texto que deces invertir");
        String text = tacoScanner.nextLine();
        char[] textC = text.toCharArray();
        for (int i = textC.length - 1; i >= 0; i--) {
            pila.push(textC[i]);
        }
        System.out.println("Este es el texto ingresado pero al reves: \n" + pila);
    }
}
