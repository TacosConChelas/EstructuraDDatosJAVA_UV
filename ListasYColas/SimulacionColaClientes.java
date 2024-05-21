/*
 * Erick Alexander Monfil Arroyo
 * Hernández Ortega Adriel Xel Há​
*Jiménez Ojeda Jesús Ignacio
 */

 import java.util.LinkedList;
 import java.util.Queue;
 import java.util.Scanner;
 
 // Clase Cliente representa a un cliente con nombre y número de identificación
 class Cliente {
     private String nombre;
     private int id;
 
     public Cliente(String nombre, int id) {
         this.nombre = nombre;
         this.id = id;
     }
 
     public String getNombre() {
         return nombre;
     }
 
     public int getId() {
         return id;
     }
 
     @Override
     public String toString() {
         return "Cliente{" +
                 "nombre='" + nombre + '\'' +
                 ", id=" + id +
                 '}';
     }
 }
 
 public class SimulacionColaClientes {
     public static void main(String[] args) {
         // Crear una cola de clientes
         Queue<Cliente> colaClientes = new LinkedList<>();
         Scanner scanner = new Scanner(System.in);
         int opcion;
 
         // Bucle para mostrar el menú hasta que el usuario elija salir
         do {
             System.out.println("\n--- Menú de Opciones ---");
             System.out.println("(1) Agregar un cliente a la cola");
             System.out.println("(2) Atender al cliente al principio de la cola");
             System.out.println("(3) Mostrar el cliente al principio de la cola");
             System.out.println("(4) Mostrar todos los clientes en espera");
             System.out.println("(5) Salir");
             System.out.print("Seleccione una opción: ");
             opcion = scanner.nextInt();
 
             switch (opcion) {
                 case 1:
                     agregarCliente(colaClientes, scanner);
                     break;
                 case 2:
                     atenderCliente(colaClientes);
                     break;
                 case 3:
                     mostrarPrimerCliente(colaClientes);
                     break;
                 case 4:
                     mostrarTodosLosClientes(colaClientes);
                     break;
                 case 5:
                     System.out.println("Saliendo del programa...");
                     break;
                 default:
                     System.out.println("Opcion no válida intente nuevament");
             }
         } while (opcion != 5);
 
         scanner.close();
     }
 
     // Metodo para agregar un cliente 
     private static void agregarCliente(Queue<Cliente> colaClientes, Scanner scanner) {
         System.out.print("Ingrese el nombre del cltyente: ");
         String nombre = scanner.next();
         System.out.print("Ingrese el número de identificación del cliente: ");
         int id = scanner.nextInt();
         Cliente cliente = new Cliente(nombre, id);
         colaClientes.add(cliente);
         System.out.println("Cliente agregado a la cola");
     }
 
     // Metodo para atender al cliente al principio de la cola (eliminarlo de la cola)
     private static void atenderCliente(Queue<Cliente> colaClientes) {
         Cliente clienteAtendido = colaClientes.poll(); // Remueve y retorna el primer cliente en la cola
         if (clienteAtendido != null) {
             System.out.println("Cliente atendido: " + clienteAtendido);
         } else {
             System.out.println("No hay clientes en la cola");
         }
     }
 
     // Metodo para mostrar el cliente al principio de la cola sin eliminarlo
     private static void mostrarPrimerCliente(Queue<Cliente> colaClientes) {
         Cliente primerCliente = colaClientes.peek(); // Retorna el primer cliente en la cola sin removerlo
         if (primerCliente != null) {
             System.out.println("Cliente al principio de la cola: " + primerCliente);
         } else {
             System.out.println("No hay clientes en la cola.");
         }
     }
 
     // metodo para mostrar todos los clientes en espera en la cola
     private static void mostrarTodosLosClientes(Queue<Cliente> colaClientes) {
         if (colaClientes.isEmpty()) {
             System.out.println("No hay clientes en la cola");
         } else {
             System.out.println("clientes en espera:");
             for (Cliente cliente : colaClientes) {
                 System.out.println(cliente);
             }
         }
     }
 }
 