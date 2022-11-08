package ru.relex.spring.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.relex.spring.dto.ArithmeticMeanDto;
import ru.relex.spring.service.IArithmeticMeanService;

import java.util.ArrayList;


/**
 * Класс для расчёта среднего арифметического значения в массиве целых чисел из текстового файла
 * @author Николай Шведов
 * @version 1.0.0
 */
@Component
@RequiredArgsConstructor
public class ArithmeticMeanServiceImpl implements IArithmeticMeanService {


    /**
     * Функция для расчёта среднего арифметического значения в массиве целых чисел
     * Среднее арифметическое = сумма всех чисел / количество чисел
     * @param integers - массив целых чисел из текстового файла
     * @return возвращает среднее арифметическое значение в массиве
     */
    @Override
    public ArithmeticMeanDto getArithmeticMean(ArrayList<Integer> integers) {

        long integersSum = integers.stream()
                .mapToLong(Integer::longValue)
                .sum();

        return new ArithmeticMeanDto(integersSum / integers.size());
    }
}
