package ru.relex.spring.service.arithmetic_mean;

import ru.relex.spring.dto.ArithmeticMeanDto;

import java.util.ArrayList;

public interface ArithmeticMeanService {

    ArithmeticMeanDto getArithmeticMean(ArrayList<Integer> integers);
}
