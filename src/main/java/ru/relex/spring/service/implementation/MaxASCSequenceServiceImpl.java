package ru.relex.spring.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.relex.spring.dto.MaxASCSequenceDto;
import ru.relex.spring.service.IMaxASCSequenceService;
import ru.relex.spring.service.MaxSequenceCalculatingService;

import java.util.ArrayList;

/**
 * Класс для расчёта самой длинной последовательности идущих подряд чисел, которая увеличивается
 *
 * @author Николай Шведов
 * @version 1.0.0
 */
@Component
@RequiredArgsConstructor
public class MaxASCSequenceServiceImpl extends MaxSequenceCalculatingService implements IMaxASCSequenceService {

    /**
     * Функция для расчёта самой длинной последовательности идущих подряд чисел, которая увеличивается
     *
     * @param integers - массив целых чисел из текстового файла
     * @return возвращает объект MaxASCSequenceDto, хранящий все последовательности идущих подряд чисел максимальной длины, которые увеличиваются
     */
    @Override
    public MaxASCSequenceDto getMaxASCSequenceService(ArrayList<Integer> integers) {

        int[] indexOfElements = new int[integers.size()];                   // массив индексов элементов в последовательности идущих подряд чисел
        int lengthOfTheLargestSequence = 0;                                 // длина самой большой последовательности чисел

        for (int i = 1; i < integers.size(); i++) {
            if (integers.get(i) > integers.get(i - 1)) {                    // Если текущий элемент больше предыдущего элемента
                indexOfElements[i] = indexOfElements[i - 1] + 1;            // индекс элемента в последовательности увеличивается на единицу
            } else {                                                        // Если текущий элемент меньше или равен предыдущего элемента
                indexOfElements[i] = 0;                                     // индекс обнуляется и счёт элементов начинается с новой последовательности
            }
            lengthOfTheLargestSequence = Math.max(indexOfElements[i], lengthOfTheLargestSequence); // определение длины самой большой последовательности
        }

        return new MaxASCSequenceDto(getResultSequences(integers, indexOfElements, lengthOfTheLargestSequence));
    }
}
