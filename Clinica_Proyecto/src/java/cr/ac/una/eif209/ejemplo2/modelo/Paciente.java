package cr.ac.una.eif209.ejemplo2.modelo;

//import java.io.Serializable;

import java.io.Serializable;

//import java.sql.Timestamp;
//import java.time.format.DateTimeFormatter;
//
//public class Usuario implements Serializable {
//
////    // <editor-fold desc="Constructores" defaultstate="collapsed">
////    public Usuario(String idUsuario,
////            String password,
////            String nombre,
////            Timestamp ultimoAcceso,
////            int prioridad) {
////        this.idUsuario = idUsuario;
////        this.clave = password;
////        this.nombre = nombre;
////        this.ultimoAcceso = ultimoAcceso;
////        this.prioridad = prioridad;
////    }
////
////    public Usuario() {
////        this(null, null, null, null, 0);
////    }
////
////    // </editor-fold>
////    // <editor-fold desc="Métodos" defaultstate="collapsed">
////    @Override
////    public String toString() {
////        return String.format("{%s, %s, %s, %s, %d}",
////                getIdUsuario(),
////                getClave(),
////                getNombre(),
////                getUltimoAcceso().toLocalDateTime().format(DateTimeFormatter.ISO_DATE_TIME),
////                getPrioridad());
////    }
////
////    // </editor-fold>
////    // <editor-fold desc="Accesores y mutadores" defaultstate="collapsed">
////    public String getIdUsuario() {
////        return idUsuario;
////    }
////
////    public void setIdUsuario(String idUsuario) {
////        this.idUsuario = idUsuario;
////    }
////
////    public String getClave() {
////        return clave;
////    }
////
////    public void setClave(String clave) {
////        this.clave = clave;
////    }
////
////    public String getNombre() {
////        return nombre;
////    }
////
////    public void setNombre(String nombre) {
////        this.nombre = nombre;
////    }
////
////    public Timestamp getUltimoAcceso() {
////        return ultimoAcceso;
////    }
////
////    public void setUltimoAcceso(Timestamp ultimoAcceso) {
////        this.ultimoAcceso = ultimoAcceso;
////    }
////
////    public int getPrioridad() {
////        return prioridad;
////    }
////
////    public void setPrioridad(int prioridad) {
////        this.prioridad = prioridad;
////    }
////
////    // </editor-fold>
////    // <editor-fold desc="Atributos" defaultstate="collapsed">
////    private String idUsuario;
////    private String clave;
////    private String nombre;
////    private Timestamp ultimoAcceso;
////    private int prioridad;
////    // </editor-fold>
//}
public class Paciente implements Serializable{
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
       
    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s",
                getCedula(),
                getNombre(),
                getApellido(),
                getClave());
    }
}
