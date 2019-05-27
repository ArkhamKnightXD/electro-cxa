package knight.arkham.practica10.controladores;

import knight.arkham.practica10.servicios.FamiliaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/familia")
public class FamiliaController {

    // El asunto de la familia y la subfamilia es lo mas irrelevante para el funcionamiento del programa, por lo tanto es recomendable
    //hacer mas enfasis en esta clase cuando los puntos mas importantes de la tarea hayan sido resueltos

    @Autowired
    private FamiliaService familiaService;

    @RequestMapping("/")
    public String index(Model model){

        //Indicando el modelo que será pasado a la vista.
        model.addAttribute("titulo", "Electrodomesticos CXA");
        model.addAttribute("familias", familiaService.listarFamilias());
        //Ubicando la vista desde resources/templates
        return "/freemarker/familia";
    }


    @RequestMapping("/borrar")
    public String eliminarFamilia(Model model,  @RequestParam(name = "id") long id){


        // Aqui elimino el cliente mandandole el id obtenido mediante la url en el requesparam
        familiaService.eliminarFamilia(id);

        model.addAttribute("titulo", "Electrodomesticos CXA");
        model.addAttribute("mensaje","La familia ha sido eliminada con exito");
        model.addAttribute("ruta","familia");

        //Ubicando la vista desde resources/templates
        return "/freemarker/mensajes";
    }
}
