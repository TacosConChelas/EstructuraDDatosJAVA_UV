package ListasYColas;
import java.util.Stack;
import java.util.Scanner;

public class PilasEjer1 {
    public static void main(String[] args) {
        Stack<Integer> pila = new Stack<>();
        Scanner leer = new Scanner(System.in);
        int option;
        do {
            System.out.println("Ingresa la opcion que decees elegir: \n1)Agregar elemento a la pila \n2)Quitar elemento superior de la pila \n3)Mostrar el elemento en la parte superior");
            System.out.println("4)Mostrar elementos de la lista \n5)Salir ");
            option = leer.nextInt();
            switch (option) {
                case 1:
                    System.out.println("ingresa un dato de la pila");
                    int number = leer.nextInt();
                    pila.push(number);
                    System.out.println("Dato añadido a al pila");
                    break;
                case 2:
                    if (!pila.isEmpty()) {
                        pila.pop();
                        System.out.println("Se ha eliminado el elemento de la parte superior \nEstos son los datos actuales que estan dentro de la pila : " + pila);
                    } else {
                        System.out.println("La lista está vacia por lo que no se le pueden quitar elementos de ella");
                    }
                
                    break;
                case 3:
                    if (!pila.isEmpty()) {
                        System.out.println("Este es el elemento de la parte superior de la pila" + pila.peek());
                    } else {
                        System.out.println("La lista está vacia por lo que no se puede mostrar datos aun");
                    }   
                    break;
                case 4: 
                    System.out.println("Estos son todos los elementos de la lista: " + pila);   break;
                case 5:     break;
                default:
                    System.out.println("Eleccion erronea"); break;
            }
        } while (option != 5);  leer.close();
    }
}
