package com.teste.dev.java.infuse.controller;

import com.teste.dev.java.infuse.dto.PedidoDTO;
import com.teste.dev.java.infuse.dto.PedidoInputDTO;
import com.teste.dev.java.infuse.service.PedidoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/novo")
    public PedidoInputDTO novoPedido(@RequestBody @Valid PedidoInputDTO pedidoInput){
        return pedidoService.cadastrarPedido(pedidoInput);
    }

    @GetMapping("/buscar")
    public List<PedidoDTO> buscarPedidos(@RequestParam(name="numero", required = false) Integer numero,
                                         @RequestParam(name="dataCadastro", required = false) String dataCadastro,
                                         @RequestParam(name="todos", required = false, defaultValue = "true") Boolean todos) throws ParseException {

        return pedidoService.buscarPedidos(numero, dataCadastro, todos);

    }
}
