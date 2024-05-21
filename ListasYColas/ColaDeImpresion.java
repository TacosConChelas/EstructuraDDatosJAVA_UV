import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Clase Documento representa un documento con nombre o número de identificación
class Documento {
    private String nombre;
    private int id;

    public Documento(String nombre, int id) {
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
        return "Documento{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                '}';
    }
}

public class ColaDeImpresion {
    public static void main(String[] args) {
        // Crear una cola de documentos para la impresión
        Queue<Documento> colaDocumentos = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Bucle para mostrar el menu hasta que el usuario elija salir
        do {
            System.out.println("\n--- Menú de Opciones ---");
            System.out.println("(1) Agregar un documento a la cola de impresión");
            System.out.println("(2) Imprimir el documento al principio de la cola");
            System.out.println("(3) Mostrar el documento al principio de la cola");
            System.out.println("(4) Mostrar todos los documentos en espera");
            System.out.println("(5) Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarDocumento(colaDocumentos, scanner);
                    break;
                case 2:
                    imprimirDocumento(colaDocumentos);
                    break;
                case 3:
                    mostrarPrimerDocumento(colaDocumentos);
                    break;
                case 4:
                    mostrarTodosLosDocumentos(colaDocumentos);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida intente nuevamente.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    // Método para agregar un documento a la cola de impresión
    private static void agregarDocumento(Queue<Documento> colaDocumentos, Scanner scanner) {
        System.out.print("Ingrese el nombre del documento: ");
        String nombre = scanner.next();
        System.out.print("Ingrese el numero de identificación del documento: ");
        int id = scanner.nextInt();
        Documento documento = new Documento(nombre, id);
        colaDocumentos.add(documento);
        System.out.println("Documento agregado a la cola de impresion");
    }

    // Mwtodo para imprimir el documento al principio de la cola eliminarlo de la cola
    private static void imprimirDocumento(Queue<Documento> colaDocumentos) {
        Documento documentoImpreso = colaDocumentos.poll(); // Remueve y retorna el primer documento en la cola
        if (documentoImpreso != null) {
            System.out.println("Documento impreso: " + documentoImpreso);
        } else {
            System.out.println("No hay documentos en la cola de impresion");
        }
    }

    // Metodo para mostrar el documento al principio de la cola sin eliminarlo
    private static void mostrarPrimerDocumento(Queue<Documento> colaDocumentos) {
        Documento primerDocumento = colaDocumentos.peek(); // Retorna el primer documento en la cola sin removerlo
        if (primerDocumento != null) {
            System.out.println("Documento al principio de la cola: " + primerDocumento);
        } else {
            System.out.println("No hay documentos en la cola de impresion");
        }
    }

    // Metodo para mostrar todos los documentos en espera en la cola de impresipn
    private static void mostrarTodosLosDocumentos(Queue<Documento> colaDocumentos) {
        if (colaDocumentos.isEmpty()) {
            System.out.println("No hay documentos en la cola de impresion");
        } else {
            System.out.println("Documentos en espera:");
            for (Documento documento : colaDocumentos) {
                System.out.println(documento);
            }
        }
    }
}
