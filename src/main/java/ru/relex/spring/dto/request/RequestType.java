package ru.relex.spring.dto.request;

import lombok.Getter;

@Getter
public enum RequestType {

    MAX_VALUE("get_max_value"),
    MIN_VALUE("get_min_value"),
    MEDIAN("get_median"),
    ARITHMETIC_MEAN("get_arithmetic_mean"),
    MAX_ASC_SEQUENCE("get_max_asc_sequence"),
    MAX_DESC_SEQUENCE("get_max_desc_sequence");


    private final String abbreviation;

    RequestType(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
