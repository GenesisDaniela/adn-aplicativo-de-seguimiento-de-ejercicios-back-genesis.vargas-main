package com.ceiba.plan.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.plan.puerto.RepositorioPlan;
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
class ComandoControladorPlanTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private RepositorioPlan repositorioPlan;

    @Test
    void crearPlanExitoso() throws Exception {
        var comandoCrearPlanTestDataBuilder =
                new ComandoCrearPlanTestDataBuilder().conRutina(1L).conSeries(3).conPeso(10).conRepeticiones(3).conEjercicio(1L).build();

        var resultado = mocMvc.perform(post("/api/usuario/1/rutina/1/plan")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoCrearPlanTestDataBuilder)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();

        var respuesta = objectMapper.readValue(jsonResult, RespuestaCrearPlan.class);
        var planGuardado = repositorioPlan.obtenerPlan(respuesta.getValor());
        Assertions.assertEquals(1L, planGuardado.getEjercicio().getId());
        Assertions.assertEquals(3, planGuardado.getRepeticiones());
        Assertions.assertEquals(10, planGuardado.getPeso());
        Assertions.assertEquals(1L, planGuardado.getRutina().getId());
        Assertions.assertEquals(3, planGuardado.getSeries());
    }
}
