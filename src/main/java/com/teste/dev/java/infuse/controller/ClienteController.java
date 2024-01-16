package com.teste.dev.java.infuse.controller;

import com.teste.dev.java.infuse.dto.ClienteDTO;
import com.teste.dev.java.infuse.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/buscar")
    public List<ClienteDTO> buscarTodosClientes() {
        return clienteService.buscarTodos();
    }
}
