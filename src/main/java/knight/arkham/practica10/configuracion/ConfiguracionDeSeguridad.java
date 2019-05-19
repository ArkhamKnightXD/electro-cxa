package knight.arkham.practica10.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
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


    //Configuracion para jpa debemos de implementar esto en un servicio
    @Autowired
    private UserDetailsService userDetailsService;

    //Esta claase es la que sirve para encriptar la contraseñas
    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();


        //Aqui configuro el accesso via  JPA.
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(bCryptPasswordEncoder);
    }*/

    /*
     * Permite configurar las reglas de seguridad.
     * @param http
     * @throws Exception
     */

    //Aqui especifico las reglas para permitir unicamente los usuarios y cuales url este podra acceder



   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/css/**", "/js/**").permitAll() //permitiendo llamadas a esas urls.
                .antMatchers("/dbconsole/**").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN", "USER")
                //.anyRequest().authenticated() //cualquier llamada debe ser validada
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
    }*/
}
