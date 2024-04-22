import java.util.*;

import javax.swing.JOptionPane;

public class ExamenPractico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Paso 1: Crear un arreglo de 8 posiciones e ingresar los datos por teclado
        int[] arreglo = new int[8];
        System.out.println("Ingresa 8 números enteros:");

        for (int i = 0; i < 8; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            arreglo[i] = scanner.nextInt();
        }

        // Mostrar los valores ingresados
        System.out.println("Valores ingresados:");
        for (int i = 0; i < 8; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();

        // Paso 2: Ordenar los elementos mediante el método de intercambio
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }

        // Mostrar los valores ordenados
        System.out.println("Valores ordenados:");
        for (int i = 0; i < 8; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();

        // Paso 3: Buscar un número
        System.out.print("Ingresa el número que deseas buscar: ");
        int buscar = scanner.nextInt();
        int indice = busquedaSecuencial(arreglo, buscar);

        if (indice != -1) {
            System.out.println("El número " + buscar + " se encuentra en la posición " + indice + ".");
        } else {
            System.out.println("El número " + buscar + " no se encuentra en el arreglo.");
        }

        scanner.close();

        // Paso 4: Mensaje de "Examen terminado" mediante JOptionPane
        JOptionPane.showMessageDialog(null, "Examen terminado");
    }

    // Método de búsqueda secuencial
    public static int busquedaSecuencial(int[] arreglo, int target) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == target) {
                return i;
            }
        }
        return (-1);
    }
}