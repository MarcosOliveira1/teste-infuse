package com.teste.dev.java.infuse.service.impl;

import com.teste.dev.java.infuse.model.Cliente;
import com.teste.dev.java.infuse.repository.ClienteRepository;
import com.teste.dev.java.infuse.service.ClienteService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Optional<Cliente> buscarPorID(Integer id) {
        return clienteRepository.findById(id);
    }
}
