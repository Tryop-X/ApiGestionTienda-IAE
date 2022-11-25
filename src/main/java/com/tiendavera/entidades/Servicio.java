package com.tiendavera.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name = "servicios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idServicio;

    @NotNull
    @Column(name = "codigo_servicio", nullable = false)
    private String codigoServicio;

    @NotNull
    @Column(name = "nombre_propietario_servicio", nullable = false)
    private String nombrePropietarioServicio;

    @NotNull
    @Column(name = "pago_servicio", nullable = false)
    private Double pagoServicio;

    @NotNull
    @Size(min = 3, max = 50, message = "tipo de servicio no valido, pequeño o muy grande")
    @Column(name = "tipo_servicio", nullable = false)
    private String tipoServicio;

    @NotNull
    @Column(name = "dia_pago_servicio", nullable = false)
    private int diaPagoServicio;
}
