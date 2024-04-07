package ru.relex.spring.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.relex.spring.dto.MinValueDto;
import ru.relex.spring.service.IMinValueService;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Класс для расчёта минимального числа в массиве целых чисел из текстового файла
 *
 * @author Николай Шведов
 * @version 1.0.0
 */
@Component
@RequiredArgsConstructor
public class MinValueServiceImpl implements IMinValueService {


    /**
     * Функция для расчёта минимального числа в массиве целых чисел
     *
     * @param integers - массив целых чисел из текстового файла
     * @return возвращает минимальное число в массиве
     */
    @Override
    public MinValueDto getMinValue(ArrayList<Integer> integers) {
        return new MinValueDto(Collections.min(integers));
    }
}
