import java.util.*;
/* Integrantes:
    Jiménez Ojeda Jesús Ignacio
    Erick Alexander Monfil Arroyo
    Adriel Xel Há Hernández Ortega
  
    3.- Introduce por teclado, el numero de elementos a ordenar, así como los elementos que estarán en tu arreglo (de forma desordenada),
    implementa el ordenamiento Quicksort, y termina imprimiendo ambos arreglos, el ordenado y el desordenado.
 */
public class Shellsort03 {
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
        Scanner tacoScanner = new Scanner(System.in); 
        int buscar;
        System.out.println("Escribe el tamaño del arreglo");
        buscar = tacoScanner.nextInt();
        int[] arreglo = new int[buscar];
        System.out.println("Ingresa los numeros del arreglo");
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = tacoScanner.nextInt();
        }
        System.out.println("Arreglo desordenado: \n" + Arrays.toString(arreglo));
        ordenarShell(arreglo);
        
        tacoScanner.close();

    }
}
