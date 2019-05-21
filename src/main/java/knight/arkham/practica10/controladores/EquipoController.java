package knight.arkham.practica10.controladores;

import knight.arkham.practica10.servicios.EquipoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/equipo")
public class EquipoController {

    @Autowired
    private EquipoServices equipoServices;

    @RequestMapping("/")
    public String index(Model model){

        //Indicando el modelo que será pasado a la vista.
        model.addAttribute("titulo", "Electrodomesticos CXA");

        //Ubicando la vista desde resources/templates
        return "/freemarker/equipo";
    }


    @RequestMapping("/borrar")
    public String eliminarEquipo(Model model,  @RequestParam(name = "id") long id){


        // Aqui elimino el cliente mandandole el id obtenido mediante la url en el requesparam
        equipoServices.eliminarEquipo(id);

        model.addAttribute("titulo", "Electrodomesticos CXA");
        model.addAttribute("mensaje","El equipo ha sido eliminado con exito");


        //Ubicando la vista desde resources/templates
        return "/freemarker/mensajes";
    }


}
