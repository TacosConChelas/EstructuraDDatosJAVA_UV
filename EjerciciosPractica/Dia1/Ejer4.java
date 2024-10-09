package EjerciciosPractica.Dia1;

import java.util.Scanner;
import java.util.Random;

import javax.security.sasl.SaslException;

/**
 * Ejer 4
 * Crea un programa en Java que simule un juego de piedra, papel o tijera. El usuario debe elegir una de las opciones 
 * y el programa debe elegir aleatoriamente una opción para enfrentarse al usuario, mostrando el resultado del juego.


 */

public class Ejer4 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);  Random random = new Random();
        byte usuario, maquina;
        System.out.println("Selecciona si quieres jugar o no: \n0) Si \n1) No");
        int opcion = leer.nextInt();
        while (opcion == 0) {
            System.out.println("Ingresa un número dependiendo de tu elección: \n1) Piedra \n");

        }
        // System.out.println(random.nextInt((3 - 1) + 1) + 1);

    }
}
