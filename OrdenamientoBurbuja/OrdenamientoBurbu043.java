import java.util.*;
/* 
    Adriel Xel Há Hernández Ortega      zS22015739
    Realizaremos el mismo ejercicio del número 1, 2 y 3,
    sin embargo, esta ocasión solo serán 5, 6 y 7 posiciones respectivamente,
    pero sera de acuerdo al ordenamiento de burbuja optimizada. 
    Ejercicio 3 pero con el metodo de burbuja optimizada.

*/
public class OrdenamientoBurbu043 {
    public static void ordenBurbuOpti(float[] a){
        System.out.println("burbuja optimizada.");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] < a[j]) {
                    float buffer = a[j];
                    a[j] = a[i];
                    a[i] = buffer;
                }
            }
        }   System.out.println("Arreglo ordenado: " + Arrays.toString(a));
    }
    public static void main(String[] args) {
        float[] numeros = new float[7];
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (float)(Math.random()*50 + 0);
        }
        System.out.println("Arreglo sin ordenar: \n" + Arrays.toString(numeros));
        ordenBurbuOpti(numeros);
    }
}
