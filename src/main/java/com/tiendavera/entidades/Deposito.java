package com.tiendavera.entidades;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "depositos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Deposito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDeposito;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    @Column(name = "hora_deposito", nullable = false)
    private LocalDateTime horaDeposito;

    @Column(name = "dni_depositante")
    private Integer dniDepositante;

    @NotNull
    @Size(min = 3, max = 20, message = "estado no valido, pequeño o muy grande")
    @Column(name = "estado_deposito", nullable = false)
    private String estadoDeposito;

    @NotNull
    @Column(name = "dinero_depositar", nullable = false)
    private Double dineroDepositar;

    @NotNull
    @Column(name = "nombre_apuntador")
    private String nombreApuntador;


    @Column(name = "vuelto_deposito", nullable = true)
    private Double vueltoDeposito;

    @Column(name = "anotacion_deposito", nullable = true)
    private String anotacionDeposito;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idCuenta", nullable = false, foreignKey = @ForeignKey(name ="FK_cuenta"))
    private Cuenta cuenta;
}
