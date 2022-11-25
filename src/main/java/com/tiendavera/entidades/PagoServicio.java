package com.tiendavera.entidades;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import org.jetbrains.annotations.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "pago_servicios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PagoServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPagoServicio;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    @Column(name = "hora_pago_servicio", nullable = false)
    private LocalDateTime horaPagoServicio;

    @NotNull
    @Size(min = 3, max = 20, message = "estado no valido, pequeño o muy grande")
    @Column(name = "estado_pago_servicio", nullable = false)
    private String estadoPagoServicio;

    @Column(name = "vuelto_pago_servicio", nullable = true)
    private Double vueltoPagoServicio;

    @NotNull
    @Column(name = "nombre_apuntador")
    private String nombreApuntador;


    @Column(name = "anotacion_pago_servicio", nullable = true)
    private String anotacionPagoServicio;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idServicio", nullable = false, foreignKey = @ForeignKey(name = "FK_servicio"))
    private Servicio servicio;
}
