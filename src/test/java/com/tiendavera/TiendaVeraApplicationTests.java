package com.tiendavera;

import com.tiendavera.seguridad.repositorios.RepositorioUsuario;
import com.tiendavera.seguridad.entidades.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TiendaVeraApplicationTests {


    @Test
    void contextLoads() {
        RepositorioUsuario repositorioUsuario= null;

        Usuario usuario =  new Usuario();

        usuario.setNombreUsuario("Hugo");
        usuario.setContrasegnaUsuario("pugueria");

        Usuario u = repositorioUsuario.save(usuario);


    }

}
