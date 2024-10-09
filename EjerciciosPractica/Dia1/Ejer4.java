package EjerciciosPractica.Dia1;

import java.util.Scanner;
import java.util.Random;


/**
 * Ejer 4
 * Crea un programa en Java que simule un juego de piedra, papel o tijera. El usuario debe elegir una de las opciones 
 * y el programa debe elegir aleatoriamente una opción para enfrentarse al usuario, mostrando el resultado del juego.


 */

public class Ejer4 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);  Random random = new Random();
        int usuario, maquina; String mensaje = "";
        System.out.println("Selecciona si quieres jugar o no: \n0) Si \n1) No");
        int opcion = leer.nextInt();
        while (opcion == 0) {
            System.out.println("Ingresa un número dependiendo de tu elección: \n1) Piedra \n2) Papel \n3) Tijera");
            usuario = leer.nextInt();
            maquina = random.nextInt((3 - 1) + 1) + 1;
            if ((usuario >= 1) && (usuario <= 3)) {
                if (usuario == maquina) {
                    mensaje = "Empate";
                } else if ((usuario == 1)) {
                    mensaje = (maquina == 2)? ("Has perido, ya que la maquina ha elegido PAPEL") : ("Has ganado ya que la maquina ha elegido TIJERA");
                } else if ((usuario == 2)) {
                    mensaje = (maquina == 3)? ("Has perido, ya que la maquina ha elegido TIJERA") : ("Has ganado ya que la maquina ha elegido PIEDRA");
                } else {
                    mensaje = (maquina == 1)? ("Has perido, ya que la maquina ha elegido PIEDRA") : ("Has ganado ya que la maquina ha elegido PIEDRA");
                } System.out.println(mensaje);
            } else {    System.out.println("Lo sentimos pero has escrito mal la opción");}
        }
        // System.out.println(random.nextInt((3 - 1) + 1) + 1);

    }
}
