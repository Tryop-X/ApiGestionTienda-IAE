package com.tiendavera.Controladores;

import com.tiendavera.entidades.PagoCredito;
import com.tiendavera.servicios.ServicioPagoCredito;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pagoCredito")
@AllArgsConstructor
public class ControladorPagoCredito {
    private final ServicioPagoCredito servicioPagoCredito;

    @GetMapping("/pag")
    public ResponseEntity<Page<PagoCredito>> getAllByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ){
        Page<PagoCredito> pagoCreditos   = this.servicioPagoCredito.getPagoCreditoByPage(
                PageRequest.of(page, size, Sort.by("idPagoCredito").descending())
        );
        return new ResponseEntity<Page<PagoCredito>>( pagoCreditos,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PagoCredito> createPagoCredito(@RequestBody PagoCredito pagoCredito){

        PagoCredito nuevoPagoCredito = this.servicioPagoCredito.createPagoCredito(pagoCredito);
        return new ResponseEntity<PagoCredito>(nuevoPagoCredito, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PagoCredito> updatePagoCredito(@RequestBody PagoCredito pagoCredito){
        return new ResponseEntity<PagoCredito>(servicioPagoCredito.updatePagoCredito(pagoCredito), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<PagoCredito>> getAllPagosCredito(){
        return new ResponseEntity<List<PagoCredito>>(servicioPagoCredito.getAllPagoCreditos(),HttpStatus.OK);
    }

    @GetMapping("/{idPagoCredito}")
    public ResponseEntity<PagoCredito> getByIdPagoCredito(@PathVariable("idPagoCredito") Integer idPagoCredito){
        return new ResponseEntity<PagoCredito>(servicioPagoCredito.getPagoCreditoById(idPagoCredito), HttpStatus.OK);
    }


    @GetMapping("estado/{estadoPagoCredito}")
    public ResponseEntity<List<PagoCredito>> getPagoCreditoByEstado (@PathVariable("estadoPagoCredito") String estadoPagoCredito){
        return new ResponseEntity<List<PagoCredito>>(this.servicioPagoCredito.getPagoCreditoByEstado(estadoPagoCredito) , HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{idPagoCredito}")
    public ResponseEntity<Void> deletePagoCredito(@PathVariable("idPagoCredito") Integer idPagoCredito){
        this.servicioPagoCredito.deletePagoCredito(idPagoCredito);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
