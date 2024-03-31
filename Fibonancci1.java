import java.util.Scanner;
/*
     Hernández Ortega Adriel Xel Há      zS22015739
 */
public class Fibonancci1 {
    public static long fibonacci(long posicion){
        long siguiente = 1, actual = 0, temporal = 0;
        for (int i = 1; i <= posicion; i++) {
            System.out.println(actual + ", ");
            temporal = actual;
            actual = siguiente;
            siguiente += temporal;
        }
        System.out.println(actual);
        return actual;
    }
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Escribe la posición en la suceción asta la que quieres que llegue");
        long a = leer.nextInt();
        long ultnum = fibonacci(a);
    }
}
