package com.tiendavera.repositorios;

import com.tiendavera.entidades.Credito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCredito extends JpaRepository<Credito, Integer> {
    @Query("Select c FROM  Credito c WHERE c.dniPropietario=:dni and c.cuotaCredito =:cuota")
    Credito buscarCreditoByDniAndCouta (@Param("dni") String dni, @Param("cuota") Double cuota) throws NullPointerException;
}
