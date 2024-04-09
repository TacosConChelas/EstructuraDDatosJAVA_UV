import java.util.*;
/* Integrantes:
    Jiménez Ojeda Jesús Ignacio
    Erick Alexander Monfil Arroyo
    Adriel Xel Há Hernández Ortega
  
    4.- Una vez que está ordenado tu arreglo de 12 posiciones, realiza una búsqueda binaria, 
    ubicando el elemento que el usuario solicite. 
 */
public class Shellsort04 {
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
        Scanner tacoScanner = new Scanner(System.in); 
        int[] arreglo = new int[12]; int buscar;
        System.out.println("Introduce 12 numeros para el arreglo");
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = tacoScanner.nextInt();
        }
        System.out.println("Arreglo desordenado: \n" + Arrays.toString(arreglo));
        ordenarShell(arreglo);
        System.out.println("Ingresa el numero que decees buscar");
        buscar = tacoScanner.nextInt();

        busquedaBinaria(arreglo, buscar);
        tacoScanner.close();
    }
}
