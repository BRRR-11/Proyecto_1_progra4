/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.data;

import java.io.IOException;

import javax.sql.DataSource;


public class Pacientedb {
  
    public static DataSource db() throws IOException {
        return cr.ac.una.db.Database.getInstance(CONFIGURACION);
    }

    @Override
    public String toString() {
        String r;
        try {
            r = db().toString();
        } catch (IOException ex) {
            r = String.format("(Excepción: '%s')", ex.getMessage());
        }
        return r;
    }

    public static final String CONFIGURACION = "/presentacion/data/paciente.properties";
}

