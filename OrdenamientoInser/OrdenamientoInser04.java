import java.util.Arrays;
public class OrdenamientoInser04 {
    /* 
        Eliminar Duplicados en Arreglo Ordenado
        Implementa un programa que elimine los elementos duplicados en un arreglo ordenado utilizando el método de ordenamiento por inserción. 
        El programa debe garantizar que el arreglo resultante permanezca ordenado.
    */
    public static void ordInsert(int[] a){
        for (int i = 0; i < a.length; i++) {
            int key = a[i]; int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];    j = j - 1;
            }   a[j + 1] = key;
        }   System.out.println("Arreglo ordenado: \n" + Arrays.toString(a));
    }
    public static void duplicados(int[] a){
        byte q1 = 1, q2 = 1, cMe = 0, cMa = 0, inMa, inMe, x = 1, y = 1;
        for (int i = 0; i < a.length; i++) {
            while (q1 != 0 || q2 != 0) {
                switch (i) {
                    case 0:
                        inMa = 0; inMe = 0;
                        if (a[0] == a[i + 1 + cMa]){    cMa++; q2 = 1;  } else  { q2 = 0;   }   break;
                    default:
                        inMe = (byte)(i - cMe);
                        if ((a[i] == a[i - 1 - cMe]) && x != 0){    
                            cMe++; q1 = 1;  x = ((i - 2 - cMe) > 0)? (byte)(1) : (0);    } else  { q1 = 0;   }
                        if ((a[i] == a[i + 1 + cMa]) && y != 0){    
                            cMa++; q2 = 1;  y = ((i + 2 + cMa) < a.length)? (byte)(1) : (0);} else  { q2 = 0;   }   
                        break;
                }
            }
        }
    }
    public static void acomodar(int[] nums, byte atras, byte adelante){
        for (int i = atras; i < (adelante + atras); i++) {
            
        }
    }
    public static void main(String[] args) {
        int[] nums = {8, 4, 6, 6, 6, 3, 4, 5, 0};
        System.out.println("\nArreglo desordenado"+ Arrays.toString(nums));
        ordInsert(nums);
        
        
        

    }
}
