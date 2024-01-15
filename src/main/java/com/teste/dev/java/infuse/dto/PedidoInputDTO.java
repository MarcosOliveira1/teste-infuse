package com.teste.dev.java.infuse.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidoInputDTO {

    @Size(max = 10, message = "Deve ser solicitado no maxímo 10 pedidos")
    @Size(min = 1, message = "Deve ser solicitado no minímo 1 pedido")
    private List<PedidoDTO> pedidos = new ArrayList<>();

}
