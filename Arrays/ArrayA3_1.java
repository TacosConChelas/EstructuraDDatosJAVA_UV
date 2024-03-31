import java.util.Scanner;
/*
 * Hernández Ortega Adriel Xel Há   zS22015739
  Programa Java que guarda en un array 10 números enteros que se leen por teclado. A continuación se
recorre el array y calcula cuántos números son positivos, cuántos negativos y cuántos ceros. 
 */
public class ArrayA3_1 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int[] n = new int[10];
        byte p = 0,  ne = 0, c = 0;
        System.out.println("Escribe 10 numeros cualquiera");
        for (int i = 0; i < n.length; i++) {
            n[i] = leer.nextInt();
        }
        for (int i = 0; i < n.length; i++) {
            if (n[i] < 0) {
                ne++;
            } else if (n[i] > 0) {
                p++;
            } else {
                c++;
            } 
        }
        System.out.println("Cantidad de numeros positivos: " + p + "\nCantidad de numeros negativos: "+ ne);
        System.out.println("Cantidad de numeros iguales a cero: " + c);
        leer.close();
    }    
}
