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

		// Por ahora la creacion del usuario admin me sigue fallando, pero me funciona de otra forma
		//guardare este codigo aqui por si luego hace falta

		// Esta funcion es necesario para obtener los distintos bean y tambien para poder llamar usuario services al
		// main
		/*ApplicationContext applicationContext = SpringApplication.run(Practica10Application.class, args);
		String[] lista = applicationContext.getBeanDefinitionNames();
		System.out.println("====== Beans Registrados =====");
		for(String bean : lista){
			System.out.println(""+bean);
		}
		System.out.println("====== FIN Beans Registrados =====");

		// Aqui prepara el usuario service para que pueda ser utilizado aqui
		SeguridadServices seguridadServices = (SeguridadServices) applicationContext.getBean("seguridadServices");

		// y aqui finalmente creo el usuario admin
		seguridadServices.crearUsuarioAdmin();
*/

	}

}
