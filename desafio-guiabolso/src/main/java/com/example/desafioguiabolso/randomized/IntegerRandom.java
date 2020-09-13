package com.example.desafioguiabolso.randomized;

import org.jeasy.random.api.Randomizer;

import java.util.Random;

public class IntegerRandom implements Randomizer<Integer> {
    private final Integer maximo = 9999999;
    private final Integer minimo = -9999999;

    @Override
    public Integer getRandomValue() {
        int inteiroAleatorio = getInteiroAleatorioEntreDoisInteiros(minimo, maximo);
        return inteiroAleatorio;
    }

    private Integer getInteiroAleatorioEntreDoisInteiros(Integer minimoValor, Integer maximoValor) {
        Random random = new Random();
        return random.nextInt(maximoValor - minimoValor) + minimoValor;
    }
}