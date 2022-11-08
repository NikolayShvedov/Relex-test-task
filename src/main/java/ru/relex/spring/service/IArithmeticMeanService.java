package ru.relex.spring.service;

import ru.relex.spring.dto.ArithmeticMeanDto;

import java.util.ArrayList;

public interface IArithmeticMeanService {

    ArithmeticMeanDto getArithmeticMean(ArrayList<Integer> integers);
}
