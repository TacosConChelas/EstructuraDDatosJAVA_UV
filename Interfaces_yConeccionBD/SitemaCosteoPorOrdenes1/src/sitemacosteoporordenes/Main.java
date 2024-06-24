/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sitemacosteoporordenes;

/**
 *
 * @author monfi
 */

public class Main {
    
    public static void main(String [] args){
        
        // Crear instancia de la ventana de inicio de sesión
        VentanaInicioSecion inicioSecion = new VentanaInicioSecion();
        inicioSecion.setVisible(true);
        inicioSecion.setLocationRelativeTo(null);
        
        // Supongamos que tienes una forma de verificar si el usuario tiene una cuenta
        boolean tieneCuenta = verificarCuenta();

        if (true) {
            // Si el usuario tiene cuenta, mostrar ventana principal
            VentaPrincipal menuPrincipal = new VentaPrincipal();
            menuPrincipal.setVisible(true);
            menuPrincipal.setLocationRelativeTo(null);
        } else {
            // Si el usuario no tiene cuenta, mostrar ventana de registro
            VentanaDeRegistroIS registroSecion = new VentanaDeRegistroIS();
            registroSecion.setVisible(true);
            registroSecion.setLocationRelativeTo(null);
        }
    }

    // Método ficticio para verificar si el usuario tiene una cuenta
    private static boolean verificarCuenta() {
        // Aquí puedes poner la lógica para verificar si el usuario tiene una cuenta
        // Por ejemplo, podrías comprobar un archivo de configuración, base de datos, etc.
        // Para este ejemplo, devolveremos un valor fijo
        return false; // Cambiar a true para simular un usuario con cuenta
    }
        
        
}
