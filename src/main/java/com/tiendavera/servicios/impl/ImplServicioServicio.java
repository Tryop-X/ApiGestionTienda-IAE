package com.tiendavera.servicios.impl;

import com.tiendavera.repositorios.RepositorioServicio;
import com.tiendavera.entidades.Servicio;
import com.tiendavera.servicios.ServicioServicio;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional

public class ImplServicioServicio implements ServicioServicio {

    private final RepositorioServicio repositorioServicio;

    @Override
    public Page<Servicio> getServicioByPage(Pageable pageable) {
        return this.repositorioServicio.findAll(pageable);
    }

    @Override
    public Servicio createServicio(Servicio servicio) {
        return this.repositorioServicio.save(servicio);
    }

    @Override
    public List<Servicio> getAllServicios() {
        return this.repositorioServicio.findAll();
    }

    @Override
    public Servicio getServicioById(Integer idServicio) {
        return this.repositorioServicio.findById(idServicio).orElse(new Servicio());
    }


    @Override
    public Servicio updateServicio(Servicio servicio) {
        return this.repositorioServicio.save(servicio);
    }

    @Override
    public void deleteServicio(Integer idServicio) {
        this.repositorioServicio.deleteById(idServicio);


    }
}
