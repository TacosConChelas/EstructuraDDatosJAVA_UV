import java.util.Scanner;
/*
    Adriel Xel Há Hernández Ortega      zS22015739
    Crea un arreglo por teclado con números primos; Escribe un programa que solicite al usuario ingresar números,
    una vez ingresados, busca un número primo ; el programa debería imprimir su posición. Si no está presente, 
    debería imprimir un mensaje
    indicando que el número no se encuentra número primo en el arreglo.

    formula para saber si "n" es primo:
    r = (n - 1)! + 1
    if (r % n == 0) entonces n es primo
    https://www.masscience.com/es-posible-encontrar-una-formula-que-permita-comprobar-si-un-numero-es-primo/
*/
public class BusquedaBinaria3_numPrimo {
    public static boolean primo(int n){
        if ((n == 1) || (n == 0)) {
            return false;
        } else {
            int b = 1;
            for (int i = 2; i < n; i++) { b *= i; } b++;
            return (b % n == 0); //boolean p = (b % n == 0)? true : false;
        }
    }
    public static void main(String[] args) {
        Scanner tacoDorado = new Scanner(System.in);
        int a;
        System.out.println("Escribe la cantidad de numeros que deces ingresar");
        a = tacoDorado.nextInt();
        int[] numbers = new int[a];

        System.out.println("Ingresa los numeros");
        for (int i = 0; i < numbers.length; i++) {
           numbers[i] = tacoDorado.nextInt();
        }
        
        for (int i = 0; i < numbers.length; i++) {
            if (primo(numbers[i])) {
                System.out.println("El numero primo: " + numbers[i] + "\nSe encuentra en la posicion: " + i);
            }
        }
        tacoDorado.close();
    }
}
