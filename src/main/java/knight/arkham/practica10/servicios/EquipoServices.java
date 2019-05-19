package knight.arkham.practica10.servicios;

import knight.arkham.practica10.modelos.Equipo;
import knight.arkham.practica10.repositorios.EquipoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class EquipoServices {

    @Autowired
    private EquipoRepositorio equipoRepo;

    @Transactional
    public Equipo crearEquipo(Equipo equipo){

        return equipoRepo.save(equipo);
    }

    public List<Equipo> listarEquipos(){

        return equipoRepo.findAll();
    }


    public Optional<Equipo> encontrarEquipoPorId(long id){
        return equipoRepo.findById(id);

    }


    public void eliminarEquipo(Equipo equipo){

        equipoRepo.delete(equipo);
    }
}
