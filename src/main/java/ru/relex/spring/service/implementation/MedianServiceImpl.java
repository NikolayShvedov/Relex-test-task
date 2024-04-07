package ru.relex.spring.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.relex.spring.dto.MedianDto;
import ru.relex.spring.service.IMedianService;

import java.util.ArrayList;
import java.util.Collections;


/**
 * Класс для расчёта медианы в массиве целых чисел из текстового файла
 *
 * @author Николай Шведов
 * @version 1.0.0
 */
@Component
@RequiredArgsConstructor
public class MedianServiceImpl implements IMedianService {


    /**
     * Функция для расчёта медианы в массиве целых чисел
     *
     * @param integers - массив целых чисел из текстового файла
     * @return возвращает медиану
     */
    @Override
    public MedianDto getMedian(ArrayList<Integer> integers) {
        Collections.sort(integers);  // Сортируем полученный массив по возрастанию

        if (integers.size() % 2 == 0) { // Если количество элементов в массиве чётное
            // Возвращаем половину от суммы двух средних элементов массива
            return new MedianDto((integers.get(integers.size() / 2) + integers.get(integers.size() / 2 - 1)) / 2f);
        }

        // Если количество элементов нечётное, то возвращаем средний элемент массива
        return new MedianDto(integers.get(integers.size() / 2));
    }
}
