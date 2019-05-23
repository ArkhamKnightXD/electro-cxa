package knight.arkham.practica10.repositorios;

import knight.arkham.practica10.modelos.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Aqui es donde se usaran las funciones del jpa para almacenar o listar los datos, esto siempre debe de ser una interfaz
// y debe extender de JpaRepository y dentro de este se especifican el modelo o la entidad con la que se va a trabajar
// seguido del tipo de dato con el que esta especificado el primary key de ese modelo

@Repository // Con esto especifico que esto es un repositorio
public interface AlquilerRepositorio extends JpaRepository<Alquiler, Long> {


    Alquiler findAlquilerById(long id);
}
