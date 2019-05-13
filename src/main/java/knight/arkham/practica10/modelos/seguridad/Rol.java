package knight.arkham.practica10.modelos.seguridad;

import java.io.Serializable;

public class Rol implements Serializable {

    private String role;

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
