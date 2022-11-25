package com.tiendavera.repositorios;

import com.tiendavera.entidades.Deposito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioDeposito extends JpaRepository<Deposito, Integer> {

    @Query("SELECT d FROM Deposito d WHERE d.estadoDeposito=:estadoDeposito")
    List<Deposito> getDepositoByEstado(@Param("estadoDeposito") String estadoDeposito);


}
