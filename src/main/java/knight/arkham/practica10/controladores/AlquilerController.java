package knight.arkham.practica10.controladores;

import knight.arkham.practica10.servicios.AlquilerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/alquiler")
public class AlquilerController {


    // En cada controlador preparo el servicio que le corresponde a cada controlador para poder trabajar con las funciones
    // del crud ya especificadas en los servicios, tener en cuenta que el services solo se puede trabajar dentro de funciones
    // nota no hay que agregar @Autowired cuando se trabaja con los servicios en el controlador, pues ya estan instanciados
    private AlquilerServices alquilerServices;



    @RequestMapping("/")
    public String index(Model model){


        //Indicando el modelo que será pasado a la vista.
        model.addAttribute("titulo", "Electrodomesticos CXA");

        //Ubicando la vista desde resources/templates
        return "/freemarker/alquiler";
    }
}
