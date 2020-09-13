package com.example.desafioguiabolso.model;

import lombok.Getter;
import lombok.Value;

@Value
@Getter
public class Transacao {
    private final String descricao;
    private final Long data;
    private final Integer valor;
    private final Boolean duplicated;
}
