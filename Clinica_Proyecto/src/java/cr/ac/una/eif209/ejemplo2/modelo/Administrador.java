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
public class Administrador implements Serializable {
    String cedula;
    String nombre;
    String apellido;
    String clave;


    public Administrador(){
    this("","","","");
    }
    
    public Administrador(String cedula, String nombre,String apellido, String clave) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido= apellido;
        this.clave = clave;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
       
    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s",
                getCedula(),
                getNombre(),
                getApellido(),
                getClave());
    }
}
