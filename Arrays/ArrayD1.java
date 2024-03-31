import java.util.Scanner;
public class ArrayD1 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int[] a = new int[4];
        System.out.println("EScribe 4 numeros a tu eleccion");
        for (int i = 0; i < a.length; i++) {
            a[i] = leer.nextInt();
        }
        System.out.println("Estos son los numeros que ingresaste");
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        leer.close();
    }
}