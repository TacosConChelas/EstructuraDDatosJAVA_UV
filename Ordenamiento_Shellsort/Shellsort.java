import java.util.*;

public class Shellsort {
    static void ordenarShell(int arreglo[]) {
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
	}
    public static void main(String args[]) {
		int datos[] = new int[]{8, 5, 3, 9, 1, 4, 7};
		System.out.println("Arreglo original: " + Arrays.toString(datos));
		ordenarShell(datos);
		System.out.println("Arreglo ordenado: " + Arrays.toString(datos));
	}   
}
