import java.io.*;
import java.util.*;

class Estudiante implements Comparable<Estudiante> {
    private String nombre;
    private int calificacion;

    public Estudiante(String nombre, int calificacion) {
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCalificacion() {
        return calificacion;
    }

    @Override
    public int compareTo(Estudiante otro) {
        return Integer.compare(this.calificacion, otro.calificacion);
    }
}

public class OrdenamientoEstudiantes {

    public static void main(String[] args) {
        List<Estudiante> estudiantes1 = leerRegistros("estudiantes1.txt");
        List<Estudiante> estudiantes2 = leerRegistros("estudiantes2.txt");

        // Fusionar las listas ordenadas de estudiantes manteniendo el orden ascendente por calificación
        List<Estudiante> estudiantesOrdenados = fusionarEstudiantes(estudiantes1, estudiantes2);

        // Escribir los registros ordenados en un nuevo archivo
        escribirRegistros("estudiantes_ordenados.txt", estudiantesOrdenados);
    }

    // Método para leer los registros de estudiantes desde un archivo y almacenarlos en una lista
    public static List<Estudiante> leerRegistros(String nombreArchivo) {
        List<Estudiante> estudiantes = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(nombreArchivo))) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(",");
                String nombre = partes[0];
                int calificacion = Integer.parseInt(partes[1]);
                estudiantes.add(new Estudiante(nombre, calificacion));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + nombreArchivo);
            e.printStackTrace();
        }
        return estudiantes;
    }

    // Método para fusionar dos listas ordenadas de estudiantes manteniendo el orden ascendente por calificación
    public static List<Estudiante> fusionarEstudiantes(List<Estudiante> lista1, List<Estudiante> lista2) {
        List<Estudiante> resultado = new ArrayList<>();
        int i = 0, j = 0;
        while (i < lista1.size() || j < lista2.size()) {
            if (i < lista1.size() && (j >= lista2.size() || lista1.get(i).compareTo(lista2.get(j)) <= 0)) {
                resultado.add(lista1.get(i++));
            } else {
                resultado.add(lista2.get(j++));
            }
        }
        return resultado;
    }

    // Método para escribir los registros de estudiantes en un archivo
    public static void escribirRegistros(String nombreArchivo, List<Estudiante> estudiantes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (Estudiante estudiante : estudiantes) {
                writer.write(estudiante.getNombre() + "," + estudiante.getCalificacion());
                writer.newLine();
            }
            System.out.println("Los registros de estudiantes ordenados se han guardado en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
            e.printStackTrace();
        }
    }
}
