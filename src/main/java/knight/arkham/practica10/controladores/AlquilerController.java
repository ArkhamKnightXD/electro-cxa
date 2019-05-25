package knight.arkham.practica10.controladores;

import knight.arkham.practica10.modelos.Alquiler;
import knight.arkham.practica10.modelos.Cliente;
import knight.arkham.practica10.modelos.Equipo;
import knight.arkham.practica10.servicios.AlquilerServices;
import knight.arkham.practica10.servicios.ClienteServices;
import knight.arkham.practica10.servicios.EquipoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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



    @RequestMapping("/")
    public String index(Model model){

        //Indicando el modelo que será pasado a la vista.
        model.addAttribute("titulo", "Electrodomesticos CXA");

        model.addAttribute("alquileres",alquilerServices.listarAlquileres());
        //Ubicando la vista desde resources/templates
        return "/freemarker/alquiler";
    }



    @RequestMapping("/creacion")
    public String creacionAlquiler(Model model){


        // Para poder crear un alquiler debo mandarle a la vista crearalquiler todos los equipos y clientes ya creados

        model.addAttribute("clientes", clienteServices.listarClientes());
        model.addAttribute("equipos", equipoServices.listarEquipos());

        model.addAttribute("titulo", "Electrodomesticos CXA");


        //Ubicando la vista desde resources/templates
        return "/freemarker/crearalquiler";
    }



    // con error a la hora de crear
    @RequestMapping("/crear")
    public String crearAlquiler(Model model, @RequestParam(name = "fecha")String fecha, @RequestParam(name = "fechaEntrega") String fechaEntrega, @RequestParam(name = "idCliente") long idCliente,@RequestParam(name = "idEquipo") long idEquipo){

        Equipo equipoAlquilado = equipoServices.encontrarEquipoPorId(idEquipo);

        List<Equipo> listaEquipo =new ArrayList<>();
        listaEquipo.add(equipoAlquilado);

        Cliente clienteQueAlquila = clienteServices.encontrarClientePorId(idCliente);
        Alquiler alquilerToCreate = new Alquiler(fecha,fechaEntrega,clienteQueAlquila,listaEquipo);

        alquilerServices.crearAlquiler(alquilerToCreate);

        model.addAttribute("titulo", "Electrodomesticos CXA");
        model.addAttribute("mensaje","El alquiler ha sido creado con exito");
        model.addAttribute("ruta","alquiler");


        //Ubicando la vista desde resources/templates
        return "/freemarker/mensajes";
    }



    @RequestMapping("/borrar")
    public String eliminarAlquiler(Model model,  @RequestParam(name = "id") long id){


        // Aqui elimino el cliente mandandole el id obtenido mediante la url en el requesparam
        alquilerServices.eliminarAlquiler(id);

        model.addAttribute("titulo", "Electrodomesticos CXA");
        model.addAttribute("mensaje","El Alquiler ha sido eliminado con exito");
        model.addAttribute("ruta","alquiler");

        //Ubicando la vista desde resources/templates
        return "/freemarker/mensajes";
    }


}
