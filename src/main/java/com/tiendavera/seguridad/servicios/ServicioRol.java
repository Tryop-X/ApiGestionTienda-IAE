package com.tiendavera.seguridad.servicios;

import com.tiendavera.seguridad.entidades.Rol;
import com.tiendavera.seguridad.enums.RolNombre;
import com.tiendavera.seguridad.repositorios.RepositorioRol;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class ServicioRol {

    private final RepositorioRol repositorioRol;

    public Optional<Rol> getByRolNombre(RolNombre rolNombre){
        return this.repositorioRol.findByRolNombre(rolNombre);
    }
    public Rol createRol(Rol rol){
        return this.repositorioRol.save(rol);
    }
}
