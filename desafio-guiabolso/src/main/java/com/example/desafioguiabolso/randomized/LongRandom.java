package com.example.desafioguiabolso.randomized;

import lombok.extern.slf4j.Slf4j;
import org.jeasy.random.api.Randomizer;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.desafioguiabolso.utils.DataUtils.*;

@Slf4j
public class LongRandom implements Randomizer<Long> {

    private Integer ano;
    private Integer mes;

    public LongRandom(Integer ano, Integer mes) {
        this.ano = ano;
        this.mes = mes;
    }

    @Override
    public Long getRandomValue() {
        return getDataAleatoriaEntreDuasDatas();
    }

    private Long getDataAleatoriaEntreDuasDatas() {
        final LocalDate dataInicioMes = getDataInicioMes(this.ano, this.mes);
        final LocalDate dataFimMes = getDataFimMes(this.ano, this.mes);

        final Long dataInicioMesLong = getDataParaLong(dataInicioMes);
        final Long dataFimMesLong = getDataParaLong(dataFimMes);

        final Long dataAleatoria = ThreadLocalRandom.current().nextLong(  dataInicioMesLong, dataFimMesLong);

        return dataAleatoria;
    }
}