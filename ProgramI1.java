import java.util.Scanner;
/*
    Hernández Ortega Adriel Xel Há       zS22015739     
    Programa Java que muestre los números del 1 al 100 utilizando la instrucción while.
 */

public class ProgramI1 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int i = 1;
        while (i < 101) {
            System.out.println(i);
            i++;
        }
        //Hola espero que esten muy bien yo estoy aqui programando 
        leer.close();
    }
}
