package com.tiendavera.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cuentas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCuenta;

    @NotNull
    @Column(name = "numero_cuenta", nullable = false)
    private String numeroCuenta;

    @NotNull
    @Column(name = "nombre_propietario_cuenta", nullable = false)
    private String nombrePropietarioCuenta;
}
