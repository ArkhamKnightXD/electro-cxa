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
        //Aqui creo el rol
        Rol rolAdmin = new Rol("ROLE_ADMIN");
        rolRepositorio.save(rolAdmin);

        // creando el usuario y agregando el rol deseado
        Usuario admin = new Usuario();
        admin.setUsername("admin");
        admin.setEsAdmin(true);
        admin.setActive(true);
        admin.setRoles(new HashSet<>(Arrays.asList(rolAdmin)));

        // Aqui creo la passwrod, pero tambien la encripto con el password encoder, que basicamente recibe un string y lo codifica

        admin.setPassword(passwordEncoder.encode("1234"));

        usuarioRepo.save(admin);
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
