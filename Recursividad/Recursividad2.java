import java.util.Scanner;

public class Recursividad2 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("escribe el numero");
        int n = leer.nextInt();
        for (int i = 1; i <= n; i++) {
            n *= i;
        }
        System.out.println("El factorial es " + n);
        leer.close();
    }
}
