package knight.arkham.practica10.configuracion;

import knight.arkham.practica10.modelos.Usuario;
import knight.arkham.practica10.repositorios.RolRepositorio;
import knight.arkham.practica10.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configurable
@EnableGlobalMethodSecurity(securedEnabled = true) // De esta forma indico que esta clase estara implementando springsecurity
public class ConfiguracionDeSeguridad extends WebSecurityConfigurerAdapter {


    //Configuracion para jpa debemos de implementar esto para trabajar con la seguridad
    @Autowired
    private UserDetailsService userDetailsService;



    //Esta claase es la que sirve para encriptar la contraseñas la especifico aqui para luego usarla en uno de los servicios para encriptar la
    // las contraseñas


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //Clase para encriptar contraseña
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

        //Cargando los usuarios en memoria.
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN","USER")
                .and()
                .withUser("usuario")
                .password("1234")
                .roles("USER")
                .and()
                .withUser("vendedor")
                .password("1234")
                .roles("VENDEDOR");


        //Configuración JPA.
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);
    }



    //Aqui especifico las reglas para permitir unicamente los usuarios y cuales rutas  este podra acceder

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()

                //Aqui especifico que permito que cualquiera pueda acceder a estas url
                .antMatchers("/","/css/**", "/js/**").permitAll()
                .antMatchers("/dbconsole/**").permitAll()

                // Aqui especifico que para entrar a esta ruta es necesario tener el rol Admin o user
                .antMatchers("/usuario/**").hasAnyRole("ADMIN", "USER")
               // .anyRequest().authenticated() //cualquier llamada debe ser validada
                .and()
                .formLogin()
                .loginPage("/login") //indicando la ruta que estaremos utilizando.
                .failureUrl("/login?error") //en caso de fallar puedo indicar otra pagina.
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
