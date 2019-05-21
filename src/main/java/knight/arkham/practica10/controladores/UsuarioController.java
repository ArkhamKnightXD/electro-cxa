package knight.arkham.practica10.controladores;

import knight.arkham.practica10.servicios.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    // Aqui retorno la pagina inicial

    @Autowired
    private UsuarioServices usuarioServices;


    // A este path solo debe ser posible acceder si eres administrador debo trabajar eso en la vista, por ahora dejare la entrada aqui
    // normal
    @RequestMapping("/")
    public String index(Model model){

        //Indicando el modelo que será pasado a la vista.
        model.addAttribute("titulo", "Electrodomesticos CXA");

        //Ubicando la vista desde resources/templates
        return "/freemarker/usuario";
    }


    @RequestMapping("/borrar")
    public String eliminarUsuario(Model model,  @RequestParam(name = "id") long id){


        // Aqui elimino el cliente mandandole el id obtenido mediante la url en el requesparam
        usuarioServices.eliminarUsuario(id);

        model.addAttribute("titulo", "Electrodomesticos CXA");
        model.addAttribute("mensaje","El Alquiler ha sido eliminado con exito");
        model.addAttribute("ruta","usuario");

        //Ubicando la vista desde resources/templates
        return "/freemarker/mensajes";
    }


}
