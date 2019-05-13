package knight.arkham.practica10.modelos.seguridad;

import java.io.Serializable;

// implemento serializable ya que quiero serializar este objeto para poder convertir el objeto a bytes, ese objeto
// se puede enviar a través de red, guardarlo en un fichero, y después reconstruirlo al otra lado de la red
public class Usuario implements Serializable {


    private int id;

    private String username;
    private String password;
    private boolean activo;
    //Tener todos los campos necesarios de mi modelo..
    private String nombre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
