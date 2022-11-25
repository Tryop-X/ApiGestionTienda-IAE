package com.tiendavera.servicios;


import com.tiendavera.entidades.Cuenta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServicioCuenta {

    Page<Cuenta> getCuentaByPage(Pageable pageable);
    Cuenta createCuenta(Cuenta cuenta);
    List<Cuenta> getAllCuentas();
    Cuenta getCuentaById(Integer idCuenta);
    Cuenta updateCuentea(Cuenta cuenta);
    void deleteCuenta(Integer idCuenta);
}
