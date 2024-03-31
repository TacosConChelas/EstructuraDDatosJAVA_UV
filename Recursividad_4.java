/**
    Hernández Ortega Adriel Xel Há      zS22015739
    Transcribe el siguiente codigo, y comenta cada linea, segun la acción que se realiza:
 */
public class Recursividad_4 {
    public static int posicionElementoRecursivo(int[] arreglo, int elementoBuscar, int indice){
        if (indice == arreglo.length || arreglo[indice] == elementoBuscar) {
            /*
                Dentro de este if lo que estamos haciendo es delimitar si el indice que colocamos en los parametros (que en este caso 
                es 0) es esactamente igual al tamaño del arreglo que colocamos O si el número que está ubicado en la posición del indice 
                del arreglo que colocamos es igual al elemento que estamos buscando 
             */
            if (indice == arreglo.length) {
                /*
                    Este bloque solo se ejecutara si el indice que colocamos (es decir 0) es igual al tamaño dle arreglo.
                    Si esto es verdad, termita aquí toda la función y regresa el valor -1 ya que no se puede econtrar
                    un número dentro de un arreglo de tamaño 0.
                 */
                return -1;
            } else {
                return indice;
                /*
                    Si este bloque se cumple quiere decir que el número que está ubicado en la posición del indice 
                    del arreglo que colocamos es igual al elemento que estamos buscando, por lo que regresará el
                    valor de la varaible indice.
                 */
            }
        } else {
            return posicionElementoRecursivo(arreglo, elementoBuscar, indice + 1);
            /*
                Si no se cumplio el caos anterior quiere decirque no se ha encontrado el número deceado, por lo que 
                debemos de sumarle +1 a la variable indice para que la funsion busque una posición más adelante 
                de la que está buscando, es decir si la varaible indice vale 0 quiere decir que estaba buscando
                dentro de la posicion 0, por lo que en este caso ahora la funsion va a buscar en la posicion del arreglo
                0+1, y si despues de esto no lo llegase a encontrar y el bloque anterior no se llega a cumplir, 
                la funsion se volveria a repetir buscando en la posicion 1+1, y asi sucesivamente asta encontrar 
                el numero que uscamosx
             */
        }
    }
    public static void main(String[] args) {
        int[] arreglo = {1, 2, 3, 4, 5}; //Declaracion dle arrreglo en el que vamos a encontrar e lnumero
        int elementoBuscar = 3; // numero a encontrar
        int posElementoEncontrado = posicionElementoRecursivo(arreglo, elementoBuscar, 0); 
        /*
         Aquí se pone la funcion posicionElementoRecursivo para que el valor de retorno de esta misma sea guardado en 
         la variable: posElementoEncontrado, además de esto dentro de los parámetros vamos a colocar el arreglo de tipo int(el primer parametro),
         el elemento que queremos buscar (este debe de ser de tipo int y es el segundo parametro), despues colocamos el indice que en este
         caso es 0, este es 0 ya que queremos que la función empiese a buscar desde el indice 0 del arreglo hasta que encuentre el numero
         que estamos buscando, peor le numeor que nos esta devolviendo es el indice de la ubicación de ese numero a buscar (que es 3).
         */
        System.out.println(posElementoEncontrado);
        //Aquí nos está imprimiendo el indice del numeor que estamos buscando


        
    }
    
}