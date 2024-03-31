import java.util.*;

public class OrdenamientoInser04 {
    public static void resultado(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                arr[index++] = arr[i];
            }
        }
        int nuevoArr = index;
        for (int i = nuevoArr; i < n; i++) {
            arr[i] = 0;
        }
    }

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);

        System.out.print("Ingresa la cantidad de cadenas: ");
        int n = leer.nextInt();

        int[] arr = new int[n];

        System.out.println("Ingresa las cadenas en enteros:");
        for (int i = 0; i < n; i++) {
            System.out.print("Cadena " + (i + 1) + ": ");
            arr[i] = leer.nextInt();
        }
        System.out.println("\nArreglo con repetidos: " + Arrays.toString(arr));

        resultado(arr, n);

        System.out.print("Arreglo sin repetidos: [");
        boolean first = true;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                if (!first) {
                    System.out.print(", ");
                }
                System.out.print(arr[i]);
                first = false;
            }
        }
        System.out.println("]");

        leer.close();
    }
}
