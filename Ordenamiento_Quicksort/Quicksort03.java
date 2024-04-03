import java.util.*;
/*  Integrantes:
    Jiménez Ojeda Jesús Ignacio​
    Erick Alexander Monfil Arroyo
    Adriel Xel Há Hernández Ortega
    Introduce por teclado, el numero de elementos a ordenar, así como los elementos que estarán en tu arreglo (de forma desordenada), 
    implementa el ordenamiento Quicksort, y termina imprimiendo ambos arreglos, el ordenado y el desordenado.
*/
public class Quicksort03 {
    static int ordenarSeccion(int arr[], int indiceIzq, int indiceDer) {
		int pivote = arr[indiceDer]; //Decisión del programador
		int elemento = (indiceIzq - 1);
		for (int indice = indiceIzq; indice < indiceDer; indice++) {
			if (arr[indice] < pivote) { //Intercambio
				elemento++;				
				int buffer = arr[elemento];
				arr[elemento] = arr[indice];
				arr[indice] = buffer;
			}
		}
		elemento++;
		int buffer = arr[elemento];
		arr[elemento] = arr[indiceDer];
		arr[indiceDer] = buffer;

		return elemento;
	}
    public static void ordenar(int arr[], int indiceIzq, int indiceDer) {
		if (indiceIzq < indiceDer) {
			int inicio = ordenarSeccion(arr, indiceIzq, indiceDer);
			ordenar(arr, indiceIzq, inicio - 1);
			ordenar(arr, inicio + 1, indiceDer);
		}
	}
    public static void main(String[] args) {
        Scanner leeScanner = new Scanner(System.in);
        System.out.println("Escribe la cantidad de numeros que vas a ingresar");
        int n = leeScanner.nextInt();
        int[] nums = new int[n];
        System.out.println("Escribe los numeros");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = leeScanner.nextInt();
        }

        System.out.println("Arreglo original: " + Arrays.toString(nums));
        ordenar(nums, 0, (nums.length - 1));
        System.out.println("Arreglo ordenado: " + Arrays.toString(nums));
        leeScanner.close();
    }
}