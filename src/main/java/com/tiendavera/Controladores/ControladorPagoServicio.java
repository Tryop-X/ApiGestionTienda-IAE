package com.tiendavera.Controladores;

import com.tiendavera.entidades.PagoServicio;
import com.tiendavera.servicios.ServicioPagoServicio;
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
@RequestMapping("/pagoServicio")
@AllArgsConstructor
public class ControladorPagoServicio {

    private final ServicioPagoServicio servicioPagoServicio;

    @GetMapping("/pag")
    public ResponseEntity<Page<PagoServicio>> getAllByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ){
        Page<PagoServicio> pagoServicios   = this.servicioPagoServicio.getPagoServicioByPage(
                PageRequest.of(page, size, Sort.by("idPagoServicio").descending())
        );
        return new ResponseEntity<Page<PagoServicio>>(pagoServicios,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PagoServicio> createPagoServicio(@RequestBody PagoServicio pagoServicio){

        return new ResponseEntity<PagoServicio>(this.servicioPagoServicio.createPagoServicio(pagoServicio), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PagoServicio> updatePagoServicio(@RequestBody PagoServicio pagoServicio ){
        return new ResponseEntity<>(this.servicioPagoServicio.updatePagoServicio(pagoServicio), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<PagoServicio>> getAllPagoServicio(){
        return new ResponseEntity<List<PagoServicio>>(this.servicioPagoServicio.getAllPagoServicios(),HttpStatus.OK);
    }

    @GetMapping("/{idPagoServicio}")
    public ResponseEntity<PagoServicio> getPagoServicioById (@PathVariable("idPagoServicio") Integer idPagoServicio){
        return new ResponseEntity<PagoServicio>(this.servicioPagoServicio.getPagoServicioById(idPagoServicio) , HttpStatus.OK);
    }

    @GetMapping("estado/{estadoPagoServicio}")
    public ResponseEntity<List<PagoServicio>> getPagoServicioByEstado (@PathVariable("estadoPagoServicio") String estadoPagoServicio){
        return new ResponseEntity<List<PagoServicio>>(this.servicioPagoServicio.getPagoServicioByEstado(estadoPagoServicio) , HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{idPagoServicio}")
    public ResponseEntity<Void> deletePagoServicio(@PathVariable("idPagoServicio") Integer idPagoServicio){
        this.servicioPagoServicio.deletePagoServicio(idPagoServicio);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
