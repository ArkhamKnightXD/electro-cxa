package knight.arkham.practica10.controladores;

import knight.arkham.practica10.servicios.SeguridadServices;
import knight.arkham.practica10.servicios.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    SeguridadServices seguridadServices;

    @RequestMapping("/")
    public String index(Model model){

        // Aqui creo el usuario administrador lo creo aqui ya que basicamente este es la primera url de entrada y por lo tanto
        // el usuario se creara al comienzo

        seguridadServices.crearUsuarioAdmin();
        //Indicando el modelo que será pasado a la vista.
        model.addAttribute("titulo", "Electrodomesticos CXA");

        //Ubicando la vista desde resources/templates
        return "/freemarker/starter";
    }
}
