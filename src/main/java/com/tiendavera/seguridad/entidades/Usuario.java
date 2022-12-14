package com.tiendavera.seguridad.entidades;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @NotNull
    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER , cascade = {CascadeType.PERSIST})
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"),
    inverseJoinColumns = @JoinColumn(name = "rol_id"))
    private Set<Rol> roles = new HashSet<>();

    @NotNull
    @Column(name = "contrasegna_usuario")
    private String contrasegnaUsuario;

}
