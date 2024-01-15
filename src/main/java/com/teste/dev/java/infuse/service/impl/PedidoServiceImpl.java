package com.teste.dev.java.infuse.service.impl;

import com.teste.dev.java.infuse.dto.ClienteDTO;
import com.teste.dev.java.infuse.dto.PedidoDTO;
import com.teste.dev.java.infuse.dto.PedidoInputDTO;
import com.teste.dev.java.infuse.model.Pedido;
import com.teste.dev.java.infuse.repository.PedidoRepository;
import com.teste.dev.java.infuse.service.PedidoService;
import com.teste.dev.java.infuse.util.AssertUtils;
import com.teste.dev.java.infuse.util.DataUtil;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;

    private final ClienteServiceImpl clienteService;

    public PedidoServiceImpl(PedidoRepository pedidoRepository, ClienteServiceImpl clienteService) {
        this.pedidoRepository = pedidoRepository;
        this.clienteService = clienteService;
    }

    @Override
    public PedidoInputDTO cadastrarPedido(PedidoInputDTO pedidos) {
        PedidoInputDTO pedidosCadastrados = new PedidoInputDTO();
        pedidos.getPedidos().forEach(pedido -> {

            validarPedidoNumeroCadastrado(pedido.getNumero());
            validadeCliente(pedido.getCliente());

            pedidosCadastrados.getPedidos()
                    .add(pedidoRepository.save(pedido.paraEntidade()).paraDTO());
        });
        return pedidosCadastrados;
    }

    @Override
    public Optional<Pedido> buscarPedidoPeloNumero(Integer numero) {
        return pedidoRepository.findById(numero);
    }

    @Override
    public List<PedidoDTO> buscarPedidos(Integer numero, String dataCadastro, Boolean todos) throws ParseException {
        Date data = DataUtil.formatarData(dataCadastro);
        List<PedidoDTO> pedidoOutput = new ArrayList<>();
        List<Pedido> pedidos = new ArrayList<>();

        if (filtrarPorData(data) && filtrarPorNumeroControle(numero)) {
            pedidos = pedidoRepository.findByNumeroAndDataCadastro(numero, data);
        } else if (filtrarPorData(data)) {
            pedidos = pedidoRepository.findByDataCadastro(data);
        } else if (filtrarPorNumeroControle(numero)) {
            pedidos = pedidoRepository.findByNumero(numero);
        } else if (Boolean.TRUE.equals(todos)){
            pedidos = pedidoRepository.findAll();
        }


        pedidos.forEach(pedido -> pedidoOutput.add(pedido.paraDTO()));

        return pedidoOutput;
    }

    private void validarPedidoNumeroCadastrado(Integer numero) {
        AssertUtils.assertTrue(buscarPedidoPeloNumero(numero).isEmpty(), String.format("Numero do pedido %s já cadastrado!", numero));
    }

    private void validadeCliente(ClienteDTO cliente) {
        AssertUtils.assertTrue(clienteService.buscarPorID(cliente.getId()).isPresent(), String.format("Cliente %s não encontrado!", cliente.getId()));
    }

    private boolean filtrarPorData(Date data) {
        return data != null;
    }

    private boolean filtrarPorNumeroControle(Integer numeroControle) {
        return numeroControle != null;
    }
}
