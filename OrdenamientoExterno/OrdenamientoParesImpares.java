import java.io.*;
import java.util.*;

public class OrdenamientoParesImpares {

    public static void main(String[] args) {
        List<Integer> pares = leerArchivo("numeros_pares.txt");
        List<Integer> impares = leerArchivo("numeros_impares.txt");

        Collections.sort(pares);
        Collections.sort(impares);

        List<Integer> ordenados = intercalarListas(pares, impares);

        escribirArchivo("numeros_ordenados.txt", ordenados);
    }

    public static List<Integer> leerArchivo(String nombreArchivo) {
        List<Integer> numeros = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(nombreArchivo))) {
            while (scanner.hasNextInt()) {
                numeros.add(scanner.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + nombreArchivo);
            e.printStackTrace();
        }
        return numeros;
    }


    public static List<Integer> intercalarListas(List<Integer> lista1, List<Integer> lista2) {
        List<Integer> resultado = new ArrayList<>();
        int i = 0, j = 0;
        while (i < lista1.size() || j < lista2.size()) {
            if (i < lista1.size()) {
                resultado.add(lista1.get(i++));
            }
            if (j < lista2.size()) {
                resultado.add(lista2.get(j++));
            }
        }
        return resultado;
    }

    public static void escribirArchivo(String nombreArchivo, List<Integer> numeros) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (int numero : numeros) {
                writer.write(String.valueOf(numero));
                writer.newLine();
            }
            System.out.println("Los números ordenados se han guardado en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo.");
            e.printStackTrace();
        }
    }
}
