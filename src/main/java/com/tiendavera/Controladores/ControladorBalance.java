package com.tiendavera.Controladores;
import com.tiendavera.entidades.Balance;
import com.tiendavera.servicios.ServicioBalance;
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
@RequestMapping("/balance")
@AllArgsConstructor
public class ControladorBalance {

    private final ServicioBalance servicioBalance;

    @GetMapping("/nuestrasDeudas")
    public ResponseEntity<Double> getNuestrasDeudas(){
        double nuestrasDeudas = this.servicioBalance.getNuestrasDedudas();
        return new ResponseEntity<Double>(nuestrasDeudas, HttpStatus.OK);
    }

    @GetMapping("/dineroPrestado")
    public ResponseEntity<Double> getDineroPrestado(){
        double dineroPrestado = this.servicioBalance.getDineroPrestado();
        return new ResponseEntity<Double>(dineroPrestado, HttpStatus.OK);
    }

    @GetMapping("/vueltos")
    public ResponseEntity<Double> getVueltos(){
        double vueltos = this.servicioBalance.getVueltos();
        return new ResponseEntity<Double>(vueltos, HttpStatus.OK);
    }


    @GetMapping("/pag")
    public ResponseEntity<Page<Balance>> getAllBalanceByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        Page<Balance> balances = this.servicioBalance.getBalancesByPage(
                PageRequest.of(page, size, Sort.by("idBalance").descending())
        );
        return new ResponseEntity<Page<Balance>>(balances,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Balance> createBalance(@RequestBody Balance balance){


        return new ResponseEntity<Balance>(this.servicioBalance.createBalance(balance), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Balance> updateBalance(@RequestBody Balance balance ){
        return new ResponseEntity<Balance>( this.servicioBalance.updateBalance(balance), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Balance>> getAllBalance(){
        return new ResponseEntity<List<Balance>>(this.servicioBalance.getAllBalances(),HttpStatus.OK);
    }

    @GetMapping("/{idBalance}")
    public ResponseEntity<Balance> getBalanceById (@PathVariable("idBalance") Integer idBalance){
        return new ResponseEntity<Balance>(this.servicioBalance.getBalanceById(idBalance) , HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{idBalance}")
    public ResponseEntity<Void> deleteBalance(@PathVariable("idBalance") Integer idBalance){
        this.servicioBalance.deleteBalance(idBalance);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
