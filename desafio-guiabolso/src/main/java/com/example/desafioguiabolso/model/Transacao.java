package com.example.desafioguiabolso.model;

import lombok.Getter;
import lombok.Value;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Value
@Getter
public class Transacao {
    private final @Size(min = 10, max = 60,message = "A descrição precisa ter no " +
            "mínimo 10 caracteres e no máximo 60 caracteres") String descricao;
    private final Long data;
    private final @Min(-9) @Max(9) Integer valor;
    private final Boolean duplicated;
}
