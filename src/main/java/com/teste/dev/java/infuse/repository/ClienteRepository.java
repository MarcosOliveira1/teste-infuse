package com.teste.dev.java.infuse.repository;

import com.teste.dev.java.infuse.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
