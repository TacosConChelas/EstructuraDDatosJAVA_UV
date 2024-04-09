import java.util.*;
/*Integrantes:
    Jiménez Ojeda Jesús Ignacio
    Erick Alexander Monfil Arroyo
    Adriel Xel Há Hernández Ortega

    2.- Introduce un arreglo de 12 posiciones por teclado, mismo que se solicita imprimir y posteriormente 
    ordenarlo mediante Quiksort. imprime el resultado.
 */
public class Shellsort02 {
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
        Scanner tacoScanner = new Scanner(System.in); int[] arreglo = new int[12];
        System.out.println("Introduce 12 numeros dentro del siguiente arreglo");
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = tacoScanner.nextInt();
        }
        System.out.println("Arreglo desordenado: \n" + Arrays.toString(arreglo));
        ordenarShell(arreglo);
        tacoScanner.close();
    }
}
