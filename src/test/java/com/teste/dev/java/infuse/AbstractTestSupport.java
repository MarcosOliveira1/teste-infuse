package com.teste.dev.java.infuse;

import com.teste.dev.java.infuse.dto.ClienteDTO;
import com.teste.dev.java.infuse.dto.PedidoDTO;
import com.teste.dev.java.infuse.dto.PedidoInputDTO;
import com.teste.dev.java.infuse.model.Cliente;
import com.teste.dev.java.infuse.model.Pedido;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public abstract class AbstractTestSupport {

    protected static final String NOME_PRODUTO_1 = "produto 1";
    protected static final String PEDIDO_COM_NUMERO_CADASTRADO = "Numero do pedido %s já cadastrado!";
    protected static final String CLIENTE_NAO_ENCONTRADO = "Cliente %s não encontrado!";

    protected Optional<Cliente> getClienteOptional() {
        return Optional.of(ClienteDTO.builder()
                .id(1)
                .nome("cliente 1")
                .build().paraEntidade());
    }

    protected Pedido getPedidoEntidade() {
        return Pedido.builder()
                .numero(1)
                .nome("produto 1")
                .quantidade(5)
                .valor(BigDecimal.valueOf(9.90))
                .valor(BigDecimal.valueOf(49.5))
                .dataCadastro(new Date())
                .cliente(Cliente.builder()
                        .id(1)
                        .nome("cliente 1")
                        .build())
                .build();
    }

    protected List<PedidoDTO> getPedidos() {
        List<PedidoDTO> pedidos = new ArrayList<>();
        pedidos.add(PedidoDTO.builder()
                .numero(1)
                .nome("produto 1")
                .quantidade(5)
                .valor(BigDecimal.valueOf(9.90))
                .valor(BigDecimal.valueOf(49.5))
                .dataCadastro(new Date())
                .cliente(ClienteDTO.builder()
                        .id(1)
                        .nome("cliente 1")
                        .build())
                .build());
        pedidos.add(PedidoDTO.builder()
                .numero(2)
                .nome("produto 2")
                .quantidade(6)
                .valor(BigDecimal.valueOf(3.90))
                .valor(BigDecimal.valueOf(49.5))
                .dataCadastro(new Date())
                .cliente(ClienteDTO.builder()
                        .id(2)
                        .nome("cliente 2")
                        .build())
                .build());

        pedidos.add(PedidoDTO.builder()
                .numero(3)
                .nome("produto 3")
                .quantidade(15)
                .valor(BigDecimal.valueOf(10.90))
                .valor(BigDecimal.valueOf(49.5))
                .dataCadastro(new Date())
                .cliente(ClienteDTO.builder()
                        .id(3)
                        .nome("cliente 3")
                        .build())
                .build());
        return pedidos;
    }

    protected PedidoInputDTO getPedidoInput() {
        PedidoInputDTO input = new PedidoInputDTO();
        input.setPedidos(getPedidos());
        return input;
    }
}
