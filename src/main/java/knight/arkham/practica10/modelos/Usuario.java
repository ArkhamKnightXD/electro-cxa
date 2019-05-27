package knight.arkham.practica10.modelos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue // El problema de que solo se creaba un usuario era debido a que me faltaba el @Generatedvalue
    private long id;

    private String username;
    private boolean esAdmin;
    private String password;
    private boolean active;



    // Para solucionar el problema de que no me creaba los nuevos usuarios solo tuve que cambiar el cascadeType que estaba en
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private
    Set<Rol> roles;

    public Usuario(){ }

    public Usuario(long id, String username, boolean esAdmin, String password, boolean active, Set<Rol> roles) {
        this.id = id;
        this.username = username;
        this.esAdmin = esAdmin;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }

    // Constructor sin rol solo para testear la creacion de usuarios


    public Usuario(String username, boolean esAdmin, String password, boolean active) {
        this.username = username;
        this.esAdmin = esAdmin;
        this.password = password;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }


}
