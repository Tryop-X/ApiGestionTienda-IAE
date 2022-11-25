package com.tiendavera.entidades;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "creditos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Credito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCredito;
    @NotNull
    @Column(name = "dni_propietario", nullable = false)
    private String dniPropietario;
    @NotNull
    @Column(name = "nombre_propietario_credito", nullable = false)
    private String nombrePropietarioCredito;
    @Column(name = "numero_pagare", nullable = true)
    private String numeroPagare;
    @NotNull
    @Column(name = "cuota_credito", nullable = false)
    private Double cuotaCredito;
    @NotNull
    @Column(name = "dia_pago_credito", nullable = false)
    private int diaPagoCredito;


}
