import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Clase Pedido representa un pedido con un número de mesa o identificador
class Pedido {
    private String nombre;
    private int numeroMesa;

    public Pedido(String nombre, int numeroMesa) {
        this.nombre = nombre;
        this.numeroMesa = numeroMesa;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "nombre='" + nombre + '\'' +
                ", numeroMesa=" + numeroMesa +
                '}';
    }
}

public class ColaDePedidos {
    public static void main(String[] args) {
        // Crear una cola de pedidos para el restaurante
        Queue<Pedido> colaPedidos = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Bucle para mostrar el menú hasta que el usuario elija salir
        do {
            System.out.println("\n--- Menú de Opciones ---");
            System.out.println("(1) Agregar un pedido a la cola de preparación");
            System.out.println("(2) Preparar y entregar el pedido al principio de la cola");
            System.out.println("(3) Mostrar el pedido al principio de la cola");
            System.out.println("(4) Mostrar todos los pedidos en preparacion");
            System.out.println("(5) Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarPedido(colaPedidos, scanner);
                    break;
                case 2:
                    prepararYEntregarPedido(colaPedidos);
                    break;
                case 3:
                    mostrarPrimerPedido(colaPedidos);
                    break;
                case 4:
                    mostrarTodosLosPedidos(colaPedidos);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida intente nuevamente");
            }
        } while (opcion != 5);

        scanner.close();
    }

    // Metodo para agregar un pedido a la cola de preparacion
    private static void agregarPedido(Queue<Pedido> colaPedidos, Scanner scanner) {
        System.out.print("Ingrese el nombre del pedido: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el numero de mesa del pedido: ");
        int numeroMesa = scanner.nextInt();
        Pedido pedido = new Pedido(nombre, numeroMesa);
        colaPedidos.add(pedido);
        System.out.println("Pedido agregado a la cola de preparacioin");
    }

    // Mwetodo para preparar y entregar el pedido al principio de la cola (eliminarlo de la cola)
    private static void prepararYEntregarPedido(Queue<Pedido> colaPedidos) {
        Pedido pedidoEntregado = colaPedidos.poll(); // Remueve y retorna el primer pedido en la cola
        if (pedidoEntregado != null) {
            System.out.println("Pedido preparado y entregado: " + pedidoEntregado);
        } else {
            System.out.println("No hay pedidos en la cola de preparacion");
        }
    }

    // Metodo para mostrar el pedido al principio de la cola sin eliminarlo
    private static void mostrarPrimerPedido(Queue<Pedido> colaPedidos) {
        Pedido primerPedido = colaPedidos.peek(); // Retorna el primer pedido en la cola sin removerlo
        if (primerPedido != null) {
            System.out.println("Pedido al principio de la cola: " + primerPedido);
        } else {
            System.out.println("No hay pedidos en la cola de preparacion");
        }
    }

    // Metodo para mostrar todos los pedidos en preparacion en el restaurante
    private static void mostrarTodosLosPedidos(Queue<Pedido> colaPedidos) {
        if (colaPedidos.isEmpty()) {
            System.out.println("No hay pedidos en la cola de preparacion");
        } else {
            System.out.println("Pedidos en preparacion:");
            for (Pedido pedido : colaPedidos) {
                System.out.println(pedido);
            }
        }
    }
}
