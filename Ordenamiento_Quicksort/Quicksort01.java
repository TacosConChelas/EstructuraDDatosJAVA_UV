import java.util.*;
/*  Integrates:
    Jiménez Ojeda Jesús Ignacio​
    Erick Alexander Monfil Arroyo
    Adriel Xel Há Hernández Ortega
    1 - Dado el siguiente arreglo arre [4, 6, 1, 3, 9, 2, 7] , se solicita ordenarlos mediante Quicksort e imprimirlo.
 */
public class Quicksort01 {
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
		int[] num = {4, 6, 1, 3, 9, 2, 7};
		ordenar(num, 0, (num.length - 1));
		System.out.println("Arreglo ordenado: " + Arrays.toString(num));
    }
}
