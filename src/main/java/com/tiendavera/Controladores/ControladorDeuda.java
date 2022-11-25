package com.tiendavera.Controladores;
import com.tiendavera.entidades.Deuda;
import com.tiendavera.entidades.PagoCredito;
import com.tiendavera.servicios.ServicioDeuda;
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
@RequestMapping("/deuda")
@AllArgsConstructor
public class ControladorDeuda {
    private final ServicioDeuda servicioDeuda;

    @GetMapping("/pag")
    public ResponseEntity<Page<Deuda>> getAllByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ){
        Page<Deuda> deudas   = this.servicioDeuda.getDeudaByPage(
                PageRequest.of(page, size, Sort.by("idDeuda").descending())
        );
        return new ResponseEntity<Page<Deuda>>(deudas,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Deuda> createDeuda(@RequestBody Deuda deuda){
        return new ResponseEntity<Deuda>(this.servicioDeuda.createDeuda(deuda), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Deuda> updateDeuda(@RequestBody Deuda deuda){
        return new ResponseEntity<Deuda>(this.servicioDeuda.updateDeuda(deuda), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Deuda>> getAllDeudas(){
        return new ResponseEntity<List<Deuda>>(this.servicioDeuda.getAllDeudas(),HttpStatus.OK);
    }

    @GetMapping("/{idDeuda}")
    public ResponseEntity<Deuda> getDeudaById (@PathVariable("idDeuda") Integer idDeuda){
        return new ResponseEntity<Deuda>(this.servicioDeuda.getDeudaById(idDeuda), HttpStatus.OK);
    }

    @GetMapping("estado/{estadoDeuda}")
    public ResponseEntity<List<Deuda>> getDeudaByEstado (@PathVariable("estadoDeuda") String estadoDeuda){
        return new ResponseEntity<List<Deuda>>(this.servicioDeuda.getDeudaByEstado(estadoDeuda) , HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{idDeuda}")
    public ResponseEntity<Void> deleteDeuda(@PathVariable("idDeuda") Integer idDeuda){
        this.servicioDeuda.deleteDeuda(idDeuda);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
