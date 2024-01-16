package com.teste.dev.java.infuse.service;

import com.teste.dev.java.infuse.dto.ClienteDTO;
import com.teste.dev.java.infuse.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    Optional<Cliente> buscarPorID(Integer id);

    List<ClienteDTO> buscarTodos();
}
