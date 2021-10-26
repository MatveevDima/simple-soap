package com.example.soap.resources;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.common.util.StringUtils;

@Getter
@RequiredArgsConstructor
public enum ClientState {

    SUCCESSFUL("0", "Успешно."),

    OUT_OF_INPUT_VALUE("-1", "Нет структуры входных параметров."),
    EMPTY_OF_INPUT_VALUE("-2", "Структура входных параметров пуста или заполнена не полностью."),

    SAVE_TO_DB_FAILED("-10", "Непредвиденная ошибка при обращении к базе данных."),

    UNKNOWN("-99", "Не удалось выполнить поиск.");

    private final String code;
    private final String description;

    public static ClientState decode(String code) {
        if (!StringUtils.isEmpty(code)) {
            for (ClientState state : ClientState.values()) {
                if (state.getCode().equalsIgnoreCase(code)) return state;
            }
        }
        return UNKNOWN;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }
}