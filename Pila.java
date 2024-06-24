/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Yaela
 */
import java.util.Scanner;
import java.util.Stack;

public class Pila {

    public static Stack<Integer> agregar(Stack<Integer> pila, Integer n) {
        pila.push(n);
        return pila;
    }

    public static Stack<Integer> eliminar(Stack<Integer> pila) {
        pila.pop();
        return pila;
    }

    public static Stack<Integer> mostrarCima(Stack<Integer> pila) {
        System.out.println(pila.peek());
        System.out.println(pila);
        return pila;
    }

    public static void main(String[] args) {
        Stack<Integer> pila = new Stack<>();
        Scanner leer = new Scanner(System.in);

        int opc, n;
        char opc2;
        do {
            System.out.println("Que desea hacer?");
            System.out.println("1.- Agregar");
            System.out.println("2.-Eliminar");
            System.out.println("3.-Mostrar el s´perior");

            System.out.println("Que opcion quiere que se realice?");
            opc = leer.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Ingresa un numero para agregar");
                    n = leer.nextInt();
                    pila = agregar(pila, n);
                    break;

                case 2:
                    System.out.println("___");
                    pila = eliminar(pila);
                    break;

                case 3:
                    System.out.println("");
                    pila = mostrarCima(pila);
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, elija una opción válida.");
            }

            System.out.println("¿Desea seguir haciendo operaciones? (S/N)");
            opc2 = leer.next().charAt(0);

        } while (opc2 == 'S' || opc2 == 's');

    }

}
