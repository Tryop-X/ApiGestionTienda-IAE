package com.tiendavera.servicios;

import com.tiendavera.Controladores.dto.RespuestaDeudor;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;


@Service
public class DeudorService {
    private RestTemplate restTemplate;

    public DeudorService (RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Value("${apiDeudores}")
    String apiKey;
    @GetMapping
    public RespuestaDeudor esDeudor(String numeroDocumento) {
        String url = "http://localhost:9090/deudores/documentoIdentidad/"+numeroDocumento;
        ResponseEntity<RespuestaDeudor> response = this.restTemplate.getForEntity(url, RespuestaDeudor.class);
        return response.getBody();
    }
}
