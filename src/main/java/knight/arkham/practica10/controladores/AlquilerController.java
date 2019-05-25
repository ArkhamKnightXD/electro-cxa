package knight.arkham.practica10.controladores;

import knight.arkham.practica10.modelos.Cliente;
import knight.arkham.practica10.servicios.AlquilerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("/alquiler")
public class AlquilerController {


    // En cada controlador preparo el servicio que le corresponde a cada controlador para poder trabajar con las funciones
    // del crud ya especificadas en los servicios, tener en cuenta que el services solo se puede trabajar dentro de funciones
    @Autowired
    private AlquilerServices alquilerServices;




    @RequestMapping("/")
    public String index(Model model){


        //Indicando el modelo que será pasado a la vista.
        model.addAttribute("titulo", "Electrodomesticos CXA");

        //Ubicando la vista desde resources/templates
        return "/freemarker/alquiler";
    }



    @RequestMapping("/creacion")
    public String creacionAlquiler(Model model){


        model.addAttribute("titulo", "Electrodomesticos CXA");


        //Ubicando la vista desde resources/templates
        return "/freemarker/crearalquiler";
    }



    // con error a la hora de crear
    @RequestMapping("/crear")
    public String crearAlquiler(Model model, @RequestParam(name = "fecha")Date fecha, @RequestParam(name = "fechaEntrega") Date fechaEntrega, @RequestParam(name = "nombreCliente") String nombreCliente, @RequestParam(name = "equiposAlquilados") String equiposAlquilados){

        // Agregando los parametros al cliente, no es necesario agregar el parametro id ya que anteriormente especificamos
        // que este se autogenerara cuando especificamos la entidad


        model.addAttribute("titulo", "Electrodomesticos CXA");
        model.addAttribute("mensaje","El cliente ha sido creado con exito");
        model.addAttribute("ruta","cliente");


        //Ubicando la vista desde resources/templates
        return "/freemarker/mensajes";
    }



    @RequestMapping("/borrar")
    public String eliminarAlquiler(Model model,  @RequestParam(name = "id") long id){


        // Aqui elimino el cliente mandandole el id obtenido mediante la url en el requesparam
        alquilerServices.eliminarAlquiler(id);

        model.addAttribute("titulo", "Electrodomesticos CXA");
        model.addAttribute("mensaje","El Alquiler ha sido eliminado con exito");
        model.addAttribute("ruta","alquiler");

        //Ubicando la vista desde resources/templates
        return "/freemarker/mensajes";
    }


}
