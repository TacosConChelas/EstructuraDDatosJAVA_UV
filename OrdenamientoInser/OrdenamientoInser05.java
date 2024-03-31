import java.util.*;
/* 
    Adriel Xel Há Hernández Ortega      zS22015739
    Encontrar el valor más pequeño en un arreglo.
    Crea un programa que encuentre el  elemento más pequeño en un arreglo de enteros utilizando el método de ordenamiento por inserción. 
    El valor del arreglo debe ser ingresado por el usuario. Se pide imprimir el arreglo desordenado, ordenado y la posición del dato más 
    pequeño.
*/
public class OrdenamientoInser05 {
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
    public static void buscarMenor(int[] n){
        int me = n[0], lugar = 0;
        for (int i = 0; i < n.length; i++) {
            if (me > n[i]) {
                me = n[i]; lugar = i;
            }   
        } System.out.println("El numero mayor es: " + me + "\nEsta en la posicion: " + lugar);
    }
    public static void main(String[] args) {
        Scanner tacoScanner = new Scanner(System.in);
        byte n;
        System.out.println("Escribe la cantidad de numeros que deces ingresar");
        n = tacoScanner.nextByte();
        int[] nums = new int[n];
        System.out.println("Escribe los numeros que decees ingresar");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = tacoScanner.nextInt();
        }
        System.out.println("Arreglo sin ordenar: \n" + Arrays.toString(nums));
        buscarMenor(nums);
        ordInsert(nums);

        tacoScanner.close();
    }
}
