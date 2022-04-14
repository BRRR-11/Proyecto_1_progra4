package principal.logic;

import java.io.Serializable;

public class Medico implements Serializable, Jsonable {

    String cedula;
    String nombre;
    String apellido;
    int telefono;
    String email;
//    String especialidad;

    public Medico() {
        this("", "", "", -1, "");
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
    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Medico(String cedula, String nombre, String apellido, int telefono, String email) {

        this.cedula = cedula;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.apellido = apellido;
    }


}
