package com.example.desafioguiabolso.utils;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@Builder
public class TransacaoSemDuplicated {
    private String descricao;
    private Long data;
    private Integer valor;
}
