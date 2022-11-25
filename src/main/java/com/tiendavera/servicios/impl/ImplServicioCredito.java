package com.tiendavera.servicios.impl;

import com.tiendavera.repositorios.RepositorioCredito;
import com.tiendavera.entidades.Credito;
import com.tiendavera.servicios.ServicioCredito;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ImplServicioCredito implements ServicioCredito {

    private RepositorioCredito repositorioCredito;

    public ImplServicioCredito(RepositorioCredito repositorioCredito){
        this.repositorioCredito = repositorioCredito;
    }

    @Override
    public Page<Credito> getCreditoByPage(Pageable pageable) {
        return this.repositorioCredito.findAll(pageable);
    }

    @Override
    public Credito createCredito(Credito credito) {
        return this.repositorioCredito.save(credito);
    }

    @Override
    public List<Credito> getAllCreditos() {
        return this.repositorioCredito.findAll();
    }

    @Override
    public Credito getCreditosById(Integer id) {
        return this.repositorioCredito.findById(id).orElse(new Credito());
    }

    @Override
    public Credito updateCredito(Credito credito) {
        return this.repositorioCredito.save(credito);
    }

    @Override
    public void deleteCredito(Integer id) {
        this.repositorioCredito.deleteById(id);
    }
}
