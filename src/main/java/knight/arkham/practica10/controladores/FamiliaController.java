package knight.arkham.practica10.controladores;

import knight.arkham.practica10.servicios.FamiliaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/familia")
public class FamiliaController {

    private FamiliaService familiaService;

    @RequestMapping("/")
    public String index(Model model){

        //Indicando el modelo que será pasado a la vista.
        model.addAttribute("titulo", "Electrodomesticos CXA");

        //Ubicando la vista desde resources/templates
        return "/freemarker/familia";
    }
}
