import java.util.Scanner;
/*
    Adriel Xel Há Hernández Ortega      zS22015739
    Contar la frecuencia de un elemento en un arreglo ordenado: 
    Crea un programa que cuente la frecuencia de un número específico en un 
    arreglo ordenado utilizando búsqueda binaria. El programa debería imprimir 
    la frecuencia del número en el arreglo.
 */
public class BusquedaBinaria5 {
    public static void binario(int[] data, int b){
        int antes = 0, despues = 1;
        int inicio = 0, f = data.length, m = 0;
        while (inicio <= f) {
            m = (f - inicio) / 2 + inicio; 
            if (data[m] < b) {
                inicio = m + 1;
                if (inicio >= f) {
                    System.out.println("tu numero no se ha encontrado");    break;
                }
            } else if (data[m] > b) {
                f = m -1;
                if (inicio >= f) {
                    System.out.println("tu numero no se ha encontrado");    break;
                }
            } else {
                for (int i = m + 1; i < data.length; i++) {
                    if (data[m] == data[i]) { despues++; System.out.println("tu numero esta en la posicion: " + i);}
                }
                for (int i = m - 1; i >= 0; i--) {
                    if (data[m] == data[i]) { antes++; System.out.println("tu numero esta en la posicion: " + i); }
                }
                System.out.println("tu numero está en esta posicion: " + m + "\nSu frecuencia es de: " + (antes + despues));
                break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner tacoScanner = new Scanner(System.in);
        int a;
        int[] nums = {2, 2, 4, 5, 6, 6, 6, 7, 7, 8, 9, 10, 11, 23, 23, 25, 26};
        System.out.println("Estos sos numeros: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println("\nEScribe el numero que decees buscar");
        a = tacoScanner.nextInt();
        binario(nums, a);

        tacoScanner.close();
    }
}
