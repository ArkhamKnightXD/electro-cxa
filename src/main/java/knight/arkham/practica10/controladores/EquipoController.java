package knight.arkham.practica10.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/thymeleaf")
public class EquipoController {



    // Ejemplo de como mandar datos por defecto
    @RequestMapping(path = "/index")
    public String indexDefault(Model model, @RequestParam(name = "matricula",required = false, defaultValue = "Mensaje por defecto") String matricula){

        //De esta forma es que mando los atributos a la vista

        model.addAttribute("titulo", "Electrodomesticos CXA");
        model.addAttribute("mensaje", "Prueba de bootstrap");
        model.addAttribute("matricula", matricula);

        // direccioando a la vista.
        return "/thymeleaf/starter";
    }



    @RequestMapping(path = "/index2")
    public String index2(Model model){

        //De esta forma es que mando los atributos a la vista

        model.addAttribute("titulo", "Electrodomesticos CXA");
        // direccioando a la vista.
        return "/thymeleaf/index2";
    }


    @RequestMapping(path = "/index3")
    public String index3(Model model){

        //De esta forma es que mando los atributos a la vista

        model.addAttribute("titulo", "Electrodomesticos CXA");
        // direccioando a la vista.
        return "/thymeleaf/index";
    }

}
