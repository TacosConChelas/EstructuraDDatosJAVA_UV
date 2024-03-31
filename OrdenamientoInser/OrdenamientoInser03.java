import java.util.*;
/*
    Adriel Xel Há Hernández Ortega      zS22015739
    Desarrolla un programa que ordene un arreglo de cadenas de texto utilizando el método de ordenamiento por inserción.
 */
public class OrdenamientoInser03 {
    public static void ordInsert02(String[] a){
        for (int i = 0; i < a.length; i++) {
            String key = a[i];
            int j = i - 1;
            boolean condicion = compararTextMayor(a[j], key);
            while (j >= 0 && condicion) {
                a[j + 1] = a[j];
                j = j - 1;
                condicion = compararTextMayor(a[j], key);
            }   a[j + 1] = key;
            
        }   System.out.println("Arreglo ordenado: \n" + Arrays.toString(a));
    }
    public static boolean compararTextMayor(String anterior, String despues){
        int r = anterior.compareTo(despues); boolean v = false;
        if (r < 0) {
            v = false;
        } else if (r > 0) {
            v = true;
        }   return v;
    }
    public static void main(String[] args) {
        Scanner tacoScanner = new Scanner(System.in);
        String[] textos = new String[4];
        System.out.println("Escribe 4 palabras o letras");
        for (int i = 0; i < textos.length; i++) {
            textos[i] = tacoScanner.nextLine();
        }
        System.out.println("Arreglo sin ordenar: \n" + Arrays.toString(textos));
        ordInsert02(textos);
        
        tacoScanner.close();
    }
}
