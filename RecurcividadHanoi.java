import java.util.Scanner;

public class RecurcividadHanoi {
    //Metodo de las torres
    public static void hanoi(int n, int origen, int auxiliar, int destino) {
        
        if (n == 1) {
           
            System.out.println("Mover disco de " + origen + " a " + destino); 
            
           
        } else {
            
            hanoi(n - 1, origen, destino, auxiliar); 
            System.out.println("Mover disco de " + + origen + " a " + destino);
            
            hanoi(n - 1, auxiliar, origen, destino); 
        }
        
    }
    public static void main(String[] args) {
        Scanner leer = new Scanner( System.in);
        int n; 
        System.out.println("Escribe le numero de discos");
        n = leer.nextInt();
        hanoi(n, 1, 2, 3);

        leer.close();
    }
}
