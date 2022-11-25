package com.tiendavera.repositorios;

import com.tiendavera.entidades.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioServicio extends JpaRepository<Servicio, Integer> {

    @Query("Select s FROM  Servicio s WHERE s.codigoServicio=:codigoServicio and s.pagoServicio =:pagoServicio and s.tipoServicio =:tipoServicio")
    Servicio buscarServicioByCodigo(@Param("codigoServicio") String codigoServicio, @Param("pagoServicio") Double pagoServicio, @Param("tipoServicio") String tipoServicio) throws NullPointerException;
}
