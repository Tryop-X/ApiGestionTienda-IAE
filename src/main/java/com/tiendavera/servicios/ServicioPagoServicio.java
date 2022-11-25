package com.tiendavera.servicios;

import com.tiendavera.entidades.PagoCredito;
import com.tiendavera.entidades.PagoServicio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServicioPagoServicio {

    Page<PagoServicio> getPagoServicioByPage(Pageable pageable);
    PagoServicio createPagoServicio(PagoServicio pagoServicio);
    List<PagoServicio> getAllPagoServicios();
    PagoServicio getPagoServicioById(Integer idPagoServicio);
    PagoServicio updatePagoServicio(PagoServicio pagoServicio);
    void deletePagoServicio(Integer idPagoServicio);
    List<PagoServicio> getPagoServicioByEstado(String estadoPagoServicio);

}
