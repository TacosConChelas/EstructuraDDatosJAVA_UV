import java.util.Scanner;
/*
    Hernández Ortega Adriel Xel Há      zS22015739
 */
public class Fibonacci2 {
    public static long fibonacci(long posicion){
        if(posicion < 2){
            return posicion;
        }
        return fibonacci(posicion - 1) + fibonacci(posicion - 2);

    }
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Escribe la posicion dle numero que deceas conocer");
        long a = leer.nextLong();
        System.out.println(fibonacci(a));

    }
}
