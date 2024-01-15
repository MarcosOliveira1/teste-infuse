create table pedido
(
    numero        int                    not null,
    data_cadastro DATE default (CURDATE()) not null,
    nome          VARCHAR(255)           null,
    valor         numeric(10, 2)         null,
    valor_total   numeric(10, 2)         null,
    quantidade    int                    null,
    id_cliente    int                    null,
    constraint pedido_pk
        primary key (numero),
    constraint pedido_pk2
        unique (numero),
    constraint pedido_cliente_id_fk
        foreign key (id_cliente) references cliente (id)
);

