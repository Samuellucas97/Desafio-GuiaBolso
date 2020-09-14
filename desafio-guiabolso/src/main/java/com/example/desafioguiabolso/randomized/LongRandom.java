package com.example.desafioguiabolso.randomized;

import lombok.RequiredArgsConstructor;
import org.jeasy.random.api.Randomizer;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

import static com.example.desafioguiabolso.utils.DataUtils.*;

@RequiredArgsConstructor
public class LongRandom implements Randomizer<Long> {
    private final Integer ano;
    private final Integer mes;

    @Override
    public Long getRandomValue() {
        return getDataAleatoriaEntreDuasDatas();
    }

    private Long getDataAleatoriaEntreDuasDatas() {
        final LocalDate dataInicioMes = getDataInicioMes(this.ano, this.mes);
        final LocalDate dataFimMes = getDataFimMes(this.ano, this.mes);

        final Long dataInicioMesLong = getDataParaLong(dataInicioMes);
        final Long dataFimMesLong = getDataParaLong(dataFimMes);

        final Long dataAleatoria = ThreadLocalRandom.current().nextLong(dataInicioMesLong, dataFimMesLong);

        return dataAleatoria;
    }
}