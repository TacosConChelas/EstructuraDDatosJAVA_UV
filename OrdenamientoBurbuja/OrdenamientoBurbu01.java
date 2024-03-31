import java.util.*;
/* 
    Adriel Xel Há Hernández Ortega      zS22015739
    Solicite al usuario ingresar un arreglo de 15 números enteros desordenados o e su caso aplique la función de números aleatorios,
    una vez que tenga el arreglo con los números, implemente el algoritmo de ordenamiento de burbuja para ordenar el arreglo en orden
    ascendente. recuerda imprimir ambos arreglos, el desordenado y el ordenado. 
*/
public class OrdenamientoBurbu01 {
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
    public static void main(String[] args) {
        Scanner tacoScanner = new Scanner(System.in);
        int[] numeros = new int[15];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int)(Math.random()*50 + 0);
        }
        System.out.println("Arreglo sin ordenar: \n" + Arrays.toString(numeros));

        ordenaBurbu(numeros);
        tacoScanner.close();
    }
}
