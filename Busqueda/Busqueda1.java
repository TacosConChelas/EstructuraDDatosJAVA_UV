import java.util.Scanner;
/*
    Adriel Xel Há Hernández Ortega      zS22015739
*/
public class Busqueda1 {
    public static void busquedaN(int busqueda, int[] a){
        int resultado = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == busqueda) {
                resultado = a[i]; System.out.println("numero encontrado " + resultado + " en la posicion " + i);
            }
        }
        if (resultado != busqueda) {
            System.out.println("numero no encontrado");
        }
    }
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int[] b = new int[10];
        System.out.println("Escribe 10 numeros");
        for ( int i = 0; i < b.length; i++) {
            b[i] = leer.nextInt();
        }
        System.out.println("Escribe el numero que decees buscar dentro de larreglo");
        int busqueda = leer.nextInt();
        busquedaN(busqueda, b);

        leer.close();
        
    }
}
