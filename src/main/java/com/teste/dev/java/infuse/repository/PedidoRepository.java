package com.teste.dev.java.infuse.repository;

import com.teste.dev.java.infuse.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByDataCadastro(Date data);

    List<Pedido> findByNumero(Integer numero);

    List<Pedido> findByNumeroAndDataCadastro(Integer numero, Date data);
}
