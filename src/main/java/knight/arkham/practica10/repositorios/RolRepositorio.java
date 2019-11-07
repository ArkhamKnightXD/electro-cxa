package knight.arkham.practica10.repositorios;
import knight.arkham.practica10.modelos.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepositorio extends JpaRepository<Rol, Long> {

    Rol findRolById(long id);
}
