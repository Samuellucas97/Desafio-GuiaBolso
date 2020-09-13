package com.example.desafioguiabolso.controller;

import com.example.desafioguiabolso.model.Transacao;
import com.example.desafioguiabolso.service.TransacaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
public class TransacaoController {
    private final TransacaoService transacaoService;

    @GetMapping(path = "/{id}/transacoes/{ano}/{mes}")
    ResponseEntity<List<Transacao>> busca(
            @PathVariable("id") @Min(value = 1000, message = "O id possui valor mínimo 1000")
                                @Max(value = 100000000, message = "O id possui valor máximo 100000000") Integer id,
            @PathVariable("ano") @Min(value = 0,message = "o ano possui valor mínimo 0") Integer ano,
            @PathVariable("mes") @Min(value = 1, message = "O mes possui valor mínimo 1")
                                @Max(value = 12, message = "O mes possui valor máximo 12") Integer mes ) {

        return ResponseEntity.ok(transacaoService.busca(ano, mes));
    }
}