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

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorUsuario.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ConsultaControladorUsuarioTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private RepositorioUsuario repositorioUsuario;

    @Test
    void iniciarSesionUsuarioExitoso() throws Exception {
        var consultaIniciarSesion =
                new ComandoSolicitudIniciarSesionUsuarioTestDataBuilder().crearPorDefecto().build();

        var resultado = mocMvc.perform(post("/api/usuario/iniciar-sesion")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(consultaIniciarSesion)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();
        var respuesta = objectMapper.readValue(jsonResult, RespuestaIniciarSesion.class);

        var usuarioAlmacenado = repositorioUsuario.
                obtenerUsuarioPorCorreo(respuesta.getValor());

        Assertions.assertEquals("genesis@gmail.com", usuarioAlmacenado.getCorreo());
        Assertions.assertEquals("2342233332223", usuarioAlmacenado.getContrasenia());
    }

    @Test
    void obtenerUsuarioExitoso() throws Exception {

        var resultado = mocMvc.perform(get("/api/usuario/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();
        var respuesta = objectMapper.readValue(jsonResult,
                RespuestaObtenerUsuario.class);

        var usuarioAlmacenado = respuesta.getValor();

        Assertions.assertEquals("genesis", usuarioAlmacenado.getNombre());
        Assertions.assertEquals(64, usuarioAlmacenado.getPeso());
        Assertions.assertEquals("2342233332223", usuarioAlmacenado.getContrasenia());
    }

    @Test
    void consultarRutinaDeUsuario() throws Exception {
        mocMvc.perform(get("/api/usuario/1/rutina")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].descripcion", is("Rutina bicep")))
                .andExpect(jsonPath("$[0].objetivo", is("Ganancia muscular")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].descripcion", is("Rutina tricep")))
                .andExpect(jsonPath("$[1].objetivo", is("Ganancia muscular")));


    }
}
