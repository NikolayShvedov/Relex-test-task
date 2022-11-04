package ru.relex.spring.service.validation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.relex.spring.dto.ResponseDto;
import ru.relex.spring.dto.request.RequestData;
import ru.relex.spring.dto.request.RequestType;
import ru.relex.spring.service.arithmetic_mean.ArithmeticMeanService;
import ru.relex.spring.service.max_sequence_numbers.max_asc_sequence.MaxASCSequenceService;
import ru.relex.spring.service.max_sequence_numbers.max_desc_sequence.MaxDESCSequenceService;
import ru.relex.spring.service.max_value.MaxValueService;
import ru.relex.spring.service.median.MedianService;
import ru.relex.spring.service.min_value.MinValueService;
import ru.relex.spring.service.parser.FileParserService;

import java.io.IOException;


/**
 * Класс для обработки типа запрашиваемой операции в теле запроса
 * @author Николай Шведов
 * @version 1.0.0
 */
@Component
@RequiredArgsConstructor
public class RequestValidationServiceImpl implements RequestValidationService {

    private final MaxValueService maxValueService;
    private final MinValueService minValueService;
    private final MedianService medianService;
    private final ArithmeticMeanService arithmeticMeanService;
    private final FileParserService fileParserService;
    private final MaxASCSequenceService maxASCSequenceService;
    private final MaxDESCSequenceService maxDESCSequenceService;


    /**
     * Метод для обработки типа запрашиваемой операции в теле запроса
     * @param requestData - тело запроса
     * @return возвращает результат запроса в зависимости от типа запрашиваемой операции
     * @throws IOException - неправильное чтение файла
     */
    @Override
    public ResponseDto validateRequest(RequestData requestData) throws IOException {

        if (requestData.getOperation().equals(RequestType.MAX_VALUE.getAbbreviation())) {
            return maxValueService.getMaxValue(fileParserService.getListOfIntegersFromTextFile(requestData.getPath_file()));
        }
        else if (requestData.getOperation().equals(RequestType.MIN_VALUE.getAbbreviation())) {
            return minValueService.getMinValue(fileParserService.getListOfIntegersFromTextFile(requestData.getPath_file()));
        }
        else if (requestData.getOperation().equals(RequestType.MEDIAN.getAbbreviation())) {
            return medianService.getMedian(fileParserService.getListOfIntegersFromTextFile(requestData.getPath_file()));
        }
        else if (requestData.getOperation().equals(RequestType.ARITHMETIC_MEAN.getAbbreviation())) {
            return arithmeticMeanService.getArithmeticMean(fileParserService.getListOfIntegersFromTextFile(requestData.getPath_file()));
        }
        else if (requestData.getOperation().equals(RequestType.MAX_ASC_SEQUENCE.getAbbreviation())) {
            return maxASCSequenceService.getMaxASCSequenceService(fileParserService.getListOfIntegersFromTextFile(requestData.getPath_file()));
        }
        else if (requestData.getOperation().equals(RequestType.MAX_DESC_SEQUENCE.getAbbreviation())) {
            return maxDESCSequenceService.getMaxDESCSequenceService(fileParserService.getListOfIntegersFromTextFile(requestData.getPath_file()));
        }
        else {
            return null;
        }

    }
}
