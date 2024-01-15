package com.teste.dev.java.infuse.service;


import com.teste.dev.java.infuse.AbstractTestSupport;
import com.teste.dev.java.infuse.dto.PedidoInputDTO;
import com.teste.dev.java.infuse.exception.NegocioException;
import com.teste.dev.java.infuse.repository.PedidoRepository;
import com.teste.dev.java.infuse.service.impl.ClienteServiceImpl;
import com.teste.dev.java.infuse.service.impl.PedidoServiceImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PedidoServiceImplTest extends AbstractTestSupport {

    @InjectMocks
    private PedidoServiceImpl pedidoService;

    @Mock
    private ClienteServiceImpl clienteService;

    @Mock
    private PedidoRepository pedidoRepository;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before()
    public void setup(){
        MockitoAnnotations.initMocks(this);
        this.pedidoService = new PedidoServiceImpl(pedidoRepository, clienteService);
    }

    @Test
    @DisplayName("Deve criar novos pedidos")
    public void criarNovoPedido(){

        when(clienteService.buscarPorID(anyInt())).thenReturn(getClienteOptional());
        when(pedidoRepository.save(any())).thenReturn(getPedidoEntidade());

        PedidoInputDTO pedidoInputDTO = pedidoService.cadastrarPedido(getPedidoInput());

        assertEquals(Optional.of(5).get(), pedidoInputDTO.getPedidos().get(0).getQuantidade());
        assertEquals(NOME_PRODUTO_1, pedidoInputDTO.getPedidos().get(0).getNome());
    }

    @Test
    @DisplayName("Deve gerar uma excessão de negocio")
    public void criarNovoPedidoComNumeroJaInfomado(){

        expectedException.expect(NegocioException.class);
        expectedException.expectMessage(String.format(PEDIDO_COM_NUMERO_CADASTRADO, 1));

        when(pedidoRepository.findById(1)).thenReturn(Optional.of(getPedidoEntidade()));

        pedidoService.cadastrarPedido(getPedidoInput());
    }

    @Test
    @DisplayName("Deve gerar uma excessão de negocio")
    public void criarNovoPedidoComClienteNaoInformado(){
        expectedException.expect(NegocioException.class);
        expectedException.expectMessage(String.format(CLIENTE_NAO_ENCONTRADO, 1));

        pedidoService.cadastrarPedido(getPedidoInput());
    }
}
