package com.tiendavera.Controladores;
import com.tiendavera.entidades.Cuenta;
import com.tiendavera.servicios.ServicioCuenta;
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
@RequestMapping("/cuenta")
@AllArgsConstructor

public class ControladorCuenta  {
    private final ServicioCuenta servicioCuenta;

    @GetMapping("/pag")
    public ResponseEntity<Page<Cuenta>> getAllByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        Page<Cuenta>  cuentas  = this.servicioCuenta.getCuentaByPage(
                PageRequest.of(page, size, Sort.by("idCuenta").descending())
        );
        return new ResponseEntity<Page<Cuenta>>(cuentas,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Cuenta> createCuenta(@RequestBody Cuenta cuenta){
        return new ResponseEntity<Cuenta>(this.servicioCuenta.createCuenta(cuenta), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Cuenta> updateCuenta(@RequestBody Cuenta cuenta){
        return new ResponseEntity<Cuenta>(this.servicioCuenta.updateCuentea(cuenta), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Cuenta>> getAllCuentas(){
        return new ResponseEntity<List<Cuenta>>(this.servicioCuenta.getAllCuentas(),HttpStatus.OK);
    }

    @GetMapping("/{idCuenta}")
    public ResponseEntity<Cuenta> getCuentaById (@PathVariable("idCuenta") Integer idCuenta){
        return new ResponseEntity<Cuenta>(this.servicioCuenta.getCuentaById(idCuenta) , HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{idCuenta}")
    public ResponseEntity<Void> deleteCuenta(@PathVariable("idCuenta") Integer idCuenta){
        this.servicioCuenta.deleteCuenta(idCuenta);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
