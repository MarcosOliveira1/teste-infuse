package com.teste.dev.java.infuse.service;

import com.teste.dev.java.infuse.dto.PedidoDTO;
import com.teste.dev.java.infuse.dto.PedidoInputDTO;
import com.teste.dev.java.infuse.model.Pedido;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

public interface PedidoService {

    ResponseEntity<PedidoInputDTO> cadastrarPedido(PedidoInputDTO pedidos);

    Optional<Pedido> buscarPedidoPeloNumero(Integer numeroControle);

    List<PedidoDTO> buscarPedidos(Integer numero, String dataCadastro, Boolean todos) throws ParseException;
}
