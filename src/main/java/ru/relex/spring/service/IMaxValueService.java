package ru.relex.spring.service;

import ru.relex.spring.dto.MaxValueDto;

import java.util.ArrayList;

public interface IMaxValueService {

    MaxValueDto getMaxValue(ArrayList<Integer> integers);
}
