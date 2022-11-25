package com.tiendavera.entidades;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "deudas")
@Getter
@Setter
public class Deuda{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDeuda;

    @NotNull
    @Size(min = 3, max = 50, message = "nombrePrestamista, pequeño o muy grande")
    @Column(name = "nombre_prestamista")
    private String nombrePrestamista;

    @NotNull
    @Column(name = "cantidad_prestada")
    private Double cantidadPrestada;

    @NotNull
    @Column(name = "nos_deben")
    private boolean nosDeben;

    @NotNull
    @Column(name = "nombre_apuntador")
    private String nombreApuntador;

    @NotNull
    @Column(name = "estado_deuda")
    private String estadoDeuda;


    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
    @Column(name = "hora_deduda", nullable = false)
    private LocalDateTime horaPrestamo;

}
