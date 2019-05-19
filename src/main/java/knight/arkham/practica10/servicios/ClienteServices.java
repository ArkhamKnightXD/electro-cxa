package knight.arkham.practica10.servicios;

import knight.arkham.practica10.modelos.Cliente;
import knight.arkham.practica10.repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class ClienteServices {

    @Autowired
    private ClienteRepositorio clienteRepo;


    @Transactional
    public Cliente crearCliente(Cliente cliente){

        return clienteRepo.save(cliente);
    }

    public List<Cliente> listarClientes(){

        return clienteRepo.findAll();
    }

    public Optional<Cliente> encontrarClientePorId(long id){

        return clienteRepo.findById(id);
    }

    public void eliminarCliente(Cliente cliente){

        clienteRepo.delete(cliente);
    }
}
