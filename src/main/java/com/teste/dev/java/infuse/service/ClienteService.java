package com.teste.dev.java.infuse.service;

import com.teste.dev.java.infuse.model.Cliente;

import java.util.Optional;

public interface ClienteService {

    Optional<Cliente> buscarPorID(Integer id);
}
