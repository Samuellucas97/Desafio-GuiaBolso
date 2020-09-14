package com.example.desafioguiabolso.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ExcecaoDetalhes {
    protected String titulo;
    protected Integer status;
    protected String detalhes;
    protected LocalDateTime timestamp;
    protected String mensagem;
}