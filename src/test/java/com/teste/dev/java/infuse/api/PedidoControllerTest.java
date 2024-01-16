package com.teste.dev.java.infuse.api;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PedidoControllerTest extends AbstractMockMvc {

    @Test
    void buscarTodosPedidos() throws Exception {
        mockMvc.perform(get("/pedidos/buscar")
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void buscarTodosPedidosPorNumero() throws Exception {
        mockMvc.perform(get("/pedidos/buscar?numero=1")
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void buscarTodosPedidosPorData() throws Exception {
        mockMvc.perform(get("/pedidos/buscar?data=15-01-2024")
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    void buscarTodosPedidosPorDataAndNumero() throws Exception {
        mockMvc.perform(get("/pedidos/buscar?numero=1&data=15-01-2024")
                        .contentType("application/json"))
                .andExpect(status().isOk());
    }
}
