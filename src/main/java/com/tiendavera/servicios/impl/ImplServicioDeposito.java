package com.tiendavera.servicios.impl;

import com.tiendavera.repositorios.RepositorioCuenta;
import com.tiendavera.repositorios.RepositorioDeposito;
import com.tiendavera.entidades.Cuenta;
import com.tiendavera.entidades.Deposito;
import com.tiendavera.servicios.ServicioDeposito;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional

public class ImplServicioDeposito implements ServicioDeposito {


    private final RepositorioDeposito repositorioDeposito;
    private final RepositorioCuenta repositorioCuenta;

    @Override
    public Page<Deposito> getDepositoByPage(Pageable pageable) {
        return this.repositorioDeposito.findAll(pageable);
    }

    @Override
    public Deposito createDeposito(Deposito deposito) {
        Cuenta nuevaCuenta;

        deposito.setHoraDeposito(LocalDateTime.now());
        deposito.setEstadoDeposito("pendiente");

        nuevaCuenta = this.repositorioCuenta.buscarCuentaByNumeroCuenta(deposito.getCuenta().getNumeroCuenta());

        if(nuevaCuenta == null){
            nuevaCuenta = this.repositorioCuenta.save(deposito.getCuenta());
        }

        deposito.setCuenta(nuevaCuenta);

        return this.repositorioDeposito.save(deposito);
    }

    @Override
    public List<Deposito> getAllDepositos() {
        return this.repositorioDeposito.findAll();
    }

    @Override
    public Deposito getDepositoById(Integer idDeposito) {
        return this.repositorioDeposito.findById(idDeposito).orElse(new Deposito());
    }

    @Override
    public Deposito updateDeposito(Deposito deposito) {
        return this.repositorioDeposito.save(deposito);
    }

    @Override
    public void deleteDeposito(Integer idDeposito) {
        this.repositorioDeposito.deleteById(idDeposito);
    }

    @Override
    public List<Deposito> getDepositoByEstadDeposito(String estadoDeposito) {
        List<Deposito> depositos = this.repositorioDeposito.getDepositoByEstado(estadoDeposito);
        if(depositos ==  null){
            depositos = new ArrayList<Deposito>();
        }
        return depositos;
    }
}
