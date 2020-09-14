package com.example.desafioguiabolso.utils;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@Builder
public class TransacaoSemDuplicated {
    private final String descricao;
    private final Long data;
    private final Integer valor;
}
