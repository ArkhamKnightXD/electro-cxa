package knight.arkham.practica10.servicios;

import knight.arkham.practica10.modelos.Familia;
import knight.arkham.practica10.repositorios.FamiliaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class FamiliaService {

    @Autowired
    private FamiliaRepositorio familiaRepo;

    @Transactional
    public void crearFamilia(Familia familia){

         familiaRepo.save(familia);
    }

    public List<Familia> listarFamilias(){

        return familiaRepo.findAll();
    }

    public Familia encontrarFamiliaPorId(long id){

        return familiaRepo.findFamiliaById(id);

    }


    public void eliminarFamilia(long id){

        Familia familiaToDelete = familiaRepo.findFamiliaById(id);
        familiaRepo.delete(familiaToDelete);
    }


}
