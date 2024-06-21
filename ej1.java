import java.util.Stack;
import java.util.Scanner;

public class ej1 {
    public static void main(String[] args) {
        // Crear una pila de datos con nombres de animales
        Stack<String> pila = new Stack<>();
        Scanner sn = new Scanner(System.in);
        // Insertar elementos en la pila
        pila.push("Perro");
        pila.push("Gato");
        pila.push("Elefante");
        pila.push("Tigre");
        boolean x = true;
        int opcion = 0;
        String ingresar = "";

        System.out.println("Indica cual es la accion que decees ejecutar:");
        System.out.println("1)Ingresar elementos a la pila \n2)Imprimir los elementos actuales de la pila \n3)Eliminar un elemento \n4)Mostrar el elemento arriba de la pila");
        System.out.println("5)Mostrar la cantidad de elementos \n6)Verificar si la pila está vacia ");
        opcion = sn.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Escribe el dato a ingresar\nPara colocarlo dentro de la pila");
                
                ingresar = sn.nextLine();
                pila.push(ingresar);    
                    
                break;
            case 2:
                    
                System.out.println("Pila actual: " + pila);
                break;
            case 3:
                String elementoE = pila.pop();
                System.out.println("Elemento eliminado: " + elementoE);
                break;
            case 4:
                String elementoArriba = pila.peek();
                System.out.println("Elemento en la cima: " + elementoArriba);
                break;
            case 5:
                int cantidad = pila.size();
                System.out.println("Cantidad de elementos: " + cantidad);
        
                break;
            case 6:
                boolean estaVacia = pila.isEmpty();
                if(estaVacia){
                    System.out.println("Si esta vacia");
                }   else {
                    System.out.println("No esta vacia");
                }
                break;
                
                default:
                    break;
            }
            
       
    }
}
