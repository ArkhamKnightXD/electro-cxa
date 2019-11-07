package knight.arkham.practica10.controladores;
import knight.arkham.practica10.modelos.Familia;
import knight.arkham.practica10.servicios.FamiliaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.Principal;
import java.util.Locale;

@Controller
@RequestMapping("/familia")
public class FamiliaController {

    @Autowired
    private FamiliaService familiaService;

    @Autowired
    private MessageSource messageSource;


    @RequestMapping("/")
    public String index(Model model, Principal principal, Locale locale){

        model.addAttribute("titulo", "Electrodomesticos CXA");

        //Aqui mandare las distintas traducciones de i18n al index
        model.addAttribute("clientesi18n", messageSource.getMessage("clientesi18n", null, locale));
        model.addAttribute("equiposi18n", messageSource.getMessage("equiposi18n", null, locale));
        model.addAttribute("negocioi18n", messageSource.getMessage("negocioi18n", null, locale));
        model.addAttribute("alquileri18n", messageSource.getMessage("alquileri18n", null, locale));
        model.addAttribute("familiasi18n", messageSource.getMessage("familiasi18n", null, locale));
        model.addAttribute("administradori18n", messageSource.getMessage("administradori18n", null, locale));
        model.addAttribute("usuariosi18n", messageSource.getMessage("usuariosi18n", null, locale));
        model.addAttribute("opcionei18n", messageSource.getMessage("opcionei18n", null, locale));
        model.addAttribute("listafamiliai18n", messageSource.getMessage("listafamiliai18n", null, locale));
        model.addAttribute("agregarfamiliai18n", messageSource.getMessage("agregarfamiliai18n", null, locale));
        model.addAttribute("nombrefamiliai18n", messageSource.getMessage("nombrefamiliai18n", null, locale));
        model.addAttribute("subfamiliai18n", messageSource.getMessage("subfamiliai18n", null, locale));
        model.addAttribute("familiai18n", messageSource.getMessage("familiai18n", null, locale));

        model.addAttribute("familias", familiaService.listarFamilias());
        model.addAttribute("usuario", principal.getName());

        return "/freemarker/familia";
    }


    @RequestMapping("/creacion")
    public String creacionFamilia(Model model, Locale locale){

        model.addAttribute("agregarfamiliai18n", messageSource.getMessage("agregarfamiliai18n", null, locale));
        model.addAttribute("nombrefamiliai18n", messageSource.getMessage("nombrefamiliai18n", null, locale));
        model.addAttribute("subfamiliai18n", messageSource.getMessage("subfamiliai18n", null, locale));
        model.addAttribute("familiai18n", messageSource.getMessage("familiai18n", null, locale));
        model.addAttribute("botonguardari18n", messageSource.getMessage("botonguardari18n", null, locale));
        model.addAttribute("botoncancelari18n", messageSource.getMessage("botoncancelari18n", null, locale));

        model.addAttribute("titulo", "Electrodomesticos CXA");
        model.addAttribute("familias", familiaService.listarFamilias());

        return "/freemarker/crearfamilia";
    }

    // Para controlar que se pueda mandar el valor false en subfamilia tuve
    // que indicar el required false y este me permite dejar el checkbox vacio lo que me dara un valor falso

    // El id al final me daba el siguiente: error Consider declaring it as object wrapper for the corresponding primitive type.
    // Y se soluciona basicamente cambiando long por Long
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public String crearFamilia(@RequestParam(name = "nombre") String nombre, @RequestParam(name = "subFamilia", required = false) boolean subFamilia,@RequestParam(name = "idFamilia", required = false) Long idFamilia){

        //Ahora aqui debe de haber una eleccion, pues o se creara una familia normal o se creara una
        // subfamilia que va a tener una familia padre, por lo tanto usare un if aqui

        // Si se selecciona que no es una subfamilia aqui me creara una familia normal, este es el caso mas sencillo
        if (subFamilia == false){

            Familia familiaToCreate = new Familia(nombre,subFamilia);

            familiaService.crearFamilia(familiaToCreate);
        }

        // Este es el caso mas complejo aqui creo la subfamilia con su respectiva familia padre
        if (subFamilia == true){

            // Obtengo el id de la familia que estara asociada a la subfamilia y busco la familia mediante este
            // para asi agregarla a la subfamilia que creare, entro el familiatofind dentro de esta funcion
            // ya que afuera me daria error cuando no me llegue el id de familiapadre

            Familia familiaToFind = familiaService.encontrarFamiliaPorId(idFamilia);

            Familia familiaToCreate = new Familia(nombre,subFamilia, familiaToFind);

            familiaService.crearFamilia(familiaToCreate);

        }

        return "redirect:/familia/";
    }


    @RequestMapping("/borrar")
    public String eliminarFamilia(@RequestParam(name = "id") long id){

        familiaService.eliminarFamilia(id);

        return "redirect:/familia/";
    }
}
