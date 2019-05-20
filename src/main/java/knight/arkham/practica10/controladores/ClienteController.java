package knight.arkham.practica10.controladores;

import knight.arkham.practica10.modelos.Cliente;
import knight.arkham.practica10.repositorios.ClienteRepositorio;
import knight.arkham.practica10.servicios.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cliente")
public class ClienteController {


    @Autowired
    private ClienteServices clienteServices;


    @RequestMapping("/")
    public String index(Model model){

        //Indicando el modelo que será pasado a la vista.
        model.addAttribute("titulo", "Electrodomesticos CXA");

        // Aqui le mando el listado de clientes a la vista
        model.addAttribute("clientes", clienteServices.listarClientes());


        //Ubicando la vista desde resources/templates
        return "/freemarker/cliente";
    }

    @RequestMapping("/crear")
    public String crearCliente(Model model){

        // Agregando cliente de prueba
        Cliente cliente = new Cliente("Samuel","Jimenez","4645644","Calle 9","80958247","foto.jpg");

        // Aqui inserto cliente de prueba
        clienteServices.crearCliente(cliente);



        //Ubicando la vista desde resources/templates
        return "/freemarker/cliente";
    }


    // Como tengo que obtener el cliente de la vista aqui necesito un requesparam
    @RequestMapping("/editar")
    public String editarCliente(Model model,  @RequestParam(name = "id") long id){

        // Para editar el cliente primero debo de buscarlo


        clienteServices.encontrarClientePorId(id);

        // Aqui guardo el cliente de nuevo ya que .save funciona tanto como para crear nuevo o editar tengo que encontrar una forma de mandarle este
      //  clienteServices.crearCliente();



        //Ubicando la vista desde resources/templates
        return "/freemarker/editarcliente";
    }


    // Como tengo que obtener el id de la vista aqui necesito un requesparam, tengo que ver como hacer funcionar el editar
    @RequestMapping("/borrar")
    public String eliminarCliente(Model model,  @RequestParam(name = "cliente") Cliente cliente){

        // Agregando cliente de prueba


        // Aqui elimino el cliente
          clienteServices.eliminarCliente(cliente);



        //Ubicando la vista desde resources/templates
        return "/freemarker/cliente";
    }


}
