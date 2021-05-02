package knight.arkham.practica10;

import knight.arkham.practica10.controladores.ClienteController;
import knight.arkham.practica10.controladores.EquipoController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import java.io.File;

@SpringBootApplication

// Para trabajar con archivos debo especificar esto
@ComponentScan({"knight.arkham.practica10", "knight.arkham.practica10.controladores"})
public class Practica10Application {


	public static void main(String[] args) {

		//Esto creara el direcctorio especificado en el controlador al inicio
		// del programa si no existe, tanto para cliente como para equipo
		new File(ClienteController.uploadDirectory).mkdir();

		new File(EquipoController.uploadDirectory).mkdir();

		SpringApplication.run(Practica10Application.class, args);

	}
}
