package com.example.desafioguiabolso.exception;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Data
@SuperBuilder
public class ExcecaoDetalhes {
    protected String titulo;
    protected Integer status;
    protected String detalhes;
    protected LocalDateTime timestamp;
    protected String mensagem;
}