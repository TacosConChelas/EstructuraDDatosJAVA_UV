/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *INTEGRANTES:
 * Angel Jarley Garzota Barrera 
Juan Pablo Velázquez Méndez 
Jearim Obed Martinez Villalba
 * 
 */
import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    // Identificador especial, 0 = cuenta normal, >0 = cuenta especial
    private int codigoUnico;
    private String descripcion;
    private ArrayList<Double> registrosPeriodos;

    // Constructor principal: se inicia como cuenta normal (codigoUnico = 0)
    public Cuenta(String descripcion, List<Double> registrosPeriodos) {
        this.codigoUnico = 0;
        this.descripcion = descripcion;
        // Se copia la lista a un ArrayList propio para asegurar encapsulamiento
        this.registrosPeriodos = new ArrayList<>(registrosPeriodos);
    }

    // Asignar código especial
    public void asignarCodigoUnico(int codigo) {
        this.codigoUnico = codigo;
    }

    // Remover código especial (regresa a cuenta normal)
    public void removerCodigoUnico() {
        this.codigoUnico = 0;
    }

    // Actualizar valor de un año específico
    public void actualizarValor(int indiceAnio, double nuevoValor) {
        if (indiceAnio >= 0 && indiceAnio < registrosPeriodos.size()) {
            registrosPeriodos.set(indiceAnio, nuevoValor);
        }
    }

    // Obtener valor de un año específico
    public double obtenerValor(int indiceAnio) {
        if (indiceAnio >= 0 && indiceAnio < registrosPeriodos.size()) {
            return registrosPeriodos.get(indiceAnio);
        }
        // Puede lanzar excepción, aquí solo retorna 0 por seguridad
        return 0.0;
    }

    // Getters y setters básicos
    public int getCodigoUnico() {
        return codigoUnico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Double> getRegistrosPeriodos() {
        return registrosPeriodos;
    }

    public void setRegistrosPeriodos(ArrayList<Double> registrosPeriodos) {
        this.registrosPeriodos = registrosPeriodos;
    }

    // Sobrescribir toString para debug/visualización rápida
    @Override
    public String toString() {
        return "Cuenta{" +
                "codigoUnico=" + codigoUnico +
                ", descripcion='" + descripcion + '\'' +
                ", registrosPeriodos=" + registrosPeriodos +
                '}';
    }
}
