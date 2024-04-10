import java.util.Scanner;
/*
    Adriel Xel Há Hernández Ortega      zS22015739
    Buscar un elemento en un arreglo: Escribe un programa que solicite al usuario ingresar un número y luego 
    busca ese número en un arreglo predefinido. Si el número está presente en el arreglo, el programa debería 
    imprimir su posición. Si no está presente, debería imprimir un mensaje indicando que el número no se encuentra 
    en el arreglo.
 */
public class BusquedaBinaria2 {
    public static void binario(int[] data, int b){
        int inicio = 0, f = data.length, m = 0;
        while (inicio <= f) {
            m = (f - inicio) / 2 + inicio; //al principio m vale 10
            if (data[m] < b) {
                inicio = m + 1;
                if (inicio > f) {
                    System.out.println("tu numero no se ha encontrado");    break;
                }
            } else if (data[m] > b) {
                f = m -1;
                if (inicio > f) {
                    System.out.println("tu numero no se ha encontrado");    break;
                }
            } else {
                System.out.println("tu numero esta en esta posicion: " + m);
                break;
            }
        }
    }
    public static void binario1(int[] arreglo, int valorABuscar){
        int indiceInferior = 0, indiceSuperior = arreglo.length, indiceMedio = 0;
        while (indiceInferior <= indiceSuperior) {
            indiceMedio = (indiceSuperior - indiceInferior) / 2 + indiceInferior;
            if (arreglo[indiceMedio] < valorABuscar) {
                indiceInferior = indiceMedio + 1;
                if (indiceInferior > indiceSuperior) {
                    System.out.println("tu numero no se ha encontrado");    break;
                } 
            } else if (arreglo[indiceMedio] > valorABuscar) {
                indiceSuperior = indiceMedio  - 1;
                if (indiceInferior > indiceSuperior) {
                    System.out.println("tu numero no se ha encontrado");    break;
                }
            } else {
                System.out.println("El numero esta en la posicion: " + indiceMedio);
                break;
            }
        }
    }


    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}; //tamaño de 20
        int n;
        System.out.println("Estos son los numeros: ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.println("\nEScribe el numero que decees buscar");
        n = leer.nextInt();
        binario(a, n);


        leer.close();

    }
}
