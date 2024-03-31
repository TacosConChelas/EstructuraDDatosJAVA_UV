import java.util.Scanner;
/*
    Adriel Xel Há Hernández Ortega      zS22015739
    Encontrar el primer y último índice de un elemento en un arreglo ordenado: 
    Desarrolla un programa que encuentre el primer y el último índice de un número específico
    en un arreglo ordenado. El programa debería imprimir ambos índices si el número está presente 
    en el arreglo, o un mensaje indicando que el número no está presente.
 */


public class BusquedaBinaria4 {
    public static int encontrarPrimerIndice(int[] arr, int objetivo) {
        int bajo = 0;
        int alto = arr.length - 1;
        int primerIndice = -1;

        while (bajo <= alto) {
            int medio = bajo + (alto - bajo) / 2;
            if (arr[medio] == objetivo) {
                primerIndice = medio;
                alto = medio - 1;
            } else if (arr[medio] < objetivo) {
                bajo = medio + 1;
            } else {
                alto = medio - 1;
            }
        }

        return primerIndice;
    }
    public static int encontrarUltimoIndice(int[] arr, int objetivo) {
        int bajo = 0;
        int alto = arr.length - 1;
        int ultimoIndice = -1;

        while (bajo <= alto) {
            int medio = bajo + (alto - bajo) / 2;
            if (arr[medio] == objetivo) {
                ultimoIndice = medio;
                bajo = medio + 1;
            } else if (arr[medio] < objetivo) {
                bajo = medio + 1;
            } else {
                alto = medio - 1;
            }
        }

        return ultimoIndice;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 4, 5, 5, 6, 7};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el numero que desea buscar: ");
        int objetivo = scanner.nextInt();

        int primerIndice = encontrarPrimerIndice(arr, objetivo);
        int ultimoIndice = encontrarUltimoIndice(arr, objetivo);

        if (primerIndice != -1 && ultimoIndice != -1) {
            System.out.println("El primer indice de "+objetivo+" es: "+primerIndice);
            System.out.println("El ultimo indice de "+objetivo+" es: "+ultimoIndice);
        } else {
            System.out.println("El numero "+objetivo+" no esta presente en el arreglo");

        }
    }
}

