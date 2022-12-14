package com.tiendavera.seguridad.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginUsuario {

    @NotBlank
    private String nombreUsuario;
    @NotBlank
    private String contrasegnaUsuario;

}
