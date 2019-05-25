package knight.arkham.practica10.servicios;

import knight.arkham.practica10.modelos.Cliente;
import knight.arkham.practica10.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteServices {

    @Autowired
    private ClienteRepositorio clienteRepo;


    @Transactional
    public void crearCliente(Cliente cliente){

         clienteRepo.save(cliente);
    }

    public List<Cliente> listarClientes(){

        return clienteRepo.findAll();
    }

    public Cliente encontrarClientePorId(long id){

        return clienteRepo.findClienteById(id);
    }

    public void eliminarCliente(long id){

       // Igualo  el cliente al cliente que buscamos mediante el id
       Cliente clienteToDelete = clienteRepo.findClienteById(id);

       // y aqui lo borro
       clienteRepo.delete(clienteToDelete);
    }
}
