package com.ceiba.rutina.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.usuario.controlador.ConsultaControladorUsuario;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorUsuario.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ConsultaControladorRutinaTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    void consultarRutinas() throws Exception {
        mocMvc.perform(get("/api/usuario/1/rutina")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].descripcion", is("Rutina bicep")))
                .andExpect(jsonPath("$[0].objetivo", is("Ganancia muscular")));
    }

    @Test
    void consultarPlanes() throws Exception {
        mocMvc.perform(get("/api/usuario/1/rutina/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.idRutina", is(1)))
                .andExpect(jsonPath("$.descripcion", is("Rutina bicep")))
                .andExpect(jsonPath("$.objetivo", is("Ganancia muscular")))
                .andExpect(jsonPath("$.planes[0].id", is(1)))
                .andExpect(jsonPath("$.planes[0].rutina.id", is(1)))
                .andExpect(jsonPath("$.planes[0].ejercicio.id", is(1)));


    }
}
