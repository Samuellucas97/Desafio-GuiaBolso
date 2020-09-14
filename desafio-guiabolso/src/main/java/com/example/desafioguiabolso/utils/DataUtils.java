package com.example.desafioguiabolso.utils;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.YearMonth;

public class DataUtils {
    public static LocalDate getDataInicioMes(Integer ano, Integer mes) {
        return YearMonth.of(ano, mes).atDay(1);
    }
    public static LocalDate getDataFimMes(Integer ano, Integer mes) {
        return YearMonth.of(ano,mes).atEndOfMonth();
    }
    public static Long getDataParaLong(LocalDate data) {
        final Timestamp timestampData = Timestamp.valueOf(data.atStartOfDay());
        return timestampData.getTime();
    }
}
