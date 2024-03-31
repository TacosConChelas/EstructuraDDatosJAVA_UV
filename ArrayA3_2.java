import java.util.Scanner;
/*  
    Hernández Ortega Adriel Xel Há   zS22015739
    Programa Java que llene un array con 10 números enteros que se leen por teclado. A continuación calcula y 
    muestra la media de los valores positivos y la de los valores negativos del array.

 */
public class ArrayA3_2 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int[] n = new int[10];
        byte p = 0,  ne = 0, mp = 0, mn = 0;
        System.out.println("Escribe 10 numeros cualquiera");
        for (int i = 0; i < n.length; i++) {
            n[i] = leer.nextInt();
            if (n[i] < 0) {
                ne++; mn += n[i];
            } else if (n[i] > 0) {
                p++; mp += n[i];
            } 
        }
        mp = (byte)(mp / p);    mn = (byte)(mn / ne);
        System.out.println("La media de los numeros positivos es: " + mp);
        System.out.println("La media de los numeros negativos es: " + mn);
        leer.close();
    }
}
