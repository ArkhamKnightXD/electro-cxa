package knight.arkham.practica10.configuracion;

import knight.arkham.practica10.servicios.SeguridadServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Configurable
@EnableGlobalMethodSecurity(securedEnabled = true) // De esta forma indico que esta clase estara implementando springsecurity
public class ConfiguracionDeSeguridad extends WebSecurityConfigurerAdapter { // esta clase nos exige sobresscribir un metodo, que sera el metodo donde se especificara el usuario


    //Configuracion para jpa debemos implementar el servicio usuario para trabajar con el user details service
    @Autowired
    private SeguridadServices seguridadServices;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    //Clase para encriptar contraseña
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    // Esta clase sirve para cargar el usuario en memoria, es parecido a cuando se crea el usuario en aplication properties
    // pero esta es la forma correcta de hacer
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        //Configuracion y carga de usuarios metodo JPA de esta forma agregaremos nuestro usuario a la base de datos c
        auth
                .userDetailsService(seguridadServices)
                .passwordEncoder(bCryptPasswordEncoder);
    }// aqui quede




    //Aqui especifico las reglas para permitir unicamente los usuarios y cuales rutas  este podra acceder

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()

                //Aqui especifico que permito que cualquiera pueda acceder a estas url
                .antMatchers("/","/css/**", "/js/**").permitAll()
                .antMatchers("/dbconsole/**").permitAll()

                // Aqui especifico que para entrar a esta ruta es necesario tener el rol Admin o user, por alguna razon falla con el usuario
                //.antMatchers("/usuario/**").hasAnyRole("ADMIN")
               // .antMatchers("/cliente/**").hasAnyRole("ADMIN", "USER")
                //.antMatchers("/equipo/**").hasAnyRole("ADMIN", "USER")
               // .antMatchers("/familia/**").hasAnyRole("ADMIN", "USER")
                //.antMatchers("/alquiler/**").hasAnyRole("ADMIN", "USER")
               // .anyRequest().authenticated() //cualquier llamada debe ser validada
                .and()
                .formLogin()
                //.loginPage("/login") //indicando la ruta que estaremos utilizando, sino vamos a utilizar el login por defecto.
                //.failureUrl("/login?error") //en caso de fallar puedo indicar otra pagina, esta url la utilizare para
                // indicar cuando hay algun error en la aplicacion y mandare la pagina que aqui designe
                .permitAll()
                .and()
                .logout()
                .permitAll();

        //deshabilitando las seguridad contra los frame internos.
        //Necesario para H2.
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
