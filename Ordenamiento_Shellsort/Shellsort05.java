import java.util.*;
/* Integrantes:
    Jiménez Ojeda Jesús Ignacio
    Erick Alexander Monfil Arroyo
    Adriel Xel Há Hernández Ortega

    5.- Una vez ordenado tu arreglo del ejercicio 3, realiza una búsqueda binaria, ubicando el elemento mayor.
*/
public class Shellsort05 {
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
    public static void busquedaBinaria(int[] data, int b){
        int inicio = 0, f = data.length, m = 0;
        while (inicio <= f) {
            m = (f - inicio) / 2 + inicio; //al principio m vale 10
            if (data[m] < b) {
                inicio = m + 1;
                if (inicio > f) {
                    System.out.println("tu numero no se ha encontrado");
                    break;
                }
            } else if (data[m] > b) {
                f = m -1;
                if (inicio > f) {
                    System.out.println("tu numero no se ha encontrado");
                    break;
                }
            } else {
                System.out.println("tu numero esta en esta posicion: " + m);
                break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner tScanner = new Scanner(System.in); 
        int numero, mayor;
        System.out.println("Escribe el tamaño del arreglo");
        numero = tScanner.nextInt();
        int[] arreglo = new int[numero];
        System.out.println("Ingresa los numeros del arreglo");
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = tScanner.nextInt();
        }
        System.out.println("Arreglo desordenado: \n" + Arrays.toString(arreglo));
        ordenarShell(arreglo);
        
        mayor = arreglo[arreglo.length - 1];
        System.out.println("Ahora buscamos el numero mayor");
        busquedaBinaria(arreglo, mayor);
        
        tScanner.close();
    }
}
