import java.util.Arrays;
/*
 * Ejercicio 4 (burbuja)
 Hernández Ortega Adriel Xel Há
 */
public class Ejer2_InvertirArreglo {
    public static void invertir_arreglo(int[] nums, int inicio, int fina){
        if (inicio > fina) {
            System.out.println("El arrego invertido: \n" + Arrays.toString(nums));
            //final de la recursividad
        } else {
            int cambio = nums[fina];
            nums[fina] = nums[inicio];
            nums[inicio] = cambio;
            invertir_arreglo(nums, (inicio + 1), (fina - 1));
        }
    }
    public static void main(String[] args) {
        int[] arreglo1 = {3, 7, 9, 20, 2, 8, 1};
        int[] arreglo2 = {1, 2, 3, 4, 5, 6};
        int[] arreglo3 = {6, 7, 8, 9, 10, 11};
        invertir_arreglo(arreglo1, 0, (arreglo1.length - 1));
        /*
         inicio     final
         0          5
         1          4
         2          3
         3          4
         */
    }
}
