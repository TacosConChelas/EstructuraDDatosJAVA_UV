package ListasYColas;

import java.util.ArrayList;
import java.util.Arrays;

public class Nodo {
    Object valor;
    Nodo siguiente;

    public Nodo(int i) {
        //TODO Auto-generated constructor stub
    }
    public Nodo(String string) {
        //TODO Auto-generated constructor stub
    }

    public void Nodo(Object valor){
        this.valor = valor;
        this.siguiente = null;
    }

    public void enlazarNext (Nodo n){
        siguiente = n;
    }

    public Object obtenerValor(){
        return valor;
    }
    public Nodo obtenerSiguiente(){
        return siguiente;
    }
    /* 
     ArrayList<Integer> miArray = new ArrayList<>();
        //añadir datos a esta lista y se coloca :
        miArray.add(10);

    */
    public static void main(String[] args) {
       
    }
}
