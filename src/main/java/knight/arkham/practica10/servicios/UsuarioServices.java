package knight.arkham.practica10.servicios;


import knight.arkham.practica10.modelos.Rol;
import knight.arkham.practica10.modelos.Usuario;
import knight.arkham.practica10.repositorios.RolRepositorio;
import knight.arkham.practica10.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class UsuarioServices  {

    @Autowired
    private UsuarioRepositorio usuarioRepo;


    public void crearUsuario(Usuario usuario){

        usuarioRepo.save(usuario);
    }


    public List<Usuario> listarUsuarios(){

        return usuarioRepo.findAll();
    }

    public Usuario encontrarUsuarioPorId(long id){

        return usuarioRepo.findUsuarioById(id);
    }

    public void eliminarUsuario(long id){

        // Igualo  el cliente al cliente que buscamos mediante el id
        Usuario usuarioToDelete = usuarioRepo.findUsuarioById(id);

        // y aqui lo borro
        usuarioRepo.delete(usuarioToDelete);
    }


}
