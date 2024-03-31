import java.util.Scanner;
/*
    Adriel Xel Há Hernández Ortega      zS22015739
    Contar la frecuencia de un elemento en un arreglo: Crea un programa que cuente la frecuencia de un 
    número específico en un arreglo. El programa debería solicitar al usuario ingresar un número y luego 
    contar cuántas veces aparece ese número en el arreglo.
 */
public class Busqueda2 { 
    public static void busqueda(int[] n, int b){
            int pp = 0;
            for (int i = 0; i < n.length; i++) {
                pp = (n[i] == b)? (pp + 1) : pp;
            }
            if (pp == 0) {
                System.out.println("El numero que escribiste no se repitio");
            } else {
                System.out.println("Esta es la cantidad que se repitio el numero " + pp);
            }
        }
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int a;
        System.out.println("Escribe el tamaño del arreglo");
        a = leer.nextInt();
        int[] nums = new int[a];
        System.out.println("Llena el arreglo con numeros, en donde almenos uno se repita más de 1 vez");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = leer.nextInt();
        }
        System.out.println("Escribe el numeor que decees saber su frecuencia");
        a = leer.nextInt();

        busqueda(nums, a);
        leer.close();
    }
}
