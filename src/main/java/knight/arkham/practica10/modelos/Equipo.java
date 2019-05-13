package knight.arkham.practica10.modelos;

import java.io.Serializable;

public class Equipo implements Serializable {

    private int id;

    private String nombre;
    private String marca;
    private String modelo;
    private String imagenEquipo;
    private int cantidadExistencia;
    private float costoAlquilerPorDia;
    private float tarifa;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getImagenEquipo() {
        return imagenEquipo;
    }

    public void setImagenEquipo(String imagenEquipo) {
        this.imagenEquipo = imagenEquipo;
    }

    public int getCantidadExistencia() {
        return cantidadExistencia;
    }

    public void setCantidadExistencia(int cantidadExistencia) {
        this.cantidadExistencia = cantidadExistencia;
    }

    public float getCostoAlquilerPorDia() {
        return costoAlquilerPorDia;
    }

    public void setCostoAlquilerPorDia(float costoAlquilerPorDia) {
        this.costoAlquilerPorDia = costoAlquilerPorDia;
    }

    public float getTarifa() {
        return tarifa;
    }

    public void setTarifa(float tarifa) {
        this.tarifa = tarifa;
    }
}
