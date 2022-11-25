package com.tiendavera.servicios;

import com.tiendavera.entidades.Cuenta;
import com.tiendavera.entidades.Servicio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServicioServicio {

    Page<Servicio> getServicioByPage(Pageable pageable);
    Servicio createServicio(Servicio servicio);
    List<Servicio> getAllServicios();
    Servicio getServicioById(Integer idServicio);
    Servicio updateServicio(Servicio servicio);
    void deleteServicio(Integer idServicio);
}
