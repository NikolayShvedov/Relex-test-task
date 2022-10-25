package ru.relex.spring.service.min_value;

import ru.relex.spring.dto.MinValueDto;

import java.util.ArrayList;

public interface MinValueService {

    MinValueDto getMinValue(ArrayList<Integer> integers);
}
