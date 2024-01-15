package com.teste.dev.java.infuse.service;

import com.teste.dev.java.infuse.dto.PedidoInputDTO;
import com.teste.dev.java.infuse.model.Pedido;

import java.util.Optional;

public interface PedidoService {

    PedidoInputDTO cadastrarPedido(PedidoInputDTO pedidos);

    Optional<Pedido> buscarPedidoPeloNumero(Integer numeroControle);
}
