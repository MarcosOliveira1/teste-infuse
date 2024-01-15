package com.teste.dev.java.infuse.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.teste.dev.java.infuse.model.Pedido;
import jakarta.validation.constraints.Min;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoDTO {

    private Integer numero;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date dataCadastro = new Date();
    private String nome;
    private BigDecimal valor;
    private BigDecimal valorTotal;
    @Min(1)
    private Integer quantidade = 1;
    private ClienteDTO cliente;

    private void calcularValorTotal() {
        BigDecimal total = this.valor.multiply(BigDecimal.valueOf(quantidade));
        this.valorTotal = calcularDesconto(total);
    }

    private BigDecimal calcularDesconto(BigDecimal total) {
        if (this.quantidade >= 10) {

            return total.subtract(total.multiply(BigDecimal.valueOf(0.10)));

        } else if (this.quantidade > 5) {
            return total.subtract(total.multiply(BigDecimal.valueOf(0.05)));
        } else {
            return total;
        }
    }

    public Pedido paraEntidade() {
        calcularValorTotal();
        return Pedido.builder()
                .numero(this.numero)
                .dataCadastro(this.dataCadastro)
                .nome(this.nome)
                .valor(this.valor)
                .valorTotal(this.valorTotal)
                .quantidade(this.quantidade)
                .cliente(this.cliente.paraEntidade())
                .build();
    }
}
