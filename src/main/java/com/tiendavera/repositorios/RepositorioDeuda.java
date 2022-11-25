package com.tiendavera.repositorios;

import com.tiendavera.entidades.Deuda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioDeuda extends JpaRepository<Deuda, Integer> {

    @Query("SELECT d FROM Deuda d WHERE d.estadoDeuda=:estadoDeuda")
    List<Deuda> getDeudaByEstado(@Param("estadoDeuda") String estadoDeuda);


}
