package knight.arkham.practica10.servicios;

import knight.arkham.practica10.modelos.Alquiler;
import knight.arkham.practica10.repositorios.AlquilerRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class AlquilerServices {

    // Por cada repositorio se debe de crear un servicio e implementar cada repositorio en su respectivo servicio
    // ya que los servicios son los encargados de manejar las reglas de negocios y por lo tanto de aqui sera que se obtendran
    // los datos para trabajar en los respectivos controladores

    @Autowired
    private AlquilerRepositorio alquilerRepo;

    // Aqui manejare las funciones que utilizare en la vista para el manejo de datos, las funciones que especificare
    // y estas seran las 4 funciones basicas de los CRUD



    @Transactional
    public Alquiler crearAlquiler(Alquiler alquiler){

        return alquilerRepo.save(alquiler);
    }


    public List<Alquiler> listarAlquileres(){
        return alquilerRepo.findAll();
    }


    public Optional<Alquiler> encontrarAlquilerPorId(long id){

        return alquilerRepo.findById(id);

    }

    public void eliminarAlquiler(Alquiler alquiler){

        alquilerRepo.delete(alquiler);
    }


}
