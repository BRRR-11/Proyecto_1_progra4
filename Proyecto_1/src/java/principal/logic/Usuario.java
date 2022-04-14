
package principal.logic;

import java.io.Serializable;

public class Usuario implements Serializable, Jsonable{
    String id;
    String clave;
    
    public Usuario(String id, String clave) {
        this.id = id;
        this.clave = clave;
    }

    public Usuario() {
    }
    
    public String getId() {
        return id;
    }

    public String getClave() {
        return clave;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
