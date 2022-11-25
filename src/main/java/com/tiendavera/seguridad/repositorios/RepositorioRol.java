package com.tiendavera.seguridad.repositorios;

import com.tiendavera.seguridad.entidades.Rol;
import com.tiendavera.seguridad.entidades.Usuario;
import com.tiendavera.seguridad.enums.RolNombre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositorioRol extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
