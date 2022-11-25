package com.tiendavera.servicios;

import com.tiendavera.entidades.Cuenta;
import com.tiendavera.entidades.Deposito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServicioDeposito {

    Page<Deposito> getDepositoByPage(Pageable pageable);
    Deposito createDeposito(Deposito deposito);
    List<Deposito> getAllDepositos();
    Deposito getDepositoById(Integer idDeposito);
    Deposito updateDeposito(Deposito deposito);
    void deleteDeposito(Integer idDeposito);
    List<Deposito> getDepositoByEstadDeposito (String estadoDeposito);

}
