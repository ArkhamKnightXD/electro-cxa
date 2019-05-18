package knight.arkham.practica10.modelos;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Rol implements Serializable {

    @Id
    private
    String role;

    public Rol(){

    }

    public Rol(String role){
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
