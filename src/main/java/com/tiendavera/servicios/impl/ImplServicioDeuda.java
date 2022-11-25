package com.tiendavera.servicios.impl;

import com.tiendavera.repositorios.RepositorioDeuda;
import com.tiendavera.entidades.Deuda;
import com.tiendavera.servicios.ServicioDeuda;
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

public class ImplServicioDeuda implements ServicioDeuda {

    private final RepositorioDeuda repositorioDeuda;

    @Override
    public Page<Deuda> getDeudaByPage(Pageable pageable) {
        return this.repositorioDeuda.findAll(pageable);
    }

    @Override
    public Deuda createDeuda(Deuda deuda) {
        deuda.setHoraPrestamo(LocalDateTime.now());
        deuda.setEstadoDeuda("pendiente");
        return this.repositorioDeuda.save(deuda);
    }

    @Override
    public List<Deuda> getAllDeudas() {
        return this.repositorioDeuda.findAll();
    }

    @Override
    public Deuda getDeudaById(Integer idDeuda) {
        return this.repositorioDeuda.findById(idDeuda).orElse(new Deuda());
    }

    @Override
    public Deuda updateDeuda(Deuda deuda) {
        return this.repositorioDeuda.save(deuda);
    }

    @Override
    public void deleteDeuda(Integer idDeuda) {
        this.repositorioDeuda.deleteById(idDeuda);
    }

    @Override
    public List<Deuda> getDeudaByEstado(String estadoDeuda) {
        
        List<Deuda> deudas = this.repositorioDeuda.getDeudaByEstado(estadoDeuda);
        if(deudas == null){
            deudas = new ArrayList<Deuda>();
        }
        return deudas;
    }
}
