package com.ceiba.rutina.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.rutina.puerto.RepositorioRutina;
import com.ceiba.usuario.controlador.ComandoControladorUsuario;
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


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorUsuario.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ComandoControladorRutinaTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private RepositorioRutina repositorioRutina;

    @Test
    void crearRutinaoExitoso() throws Exception {
        var comandoCrearRutinaTestDataBuilder =
                new ComandoCrearRutinaTestDataBuilder().crearPorDefecto().build();

        var resultado = mocMvc.perform(post("/api/usuario/1/rutina")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoCrearRutinaTestDataBuilder)))
                .andExpect(status().is2xxSuccessful()).andReturn();
        String jsonResult = resultado.getResponse().getContentAsString();
        var respuesta = objectMapper.readValue(jsonResult, RespuestaCrearRutina.class);

        var rutinaGuardada = repositorioRutina.obtenerRutina(respuesta.getValor());
        Assertions.assertEquals("Rutina cardiovascular", rutinaGuardada.getDescripcion());
        Assertions.assertEquals("Un corazón más saludable", rutinaGuardada.getObjetivo());
    }

    @Test
    void editarRutinaExitoso() throws Exception {
        var comandoEditarRutinaTestDataBuilder =
                new ComandoEditarRutinaTestDataBuilder().crearPorDefecto().build();

        var resultado = mocMvc.perform(post("/api/usuario/1/rutina")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoEditarRutinaTestDataBuilder)))
                .andExpect(status().is2xxSuccessful()).andReturn();
        String jsonResult = resultado.getResponse().getContentAsString();
        var respuesta = objectMapper.readValue(jsonResult, RespuestaCrearRutina.class);

        var rutinaGuardada = repositorioRutina.obtenerRutina(respuesta.getValor());
        Assertions.assertEquals("Rutina cardiovascular editada", rutinaGuardada.getDescripcion());
        Assertions.assertEquals("Un corazón más saludable editada", rutinaGuardada.getObjetivo());
    }


}
