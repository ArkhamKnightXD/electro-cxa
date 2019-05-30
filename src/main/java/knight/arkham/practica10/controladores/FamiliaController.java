package knight.arkham.practica10.controladores;

import knight.arkham.practica10.modelos.Familia;
import knight.arkham.practica10.servicios.FamiliaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/familia")
public class FamiliaController {

    // Trabajar con familia para ya terminar un equipo completo

    @Autowired
    private FamiliaService familiaService;

    @RequestMapping("/")
    public String index(Model model, Principal principal){

        //Indicando el modelo que será pasado a la vista.
        model.addAttribute("titulo", "Electrodomesticos CXA");
        model.addAttribute("familias", familiaService.listarFamilias());

        model.addAttribute("usuario", principal.getName());

        return "/freemarker/familia";
    }


    @RequestMapping("/creacion")
    public String creacionFamilia(Model model){


        model.addAttribute("titulo", "Electrodomesticos CXA");


        //Ubicando la vista desde resources/templates
        return "/freemarker/crearfamilia";
    }

    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public String crearFamilia(Model model, @RequestParam(name = "nombre") String nombre, @RequestParam(name = "subFamilia") boolean subFamilia){

        // intentar agregar la eleccion de familia y subfamilia en el create del misma forma que utilize en alquiler
        Familia familiaToCreate = new Familia(nombre,subFamilia);

        familiaService.crearFamilia(familiaToCreate);


        model.addAttribute("titulo", "Electrodomesticos CXA");
        model.addAttribute("mensaje","La familia ha sido creada con exito");
        model.addAttribute("ruta","familia");


        //Ubicando la vista desde resources/templates
        return "/freemarker/mensajes";
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
