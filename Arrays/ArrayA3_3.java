import java.util.Scanner;
/*
 * Hernández Ortega Adriel Xel Há   zS22015739
    Programa Java para leer la altura de N personas y calcular la altura media. Calcular cuántas personas tienen una altura 
    superior a la media y cuántas tienen una altura inferior a la media. El valor de N se pide 
    por teclado y debe ser entero positivo
 */
public class ArrayA3_3 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int n, s = 0, in = 0; float mt = 0;
        System.out.println("Escribe la cantidad de personas que deceas ingresar su altura");
        n = leer.nextInt();
        int[] p = new int[n];
        System.out.println("Escribe cada una de las altura");
        for (int i = 0; i < p.length; i++) {
            p[i] = leer.nextInt();      mt += p[i]; 
        }
        mt = (float)(mt / n);
        for (int i = 0; i < p.length; i++) {
            if (p[i] > mt) {
                s++;
            } else if (p[i] < mt){
                in++;
            }
        }
        System.out.println("La media total fue de: " + mt);
        System.out.println("La cantidad de personas que superaron a la media total fue de: " + s);
        System.out.println("La cantidad de personas que estaban por debajo de la media total fue de: " + in);
        leer.close();
    }
}
