/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.eif209.ejemplo2.modelo;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Especialidad implements Serializable {
    String id;
    String descripcion;

    public Especialidad(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Especialidad() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

     @Override
    public String toString() {
        return String.format("%s, %s",
                getId(),
                getDescripcion());
                     
    }

     public String showEspacialidad() {
        return String.format("%s",
                getDescripcion());
                     
    }
}
