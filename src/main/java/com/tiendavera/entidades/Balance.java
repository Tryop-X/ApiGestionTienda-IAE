package com.tiendavera.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "balances")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBalance;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    @Column(name = "hora_deposito", nullable = false)
    private LocalDateTime horaPagoCredito;

    @NotNull
    @Column(name = "sado_dia")
    private Double saldoDia;

    @NotNull
    @Column(name = "saldo_caja_piura")
    private Double saldoCajaPiura;

    @NotNull
    @Column(name = "saldo_bn")
    private Double saldoBN;

    @NotNull
    @Column(name = "saldo_efectivo")
    private Double saldoEfectivo;

    @NotNull
    @Column(name = "nuestras_deudas")
    private Double nuestrasDeudas;

    @NotNull
    @Column(name = "dinero_prestado")
    private Double dineroPrestado;

    @NotNull
    @Column(name = "vueltos")
    private Double vueltos;
}
