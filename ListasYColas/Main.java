package ListasYColas;
/**
 * Main
 */

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Nodo primer = new Nodo("Ejemplo");
        Nodo segundo = new Nodo(45);
        Nodo tercer = new Nodo("Hola");

        primer.enlazarNext(segundo);
        primer.obtenerSiguiente().enlazarNext(tercer);

        System.out.println(primer.obtenerSiguiente().obtenerSiguiente().obtenerValor().toString());
    }
    
}