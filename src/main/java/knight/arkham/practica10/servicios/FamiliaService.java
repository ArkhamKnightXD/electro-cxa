package knight.arkham.practica10.servicios;

import knight.arkham.practica10.modelos.Familia;
import knight.arkham.practica10.repositorios.FamiliaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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

    public Optional<Familia> encontrarFamiliaPorId(long id){

        return familiaRepo.findById(id);

    }


    public void eliminarFamilia(Familia familia){

        familiaRepo.delete(familia);
    }


}
