package com.tiendavera.repositorios;

import com.tiendavera.entidades.PagoCredito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioPagoCredito extends JpaRepository<PagoCredito, Integer> {

    @Query("SELECT p FROM PagoCredito p WHERE p.estadoPagoCredito=:estadoPagoCredito")
    List<PagoCredito> getPagoCreditoByEstado(@Param("estadoPagoCredito") String estadoPagoCredito);

}
