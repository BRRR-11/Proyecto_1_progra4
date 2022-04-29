/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import presentacion.logic.Paciente;

public class PacienteDao {
    Database db;
    
    public PacienteDao(){
        db= Database.instance();
    }

    public void create(Paciente c) throws Exception{
        String sql="insert into paciente (cedula, nombre, apellido, clave) "+
                "values(?,?,?,?)";
        PreparedStatement stm = db.prepareStatement(sql);
        stm.setString(1, c.getCedula());
        stm.setString(2, c.getNombre());
        stm.setString(3, c.getApellido());
        stm.setString(4, c.getClave());
      
        int count=db.executeUpdate(stm);
        if (count==0){
            throw new Exception("Cliente ya existe");
        }
    }
//    
//    public Paciente read(String nombre) throws Exception{
//        String sql="select * from cliente c where nombre=?";
//        PreparedStatement stm = db.prepareStatement(sql);
//        stm.setString(1, nombre);
//        ResultSet rs =  db.executeQuery(stm);
//        if (rs.next()) {
//            Paciente c = from(rs, "c"); 
//            return c;
//        }
//        else{
//            throw new Exception ("Cliente no Existe");
//        }
//    }
//    public void update(Paciente c) throws Exception{
//        String sql="update cliente set nombre=?, password=?"+
//                "where nombre=?";
//        PreparedStatement stm = db.prepareStatement(sql);
//        stm.setString(1, c.getContraseña());
//        stm.setString(2, c.getNombre());
//        //stm.setDouble(3, c.getSaldo());
//        //stm.setString(3, c.getId());
//        int count=db.executeUpdate(stm);
//        if (count==0){
//            throw new Exception("Cliente no existe");
//        }        
//    }
//
//    public void delete(Paciente c) throws Exception{
//        String sql="delete from cliente where nombre=?";
//        PreparedStatement stm = db.prepareStatement(sql);
//        stm.setString(1, c.getNombre());
//        int count=db.executeUpdate(stm);
//        if (count==0){
//            throw new Exception("Cliente no existe");
//        }
//    }
//    
//    
//    public List<Paciente> findAll(){
//        List<Paciente> resultado=new ArrayList<>();
//        try {
//            String sql="select * from Cliente c";
//            PreparedStatement stm = db.prepareStatement(sql);
//            ResultSet rs =  db.executeQuery(stm);
//            Paciente c;
//            while (rs.next()) {
//                c = from(rs, "c"); 
//                resultado.add(c);
//            }
//        } catch (SQLException ex) { }
//        return resultado;        
//    }
//
//    public List<Paciente> findByUsuario(String id){
//        List<Paciente> resultado = new ArrayList<>();
//        try {
//            String sql="select * from cliente c "+
//                    "where c.nombre like ?";            
//            PreparedStatement stm = db.prepareStatement(sql);
//            stm.setString(1, id+"%");
//            ResultSet rs =  db.executeQuery(stm); 
//            Paciente c;
//            while (rs.next()) {
//                c = from(rs, "c"); 
//                resultado.add(c);
//            }
//        } catch (SQLException ex) {  }
//        return resultado;
//    }
//    
//    public Paciente from(ResultSet rs, String alias){
//        try {
//            Paciente c= new Paciente();
//            //c.setId(rs.getString(alias+".id"));
//            c.setNombre(rs.getString(alias+".nombre"));
//            c.setContraseña(rs.getString(alias+".password"));
//            c.setSaldo(rs.getDouble(alias+".saldo")); //Revisar
//            return c;
//        } catch (SQLException ex) {
//            return null;
//        }
//    }   
//    
//    public boolean validarUsuario(String usuario, String contraseña) throws Exception{
//        String sql = "select nombre from cliente where nombre=? and password=?";
//        PreparedStatement stm = db.prepareStatement(sql);
//        stm.setString(1, usuario);
//        stm.setString(2, contraseña);
//        ResultSet rs =  db.executeQuery(stm);
//        if (rs.next()) {
//            return true;
//        }
//        else{
//            return false;
//        }        
//    }
//    /*
//      public boolean validarContraseña(String contraseña) throws Exception{
//        String sql = "select nombre from cliente where password=?";
//        PreparedStatement stm = db.prepareStatement(sql);
//        stm.setString(1, contraseña);
//        ResultSet rs =  db.executeQuery(stm);
//        if (rs.next()) {
//            return true;
//        }
//        else{
//            return false;
//        }        
//    }*/
//    public void modificarContraseña(String usuario,String contraseña) throws Exception{
//        String sql="update cliente set password=?"+
//                "where nombre=?";
//        PreparedStatement stm = db.prepareStatement(sql);
//        stm.setString(1, contraseña);
//        stm.setString(2, usuario);
//        int count=db.executeUpdate(stm);
//        if (count==0){
//            throw new Exception("Cliente no existe");
//        }        
//    }
//    
//    public void modificarSaldo(String usuario,String saldo)throws Exception
//    {
//        String sql="update cliente set saldo=?"+
//                "where nombre=?";
//        PreparedStatement stm = db.prepareStatement(sql);
//        stm.setString(1, saldo);
//        stm.setString(2, usuario);
//        int count=db.executeUpdate(stm);
//        if (count==0){
//            throw new Exception("Cliente no existe");
//        } 
//    }
//    
}
