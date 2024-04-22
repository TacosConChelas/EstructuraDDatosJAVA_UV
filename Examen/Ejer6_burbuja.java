import java.util.*;
/* 
 Ejercicio 4 (burbuja)
 Hernández Ortega Adriel Xel Há
*/
public class Ejer6_burbuja {
    public static void ordenaBurbu(int[] nums){
        for (int recorrido = 0; recorrido < nums.length; recorrido++) {
            for (int indice = 0; indice < nums.length - 1; indice++){
                if (nums[indice] > nums[indice + 1]) {
                    int buffer = nums[indice];
                    nums[indice] = nums[indice + 1];
                    nums[indice + 1] = buffer;              
                }
            }      
        } System.out.println("Arreglo ordenado: " + Arrays.toString(nums));
    }  
    public static void binario(int[] data, int b){
        int inicio = 0, f = data.length, m = 0;
        while (inicio <= f) {
            m = (f - inicio) / 2 + inicio; //al principio m vale 10
            if (data[m] < b) {
                inicio = m + 1;
                if (inicio > f) {
                    System.out.println("tu numero no se ha encontrado");    break;
                }
            } else if (data[m] > b) {
                f = m -1;
                if (inicio > f) {
                    System.out.println("tu numero no se ha encontrado");    break;
                }
            } else {
                System.out.println("tu numero esta en esta posicion: " + m);
                break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int[] nums = new int[10]; int buscar;
        System.out.println("Escribe 10 numeros enteros para ingresarlos dentro del arreglo");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = leer.nextInt();
        }
        System.out.println("Arreglo desordenado: \n" + Arrays.toString(nums));
        ordenaBurbu(nums);
        System.out.println("ingresa un numero que quieras encontrar dentro del arreglo");
        buscar = leer.nextInt();
        binario(nums, buscar);

        leer.close();

    }
    
}