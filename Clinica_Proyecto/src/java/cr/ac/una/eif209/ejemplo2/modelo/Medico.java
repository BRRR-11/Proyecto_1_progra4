/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.eif209.ejemplo2.modelo;

import java.io.Serializable;

public class Medico implements Serializable{
    String cedula;
    String nombre;
    String apellido;
    String clave;
    String telefono;
    String direccion;
    String idEspecialidad;
    int frecuenciaCita;
    


    public Medico(){
    this("","","","","","","",0);
    }
    
    public Medico(String cedula, String nombre,String apellido, String clave,String telefono,String direccion, String id_especialidad, int frecuencia) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido= apellido;
        this.clave = clave;
        this.direccion = direccion;
        this.telefono = telefono;
        this.idEspecialidad = id_especialidad;
        this.frecuenciaCita = frecuencia;
    }

    public String getId_Especialidad() {
        return idEspecialidad;
    }

    public void setId_Especialidad(String id_especialidad) {
        this.idEspecialidad = id_especialidad;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getFrecuenciaCita() {
        return frecuenciaCita;
    }

    public void setFrecuenciaCita(int frecuenciaCita) {
        this.frecuenciaCita = frecuenciaCita;
    }
    
       
    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %s, %s, %s",
                getCedula(),
                getNombre(),
                getApellido(),
                //getClave(),
                getId_Especialidad(),
                getTelefono(),
                getDireccion(),
                getFrecuenciaCita());
        
    }
    
    public String showDireccion() {
        return String.format("%s",
                getDireccion());
    }

   public String showCitaInfo() {
        return String.format("%s,%s, %s, %s, %s",
                getCedula(),
                getNombre(),
                getId_Especialidad(),
                getTelefono(),
                getDireccion());
    }

}
