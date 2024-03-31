import java.util.Arrays;
/* 
    Adriel Xel Há Hernández Ortega      zS22015739
    Escribe un programa que ordene un arreglo de números enteros utilizando el método de ordenamiento por inserción de forma descendente.
*/
public class OrdenamientoInser02 {
    public static void ordInsert02(int[] a){
        for (int i = 0; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] < key) {
                a[j + 1] = a[j];
                j = j - 1;
            }   a[j + 1] = key;
        }   System.out.println("Arreglo ordenado: \n" + Arrays.toString(a));
    }
    public static void main(String[] args) {
        int[] numeros = new int[10];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int)(Math.random()*50 + 0);
        }
        System.out.println("Arreglo sin ordenar: \n" + Arrays.toString(numeros));
        ordInsert02(numeros);
    }
}