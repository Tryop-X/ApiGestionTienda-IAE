package com.tiendavera.util;
import com.tiendavera.entidades.Cuenta;
import com.tiendavera.seguridad.controladores.ControladorUsuario;
import com.tiendavera.seguridad.dto.NuevoUsuario;
import com.tiendavera.seguridad.entidades.Rol;
import com.tiendavera.seguridad.entidades.Usuario;
import com.tiendavera.seguridad.enums.RolNombre;
import com.tiendavera.seguridad.servicios.ServicioRol;
import com.tiendavera.seguridad.servicios.ServicioUsuario;
import com.tiendavera.servicios.ServicioCuenta;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@Component
public class CreacionRoles implements CommandLineRunner {
    private final ServicioRol servicioRol;
    private PasswordEncoder passwordEncoder;
    private final ServicioUsuario servicioUsuario;
    private final ServicioCuenta servicioCuenta;

    private final String NOMBRE_USUARIO="hugoVera";
    private final String CONTRA_USUARIO="adminVera";


    @Override
    public void run(String... args) throws Exception {
        try {
            //----------CREACIÓN DE ROLES---------------------
            Rol rolAdmin = new Rol();
            rolAdmin.setRolNombre(RolNombre.ROLE_ADMIN);
            Rol rolUser = new Rol();
            rolUser.setRolNombre(RolNombre.ROLE_USER);
            servicioRol.createRol(rolAdmin);
            servicioRol.createRol(rolUser);
            //----------CREACIÓN DEL USUARIO--------------
            Usuario usuarioNuevo = new Usuario();
            usuarioNuevo.setNombreUsuario(NOMBRE_USUARIO);
            usuarioNuevo.setContrasegnaUsuario(
                    passwordEncoder.encode(CONTRA_USUARIO)
            );
            servicioUsuario.createUsuario(usuarioNuevo);
            //----------OBTENIENDO ROLES Y EL USUARIO CREADO----
            Rol rolAdmin1 = servicioRol.getByRolNombre(RolNombre.ROLE_ADMIN).get();
            Rol rolUser2 = servicioRol.getByRolNombre(RolNombre.ROLE_USER).get();
            Usuario u =servicioUsuario.getByNombre(NOMBRE_USUARIO).get();
            //----------GUARDANDO EL USUARIO CON LOS ROLES OBTENIDOS-------
            Set<Rol> roles = new HashSet<>();
            roles.add(rolUser2);
            roles.add(rolAdmin1);
            u.setRoles(roles);
            servicioUsuario.createUsuario(u);
        }catch (Exception e){
            System.out.println("Roles creados, Error:"+ e);
        }


    }
}
