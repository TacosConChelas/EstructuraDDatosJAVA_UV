import java.util.Scanner;
/*
    Adriel Xel Há Hernández Ortega      zS22015739
 */
public class BusquedaBinaria1 {
    public static int binario(int[] data, int valor){
        int li = 0, ls = data.length, lm = 0;
        while (li <= ls) {
            lm = (ls - li) / 2 + li;
            if (data[lm] < valor) {
                li = lm + 1;
            } else if (data[lm] > valor) {
                ls = lm -1;
            } else {
                return lm;
            }
        }
        return lm;
    }
    public static void main(String[] args) {
        Scanner leer  = new Scanner(System.in);
        int[] a = {1, 2, 3, 4, 5, 9, 11, 13, 34, 55, 66, 67, 68};
        System.out.println("ingresa un numero");
        int n = leer.nextInt();
        
        int num = binario(a, n);
        System.out.println("el numero que buscas esta en la posición " + num);
        leer.close();
    }
}

