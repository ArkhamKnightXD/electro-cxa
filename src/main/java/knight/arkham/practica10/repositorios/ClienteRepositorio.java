package knight.arkham.practica10.repositorios;

import knight.arkham.practica10.modelos.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

    // En los repositorio puedo definir cualquier funcion extra que desee para luego implementarla en los servicios
    // Ya cuando declaro esta funcion aqui, puedo llamarla en el servicio para trabajar con esta

    Cliente findClienteById(long id);
}
