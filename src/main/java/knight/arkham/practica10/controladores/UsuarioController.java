package knight.arkham.practica10.controladores;

import knight.arkham.practica10.modelos.Equipo;
import knight.arkham.practica10.modelos.Rol;
import knight.arkham.practica10.modelos.Usuario;
import knight.arkham.practica10.servicios.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    // Aqui retorno la pagina inicial

    @Autowired
    private UsuarioServices usuarioServices;


    // A este path solo debe ser posible acceder si eres administrador debo trabajar eso en la vista, por ahora dejare la entrada aqui
    // normal
    @RequestMapping("/")
    public String index(Model model){

        model.addAttribute("titulo", "Electrodomesticos CXA");
        model.addAttribute("usuarios",usuarioServices.listarUsuarios());

        return "/freemarker/usuario";
    }



    @RequestMapping("/creacion")
    public String creacionUsuario(Model model){


        model.addAttribute("titulo", "Electrodomesticos CXA");


        //Ubicando la vista desde resources/templates
        return "/freemarker/crearusuario";
    }


    @RequestMapping( value = "/crear", method = RequestMethod.POST)
    public String crearUsuario(Model model, @RequestParam(name = "username") String username, @RequestParam(name = "esAdmin") boolean esAdmin,@RequestParam(name = "password") String password ){

        // para la creacion de los roles puedo usar el mismo metodo que utilice en alquiler tanto en el controlador como en la vista


//        Rol rolAdmin = new Rol("ROLE_ADMIN");
        // Ver como lograr agregar los roles en esto, ya que es necesario que el usuario admin pueda definir los roles
        // por lo tanto debo saber como trabajar con estos tanto en el controlador como en la vista
        Usuario usuarioToCreate = new Usuario();
        usuarioToCreate.setUsername(username);
        usuarioToCreate.setPassword(password);
        usuarioToCreate.setEsAdmin(esAdmin);
        // No es necesario aclarar en el create que el usuario esta activo pues si se crea se supone que esta activo,
        // asi que se puede definir de una vez aqui
        usuarioToCreate.setActive(true);

        // Aqui inserto cliente
        usuarioServices.crearUsuario(usuarioToCreate);

        model.addAttribute("titulo", "Electrodomesticos CXA");
        model.addAttribute("mensaje","El usuario ha sido creado con exito");
        model.addAttribute("ruta","usuario");


        return "/freemarker/mensajes";
    }


    // Considero que editar usuario no es necesario, por lo tanto no creare estas funciones

    @RequestMapping("/borrar")
    public String eliminarUsuario(Model model,  @RequestParam(name = "id") long id){


        // Aqui elimino el cliente mandandole el id obtenido mediante la url en el requesparam
        usuarioServices.eliminarUsuario(id);

        model.addAttribute("titulo", "Electrodomesticos CXA");
        model.addAttribute("mensaje","El usuario ha sido eliminado con exito");
        model.addAttribute("ruta","usuario");

        //Ubicando la vista desde resources/templates
        return "/freemarker/mensajes";
    }


}
