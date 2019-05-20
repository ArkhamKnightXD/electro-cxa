package knight.arkham.practica10.controladores;

import knight.arkham.practica10.modelos.Cliente;
import knight.arkham.practica10.repositorios.ClienteRepositorio;
import knight.arkham.practica10.servicios.ClienteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
        return "/freemarker/index2";
    }
}
