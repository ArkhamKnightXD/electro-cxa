package knight.arkham.practica10.modelos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Alquiler implements Serializable {
    @Id
    @GeneratedValue
    private long id;

    private Date fecha;

    private Date fechaEntrega;

    // Relacion uno a mucho
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Cliente cliente;

    // Relacion mucho a mucho
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Equipo> equipos;

    private long total;

    public Alquiler() {
    }

    public Alquiler(Date fecha, Date fechaEntrega, Cliente cliente, List<Equipo> equipos, long total) {
        this.fecha = fecha;
        this.fechaEntrega = fechaEntrega;
        this.cliente = cliente;
        this.equipos = equipos;
        this.total = total;
    }

    public Alquiler(Date fecha, Date fechaEntrega, Cliente cliente, List<Equipo> equipos, List<Equipo> equiposNoDevueltos, long total) {
        this.fecha = fecha;
        this.fechaEntrega = fechaEntrega;
        this.cliente = cliente;
        this.equipos = equipos;
        this.total = total;
    }


    //En este metodo manejare lo que es la existencia de los distintos equipos a la hora de hacer el alquiler de un equioo
    public int controlarCantidadExistencia(int cantidadExistencia){

        cantidadExistencia--;

        return cantidadExistencia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
