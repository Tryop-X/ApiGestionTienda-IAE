package com.tiendavera.servicios.impl;

import com.tiendavera.repositorios.RepositorioCuenta;
import com.tiendavera.entidades.Cuenta;
import com.tiendavera.servicios.ServicioCuenta;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional

public class ImplServicioCuenta implements ServicioCuenta {

    private final RepositorioCuenta repositorioCuenta;


    @Override
    public Page<Cuenta> getCuentaByPage(Pageable pageable) {
        return this.repositorioCuenta.findAll(pageable);
    }

    @Override
    public Cuenta createCuenta(Cuenta cuenta) {
        return this.repositorioCuenta.save(cuenta);
    }

    @Override
    public List<Cuenta> getAllCuentas() {
        return this.repositorioCuenta.findAll();
    }

    @Override
    public Cuenta getCuentaById(Integer idCuenta) {
        return this.repositorioCuenta.findById(idCuenta).orElse(new Cuenta());
    }

    @Override
    public Cuenta updateCuentea(Cuenta cuenta) {
        return this.repositorioCuenta.save(cuenta);
    }

    @Override
    public void deleteCuenta(Integer idCuenta) {
        this.repositorioCuenta.deleteById(idCuenta);
    }
}
