package elmote_elian;

 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.Scanner;

/**
 *
 * @author TheOneAboveAll
 */
public class Encriptacion {
    public String palabra;

    public static String encriptar(String palabra){
        char array[] = palabra.toCharArray(); // [H, O, L ,A] //HOLA
        
        for(int i = 0; i < array.length; i++){
            
            array[i] = (char)(array[i] + (char)5);
            // a b c d e f g h i j k l m n o p q r s t u v w x y z 0 -> 9 
            // i = 0  -> H -> M   O ->  T   L -> Q      A -> F
            
        }
        palabra = String.valueOf(array);
        
        return palabra;
    }
    
    public static String desencriptar(String palabra){
        char array[] = palabra.toCharArray();
        for(int i = 0; i < array.length; i++){
            
            array[i] = (char)(array[i] - (char)5);
            
        }
        palabra = String.valueOf(array);
        return palabra;
    }
    
    public static void main(String args[]){
        // 2000 Elian_22
        // 1000 2222
        // 2340 torta346
        // 7890 rojo99
        Scanner sn = new Scanner(System.in);
        System.out.println("Escribe la palabra a encriptar");
        String palabra = sn.nextLine();
        System.out.println("Esta es la palabra encriptada " + encriptar(palabra));
        String palabraEncriptada = encriptar(palabra);
        System.out.println("Esta es la palabra decencriptada " + desencriptar(palabraEncriptada));
        
       
    }
    
}
