import java.util.*;
/* 
Adriel Xel Há Hernández Ortega      zS22015739
*/
public class OrdenamientoInser {
    public static void ordInsert(int[] a){
        for (int i = 0; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j = j - 1;
            }   a[j + 1] = key;
        }   System.out.println("Arreglo ordenado: \n" + Arrays.toString(a));
    }
    public static void main(String[] args) {
        int[] numeros = new int[7];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int)(Math.random()*50 + 0);
        }
        System.out.println("Arreglo sin ordenar: \n" + Arrays.toString(numeros));
        ordInsert(numeros);
    }
}
