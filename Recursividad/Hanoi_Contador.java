import java.util.Scanner;
/*
    Hernández Ortega Adriel Xel Há      zS22015739
    Se trata de realizar una modificación del método Torres de Hanoi. Escribe un método 
    recursivo que calcule el número de movimientos necesarios para mover n discos de la 
    torre origen a la torre destino.
*/
public class Hanoi_Contador {
    public static int hanoi(int n, int origen, int auxiliar, int destino) {
        if(n == 1){
            System.out.println("Mover disco de " + origen + " a " + destino);
            return 1;
        } else {
            int m1 = hanoi(n - 1, origen, destino, auxiliar);
            System.out.println("Mover disco de " + origen + " a " + destino);
            int m2 = hanoi(n - 1, auxiliar, origen, destino);
            return 1 + m1 + m2;
        }
    }
    public static void main(String [] args ){
        Scanner leer = new Scanner(System.in);
        int n;
        System.out.println("Número de discos:");
        n = leer.nextInt();
        int movimientos = hanoi(n, 1, 2, 3);
        System.out.println("Número de movimientos necesarios: " + movimientos);

        leer.close();
    }
}
