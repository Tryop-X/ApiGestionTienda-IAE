package com.tiendavera.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "pago_creditos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class PagoCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPagoCredito;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    @Column(name = "hora_deposito", nullable = false)
    private LocalDateTime horaPagoCredito;

    @NotNull
    @Size(min = 3, max = 20, message = "estado no valido, pequeño o muy grande")
    @Column(name = "estado_pago_credito", nullable = false)
    private String estadoPagoCredito;

    @Column(name = "vuelto_pago_credito", nullable = true)
    private Double vueltoPagoCredito;

    @Column(name = "anotacion_pago_credito", nullable = true)
    private String anotacionPagoCredito;

    @NotNull
    @Column(name = "nombre_apuntador")
    private String nombreApuntador;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idCredito", nullable = false, foreignKey = @ForeignKey(name ="FK_credito"))
    private Credito credito;
}
