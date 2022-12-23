package com.tiendavera.Controladores.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Deuda {
    private Long idDeuda;
    private String lugar;
    private String moneda;
    private Double monto;
    private String afavor;
}
