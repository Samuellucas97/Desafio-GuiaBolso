package com.example.desafioguiabolso.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Transacao {
    private final String descricao;
    private final Long data;
    private final Integer valor;
    private Boolean duplicated;
}
