import java.util.*;

public class Ordenamiento_Insercion03 {
    public static void resultado(String[] arr, int n) {
        for (int i=1; i<n; i++) {
            String key=arr[i];
            int j=i-1;
            while (j>=0 && arr[j].compareTo(key)>0) {
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.print("Ingresa la cantidad de cadenas: ");
        int n = leer.nextInt();
        leer.nextLine();/*Se coloca despues de leer un numero para asegurar
        que el siguiente nextLine() lea correctamente la entrada de texto */

        String[] arr = new String[n];

        System.out.println("Ingresa las cadenas en texto:");
        for (int i=0; i<n; i++) {
            System.out.print("Cadena "+(i+1)+": ");
            arr[i] = leer.nextLine();
        }
        System.out.println("\nArreglo desordenado: "+Arrays.toString(arr));

        resultado(arr, n);

        System.out.println("Arreglo ordenado:"+Arrays.toString(arr));

        leer.close();
    }
}
