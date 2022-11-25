package com.tiendavera.Controladores;

import com.tiendavera.entidades.Servicio;
import com.tiendavera.servicios.ServicioServicio;
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
@RequestMapping("/servicio")
@AllArgsConstructor
public class ControladorServicio {
    private final ServicioServicio servicioServicio;

    @GetMapping("/pag")
    public ResponseEntity<Page<Servicio>> getAllByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ){
        Page<Servicio> servicios = this.servicioServicio.getServicioByPage(
                PageRequest.of(page, size, Sort.by("idServicio").descending())
        );
        return new ResponseEntity<Page<Servicio>>(servicios,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Servicio> createServicio(@RequestBody Servicio  servicio){
        return new ResponseEntity<Servicio>(this.servicioServicio.createServicio(servicio), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Servicio> updateServicio(@RequestBody Servicio servicio){
        return new ResponseEntity<Servicio>(this.servicioServicio.updateServicio(servicio) , HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Servicio>> getAllServicios(){
        return new ResponseEntity<List<Servicio>>(this.servicioServicio.getAllServicios(),HttpStatus.OK);
    }

    @GetMapping("/{idServicio}")
    public ResponseEntity<Servicio> getServicioById (@PathVariable("idServicio") Integer idServicio){
        return new ResponseEntity<Servicio>( this.servicioServicio.getServicioById(idServicio), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{idServicio}")
    public ResponseEntity<Void> deleteServicio(@PathVariable("idServicio") Integer idServicio){
        this.servicioServicio.deleteServicio(idServicio);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
