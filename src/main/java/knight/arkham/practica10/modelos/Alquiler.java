package knight.arkham.practica10.modelos;

import java.util.Date;

public class Alquiler {

    private int id;

    private Date fechaEntregaEquipo;
    private Date fechaDevueltaEquipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaEntregaEquipo() {
        return fechaEntregaEquipo;
    }

    public void setFechaEntregaEquipo(Date fechaEntregaEquipo) {
        this.fechaEntregaEquipo = fechaEntregaEquipo;
    }

    public Date getFechaDevueltaEquipo() {
        return fechaDevueltaEquipo;
    }

    public void setFechaDevueltaEquipo(Date fechaDevueltaEquipo) {
        this.fechaDevueltaEquipo = fechaDevueltaEquipo;
    }
}
