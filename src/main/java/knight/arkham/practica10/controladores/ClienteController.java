package knight.arkham.practica10.controladores;

import knight.arkham.practica10.modelos.Cliente;
import knight.arkham.practica10.servicios.ClienteServices;
import knight.arkham.practica10.servicios.FileUploadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.Locale;


@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteServices clienteServices;

    // Instancio este servicio para poder trabajar los archivos o imagenes
    @Autowired
    private FileUploadServices fileUploadServices;

    //Instancio esta dependencia que es necesaria para la internacionalizacion
    @Autowired
    private MessageSource messageSource;


    // Con esta variable indicaremos el directorio donde se subiran nuestros archivos
    public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";



    // Para conseguir el nombre de usuario mediante spring security debo especificar un objeto de la clase principal aqui
    // para implementar las traducciones de i18n debo utilizar Locale
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

        model.addAttribute("listaclientei18n", messageSource.getMessage("listaclientei18n", null, locale));
        model.addAttribute("agregarclientei18n", messageSource.getMessage("agregarclientei18n", null, locale));
        model.addAttribute("nombreclientei18n", messageSource.getMessage("nombreclientei18n", null, locale));
        model.addAttribute("apellidoclientei18n", messageSource.getMessage("apellidoclientei18n", null, locale));
        model.addAttribute("cedulaclientei18n", messageSource.getMessage("cedulaclientei18n", null, locale));
        model.addAttribute("direccionclientei18n", messageSource.getMessage("direccionclientei18n", null, locale));
        model.addAttribute("telefonoclientei18n", messageSource.getMessage("telefonoclientei18n", null, locale));
        model.addAttribute("fotoclientei18n", messageSource.getMessage("fotoclientei18n", null, locale));
        model.addAttribute("opcionei18n", messageSource.getMessage("opcionei18n", null, locale));
        // Aqui le mando el listado de clientes a la vista
        model.addAttribute("clientes", clienteServices.listarClientes());

        // Aqui le mando a la vista el nombre del usuario que esta logeado mediante principal consigo esos datos
     //   model.addAttribute("usuario", principal.getName());

        return "/freemarker/cliente";
    }


    @RequestMapping("/creacion")
    public String creacionCliente(Model model, Locale locale){


        model.addAttribute("titulo", "Electrodomesticos CXA");
        model.addAttribute("agregarclientei18n", messageSource.getMessage("agregarclientei18n", null, locale));
        model.addAttribute("nombreclientei18n", messageSource.getMessage("nombreclientei18n", null, locale));
        model.addAttribute("apellidoclientei18n", messageSource.getMessage("apellidoclientei18n", null, locale));
        model.addAttribute("cedulaclientei18n", messageSource.getMessage("cedulaclientei18n", null, locale));
        model.addAttribute("direccionclientei18n", messageSource.getMessage("direccionclientei18n", null, locale));
        model.addAttribute("telefonoclientei18n", messageSource.getMessage("telefonoclientei18n", null, locale));
        model.addAttribute("fotoclientei18n", messageSource.getMessage("fotoclientei18n", null, locale));
        model.addAttribute("botonguardari18n", messageSource.getMessage("botonguardari18n", null, locale));
        model.addAttribute("botoncancelari18n", messageSource.getMessage("botoncancelari18n", null, locale));

        return "/freemarker/crearcliente";
    }



    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public String crearCliente(@RequestParam(name = "files") MultipartFile[] files, @RequestParam(name = "nombre") String nombre, @RequestParam(name = "apellido") String apellido, @RequestParam(name = "cedula") String cedula, @RequestParam(name = "direccion") String direccion,  @RequestParam(name = "telefono") String telefono){

        //Primero manejo la imagen esta funcion me devuelve un string con el nombre
        // del archivo que fue insertado en el formulario
        String nombreDeLaFoto = fileUploadServices.almacenarAndDepurarImagen(files,uploadDirectory);


        // Agregando los parametros al cliente, no es necesario agregar el parametro id ya que anteriormente especificamos
        // que este se autogenerara cuando especificamos la entidad
        Cliente cliente = new Cliente(nombre,apellido,cedula,direccion,telefono,nombreDeLaFoto);

        // Aqui inserto cliente
        clienteServices.crearCliente(cliente);

        // de esta forma redirecciono hacia la vista index, esto es recomendable cuando se crea, se elimina
        // o se edita al final del proceso debe de redireccionar al index
        return "redirect:/cliente/";
    }


    @RequestMapping(value = "/edicion" )
    public String edicionCliente(Model model, Locale locale,  @RequestParam(name = "id") long id ){



        //Aqui obtengo el cliente que voy a editar
        Cliente clienteToEdit = clienteServices.encontrarClientePorId(id);

        //Aqui le mando el cliente que editaremos a la vista de editar cliente para asi trabajar con sus datos y poder
        // modificarlos de manera correcta
        model.addAttribute("cliente",clienteToEdit);
        model.addAttribute("titulo", "Electrodomesticos CXA");


        model.addAttribute("editarclientei18n", messageSource.getMessage("editarclientei18n", null, locale));
        model.addAttribute("nombreclientei18n", messageSource.getMessage("nombreclientei18n", null, locale));
        model.addAttribute("apellidoclientei18n", messageSource.getMessage("apellidoclientei18n", null, locale));
        model.addAttribute("cedulaclientei18n", messageSource.getMessage("cedulaclientei18n", null, locale));
        model.addAttribute("direccionclientei18n", messageSource.getMessage("direccionclientei18n", null, locale));
        model.addAttribute("telefonoclientei18n", messageSource.getMessage("telefonoclientei18n", null, locale));
        model.addAttribute("fotoclientei18n", messageSource.getMessage("fotoclientei18n", null, locale));
        model.addAttribute("botonguardari18n", messageSource.getMessage("botonguardari18n", null, locale));
        model.addAttribute("botoncancelari18n", messageSource.getMessage("botoncancelari18n", null, locale));


        return "/freemarker/editarcliente";
    }



    // Como tengo que obtener el cliente de la vista aqui necesito un requesparam y le mando el parametro con /?id=cliente.id
    // desde la vista hacia esta funcion mediante la url
    @RequestMapping("/editar")
    public String editarCliente(@RequestParam(name = "files") MultipartFile[] files, @RequestParam(name = "id") long id,@RequestParam(name = "nombre") String nombre, @RequestParam(name = "apellido") String apellido, @RequestParam(name = "cedula") String cedula, @RequestParam(name = "direccion") String direccion,  @RequestParam(name = "telefono") String telefono){

        //Aqui obtengo el nombre de la imagen
        String fotoName = fileUploadServices.almacenarAndDepurarImagen(files,uploadDirectory);

        // Para editar el cliente primero debo de buscarlo
        // almaceno el cliente encontrado en el objeto clienteToEdit
        Cliente clienteToEdit = clienteServices.encontrarClientePorId(id);

        //Le agrego los campos editados mediante las propiedades set de la clase
        clienteToEdit.setApellido(apellido);
        clienteToEdit.setCedula(cedula);
        clienteToEdit.setDireccion(direccion);
        clienteToEdit.setNombre(nombre);
        clienteToEdit.setFoto(fotoName);
        clienteToEdit.setTelefono(telefono);

        // Aqui guardo el cliente de nuevo ya que .save funciona tanto como para crear nuevo o editar.
        clienteServices.crearCliente(clienteToEdit);

        //Ubicando la vista desde resources/templates
        return "redirect:/cliente/";
    }


    // Como tengo que obtener el id de la vista aqui necesito un requesparam, tengo que ver como hacer funcionar el editar
    // Para obtener el id mediante la vista tengo que mandarselo a la url mediante un href de esta forma ?id=
    // Entonces la url para borrar estaria por ejemplo de esta forma borrar/?id=3
    @RequestMapping( value = "/borrar")
    public String eliminarCliente(@RequestParam(name = "id") long id){


        // Aqui elimino el cliente mandandole el id obtenido mediante la url en el requesparam
          clienteServices.eliminarCliente(id);

        return "redirect:/cliente/";
    }


}
