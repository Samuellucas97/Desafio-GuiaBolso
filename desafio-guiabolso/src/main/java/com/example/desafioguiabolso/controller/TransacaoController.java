package com.example.desafioguiabolso.controller;

import com.example.desafioguiabolso.model.Transacao;
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
import java.util.stream.Collectors;

@RestController
@Validated
@Slf4j
public class TransacaoController {

    @GetMapping(path = "/{id}/transacoes/{ano}/{mes}")
    ResponseEntity<List<Transacao>> get(
            @PathVariable("id") @Min(value = 1000, message = "O id possui valor mínimo de 1000")
                                @Max(value = 100000000, message = "O id possui valor máximo de 100000000") Integer id,
            @PathVariable("ano") Integer ano,
            @PathVariable("mes") Integer mes
            ) {

        EasyRandomParameters parameters = new EasyRandomParameters();
        parameters.stringLengthRange(10, 120);

        EasyRandom generator = new EasyRandom();
        List<Transacao> transacaoList = generator.objects(Transacao.class, 20).collect(Collectors.toList());

        log.info("Transacao {}", transacaoList);

        return ResponseEntity.ok(transacaoList);
    }
}