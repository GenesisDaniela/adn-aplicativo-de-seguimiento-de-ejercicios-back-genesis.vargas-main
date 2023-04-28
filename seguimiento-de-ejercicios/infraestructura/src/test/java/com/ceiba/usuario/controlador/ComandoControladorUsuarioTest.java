package com.ceiba.usuario.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorUsuario.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
 public class ComandoControladorUsuarioTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Test
    void crearUsuarioExitoso() throws Exception {
        var comandoCrearUsuarioTestDataBuilder =
                new ComandoCrearUsuarioTestDataBuilder().crearPorDefecto().build();

        var resultado = mocMvc.perform(post("/api/usuario")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoCrearUsuarioTestDataBuilder)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();
        var respuesta = objectMapper.readValue(jsonResult, RespuestaCrearUsuario.class);

        var usuarioGuardado = repositorioUsuario.obtenerUsuario(Math.toIntExact(respuesta.getValor()));

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaNacimiento = formato.parse("23/11/2001");

        Assertions.assertEquals("Genesis", usuarioGuardado.getNombre());
        Assertions.assertEquals(64f, usuarioGuardado.getPeso());
        Assertions.assertEquals("Genesis@gmail.com", usuarioGuardado.getCorreo());
        Assertions.assertEquals("1234567898", usuarioGuardado.getContrasenia());
        Assertions.assertEquals(fechaNacimiento, usuarioGuardado.getFechaNacimiento());

    }




}
