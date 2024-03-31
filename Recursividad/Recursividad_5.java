import java.util.Scanner;
/*
    Hernández Ortega Adriel Xel Há      zS22015739
    Ahora vamos a invertir un numero de forma recursiva (no usar String)
 */
public class Recursividad_5 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("Escribe un numero");
        int n = leer.nextInt();
        String numeros = String.valueOf(n);
        char[] a = numeros.toCharArray();
        char[] b = new char[a.length];
        
        for (int i = 0; i < a.length; i++) {
            b[b.length - i - 1] = a[i];
            
        }
        System.out.println("Estos son los digitos del numero escritos de forma invertida:");
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }

        leer.close();
    }
}
