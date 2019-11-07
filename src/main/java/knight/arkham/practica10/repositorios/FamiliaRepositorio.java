package knight.arkham.practica10.repositorios;
import knight.arkham.practica10.modelos.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamiliaRepositorio extends JpaRepository<Familia, Long> {

    Familia findFamiliaById(long id);
}
