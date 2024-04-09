import java.util.*;
/* Integrantes:
    Jiménez Ojeda Jesús Ignacio
    Erick Alexander Monfil Arroyo
    Adriel Xel Há Hernández Ortega

    1.- Dado el siguiente arreglo  [4, 6, 1, 3, 9, 2, 7] , se solicita ordenarlos mediante Shellsort e imprimirlo.
*/
public class Shellsort01 {
    static void ordenarShell(int[] arreglo) {
		int arreglo_size = arreglo.length;
		int brecha = (arreglo_size/2);
		
		while (brecha > 0) { 				
			for (int recorrido=brecha; recorrido < arreglo_size ; recorrido++) { 
				int buffer = arreglo[recorrido];
				int indice = recorrido ;
				while (indice >= brecha && arreglo[indice-brecha] > buffer) { 
					arreglo[indice] = arreglo[indice-brecha];
					indice -= brecha;
				}
				arreglo[indice] = buffer;
			}
			brecha = brecha/2;
		}
        System.out.println("Arreglo ordenado: \n" + Arrays.toString(arreglo));
	}
    public static void main(String[] args) {
        int[] arrelgo = {4, 6, 1, 3, 9, 2, 7};
        System.out.println("Arreglo desordenado: \n" + Arrays.toString(arrelgo));
        ordenarShell(arrelgo);

    }
}
