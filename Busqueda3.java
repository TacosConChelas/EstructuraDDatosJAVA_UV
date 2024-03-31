import java.util.Scanner;
/*
    Adriel Xel Há Hernández Ortega      zS22015739
    Encontrar el número máximo en un arreglo: 
    Desarrolla un programa que encuentre el número máximo en un arreglo dado. 
    El programa debería imprimir el número máximo y su posición en el arreglo.
*/
public class Busqueda3 {
    public static void numMayor(int[] n){
        int num = n[0], p = 0;
        for (int i = 0; i < n.length; i++) {
            if (num < n[i]) {
                num = n[i]; p = i;
            }
        }
        System.out.println("Este es el numero mayor: " + num + "\nEsta es su posicion: " + p);
    }
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int a;
        System.out.println("Escribe cuantos numeros deces ingreesar");
        a = leer.nextInt();
        int[] nums = new int[a];
        System.out.println("Escribe esa cantidad de numeros");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = leer.nextInt();
        }
        numMayor(nums);

        leer.close();
    }    
}
