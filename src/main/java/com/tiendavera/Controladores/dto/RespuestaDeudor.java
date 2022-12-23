package com.tiendavera.Controladores.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RespuestaDeudor {
    private boolean satisfactorio ;
    private String mensaje;
    private Deudor data;
}
