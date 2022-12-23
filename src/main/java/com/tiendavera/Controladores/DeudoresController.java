package com.tiendavera.Controladores;


import com.tiendavera.Controladores.dto.RespuestaDeudor;
import com.tiendavera.servicios.DeudorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deudores")
@AllArgsConstructor
public class DeudoresController {

    private final DeudorService deudorService;
    @GetMapping("/{numeroDocumento}")
    public ResponseEntity<RespuestaDeudor> getDeudor(@PathVariable("numeroDocumento") String numeroDocumento){
        RespuestaDeudor respuestaDeudor = this.deudorService.esDeudor(numeroDocumento);
        return new ResponseEntity<>(respuestaDeudor, HttpStatus.OK);
    }
}
