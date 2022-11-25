package com.tiendavera.Controladores;

import com.tiendavera.entidades.Credito;
import com.tiendavera.servicios.ServicioCredito;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/credito")
@AllArgsConstructor
public class ControladorCredito {

    private final ServicioCredito servicioCredito;

    @GetMapping("/pag")
    public ResponseEntity<Page<Credito>> getAllCreditosByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        Page<Credito>  creditos  = this.servicioCredito.getCreditoByPage(
                PageRequest.of(page, size, Sort.by("idCredito").descending())
        );
        return new ResponseEntity<Page<Credito>>(creditos,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Credito> createCredito(@Valid @RequestBody Credito credito){
        return new ResponseEntity<Credito>(this.servicioCredito.createCredito(credito), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Credito> updateCredito(@RequestBody Credito credito){
        return new ResponseEntity<>(this.servicioCredito.updateCredito(credito), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Credito>> getAllCreditos(){
        return new ResponseEntity<List<Credito>>(this.servicioCredito.getAllCreditos(),HttpStatus.OK);
    }

    @GetMapping("/{idCredito}")
    public ResponseEntity<Credito> getCreditoById (@PathVariable("idCredito") Integer idCredito){
        return new ResponseEntity<Credito>(this.servicioCredito.getCreditosById(idCredito) , HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{idCredito}")
    public ResponseEntity<Void> deleteCredito(@PathVariable("idCredito") Integer idCredito){
        this.servicioCredito.deleteCredito(idCredito);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
