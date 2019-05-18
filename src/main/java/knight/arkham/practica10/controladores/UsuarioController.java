package knight.arkham.practica10.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// El controlador usuario es el mas recomendado para que maneje el inicio de pagina y el login, asi que por lo tanto
// no se debe poner un requestmapping para que este trabaje en localhost:8080 directamente
@Controller
public class UsuarioController {

    // Aqui retorno la pagina inicial

    @RequestMapping("/")
    public String index(Model model){

        //Indicando el modelo que será pasado a la vista.
        model.addAttribute("titulo", "Electrodomesticos CXA");

        //Ubicando la vista desde resources/templates
        return "/freemarker/starter";
    }


    @RequestMapping("/index")
    public String index2(Model model){

        //Indicando el modelo que será pasado a la vista.
        model.addAttribute("titulo", "Electrodomesticos CXA");

        //Ubicando la vista desde resources/templates
        return "/freemarker/index";
    }


    @RequestMapping("/index2")
    public String index3(Model model){

        //Indicando el modelo que será pasado a la vista.
        model.addAttribute("titulo", "Electrodomesticos CXA");

        //Ubicando la vista desde resources/templates
        return "/freemarker/index2";
    }



}
