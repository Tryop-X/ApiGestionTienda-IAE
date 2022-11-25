package com.tiendavera.servicios;

import com.tiendavera.entidades.Credito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
public interface ServicioCredito {

    Page<Credito> getCreditoByPage(Pageable pageable);
    Credito createCredito(Credito credito);
    List<Credito> getAllCreditos();
    Credito getCreditosById(Integer idCredito);
    Credito updateCredito(Credito credito);
    void deleteCredito(Integer idCredito);

}
