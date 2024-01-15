package com.teste.dev.java.infuse.model;

import com.teste.dev.java.infuse.dto.PedidoDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido {

    @Id
    @Column(unique = true, nullable = false)
    private Integer numero;

    @Column(nullable = false)
    private Date dataCadastro;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private BigDecimal valorTotal;

    @Column(nullable = false)
    @Min(value = 1, message = "Quantidade minima de ser 1")
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente cliente;

    public PedidoDTO paraDTO() {
        return PedidoDTO.builder()
                .numero(this.numero)
                .dataCadastro(this.dataCadastro)
                .nome(this.nome)
                .valor(this.valor)
                .valorTotal(this.valorTotal)
                .quantidade(this.quantidade)
                .cliente(this.cliente.paraDTO())
                .build();
    }
}
