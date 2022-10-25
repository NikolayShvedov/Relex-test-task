package ru.relex.spring.service.max_value;

import ru.relex.spring.dto.MaxValueDto;

import java.util.ArrayList;

public interface MaxValueService {

    MaxValueDto getMaxValue(ArrayList<Integer> integers);
}
