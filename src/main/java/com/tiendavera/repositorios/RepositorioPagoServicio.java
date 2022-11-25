package com.tiendavera.repositorios;

import com.tiendavera.entidades.PagoServicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioPagoServicio extends JpaRepository<PagoServicio, Integer> {

    @Query("SELECT p FROM PagoServicio p WHERE p.estadoPagoServicio=:estadoPagoServicio")
    List<PagoServicio> getPagoServicioByEstado(@Param("estadoPagoServicio") String estadoPagoServicio);
}
