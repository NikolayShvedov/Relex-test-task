package ru.relex.spring.service.max_value;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.relex.spring.dto.MaxValueDto;

import java.util.Collections;
import java.util.ArrayList;


/**
 * Класс для расчёта максимального числа в массиве целых чисел из текстового файла
 * @author Николай Шведов
 * @version 1.0.0
 */
@Component
@RequiredArgsConstructor
public class MaxValueServiceImpl implements MaxValueService{


    /**
     * Функция для расчёта максимального числа в массиве целых чисел
     * @param integers - массив целых чисел из текстового файла
     * @return возвращает максимальное число в массиве
     */
    @Override
    public MaxValueDto getMaxValue(ArrayList<Integer> integers) {
        return new MaxValueDto(Collections.max(integers));
    }
}
