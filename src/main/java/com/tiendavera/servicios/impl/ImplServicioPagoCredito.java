package com.tiendavera.servicios.impl;

import com.tiendavera.entidades.PagoServicio;
import com.tiendavera.repositorios.RepositorioCredito;
import com.tiendavera.repositorios.RepositorioPagoCredito;
import com.tiendavera.entidades.Credito;
import com.tiendavera.entidades.PagoCredito;
import com.tiendavera.servicios.ServicioPagoCredito;
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

public class ImplServicioPagoCredito implements ServicioPagoCredito {
    private final RepositorioPagoCredito repositorioPagoCredito;
    private final RepositorioCredito repositorioCredito;

    @Override
    public Page<PagoCredito> getPagoCreditoByPage(Pageable pageable) {
        return this.repositorioPagoCredito.findAll(pageable);
    }

    @Override
    public PagoCredito createPagoCredito(PagoCredito pagoCredito) {

        Credito nuevoCredito;
        pagoCredito.setHoraPagoCredito(LocalDateTime.now());
        pagoCredito.setEstadoPagoCredito("pendiente");

        nuevoCredito = repositorioCredito.buscarCreditoByDniAndCouta(pagoCredito.getCredito().getDniPropietario(),pagoCredito.getCredito().getCuotaCredito());
        if(nuevoCredito == null){
            pagoCredito.getCredito().setDiaPagoCredito(LocalDateTime.now().getDayOfMonth());
            nuevoCredito = this.repositorioCredito.save(pagoCredito.getCredito());
        }
        pagoCredito.setCredito(nuevoCredito);
        return this.repositorioPagoCredito.save(pagoCredito);
    }

    @Override
    public List<PagoCredito> getAllPagoCreditos() {
        return this.repositorioPagoCredito.findAll();
    }

    @Override
    public PagoCredito getPagoCreditoById(Integer idPagoCredito) {
        return this.repositorioPagoCredito.findById(idPagoCredito).orElse(new PagoCredito());
    }

    @Override
    public PagoCredito updatePagoCredito(PagoCredito pagoCredito) {
        return this.repositorioPagoCredito.save(pagoCredito);
    }

    @Override
    public void deletePagoCredito(Integer idPagoCredito) {
        this.repositorioPagoCredito.deleteById(idPagoCredito);
    }

    @Override
    public List<PagoCredito> getPagoCreditoByEstado(String estadoPagoCredito) {

        List<PagoCredito> pagoCredito = this.repositorioPagoCredito.getPagoCreditoByEstado(estadoPagoCredito);
        if(pagoCredito == null){
            pagoCredito = new ArrayList<PagoCredito>();
        }
        return pagoCredito;
    }
}
