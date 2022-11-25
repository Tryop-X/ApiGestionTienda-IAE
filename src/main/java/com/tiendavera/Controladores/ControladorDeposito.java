package com.tiendavera.Controladores;
import com.tiendavera.entidades.Deposito;
import com.tiendavera.entidades.Deuda;
import com.tiendavera.servicios.ServicioDeposito;
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
@RequestMapping("/deposito")
@AllArgsConstructor
public class ControladorDeposito {

    private final ServicioDeposito servicioDeposito;

    @GetMapping("/pag")
    public ResponseEntity<Page<Deposito>> getAllByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ){
        Page<Deposito> depositos   = this.servicioDeposito.getDepositoByPage(
                PageRequest.of(page, size, Sort.by("idDeposito").descending())
        );
        return new ResponseEntity<Page<Deposito>>( depositos,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Deposito> createDeposito(@RequestBody Deposito deposito){
        return new ResponseEntity<Deposito>(this.servicioDeposito.createDeposito(deposito), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Deposito> updateDeposito(@RequestBody Deposito deposito ){
        System.out.println("asd");
        return new ResponseEntity<Deposito>(this.servicioDeposito.updateDeposito(deposito), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Deposito>> getAllDepositos(){
        return new ResponseEntity<List<Deposito>>(this.servicioDeposito.getAllDepositos(),HttpStatus.OK);
    }

    @GetMapping("/{idDeposito}")
    public ResponseEntity<Deposito> getDepositoById(@PathVariable("idDeposito") Integer idDeposito){
        return new ResponseEntity<Deposito>( this.servicioDeposito.getDepositoById(idDeposito), HttpStatus.OK);
    }

    @GetMapping("estado/{estadoDeposito}")
    public ResponseEntity<List<Deposito>> getDepositoByEstado (@PathVariable("estadoDeposito") String estadoDeposito){
        return new ResponseEntity<List<Deposito>>(this.servicioDeposito.getDepositoByEstadDeposito(estadoDeposito) , HttpStatus.OK);
    }

    @DeleteMapping("/{idDeposito}")
    public ResponseEntity<Void> deleteDeposito(@PathVariable("idDeposito") Integer idDeposito){
        this.servicioDeposito.deleteDeposito(idDeposito);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
