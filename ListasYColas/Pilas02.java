package ListasYColas;
import java.util.*;

public class Pilas02 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Stack<Integer> pila = new Stack<>();

        System.out.print("Ingrsa un numero decimal: ");
        int num = leer.nextInt();

        while (num > 0 ) {
            int residuo = num % 2;
            pila.push(residuo);
            num = num / 2;
        }

        System.out.print("La representacion binaria es: ");
        while (!pila.isEmpty()) {
            System.out.print(pila.pop());
        }
        System.out.println();

        leer.close();
    }
}
