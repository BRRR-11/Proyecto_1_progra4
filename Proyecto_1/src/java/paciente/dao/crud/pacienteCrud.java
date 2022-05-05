/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paciente.dao.crud;

import cr.ac.una.db.dao.crud.AbstractCRUD;

/**
 *
 * @author Admin
 */
public class pacienteCrud extends AbstractCRUD{
  @Override
    public String getListAllCmd() {
        return LIST_CMD;
    }

    @Override
    public String getAddCmd() {
        return ADD_CMD;
    }

    @Override
    public String getRetrieveCmd() {
        return RETRIEVE_CMD;
    }

    @Override
    public String getUpdateCmd() {
        return UPDATE_CMD;
    }

    @Override
    public String getDeleteCmd() {
        return DELETE_CMD;
    }

    protected static final String LIST_CMD
            = "SELECT "
            + "id, apellido1, apellido2, nombre, nacimiento "
            + "FROM bd_estudiantes.estudiante ORDER BY id; ";

    protected static final String ADD_CMD
            = "INSERT INTO bd_estudiantes.estudiante "
            + "(id, apellido1, apellido2, nombre, nacimiento) "
            + "VALUES (?, ?, ?, ?, ?); ";
    protected static final String RETRIEVE_CMD
            = "SELECT "
            + "id, apellido1, apellido2, nombre, nacimiento "
            + "FROM bd_estudiantes.estudiante WHERE id = ?; ";
    protected static final String UPDATE_CMD
            = "UPDATE bd_estudiantes.estudiante "
            + "SET apellido1 = ?, apellido2 = ?, nombre = ?, nacimiento = ? "
            + "WHERE id = ?; ";
    protected static final String DELETE_CMD
            = "DELETE FROM bd_estudiantes.estudiante "
            + "WHERE id = ?; ";
    
}
