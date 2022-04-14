/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.administrador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
//import sistema.Aplicacion;
import presentacion.logic.Cita;
//import sistema.logico.Service;

public class Controller {
    Model model;
//    ViewCambio view;

    public Controller(Model model) {
        this.model = model;
//        this.view = view;
        // invoke Model sets for initialization before linking to the view
        // problably get the data from Service
        model.setCita(new Cita());
        model.setCitas(new ArrayList<>());
        
//        view.setModel(model);
//        view.setController(this);
    }
    
//    public void show(){
//        this.view.setVisible(true);
//    }
//    
//    public void hide(){
//        this.view.setVisible(false);
//        Aplicacion.PRINCIPAL.show();
//    }    
//    public void setearUsuario(String usuario){
//        this.view.usuarioTextCambio.setText(usuario);
//    }
    
    // Controller methods that respond to View events
    // probably invoke methods from Service,
    // and set data to Model, which in turn causes the View to update 
    
    public void clienteGet(String cedula){
        try {
            Cita cita ;
//            model.setCita(cita);
            //model.setClientes(Arrays.asList(cliente));
            model.commit();
        } catch (Exception ex) {
            model.setCita(new Cita());
            model.setCitas(new ArrayList<>());
            model.commit();
        }
    }
    
    public void  clienteSearch(String nombre){
//        List<Cliente> clientes= Service.instance().clienteSearch(nombre);
//        model.setCliente(new Cliente(nombre,""));
//        model.setClientes(clientes);
//        model.commit();
    }
    
    public void clienteEdit(int row){
//        Cliente cliente = model.getClientes().get(row);
//        model.setCliente(cliente);
//        model.commit();
    }  
}
