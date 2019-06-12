package knight.arkham.practica10.controladores;

import knight.arkham.practica10.modelos.Equipo;
import knight.arkham.practica10.modelos.Familia;
import knight.arkham.practica10.servicios.EquipoServices;
import knight.arkham.practica10.servicios.FamiliaService;
import knight.arkham.practica10.servicios.FileUploadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;

@Controller
@RequestMapping("/equipo")
public class EquipoController {

    @Autowired
    private EquipoServices equipoServices;

    @Autowired
    private FamiliaService familiaService;

    @Autowired
    private FileUploadServices fileUploadServices;


    public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";


    @RequestMapping("/")
    public String index(Model model, Principal principal){

        model.addAttribute("titulo", "Electrodomesticos CXA");
        model.addAttribute("equipos",equipoServices.listarEquipos());

       // model.addAttribute("usuario", principal.getName());
        return "/freemarker/equipo";
    }


    @RequestMapping("/creacion")
    public String creacionEquipo(Model model){


        model.addAttribute("familias", familiaService.listarFamilias());
        model.addAttribute("titulo", "Electrodomesticos CXA");


        return "/freemarker/crearequipo";
    }


    @RequestMapping(value = "/crear", method = RequestMethod.POST)
    public String crearEquipo(Model model, @RequestParam(name = "files") MultipartFile[] files, @RequestParam(name = "nombre") String nombre, @RequestParam(name = "marca") String marca, @RequestParam(name = "cantidadExistencia") int cantidadExistencia, @RequestParam(name = "costoAlquilerPorDia") float costoAlquilerPorDia, @RequestParam(name = "familia", required = false) Long idFamilia, @RequestParam(name = "subFamilia", required = false) Long idSubFamilia ){

        //Manejando la imagen para conseguir su nombre y almacenarla
        String nombreDeLaFoto = fileUploadServices.almacenarAndDepurarImagen(files,uploadDirectory);

         Familia familia = familiaService.encontrarFamiliaPorId(idFamilia);
        Familia subFamiliaToFind = familiaService.encontrarFamiliaPorId(idSubFamilia);

        // Familias y subfamilias de prueba para comprobar que se creara bien el equipo
//        Familia familiaTest = new Familia("Personas",false);
  //      Familia subFamiliaTest = new Familia("Gente",true,familiaTest);

    //    familiaService.crearFamilia(familiaTest);
      //  familiaService.crearFamilia(subFamiliaTest);


        //Ahora mismo lo unico que me falla de equipo es lo de obtener la subfamilia mediante el formulario
        Equipo equipoToCreate = new Equipo(nombre,marca,nombreDeLaFoto,cantidadExistencia,costoAlquilerPorDia,familia,subFamiliaToFind);

        equipoServices.crearEquipo(equipoToCreate);

        model.addAttribute("titulo", "Electrodomesticos CXA");
        model.addAttribute("mensaje","El equipo ha sido creado con exito");
        model.addAttribute("ruta","equipo");


        return "/freemarker/mensajes";
    }



    @RequestMapping("/edicion")
    public String edicionEquipo(Model model,  @RequestParam(name = "id") long id ){

        Equipo equipoToEdit = equipoServices.encontrarEquipoPorId(id);


        model.addAttribute("equipo",equipoToEdit);
        model.addAttribute("familias", familiaService.listarFamilias());
        model.addAttribute("titulo", "Electrodomesticos CXA");


        return "/freemarker/editarequipo";
    }



    @RequestMapping("/editar")
    public String editarEquipo(Model model, @RequestParam(name = "files") MultipartFile[] files, @RequestParam(name = "id") long id, @RequestParam(name = "nombre") String nombre, @RequestParam(name = "marca") String marca, @RequestParam(name = "cantidadExistencia") int cantidadExistencia,@RequestParam(name = "costoAlquilerPorDia") float costoAlquilerPorDia, @RequestParam(name = "familia", required = false) Long idFamilia, @RequestParam(name = "subFamilia", required = false) Long subFamilia ){


        String imagenEquipo = fileUploadServices.almacenarAndDepurarImagen(files,uploadDirectory);

        Equipo equipoToEdit = equipoServices.encontrarEquipoPorId(id);

        Familia familiaToEdit = familiaService.encontrarFamiliaPorId(idFamilia);

        Familia subFamiliaToEdit = familiaService.encontrarFamiliaPorId(idFamilia);

        equipoToEdit.setNombre(nombre);
        equipoToEdit.setMarca(marca);
        equipoToEdit.setCantidadExistencia(cantidadExistencia);
        equipoToEdit.setImagenEquipo(imagenEquipo);
        equipoToEdit.setCostoAlquilerPorDia(costoAlquilerPorDia);

        //Aqui le mando las familias y subfamilias
        equipoToEdit.setFamilia(familiaToEdit);
        equipoToEdit.setSubFamilia(subFamiliaToEdit);


        equipoServices.crearEquipo(equipoToEdit);


        model.addAttribute("titulo", "Electrodomesticos CXA");
        model.addAttribute("mensaje","El equipo ha sido editado con exito");
        model.addAttribute("ruta","equipo");

        return "/freemarker/mensajes";
    }




    @RequestMapping("/borrar")
    public String eliminarEquipo(Model model,  @RequestParam(name = "id") long id){


        equipoServices.eliminarEquipo(id);

        model.addAttribute("titulo", "Electrodomesticos CXA");
        model.addAttribute("mensaje","El equipo ha sido eliminado con exito");
        model.addAttribute("ruta","equipo");

        return "/freemarker/mensajes";
    }


}
