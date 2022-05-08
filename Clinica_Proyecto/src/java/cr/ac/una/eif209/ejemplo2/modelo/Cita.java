/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.eif209.ejemplo2.modelo;

public class Cita {
    String id_Medico;
    String id_Paciente;
    String hora;
    String estado;

    public Cita() {
        this("","","","");
    }

    public Cita(String id_Medico, String id_Paciente, String hora, String estado) {
        this.id_Medico = id_Medico;
        this.id_Paciente = id_Paciente;
        this.hora = hora;
        this.estado = estado;
    }

    public String getId_Medico() {
        return id_Medico;
    }

    public void setId_Medico(String id_Medico) {
        this.id_Medico = id_Medico;
    }

    public String getId_Paciente() {
        return id_Paciente;
    }

    public void setId_Paciente(String id_Paciente) {
        this.id_Paciente = id_Paciente;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s",
                getId_Medico(),
                getId_Paciente(),
                getHora(),
                getEstado());
    }

    public String VerCita() {
        return String.format("%s, %s,%s",
                getId_Medico(),
                getHora(),
                getEstado());
    }
    
    
}
