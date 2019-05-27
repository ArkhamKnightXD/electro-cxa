package knight.arkham.practica10.controladores;

import knight.arkham.practica10.modelos.Equipo;
import knight.arkham.practica10.modelos.Rol;
import knight.arkham.practica10.modelos.Usuario;
import knight.arkham.practica10.repositorios.RolRepositorio;
import knight.arkham.practica10.servicios.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.*;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    // Aqui retorno la pagina inicial

    @Autowired
    private UsuarioServices usuarioServices;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    // A este path solo debe ser posible acceder si eres administrador debo trabajar eso en la vista, por ahora dejare la entrada aqui
    // normal
    @RequestMapping("/")
    public String index(Model model){

        Rol rolAdmin = new Rol("ROLE_ADMIN");
        Rol rol = new Rol("ROLE_USER");
        usuarioServices.crearRol(rolAdmin);
        usuarioServices.crearRol(rol);

        model.addAttribute("titulo", "Electrodomesticos CXA");
        model.addAttribute("usuarios",usuarioServices.listarUsuarios());

        return "/freemarker/usuario";
    }



    @RequestMapping("/creacion")
    public String creacionUsuario(Model model){


        model.addAttribute("titulo", "Electrodomesticos CXA");
        // Debo de mandarle los roles a crear para poder seleccionar
        model.addAttribute("roles", usuarioServices.listarRoles());

        //Ubicando la vista desde resources/templates
        return "/freemarker/crearusuario";
    }



    @RequestMapping( value = "/crear", method = RequestMethod.POST)
    public String crearUsuario(Model model, @RequestParam(name = "username") String username, @RequestParam(name = "esAdmin") boolean esAdmin,@RequestParam(name = "password") String password, @RequestParam(name = "roles") String roles ){

        Rol rolCreated = usuarioServices.encontrarRolPorNombre(roles);


        Usuario usuarioToCreate = new Usuario();
        usuarioToCreate.setUsername(username);
        usuarioToCreate.setEsAdmin(esAdmin);

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
