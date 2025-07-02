/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto.Calculos.DataBase;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una cuenta individual dentro del balance.
 * Puede tener un id (Integer, puede ser null), un nombre (String),
 * y una lista de valores correspondientes a cada año del periodo analizado.
 */
public class RegistroCuenta {
    // Identificador único de la cuenta (puede ser null si no aplica)
    private Integer id;
    // Nombre o descripción de la cuenta
    private String nombre;
    // Valores registrados para cada año (siempre tamaño 3)
    private ArrayList<Double> valoresPorPeriodo;

    // Constructor: inicializa el registro con id, nombre y los valores de los 3 años
    public RegistroCuenta(Integer id, String nombre, List<Double> valoresPorPeriodo) {
        this.id = id; // Puede ser null
        this.nombre = nombre;
        // Crea una copia local de los valores para proteger el encapsulamiento
        this.valoresPorPeriodo = new ArrayList<>(valoresPorPeriodo);
    }

    // Getter para el id (puede regresar null)
    public Integer getId() {
        return id;
    }

    // Getter para el nombre/descripción de la cuenta
    public String getNombre() {
        return nombre;
    }

    // Setter para el nombre/descripción de la cuenta
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para la lista de valores de los tres años
    public ArrayList<Double> getValoresPorPeriodo() {
        return valoresPorPeriodo;
    }

    // Setter para la lista de valores (reemplaza los 3 valores)
    public void setValoresPorPeriodo(ArrayList<Double> valoresPorPeriodo) {
        this.valoresPorPeriodo = valoresPorPeriodo;
    }

    // Actualiza el valor de un año específico, usando índice (0 = Año 1, 1 = Año 2, 2 = Año 3)
    public void actualizarValor(int indiceAnio, double nuevoValor) {
        if (indiceAnio >= 0 && indiceAnio < valoresPorPeriodo.size()) {
            valoresPorPeriodo.set(indiceAnio, nuevoValor);
        }
    }

    // Obtiene el valor de un año específico (según índice)
    public double obtenerValor(int indiceAnio) {
        if (indiceAnio >= 0 && indiceAnio < valoresPorPeriodo.size()) {
            return valoresPorPeriodo.get(indiceAnio);
        }
        // Si el índice es inválido, regresa 0.0 (opcionalmente puedes lanzar excepción)
        return 0.0;
    }

    
}
