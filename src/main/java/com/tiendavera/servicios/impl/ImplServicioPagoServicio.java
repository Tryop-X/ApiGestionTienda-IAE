package com.tiendavera.servicios.impl;

import com.tiendavera.repositorios.RepositorioPagoServicio;
import com.tiendavera.repositorios.RepositorioServicio;
import com.tiendavera.entidades.PagoServicio;
import com.tiendavera.entidades.Servicio;
import com.tiendavera.servicios.ServicioPagoServicio;
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

public class ImplServicioPagoServicio implements ServicioPagoServicio {

    private final RepositorioPagoServicio repositorioPagoServicio;
    private final RepositorioServicio repositorioServicio;

    @Override
    public Page<PagoServicio> getPagoServicioByPage(Pageable pageable) {
        return this.repositorioPagoServicio.findAll(pageable);
    }

    @Override
    public PagoServicio createPagoServicio(PagoServicio pagoServicio) {
        Servicio servicio;
        pagoServicio.setHoraPagoServicio(LocalDateTime.now());
        pagoServicio.setEstadoPagoServicio("pendiente");
        servicio = repositorioServicio.buscarServicioByCodigo(pagoServicio.getServicio().getCodigoServicio(), pagoServicio.getServicio().getPagoServicio(), pagoServicio.getServicio().getTipoServicio());

        if (servicio == null){
            pagoServicio.getServicio().setDiaPagoServicio(LocalDateTime.now().getDayOfMonth());
            servicio = this.repositorioServicio.save(pagoServicio.getServicio());
        }

        pagoServicio.setServicio(servicio);



        return this.repositorioPagoServicio.save(pagoServicio);
    }

    @Override
    public List<PagoServicio> getAllPagoServicios() {
        return this.repositorioPagoServicio.findAll();
    }

    @Override
    public PagoServicio getPagoServicioById(Integer idPagoServicio) {
        return this.repositorioPagoServicio.findById(idPagoServicio).orElse(new PagoServicio());
    }

    @Override
    public PagoServicio updatePagoServicio(PagoServicio pagoServicio) {
        return this.repositorioPagoServicio.save(pagoServicio);
    }

    @Override
    public void deletePagoServicio(Integer idPagoServicio) {
        this.repositorioPagoServicio.deleteById(idPagoServicio);
    }

    @Override
    public List<PagoServicio> getPagoServicioByEstado(String estadoPagoServicio) {

        List<PagoServicio> pagoServicio = this.repositorioPagoServicio.getPagoServicioByEstado(estadoPagoServicio);
        if(pagoServicio == null){
            pagoServicio = new ArrayList<PagoServicio>();
        }
        return pagoServicio;
    }
}
