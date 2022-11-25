package com.tiendavera.repositorios;

import com.tiendavera.entidades.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCuenta extends JpaRepository<Cuenta, Integer> {

    @Query("Select c FROM  Cuenta c WHERE c.numeroCuenta=:numeroCuenta ")
    Cuenta buscarCuentaByNumeroCuenta (@Param("numeroCuenta") String numeroCuenta) throws NullPointerException;
}
