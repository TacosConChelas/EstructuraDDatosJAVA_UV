import java.util.*;
/*  Integrantes:
    Jiménez Ojeda Jesús Ignacio​
    Erick Alexander Monfil Arroyo
    Adriel Xel Há Hernández Ortega
    Introduce por teclado, el numero de elementos a ordenar, así como los elementos que estarán en tu arreglo (de forma desordenada), 
    2.- Introduce un arreglo de 10 posiciones por teclado, mismo que se solicita imprimir y posteriormente ordenarlo mediante Quiksort. imprime el resultado.
*/
public class Quicksort02 {
    static int ordenarSeccion(int arr[], int indiceIzq, int indiceDer) {
		int pivote = arr[indiceDer]; 
		int elemento = (indiceIzq - 1);
		for (int indice = indiceIzq; indice < indiceDer; indice++) {
			if (arr[indice] < pivote) {
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

        
        ordenar(nums, 0, (nums.length - 1));
        System.out.println("Arreglo ordenado: " + Arrays.toString(nums));
        leeScanner.close();
    }
}
