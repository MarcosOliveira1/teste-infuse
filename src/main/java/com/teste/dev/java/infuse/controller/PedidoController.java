package com.teste.dev.java.infuse.controller;

import com.teste.dev.java.infuse.dto.PedidoInputDTO;
import com.teste.dev.java.infuse.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/novo")
    public PedidoInputDTO novoPedido(@RequestBody @Valid PedidoInputDTO pedidoInput){
        return pedidoService.cadastrarPedido(pedidoInput);
    }

}
