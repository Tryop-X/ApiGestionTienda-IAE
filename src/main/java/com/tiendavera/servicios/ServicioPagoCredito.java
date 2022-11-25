package com.tiendavera.servicios;

import com.tiendavera.entidades.PagoCredito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServicioPagoCredito {

    Page<PagoCredito> getPagoCreditoByPage(Pageable pageable);
    PagoCredito createPagoCredito(PagoCredito pagoCredito);
    List<PagoCredito> getAllPagoCreditos();
    PagoCredito getPagoCreditoById(Integer idPagoCredito);
    PagoCredito updatePagoCredito(PagoCredito pagoCredito);
    void deletePagoCredito(Integer idPagoCredito);
    List<PagoCredito> getPagoCreditoByEstado(String estadoPagoCredito);

}
