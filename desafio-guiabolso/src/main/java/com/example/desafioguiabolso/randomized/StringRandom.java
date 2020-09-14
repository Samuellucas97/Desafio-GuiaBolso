package com.example.desafioguiabolso.randomized;

import com.thedeanda.lorem.LoremIpsum;
import lombok.RequiredArgsConstructor;
import org.jeasy.random.api.Randomizer;

@RequiredArgsConstructor
public class StringRandom implements Randomizer<String> {
    private final Integer menorTamanho;
    private final Integer maiorTamanho;

    @Override
    public String getRandomValue() {
        final String descricao = getDescricaoAleatoriaLegivel();
        return validandoDescricao(descricao);
    }

    private String getDescricaoAleatoriaLegivel() {
        return LoremIpsum.getInstance().getTitle(this.menorTamanho, this.maiorTamanho);
    }

    private String validandoDescricao(String descricao) {
        if (descricao.length() > this.maiorTamanho)
            return descricao.substring(0, this.maiorTamanho);
        return descricao;
    }
}