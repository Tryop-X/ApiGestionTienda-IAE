package com.tiendavera.servicios.impl;

import com.tiendavera.entidades.*;
import com.tiendavera.repositorios.RepositorioBalance;
import com.tiendavera.servicios.*;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional

public class ImplServicioBalance implements ServicioBalance {

    private final RepositorioBalance repositorioBalance;
    private ServicioPagoServicio servicioPagoServicio;
    private ServicioPagoCredito servicioPagoCredito;
    private ServicioDeposito servicioDeposito;
    private ServicioDeuda servicioDeuda;

    @Override
    public double getNuestrasDedudas(){
        double nuestrasDeudas =0;
        List<PagoServicio>  pagoServicios=  this.servicioPagoServicio.getPagoServicioByEstado("pendiente");
        List<PagoCredito> pagoCreditos = this.servicioPagoCredito.getPagoCreditoByEstado("pendiente");
        List<Deposito> depositos = this.servicioDeposito.getDepositoByEstadDeposito("pendiente");
        List<Deuda> deudas = this.servicioDeuda.getDeudaByEstado("pendiente");
        for (PagoServicio pagoS: pagoServicios) {
            nuestrasDeudas +=  pagoS.getServicio().getPagoServicio();
        }
        for (PagoCredito pagoC: pagoCreditos) {
            nuestrasDeudas +=  pagoC.getCredito().getCuotaCredito();
        }
        for (Deposito deposito: depositos) {
            nuestrasDeudas +=  deposito.getDineroDepositar();
        }
        for (Deuda deuda: deudas) {
            if(!deuda.isNosDeben()){
                nuestrasDeudas += deuda.getCantidadPrestada();
            }
        }
        return nuestrasDeudas;
    }

    @Override
    public double getDineroPrestado(){
        int dineroPrestado = 0;
        List<Deuda> deudas = this.servicioDeuda.getDeudaByEstado("pendiente");
        for (Deuda deuda: deudas) {
            if(deuda.isNosDeben()){
                dineroPrestado += deuda.getCantidadPrestada();
            }
        }
        return dineroPrestado;
    }

    @Override
    public double getVueltos(){
        double vueltos =0;
        List<PagoServicio>  pagoServicios=  this.servicioPagoServicio.getPagoServicioByEstado("pendiente");
        List<PagoCredito> pagoCreditos = this.servicioPagoCredito.getPagoCreditoByEstado("pendiente");
        List<Deposito> depositos = this.servicioDeposito.getDepositoByEstadDeposito("pendiente");

        for (PagoServicio pagoS: pagoServicios) {
            vueltos +=  pagoS.getVueltoPagoServicio();
        }

        for (PagoCredito pagoC: pagoCreditos) {
            vueltos +=  pagoC.getVueltoPagoCredito();
        }

        for (Deposito deposito: depositos) {
            vueltos +=  deposito.getVueltoDeposito();
        }
        return vueltos;
    }

    @Override
    public Page<Balance> getBalancesByPage(Pageable pageable) {
        return this.repositorioBalance.findAll(pageable);
    }

    @Override
    public Balance createBalance(Balance balance) {
        balance.setHoraPagoCredito(LocalDateTime.now());
        return this.repositorioBalance.save(balance);
    }

    @Override
    public List<Balance> getAllBalances() {
        return this.repositorioBalance.findAll();
    }

    @Override
    public Balance getBalanceById(Integer idBalance) {
        return this.repositorioBalance.findById(idBalance).orElse(new Balance());
    }

    @Override
    public Balance updateBalance(Balance balance) {
        return this.repositorioBalance.save(balance);
    }

    @Override
    public void deleteBalance(Integer idBalance) {
        System.out.println("tienda vera");
        System.out.println("Array de pruueba")
        this.repositorioBalance.deleteById(idBalance);
    }
}
