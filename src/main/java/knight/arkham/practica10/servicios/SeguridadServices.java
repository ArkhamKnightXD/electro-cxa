package knight.arkham.practica10.servicios;

import knight.arkham.practica10.modelos.Rol;
import knight.arkham.practica10.modelos.Usuario;
import knight.arkham.practica10.repositorios.RolRepositorio;
import knight.arkham.practica10.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class SeguridadServices implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepo;

    @Autowired
    private RolRepositorio rolRepositorio;

    //Para encriptar la información

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();



    @Transactional
    public void crearUsuarioAdmin(){
        //Aqui creo los roles

        Rol rolUser = new Rol();
        rolUser.setRole("ROLE_USER");
        rolRepositorio.save(rolUser);

        Rol rolAdmin = new Rol("ROLE_ADMIN");
        rolRepositorio.save(rolAdmin);

        // Aveces me da problema de que se crean dos usuarios admin en vez de uno y esto no me deja iniciar sesion, para solucionar esto solo le cambio el nombre a
        // usuario diferente por otro nombre y listo, esta es una solucion temporal, pues debo ver que es lo que causa esto
        Usuario usuarioAdmin = new Usuario();
        usuarioAdmin.setUsername("admin");
        usuarioAdmin.setActive(true);
        usuarioAdmin.setRoles(new HashSet<>(Arrays.asList(rolAdmin)));

        // Aqui creo la passwrod, pero tambien la encripto con el password encoder, que basicamente recibe un string y lo codifica

        usuarioAdmin.setPassword(passwordEncoder.encode("1234"));

        usuarioRepo.save(usuarioAdmin);
    }



    // ES necesario implementar este metodo cuando se implementa user details service
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario user = usuarioRepo.findByUsername(username);

        // Codigo de camacho para reoorrer roles
        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Rol role : user.getRoles()) {
            roles.add(new SimpleGrantedAuthority(role.getRole()));
        }

        //
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);



        // Hay que retornar un objeto de tipo userdetails por lo tanto hacemos esto y le mandamos los datos del usuario
        // UserDetails userDetails = new User(usuario.getUsername(),usuario.getPassword(),roles);
        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(), user.isActive(), true, true, true, grantedAuthorities);
    }

}
