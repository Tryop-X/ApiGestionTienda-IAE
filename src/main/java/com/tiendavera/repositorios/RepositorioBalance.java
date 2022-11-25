package com.tiendavera.repositorios;

import com.tiendavera.entidades.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioBalance extends JpaRepository<Balance, Integer> {

}
