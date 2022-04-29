/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.logic;

import java.io.Serializable;

public class Paciente implements Serializable, Jsonable{
    String cedula;
    String nombre;
    String apellido;
    String clave;


    public Paciente(){
    this("","","","");
    }
    
    public Paciente(String cedula, String nombre,String apellido, String clave) {
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
       
    
}
