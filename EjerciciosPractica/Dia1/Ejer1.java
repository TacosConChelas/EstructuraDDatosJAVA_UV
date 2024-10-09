package EjerciciosPractica.Dia1;

/**
 * Ejer1
 *  Crea un programa en Java que imprima los números del 1 al 500. Si el número es múltiplo de 7, 
 * imprime 'Boom' en lugar del número. Si es múltiplo de 11, imprime 'Bang'. Si es múltiplo de ambos, 
 * imprime 'BoomBang'.
 */
public class Ejer1 {
    public static void main(String[] args) {
        for (int i = 0; i < 501; i++) { 
            if (i % 7 == 0) {       System.out.println("Boom");  
            } else if (i % 11 == 0) { System.out.println("Bang");  
            } else if (i % 77 == 0) {   System.out.println("BoomBang");  
            }
        }
    }
}