package com.tiendavera.Controladores.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Deudor {

    private Long idDeudor;
    private String nombreDeudor;
    private String tipoDocumento;
    private String numeroDocumento;
    private List<Deuda> deudas;
}
