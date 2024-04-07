package ru.relex.spring.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.relex.spring.dto.ResponseDto;
import ru.relex.spring.dto.request.RequestType;
import ru.relex.spring.service.IArithmeticMeanService;
import ru.relex.spring.service.IMaxASCSequenceService;
import ru.relex.spring.service.IMaxDESCSequenceService;
import ru.relex.spring.service.IMaxValueService;
import ru.relex.spring.service.IMedianService;
import ru.relex.spring.service.IMinValueService;
import ru.relex.spring.service.IRequestValidationService;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Класс для обработки типа запрашиваемой операции в теле запроса
 *
 * @author Николай Шведов
 * @version 1.0.1
 */
@Component
@RequiredArgsConstructor
public class RequestValidationServiceImpl implements IRequestValidationService {

    private final IMaxValueService maxValueService;
    private final IMinValueService minValueService;
    private final IMedianService medianService;
    private final IArithmeticMeanService arithmeticMeanService;
    private final IMaxASCSequenceService maxASCSequenceService;
    private final IMaxDESCSequenceService maxDESCSequenceService;

    /**
     * Метод для обработки типа запрашиваемой операции в теле запроса
     *
     * @param operation - выбранная операция над последовательностью чисел
     * @param integers  - массив целых чисел из текстового файла
     * @return возвращает результат запроса в зависимости от типа запрашиваемой операции
     * @throws IOException - неправильное чтение файла
     */
    @Override
    public ResponseDto validateRequest(String operation, ArrayList<Integer> integers) {

        if (operation.equals(RequestType.MAX_VALUE.getAbbreviation())) {
            return maxValueService.getMaxValue(integers);
        } else if (operation.equals(RequestType.MIN_VALUE.getAbbreviation())) {
            return minValueService.getMinValue(integers);
        } else if (operation.equals(RequestType.MEDIAN.getAbbreviation())) {
            return medianService.getMedian(integers);
        } else if (operation.equals(RequestType.ARITHMETIC_MEAN.getAbbreviation())) {
            return arithmeticMeanService.getArithmeticMean(integers);
        } else if (operation.equals(RequestType.MAX_ASC_SEQUENCE.getAbbreviation())) {
            return maxASCSequenceService.getMaxASCSequenceService(integers);
        } else if (operation.equals(RequestType.MAX_DESC_SEQUENCE.getAbbreviation())) {
            return maxDESCSequenceService.getMaxDESCSequenceService(integers);
        } else {
            return null;
        }
    }
}
