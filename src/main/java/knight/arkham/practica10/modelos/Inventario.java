package knight.arkham.practica10.modelos;

import java.io.Serializable;

public class Inventario implements Serializable {

    private int id;

    private int nombreEquipo;
    private int cantidadEquipo;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(int nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public int getCantidadEquipo() {
        return cantidadEquipo;
    }

    public void setCantidadEquipo(int cantidadEquipo) {
        this.cantidadEquipo = cantidadEquipo;
    }
}
