/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package logica;
import igu.Pantalla; //Mandamos a llamar a la clase pantalla para poder mandarla a llamar y ejecutarla

/**
 *
 * @author TheOneAboveAll
 */
public class Interfaces1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Pantalla panta = new Pantalla(); //Crea un objeto de nuestra pantalla
        panta.setVisible(true); //con estos atributos de la clase podemos hacer visible la pantalla y ejecutarla.
        panta.setLocationRelativeTo(null); // con esto le estmaos dienciendo que aparesca en el centro de la pantalla.
        
        
    }
    
}
