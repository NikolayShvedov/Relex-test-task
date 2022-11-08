package ru.relex.spring.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.relex.spring.dto.MaxDESCSequenceDto;
import ru.relex.spring.service.MaxSequenceCalculatingService;
import ru.relex.spring.service.IMaxDESCSequenceService;

import java.util.ArrayList;

/**
 * Класс для расчёта самой длинной последовательности идущих подряд чисел, которая уменьшается
 * @author Николай Шведов
 * @version 1.0.0
 */
@Component
@RequiredArgsConstructor
public class MaxDESCSequenceServiceImpl extends MaxSequenceCalculatingService implements IMaxDESCSequenceService {


    /**
     * Функция для расчёта самой длинной последовательности идущих подряд чисел, которая уменьшается
     * @param integers - массив целых чисел из текстового файла
     * @return возвращает объект MaxDESCSequenceDto, хранящий все последовательности идущих подряд чисел максимальной длины, которые уменьшаются
     */
    @Override
    public MaxDESCSequenceDto getMaxDESCSequenceService(ArrayList<Integer> integers) {

        int[] indexOfElements = new int[integers.size()];                   // массив индексов элементов в последовательности идущих подряд чисел
        int lengthOfTheLargestSequence = 0;                                 // длина самой большой последовательности чисел

        for (int i = 1; i < integers.size(); i++) {
            if (integers.get(i) < integers.get(i - 1)) {                    // Если текущий элемент меньше предыдущего элемента
                indexOfElements[i] = indexOfElements[i - 1] + 1;            // индекс элемента в последовательности увеличивается на единицу
            } else {                                                        // Если текущий элемент больше или равен предыдущего элемента
                indexOfElements[i] = 0;                                     // индекс обнуляется и счёт элементов начинается с новой последовательности
            }
            lengthOfTheLargestSequence = Math.max(indexOfElements[i], lengthOfTheLargestSequence); // определение длины самой большой последовательности
        }

        return new MaxDESCSequenceDto(getResultSequences(integers, indexOfElements, lengthOfTheLargestSequence));
    }
}
