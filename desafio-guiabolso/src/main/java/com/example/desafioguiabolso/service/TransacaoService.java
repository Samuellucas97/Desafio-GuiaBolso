package com.example.desafioguiabolso.service;

import com.example.desafioguiabolso.model.Transacao;
import com.example.desafioguiabolso.randomized.IntegerRandom;
import com.example.desafioguiabolso.randomized.LongRandom;
import com.example.desafioguiabolso.randomized.StringRandom;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransacaoService {

    public List<Transacao> busca(Integer ano, Integer mes) {
        EasyRandomParameters parameters = new EasyRandomParameters()
                .randomize(Long.class, new LongRandom(ano, mes))
                .randomize(Integer.class, new IntegerRandom())
                .randomize(String.class, new StringRandom());

        EasyRandom generator = new EasyRandom(parameters);
        List<Transacao> transacaoList = generator.objects(Transacao.class, 20)
                .collect(Collectors.toList());


        return transacaoList;
    }
}
