package com.tiendavera.seguridad.controladores;


import com.tiendavera.seguridad.dto.JwtDto;
import com.tiendavera.seguridad.dto.LoginUsuario;
import com.tiendavera.seguridad.dto.NuevoUsuario;
import com.tiendavera.seguridad.entidades.Rol;
import com.tiendavera.seguridad.entidades.Usuario;
import com.tiendavera.seguridad.enums.RolNombre;
import com.tiendavera.seguridad.jwt.JwtProvider;
import com.tiendavera.seguridad.servicios.ServicioRol;
import com.tiendavera.seguridad.servicios.ServicioUsuario;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin
@AllArgsConstructor
public class ControladorUsuario {

    private PasswordEncoder passwordEncoder;
    private ServicioUsuario servicioUsuario;
    private ServicioRol servicioRol;


    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<?> nuevoUsuario(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult bin) {
        if (bin.hasErrors()) {
            return new ResponseEntity<String>("Error en alguno de los campos", HttpStatus.BAD_REQUEST);
        } else if(servicioUsuario.existeNombreUsuario(nuevoUsuario.getNombreUsuario())){
            return new ResponseEntity<String>("Ya existe el nombre", HttpStatus.BAD_REQUEST);
        }
        Usuario usuarioNuevo = new Usuario();
        usuarioNuevo.setNombreUsuario(nuevoUsuario.getNombreUsuario());
        usuarioNuevo.setContrasegnaUsuario(
                passwordEncoder.encode(nuevoUsuario.getContrasegnaUsuario())
        );
        Set<Rol> roles = new HashSet<>();
        roles.add(servicioRol.getByRolNombre(RolNombre.ROLE_USER).get());
        if (nuevoUsuario.getRoles().contains("admin")){
            roles.add(servicioRol.getByRolNombre(RolNombre.ROLE_ADMIN).get());
        }
        usuarioNuevo.setRoles(roles);
        servicioUsuario.createUsuario(usuarioNuevo);
        return new ResponseEntity<Usuario>(usuarioNuevo, HttpStatus.CREATED);

    }


    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<String> deleteUsuario(@PathVariable("idUsuario") Integer idUsuario){
        this.servicioUsuario.removeUsuarioById(idUsuario);
        return new ResponseEntity<String>("Usuario Borrado", HttpStatus.OK);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios(){
        return new ResponseEntity<List<Usuario>>(
                this.servicioUsuario.listarUsarios(),
                HttpStatus.OK
        );
    }

}
