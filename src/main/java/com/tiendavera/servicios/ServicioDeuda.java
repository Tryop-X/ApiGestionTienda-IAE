package com.tiendavera.servicios;

import com.tiendavera.entidades.Deuda;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ServicioDeuda {

    Page<Deuda> getDeudaByPage(Pageable pageable);
    Deuda createDeuda(Deuda deuda);
    List<Deuda> getAllDeudas();
    Deuda getDeudaById(Integer idDeuda);
    Deuda updateDeuda(Deuda deuda);
    void deleteDeuda(Integer idDeuda);
    List<Deuda> getDeudaByEstado(String estadoDeuda);

}
