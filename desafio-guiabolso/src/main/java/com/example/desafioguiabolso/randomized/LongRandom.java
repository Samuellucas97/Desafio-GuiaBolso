package com.example.desafioguiabolso.randomized;

import org.jeasy.random.api.Randomizer;

import java.time.Instant;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class LongRandom implements Randomizer<Long> {

    private Integer ano;
    private Integer mes;

    public LongRandom(Integer ano, Integer mes) {
        this.ano = ano;
        this.mes = mes;
    }

    @Override
    public Long getRandomValue() {
        final LocalDate inicioMes = YearMonth.of(ano, mes).atDay(0);
        final LocalDate finalMes = YearMonth.of(ano,mes).atEndOfMonth();

        long diaAleatorio =  getDataAleatoriaEntreDuasDatas(inicioMes, finalMes);

        return diaAleatorio;
    }

    private Long getDataAleatoriaEntreDuasDatas(LocalDate dataInicial, LocalDate dataFinal) {
        final long dataAleatoria = ThreadLocalRandom.current().nextLong(Date.from(Instant.from(dataInicial)).getTime(),
                Date.from(Instant.from(dataFinal)).getTime());
        return dataAleatoria;
    }
}
