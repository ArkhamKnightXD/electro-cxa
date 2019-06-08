package knight.arkham.practica10.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
@RequestMapping("/file")
public class FileUploadController {

    // Con esta variable indicaremos el directorio donde
    // se subiran nuestros archivos
    public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";


    // Retornar la vista de prueba de subida de archivos
    @RequestMapping("/")
    public String uploadPage(Model model){


        return "/freemarker/files";
    }

    @RequestMapping("/upload")
    public String uploadFile(Model model, @RequestParam(name = "files") MultipartFile[] files){

        // Aqui guardare el nombre del archivo
        StringBuilder fileNames = new StringBuilder();

        // Aqui tomaremos cada archivo subido y que son varios utilizaremos un foreach
        // cuando sea solo uno no habrea necesidad del foreach

        for (MultipartFile file: files) {

            // Aqui consigo y almaceno el nombre el archivo
            Path fileNamePath = Paths.get(uploadDirectory,file.getOriginalFilename());

            // Aqui le agregamos el nombre del archivo a la variable que definimos arriba
            fileNames.append(file.getOriginalFilename());

            // Aqui finalmente guardamos los archivos o el archivo obtenido
            // El try y el catch son necesarios o sino data error el write

            try {

                Files.write(fileNamePath, file.getBytes());
            }catch (IOException e){

                e.printStackTrace();
            }


        }

        // Aqui finalmente le enviamos un mensaje de exito a la vista

        model.addAttribute("mensaje", "Successfully uploaded files" + fileNames.toString());

        return "/freemarker/uploadstatus";
    }

}
