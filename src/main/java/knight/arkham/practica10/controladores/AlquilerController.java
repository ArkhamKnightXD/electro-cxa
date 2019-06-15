package knight.arkham.practica10.controladores;

import knight.arkham.practica10.modelos.Alquiler;
import knight.arkham.practica10.modelos.Cliente;
import knight.arkham.practica10.modelos.Equipo;
import knight.arkham.practica10.servicios.AlquilerServices;
import knight.arkham.practica10.servicios.ClienteServices;
import knight.arkham.practica10.servicios.EquipoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/alquiler")
public class AlquilerController {


    // En cada controlador preparo el servicio que le corresponde a cada controlador para poder trabajar con las funciones
    // del crud ya especificadas en los servicios, tener en cuenta que el services solo se puede trabajar dentro de funciones
    @Autowired
    private AlquilerServices alquilerServices;

    // Debo mandarle al alquiler los clientes y equipos ya creados, por lo tanto instanciare equiposervices y clienteservices
    @Autowired
    private EquipoServices equipoServices;

    @Autowired
    private ClienteServices clienteServices;

    @Autowired
    private MessageSource messageSource;


    @RequestMapping("/")
    public String index(Model model, Principal principal, Locale locale) {

        //Indicando el modelo que será pasado a la vista.
        model.addAttribute("titulo", "Electrodomesticos CXA");

        //Aqui mandare las distintas traducciones de i18n al index
        model.addAttribute("clientesi18n", messageSource.getMessage("clientesi18n", null, locale));

        model.addAttribute("equiposi18n", messageSource.getMessage("equiposi18n", null, locale));

        model.addAttribute("negocioi18n", messageSource.getMessage("negocioi18n", null, locale));

        model.addAttribute("alquileri18n", messageSource.getMessage("alquileri18n", null, locale));

        model.addAttribute("familiasi18n", messageSource.getMessage("familiasi18n", null, locale));

        model.addAttribute("administradori18n", messageSource.getMessage("administradori18n", null, locale));

        model.addAttribute("usuariosi18n", messageSource.getMessage("usuariosi18n", null, locale));

        model.addAttribute("equipos", equipoServices.listarEquipos());
        model.addAttribute("alquileres", alquilerServices.listarAlquileres());

        // Comento esto para no tener que estar utilizando el login siempre que toy jarto
        // model.addAttribute("usuario", principal.getName());
        //Ubicando la vista desde resources/templates
        return "/freemarker/alquiler";
    }


    @RequestMapping("/creacion")
    public String creacionAlquiler(Model model, Locale locale) {



        model.addAttribute("botonguardari18n", messageSource.getMessage("botonguardari18n", null, locale));
        model.addAttribute("botoncancelari18n", messageSource.getMessage("botoncancelari18n", null, locale));

        // Para poder crear un alquiler debo mandarle a la vista crearalquiler todos los equipos y clientes ya creados

        model.addAttribute("clientes", clienteServices.listarClientes());
        model.addAttribute("equipos", equipoServices.listarEquipos());

        model.addAttribute("titulo", "Electrodomesticos CXA");


        return "/freemarker/crearalquiler";
    }


    // error de fecha solucionado, para solucionarlo utilice @DatimeFormat, ya que spring me da error a la hora de mandar
    // fechas por el controlador, y con este metodo es posible solucionar este problema, en pattern pongo el formate que mi fecha tendra
    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public String crearAlquiler(@RequestParam(name = "fecha") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fecha, @RequestParam(name = "fechaEntrega") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaEntrega, @RequestParam(name = "idCliente") long idCliente, @RequestParam(name = "idEquipo") long idEquipo) {

        Equipo equipoAlquilado = equipoServices.encontrarEquipoPorId(idEquipo);

        List<Equipo> listaEquipo = new ArrayList<>();
        listaEquipo.add(equipoAlquilado);

        Cliente clienteQueAlquila = clienteServices.encontrarClientePorId(idCliente);

        // seteare el total en 500 solo para probar la correcta de un alquiler con todos sus campos
        Alquiler alquilerToCreate = new Alquiler(fecha, fechaEntrega, clienteQueAlquila, listaEquipo, 500);

        alquilerServices.crearAlquiler(alquilerToCreate);

        return "redirect:/alquiler/";
    }


    @RequestMapping("/borrar")
    public String eliminarAlquiler(@RequestParam(name = "id") long id) {


        // Aqui elimino el cliente mandandole el id obtenido mediante la url en el requesparam
        alquilerServices.eliminarAlquiler(id);

        return "redirect:/alquiler/";
    }


}
