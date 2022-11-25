package com.tiendavera.servicios;

import com.tiendavera.entidades.Balance;
import com.tiendavera.entidades.Credito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServicioBalance {
    double getNuestrasDedudas();
    double getDineroPrestado();
    double getVueltos();
    Page<Balance> getBalancesByPage(Pageable pageable);
    Balance createBalance(Balance balance);
    List<Balance> getAllBalances();
    Balance getBalanceById(Integer idBalance);
    Balance updateBalance(Balance balance);
    void deleteBalance(Integer idBalance);

}
