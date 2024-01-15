package com.teste.dev.java.infuse.model;

import com.teste.dev.java.infuse.dto.ClienteDTO;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    public ClienteDTO paraDTO() {
        return ClienteDTO.builder()
                .id(this.id)
                .nome(this.nome)
                .build();
    }
}
