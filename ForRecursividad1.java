import java.util.Scanner;

public class ForRecursividad1 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Escribe el numero al que quieras obtener su factorial");
        int n = leer.nextInt(); int a = n;
        for (int i = 1; i <= n; ++i) {
            n *= i;
        }
        System.out.println("el factorial de " + a + " es " + n);



        leer.close();
    }
}
