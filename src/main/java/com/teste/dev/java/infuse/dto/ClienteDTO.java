package com.teste.dev.java.infuse.dto;

import com.teste.dev.java.infuse.model.Cliente;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDTO {

    private int id;
    private String nome;

    public Cliente paraEntidade() {
        return Cliente.builder()
                .id(this.id)
                .nome(this.nome)
                .build();
    }
}
