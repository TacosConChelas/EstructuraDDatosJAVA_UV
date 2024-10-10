package EjerciciosPractica.Dia1;
/**
 * Ejer 5
 * Implementa un programa en Java que gestione una agenda de contactos. El programa debe permitir al usuario añadir,
 * eliminar, buscar y mostrar contactos, almacenando la información en una lista y utilizando clases para representar los contactos.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejer5 {
    static List<Contacto> listaContactos = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        boolean salir = true; byte opcion;
        do{
            System.out.println("Selecciona la opçión que decees realizar: \n1) Agregar un nuevo contacto \n2) Elimininar contactos");
            System.out.println("3) Buscar algun contacto \n4) Mostrar todos los contactos \n5) Salir del sistema");
            opcion = leer.nextByte();
            switch (opcion) {
                case 1:
                    Contacto contacto = new Contacto();
                    System.out.println("Ingresa el nombre del contacto");
                    leer.nextLine();
                    String name = leer.nextLine();
                    contacto.setNameUser(name);
                    System.out.println("Coloca el número de teléfono del contacto");
                    contacto.setPhoneNumberUser(leer.nextLong(10));
                
                    leer.nextLine();
                    System.out.println("Coloca la dirección del contacto");
                    name = leer.nextLine();
                    contacto.setAddressUser(name);
                    listaContactos.add(contacto);
                    break;
                case 2: 
                    System.out.println("Escribe el nombre de la persona que deceas eliminar. DEBES ESCRIBIR EL NOMBRE CORRECTAMENTE");
                    leer.nextLine();
                    buscarContactoYEliminar(listaContactos, leer.nextLine());
                    break;
                case 3: 
                System.out.println("Escribe el nombre de la persona que deceas buscar");
                    break;
                case 4: 
                System.out.println("Estos son todos los contactos en tu lista: ");
                    mostrarListaDContactos(listaContactos);
                    break;
                case 5: salir = false;
                    break;
                default: System.out.println("Error en la selección en el menú");
                    break;
            }
        } while(salir);
    }
    public static void mostrarListaDContactos(List<Contacto> listaContacto){
        for (Contacto contacto : listaContacto) {
            System.out.println(contacto.toString());
        }
    }
    public static void buscarContactoYEliminar(List<Contacto> listaContacto, String name){
        boolean encontrado = false;
        for (Contacto contacto : listaContacto) {
            if (name.equals(contacto.getNameUser())) {
                encontrado = true;
                listaContacto.remove(contacto);
            }
        }
        if (encontrado) {   System.out.println("Elemento eliminado");   } else {    System.out.println("Elemento no encontrado");}
    }
    public void buscarYMostrarContacto(List<Contacto> listaContacto, String name){
        boolean encontrado = false;
        for (Contacto contacto : listaContacto) {
            if (name.equals(contacto.getNameUser())) {
                encontrado = true;  System.out.println("Contacto encontrado: " + contacto.toString());
            }
        }   if (! encontrado) {   System.out.println("Elemento no ento no encontrado");   } 
    }
        
    
    
}
