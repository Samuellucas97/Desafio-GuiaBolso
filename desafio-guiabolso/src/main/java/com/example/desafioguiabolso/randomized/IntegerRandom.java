package com.example.desafioguiabolso.randomized;

import lombok.RequiredArgsConstructor;
import org.jeasy.random.api.Randomizer;

import java.util.Random;

@RequiredArgsConstructor
public class IntegerRandom implements Randomizer<Integer> {
    private final Integer minimoValor;
    private final Integer maximoValor;

    @Override
    public Integer getRandomValue() {
        int inteiroAleatorio = getInteiroAleatorioEntreDoisInteiros(this.minimoValor, this.maximoValor);
        return inteiroAleatorio;
    }

    private Integer getInteiroAleatorioEntreDoisInteiros(Integer minimoValor, Integer maximoValor) {
        Random random = new Random();
        return random.nextInt(maximoValor - minimoValor) + minimoValor;
    }
}