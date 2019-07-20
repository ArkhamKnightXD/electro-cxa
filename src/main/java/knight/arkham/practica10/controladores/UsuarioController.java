package knight.arkham.practica10.controladores;

import knight.arkham.practica10.modelos.*;
import knight.arkham.practica10.servicios.ClienteServices;
import knight.arkham.practica10.servicios.EquipoServices;
import knight.arkham.practica10.servicios.FamiliaService;
import knight.arkham.practica10.servicios.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.security.Principal;
import java.util.*;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {


    @Autowired
    private UsuarioServices usuarioServices;

    @Autowired
    private ClienteServices clienteServices;

    @Autowired
    private EquipoServices equipoServices;

    @Autowired
    private FamiliaService familiaService;


    @Autowired
    private MessageSource messageSource;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();



    //Este boton se encargara de crear clientes equipos y familias por defecto, ya que es un trabajo muy tedioso tener que hacer esto
    //siempre que se reinicie la aplicaion
    @RequestMapping("/default")
    public String defaultCreate(Model model){


        //Creacion de cliente por defecto
        Cliente clientePorDefecto = new Cliente("Karvin","Jimenez","402-222445","Calle 9","809-227-3540","foto.jpg");
        Cliente clientePorDefecto2 = new Cliente("Samuel","Jimenez","402-231145","Calle 9","809-257-3940","foto1.jpg");
        clienteServices.crearCliente(clientePorDefecto);
        clienteServices.crearCliente(clientePorDefecto2);

        //Creacion de las familias por defecto
        Familia familiaPorDefecto = new Familia("Videojuegos",false);

        //Aqui agregare dias de alquiler por defecto  las familias por defecto
        List<Integer> diasAlquiladosPorDefault = new ArrayList<>();
        diasAlquiladosPorDefault.add(5);
        diasAlquiladosPorDefault.add(4);
        diasAlquiladosPorDefault.add(7);


        familiaPorDefecto.setDiasAlquiler(diasAlquiladosPorDefault);

        familiaPorDefecto.setPromedio(familiaPorDefecto.getPromedio());


        familiaService.crearFamilia(familiaPorDefecto);

        Familia subFamiliaPorDefecto = new Familia("Consolas",true,familiaPorDefecto);

        subFamiliaPorDefecto.setDiasAlquiler(diasAlquiladosPorDefault);
        subFamiliaPorDefecto.setPromedio(subFamiliaPorDefecto.getPromedio());

        familiaService.crearFamilia(subFamiliaPorDefecto);

        Familia subFamiliaPorDefecto2 = new Familia("Portatiles",true,familiaPorDefecto);

        subFamiliaPorDefecto2.setDiasAlquiler(diasAlquiladosPorDefault);
        subFamiliaPorDefecto2.setPromedio(subFamiliaPorDefecto.getPromedio());

        familiaService.crearFamilia(subFamiliaPorDefecto2);


        //Creacion de equipos por defecto
        Equipo equipoPorDefecto = new Equipo("PlayStation 2","Sony","play.jpg",7,250,familiaPorDefecto,subFamiliaPorDefecto);

        equipoServices.crearEquipo(equipoPorDefecto);

        return "redirect:/usuario/";
    }



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

        model.addAttribute("listausuarioi18n", messageSource.getMessage("listausuarioi18n", null, locale));
        model.addAttribute("agregarusuarioi18n", messageSource.getMessage("agregarusuarioi18n", null, locale));
        model.addAttribute("nombreusuarioi18n", messageSource.getMessage("nombreusuarioi18n", null, locale));
        model.addAttribute("activousuarioi18n", messageSource.getMessage("activousuarioi18n", null, locale));

        model.addAttribute("usuarios",usuarioServices.listarUsuarios());

        model.addAttribute("usuario", principal.getName());

        return "/freemarker/usuario";
    }



    @RequestMapping("/creacion")
    public String creacionUsuario(Model model, Locale locale){

        model.addAttribute("titulo", "Electrodomesticos CXA");
        model.addAttribute("agregarusuarioi18n", messageSource.getMessage("agregarusuarioi18n", null, locale));
        model.addAttribute("nombreusuarioi18n", messageSource.getMessage("nombreusuarioi18n", null, locale));
        model.addAttribute("passwordusuarioi18n", messageSource.getMessage("passwordusuarioi18n", null, locale));
        model.addAttribute("rolusuarioi18n", messageSource.getMessage("rolusuarioi18n", null, locale));
        model.addAttribute("botonguardari18n", messageSource.getMessage("botonguardari18n", null, locale));
        model.addAttribute("botoncancelari18n", messageSource.getMessage("botoncancelari18n", null, locale));

        //Aqui mando los roles a la ventana de crear usuario
        model.addAttribute("roles", usuarioServices.listarRoles());

        return "/freemarker/crearusuario";
    }


    @RequestMapping( value = "/crear", method = RequestMethod.POST)
    public String crearUsuario(@RequestParam(name = "username") String username,@RequestParam(name = "password") String password, @RequestParam(name = "idRoles") long idRoles ){


        // Aqui le mando el id para que me busque el rol creado
        Rol rolCreated = usuarioServices.encontrarRolPorId(idRoles);

        Usuario usuarioToCreate = new Usuario();
        usuarioToCreate.setUsername(username);

        // Esta es la forma correcta de mandarle el rol al usuario
        usuarioToCreate.setRoles(new HashSet<>(Arrays.asList(rolCreated)));

        // Aqui encripto la pass a igual que como hice en usuario admin ya que sin  esto no me reconoce las otras
        // cuentas de usuario debido a la contraseña
        usuarioToCreate.setPassword(passwordEncoder.encode(password));

        // No es necesario aclarar en el create que el usuario esta activo pues si se crea se supone que esta activo,
        // asi que se puede definir de una vez aqui
        usuarioToCreate.setActive(true);

        // Aqui inserto cliente
        usuarioServices.crearUsuario(usuarioToCreate);

        return "redirect:/usuario/";
    }


    // Considero que editar usuario no es necesario, por lo tanto no creare estas funciones
    @RequestMapping("/borrar")
    public String eliminarUsuario(@RequestParam(name = "id") long id){


        usuarioServices.eliminarUsuario(id);

        return "redirect:/usuario/";
    }


}