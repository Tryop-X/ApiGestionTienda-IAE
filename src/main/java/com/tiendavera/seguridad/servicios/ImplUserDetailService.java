package com.tiendavera.seguridad.servicios;

import com.tiendavera.seguridad.entidades.Usuario;
import com.tiendavera.seguridad.entidades.UsuarioPrincipal;
import com.tiendavera.seguridad.repositorios.RepositorioUsuario;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
 public class ImplUserDetailService implements UserDetailsService {

    private final ServicioUsuario servicioUsuario;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario usuario = servicioUsuario.getByNombre(username).get();

        return UsuarioPrincipal.build(usuario);
    }
}
