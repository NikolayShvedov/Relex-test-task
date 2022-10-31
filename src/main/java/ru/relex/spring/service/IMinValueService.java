package ru.relex.spring.service;

import ru.relex.spring.dto.MinValueDto;

import java.util.ArrayList;

public interface IMinValueService {

    MinValueDto getMinValue(ArrayList<Integer> integers);
}
