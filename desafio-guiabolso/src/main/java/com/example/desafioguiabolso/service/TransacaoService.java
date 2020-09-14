package com.example.desafioguiabolso.service;

import com.example.desafioguiabolso.model.Transacao;
import com.example.desafioguiabolso.utils.TransacaoSemDuplicated;
import com.example.desafioguiabolso.repository.TransacaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacaoService {
    private final TransacaoRepository transacaoRepository;

    private final Integer minimoValor = -9999999;
    private final Integer maximoValor = 9999999;
    private final Integer menorTamanhoDescricao = 10;
    private final Integer maiorTamanhoDescricao = 60;

    @Autowired
    public TransacaoService() {
        this.transacaoRepository = new TransacaoRepository(minimoValor, maximoValor, menorTamanhoDescricao,
                maiorTamanhoDescricao);
    }

    public List<Transacao> busca(Integer ano, Integer mes) {
        final List<Transacao> transacaos = identificandoTransacoesDuplicadas(transacaoRepository.busca(ano, mes));
        return transacaos;
    }

    private List<Transacao> identificandoTransacoesDuplicadas(List<Transacao> transacoesList) {

        List<TransacaoSemDuplicated> transacoesSemDuplicatedLista = new ArrayList<>();

        for ( Transacao transacao: transacoesList) {
            TransacaoSemDuplicated atualTransacaoSemDuplicated = TransacaoSemDuplicated.builder()
                    .descricao(transacao.getDescricao())
                    .data(transacao.getData())
                    .valor(transacao.getValor())
                    .build();

            transacoesSemDuplicatedLista.add(atualTransacaoSemDuplicated);

            Long quantidadeOcorrenciaTransacao = transacoesSemDuplicatedLista.stream()
                    .filter(transacaoSemDuplicated -> transacaoSemDuplicated.equals(atualTransacaoSemDuplicated)).count();

            if (quantidadeOcorrenciaTransacao == 2) {
                transacao.setDuplicated(true);
            }
        }

        return transacoesList;
    }
}