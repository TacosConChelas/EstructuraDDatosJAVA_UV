import java.io.*;
import java.util.*;

public class OrdenamientoNombres {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los nombres uno por uno (escribe 'fin' para terminar):");
        List<String> nombres = new ArrayList<>();
        String nombre;
        while (true) {
            nombre = scanner.nextLine().trim();
            if (nombre.equalsIgnoreCase("fin")) {
                break;
            }
            nombres.add(nombre);
        }

        Collections.sort(nombres);

        File archivoOrdenado = new File("nombres_ordenados.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivoOrdenado))) {
            for (String nombreOrdenado : nombres) {
                writer.write(nombreOrdenado);
                writer.newLine();
            }
            System.out.println("Los nombres se han ordenado y guardado en el archivo: nombres_ordenados.txt");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
            e.printStackTrace();
        }

        scanner.close();
    }
}

