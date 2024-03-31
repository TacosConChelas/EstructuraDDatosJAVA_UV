import java.util.Scanner;
/*
    Adriel Xel Há Hernández Ortega      zS22015739
    Encontrar el número más cercano en un arreglo ordenado: 
    Escribe un programa que solicite al usuario ingresar un número y luego encuentre el número más 
    cercano a ese número en un arreglo ordenado utilizando búsqueda binaria. El programa debería imprimir 
    el número más cercano.
*/
public class BusquedaBinaria6 {
    public static void binario(int[] data, int b){
        byte antes = 0, despues = 0, res = 0;
        int inicio = 0, f = data.length, m = 0;
        while (inicio <= f) {
            m = (f - inicio) / 2 + inicio; 
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
                if (m == 0) {
                    System.out.println("tu numero está en esta posicion: " + m + "\nEl numero mas sercano es: " + data[m + 1]);
                } else {
                    antes =(byte)(data[m - 1]); despues = (byte)data[m + 1];
                    antes = (byte)(data[m] - antes); despues -= data[m] ;
                    res = (antes > despues)? (byte)data[m + 1] : (byte)(data[m - 1]);
                    System.out.println("tu numero está en esta posicion: " + m + "\nEl numero más sercano es: " + res);
                }
                break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner tacoScanner = new Scanner(System.in);
        int a;
        int[] numbers = {2, 5, 6, 7, 8, 9, 12, 16, 19, 24, 28, 30, 33, 39, 40, 44, 45, 50};
        System.out.println("Estos sos numeros: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + ", ");
        }
        System.out.println("\nEScribe el numero que decees buscar");
        a = tacoScanner.nextInt();
        binario(numbers, a);

        tacoScanner.close();
    }
}
