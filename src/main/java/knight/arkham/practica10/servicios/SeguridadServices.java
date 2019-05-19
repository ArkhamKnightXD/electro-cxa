package knight.arkham.practica10.servicios;

import knight.arkham.practica10.modelos.Rol;
import knight.arkham.practica10.modelos.Usuario;
import knight.arkham.practica10.repositorios.RolRepositorio;
import knight.arkham.practica10.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;

// En esta clase configuro las caracteristicas del spring security

// En los servicio debo de implementar los repositorios e especificar aqui las funciones que utilizaremos para trabajar en el proyecto
// Osea que por cada repositorio deberia de haber un servicio, esto no es 100% necesario, pero es lo mas correcto a la hora de trabajar

public class SeguridadServices extends WebSecurityConfigurerAdapter {

  /*  @Autowired
    private UsuarioRepositorio usuarioRepository;

    @Autowired
    private RolRepositorio rolRepository;

    //Para encriptar la información.
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    //cualquier cosa...

    /**
     * Creando el usuario por defecto y su rol.
     */

  /*
    public void crearUsuarioAdmin(){
        System.out.println("Creación del usuario y rol en la base de datos");
        Rol rolAdmin = new Rol("ROLE_ADMIN");
        rolRepository.save(rolAdmin);

        Usuario admin = new Usuario();
        admin.setUsername("admin");
        admin.setPassword(bCryptPasswordEncoder.encode("admin"));
        admin.setNombre("Administrador");
        admin.setActivo(true);
        admin.setRoles(new HashSet<>(Arrays.asList(rolAdmin)));
        usuarioRepository.save(admin);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByUsername(username);

        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Rol role : user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isActivo(), true, true, true, grantedAuthorities);

    }*/
}
