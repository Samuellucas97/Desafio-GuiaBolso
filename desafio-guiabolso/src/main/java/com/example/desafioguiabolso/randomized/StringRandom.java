package com.example.desafioguiabolso.randomized;

import com.thedeanda.lorem.LoremIpsum;
import org.jeasy.random.api.Randomizer;


public class StringRandom implements Randomizer<String> {
    @Override
    public String getRandomValue() {
        final String descricao = getDescricaoAleatoriaLegivel();
        return validandoDescricao(descricao);
    }

    private String getDescricaoAleatoriaLegivel() {
        return LoremIpsum.getInstance().getTitle(10, 60);
    }

    private String validandoDescricao(String descricao) {
        if (descricao.length() > 60)
            return descricao.substring(0, 60);
        return descricao;
    }
}