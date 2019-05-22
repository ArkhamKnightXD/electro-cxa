package knight.arkham.practica10.repositorios;

import knight.arkham.practica10.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

    // En la mayoria de casos no es necesario agregar nada dentro de estas interfaces ya que con el solo hecho de crearlas
    // podremos acceder a todas sus funcionalidaddes desde otras clases
    // La unica excepciones son cuando se desee implementar codigo SQL para ahcer algo mas especifico

    Usuario findUsuarioById(long id);

    Usuario findByUsername(String username);
}
