import   java.util.Scanner;
/*
    Hernández Ortega Adriel Xel Há      zS22015739
    Suma los digitos de un numero de forma recursiva.
    https://www.delftstack.com/es/howto/java/how-to-get-the-separate-digits-of-an-int-number/
 */
public class Recursividad_3 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.println("EScribe un número");
        int n = leer.nextInt();
        String numeros = String.valueOf(n);
        char[] cadNum = numeros.toCharArray();
        System.out.println("Estos son los digitos del numero: ");
        for (int i = 0; i < cadNum.length; i++) {
            System.out.println(cadNum[i]);
        }

        leer.close();

    }
}
