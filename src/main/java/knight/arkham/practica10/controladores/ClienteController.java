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


    @RequestMapping("/creacion")
    public String creacionCliente(Model model){


        model.addAttribute("titulo", "Electrodomesticos CXA");


        //Ubicando la vista desde resources/templates
        return "/freemarker/crearcliente";
    }



    // Esta url recibira varios parametros ya que creare un usuario obteniendo cada uno de los parametros desde
    // la vista mediante el formulario, para ser mas especifico el componente name de los input le proporcionara los parametros
    // a esta funcion por lo tanto no hay necesidad de usar ?X= en la url

    @RequestMapping("/crear")
    public String crearCliente(Model model,@RequestParam(name = "nombre") String nombre, @RequestParam(name = "apellido") String apellido, @RequestParam(name = "cedula") String cedula, @RequestParam(name = "direccion") String direccion, @RequestParam(name = "foto") String foto,  @RequestParam(name = "telefono") String telefono){

        // Agregando los parametros al cliente, no es necesario agregar el parametro id ya que anteriormente especificamos
        // que este se autogenerara cuando especificamos la entidad
        Cliente cliente = new Cliente(nombre,apellido,cedula,direccion,telefono,foto);

        // Aqui inserto cliente
        clienteServices.crearCliente(cliente);

        model.addAttribute("titulo", "Electrodomesticos CXA");
        model.addAttribute("mensaje","El cliente ha sido creado con exito");
        model.addAttribute("ruta","cliente");


        //Ubicando la vista desde resources/templates
        return "/freemarker/mensajes";
    }

// La pagina editarcliente no me sale solucionar eso
    @RequestMapping("/edicion")
    public String edicionCliente(Model model,  @RequestParam(name = "id") long id){

        // Para editar el cliente primero debo de buscarlo

        Cliente clienteToEdit = clienteServices.encontrarClientePorId(id);

        //Aqui le mando el cliente que editaremos a la vista de editar cliente para asi trabajar con sus datos y poder
        // modificarlos de manera correcta
        model.addAttribute("cliente",clienteToEdit);


        return "/freemarker/editarcliente";
    }

    // Como tengo que obtener el cliente de la vista aqui necesito un requesparam y le mando el parametro con /?id=cliente.id
    // desde la vista hacia esta funcion mediante la url
    @RequestMapping("/editar")
    public String editarCliente(Model model,  @RequestParam(name = "id") long id,@RequestParam(name = "nombre") String nombre, @RequestParam(name = "apellido") String apellido, @RequestParam(name = "cedula") String cedula, @RequestParam(name = "direccion") String direccion, @RequestParam(name = "foto") String foto,  @RequestParam(name = "telefono") String telefono){

        // Para editar el cliente primero debo de buscarlo


        // almaceno el cliente encontrado en el objeto clienteToEdit
        Cliente clienteToEdit = clienteServices.encontrarClientePorId(id);

        clienteToEdit.setApellido(apellido);
        clienteToEdit.setCedula(cedula);
        clienteToEdit.setDireccion(direccion);
        clienteToEdit.setNombre(nombre);
        clienteToEdit.setFoto(foto);

        // Aqui guardo el cliente de nuevo ya que .save funciona tanto como para crear nuevo o editar tengo que encontrar una forma de mandarle este
        clienteServices.crearCliente(clienteToEdit);


        model.addAttribute("titulo", "Electrodomesticos CXA");
        model.addAttribute("mensaje","El cliente ha sido editado con exito");
        model.addAttribute("ruta","cliente");

        //Ubicando la vista desde resources/templates
        return "/freemarker/editarcliente";
    }


    // Como tengo que obtener el id de la vista aqui necesito un requesparam, tengo que ver como hacer funcionar el editar
    // Para obtener el id mediante la vista tengo que mandarselo a la url mediante un href de esta forma ?id=
    // Entonces la url para borrar estaria por ejemplo de esta forma borrar/?id=3
    @RequestMapping("/borrar")
    public String eliminarCliente(Model model,  @RequestParam(name = "id") long id){


        // Aqui elimino el cliente mandandole el id obtenido mediante la url en el requesparam
          clienteServices.eliminarCliente(id);

          model.addAttribute("titulo", "Electrodomesticos CXA");
          model.addAttribute("mensaje","El cliente ha sido eliminado con exito");
          model.addAttribute("ruta","cliente");

        //Ubicando la vista desde resources/templates
        return "/freemarker/mensajes";
    }


}
