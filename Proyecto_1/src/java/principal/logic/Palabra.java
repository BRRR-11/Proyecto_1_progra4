/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package principal.logic;

import java.io.Serializable;

public class Palabra implements Serializable, Jsonable{
    String texto;

   public Palabra(){
       this("");
   }
   
   public Palabra(String texto){
        this.texto=texto;
   }
   
   public void setTexto(String texto) {
       this.texto=texto;
   }
   
   public String getTexto() {
        return texto;
    }
}