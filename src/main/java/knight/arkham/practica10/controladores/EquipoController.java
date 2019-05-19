package knight.arkham.practica10.controladores;

import knight.arkham.practica10.servicios.EquipoServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/equipo")
public class EquipoController {

    private EquipoServices equipoServices;

    @RequestMapping("/")
    public String index(Model model){

        //Indicando el modelo que será pasado a la vista.
        model.addAttribute("titulo", "Electrodomesticos CXA");

        //Ubicando la vista desde resources/templates
        return "/freemarker/equipo";
    }


}
