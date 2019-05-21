package knight.arkham.practica10.servicios;

import knight.arkham.practica10.modelos.Equipo;
import knight.arkham.practica10.repositorios.EquipoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EquipoServices {

    @Autowired
    private EquipoRepositorio equipoRepo;

    @Transactional
    public void crearEquipo(Equipo equipo){

         equipoRepo.save(equipo);
    }

    public List<Equipo> listarEquipos(){

        return equipoRepo.findAll();
    }


    public Equipo encontrarEquipoPorId(long id){
        return equipoRepo.findEquipoById(id);

    }


    public void eliminarEquipo(long id){

        Equipo equipoToDelete = equipoRepo.findEquipoById(id);
        equipoRepo.delete(equipoToDelete);
    }
}
