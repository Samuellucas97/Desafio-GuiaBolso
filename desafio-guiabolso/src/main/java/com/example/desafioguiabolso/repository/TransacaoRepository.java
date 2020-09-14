package com.example.desafioguiabolso.repository;

import com.example.desafioguiabolso.model.Transacao;
import com.example.desafioguiabolso.randomized.IntegerRandom;
import com.example.desafioguiabolso.randomized.LongRandom;
import com.example.desafioguiabolso.randomized.StringRandom;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TransacaoRepository {
    private final Integer minimoValor;
    private final Integer maximoValor;
    private final Integer menorTamanho;
    private final Integer maiorTamanho;

    private final Integer quantidadeTransacoes = 20;

    @Autowired
    public TransacaoRepository ( @Value("${property.minimoValor:0}") Integer minimoValor,
                                 @Value("${property.maximoValor:0}") Integer maximoValor,
                                 @Value("${property.menorTamanho:0}") Integer menorTamanho,
                                 @Value("${property.maiorTamanho:0}") Integer maiorTamanho) {
        this.minimoValor = minimoValor;
        this.maximoValor = maximoValor;
        this.menorTamanho = menorTamanho;
        this.maiorTamanho = maiorTamanho;
    }

    public List<Transacao> busca(Integer ano, Integer mes) {
        return gerandoListaAleatoriaDeTransacoes(ano, mes);
    }
    private EasyRandomParameters getParametros(Integer ano, Integer mes) {
        EasyRandomParameters parametros = new EasyRandomParameters()
                .randomize(Long.class, new LongRandom(ano, mes))
                .randomize(Boolean.class, () -> false)
                .randomize(Integer.class, new IntegerRandom(minimoValor, maximoValor))
                .randomize(String.class, new StringRandom(menorTamanho, maiorTamanho));

        return parametros;
    }

    private List<Transacao> gerandoListaAleatoriaDeTransacoes(Integer ano, Integer mes) {
        EasyRandom generator = new EasyRandom(getParametros(ano, mes));
        List<Transacao> transacoesAleatoriasList = generator.objects(Transacao.class, quantidadeTransacoes)
                .collect(Collectors.toList());
        return transacoesAleatoriasList;
    }
}