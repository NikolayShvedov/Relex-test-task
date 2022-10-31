package ru.relex.spring.service;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Абстрактный класс для расчёта самой длинной последовательности идущих подряд чисел
 * @author Николай Шведов
 * @version 1.0.0
 */
public abstract class MaxSequenceCalculatingService {

    /**
     * Функция для расчёта самой длинной последовательности идущих подряд чисел
     * @param integers                   - массив целых чисел из текстового файла
     * @param indexOfElements            - массив индексов элементов в последовательности идущих подряд чисел
     * @param lengthOfTheLargestSequence - длина самой большой последовательности чисел
     * @return возвращает объект HashMap со всеми последовательностями максимальной одинаковой длины
     */
    public HashMap<String, ArrayList<Integer>> getResultSequences(ArrayList<Integer> integers,
                                                                  int[] indexOfElements,
                                                                  int lengthOfTheLargestSequence) {

        HashMap<String, ArrayList<Integer>> resultSequences = new HashMap<>();  // Результирующая мапа со всеми последовательностями с максимальной одинаковой длиной
        int numberOfSequences = 1;                                              // номер последовательности (т. к. последовательностей может быть несколько)
        ArrayList<Integer> sequence = new ArrayList<>();                        // массив элементов каждой последовательности чисел

        for (int i = 0; i < integers.size(); i++) {
            if (indexOfElements[i] == lengthOfTheLargestSequence) {                 // Если индекс эл-та равен длине самой большой последовательности
                for (int j = i - indexOfElements[i]; j <= i; j++) {                 // То запускается цикл с первого элемента последовательности до крайнего (j <= i)
                    sequence.add(integers.get(j));                                  // Числа поочерёдно добавляются массив элементов последовательности
                }
                resultSequences.put(String.valueOf(numberOfSequences), sequence);       // Массив элементов добавляется в результирующую мапу
                numberOfSequences++;                                                    // номер последовательности увеличивается на 1
            }
        }

        return resultSequences;
    }
}
