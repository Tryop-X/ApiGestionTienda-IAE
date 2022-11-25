package com.tiendavera.seguridad.dto;

import com.tiendavera.seguridad.entidades.Rol;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class NuevoUsuario {
    @NotBlank
    private String nombreUsuario;
    @NotBlank
    private String contrasegnaUsuario;
    private Set<String> roles = new HashSet<>();

}
