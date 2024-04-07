package ru.relex.spring.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import ru.relex.spring.dto.*;
import ru.relex.spring.dto.request.SequenceOperationRequest;
import ru.relex.spring.dto.request.SequenceRequest;
import ru.relex.spring.service.IArithmeticMeanService;
import ru.relex.spring.service.IMaxASCSequenceService;
import ru.relex.spring.service.IMaxDESCSequenceService;
import ru.relex.spring.service.IMaxValueService;
import ru.relex.spring.service.IMedianService;
import ru.relex.spring.service.IMinValueService;
import ru.relex.spring.service.IFileParserService;
import ru.relex.spring.service.IRequestValidationService;

import java.io.IOException;


@Api(tags = {"Number sequence processing part"})
@RestController
@RequestMapping("/api")
public class SequenceProcessingController extends ControllerUtils {

    private final IMaxValueService maxValueService;
    private final IMinValueService minValueService;
    private final IMedianService medianService;
    private final IArithmeticMeanService arithmeticMeanService;
    private final IMaxASCSequenceService maxASCSequenceService;
    private final IMaxDESCSequenceService maxDESCSequenceService;
    private final IRequestValidationService requestValidationService;

    private String currentPathFile;

    public SequenceProcessingController(IFileParserService fileParserService,
                                        IMaxValueService maxValueService,
                                        IMinValueService minValueService,
                                        IMedianService medianService,
                                        IArithmeticMeanService arithmeticMeanService,
                                        IMaxASCSequenceService maxASCSequenceService,
                                        IMaxDESCSequenceService maxDESCSequenceService,
                                        IRequestValidationService requestValidationService) {

        super(fileParserService);
        this.maxValueService = maxValueService;
        this.minValueService = minValueService;
        this.medianService = medianService;
        this.arithmeticMeanService = arithmeticMeanService;
        this.maxASCSequenceService = maxASCSequenceService;
        this.maxDESCSequenceService = maxDESCSequenceService;
        this.requestValidationService = requestValidationService;
    }

    @SneakyThrows
    @ApiOperation(value = "Return the maximum value in a file")
    @RequestMapping(
            path = "/get_max_value",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseBody
    public MaxValueDto getMaxValue(@RequestBody SequenceRequest request) {
        isPossibleToWorkWithArrayOfNumbers(request.getPathFile());
        return maxValueService.getMaxValue(integers);
    }

    @SneakyThrows
    @ApiOperation(value = "Return the minimum value in a file")
    @RequestMapping(
            path = "/get_min_value",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseBody
    public MinValueDto getMinValue(@RequestBody SequenceRequest request) {
        isPossibleToWorkWithArrayOfNumbers(request.getPathFile());
        return minValueService.getMinValue(integers);
    }

    @SneakyThrows
    @ApiOperation(value = "Return the median in a file")
    @RequestMapping(
            path = "/get_median",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseBody
    public MedianDto getMedian(@RequestBody SequenceRequest request) {
        isPossibleToWorkWithArrayOfNumbers(request.getPathFile());
        return medianService.getMedian(integers);
    }

    @SneakyThrows
    @ApiOperation(value = "Return the arithmetic mean in a file")
    @RequestMapping(
            path = "/get_arithmetic_mean",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseBody
    public ArithmeticMeanDto getArithmeticMean(@RequestBody SequenceRequest request) {
        isPossibleToWorkWithArrayOfNumbers(request.getPathFile());
        return arithmeticMeanService.getArithmeticMean(integers);
    }

    @SneakyThrows
    @ApiOperation(value = "Return the longest sequence of consecutive numbers that increases")
    @RequestMapping(
            path = "/get_max_asc_sequence",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseBody
    public MaxASCSequenceDto getMaxASCSequenceOfConsecutiveNumbers(@RequestBody SequenceRequest request) {
        isPossibleToWorkWithArrayOfNumbers(request.getPathFile());
        return maxASCSequenceService.getMaxASCSequenceService(integers);
    }

    @SneakyThrows
    @ApiOperation(value = "Return the longest sequence of consecutive numbers that decreases")
    @RequestMapping(
            path = "/get_max_desc_sequence",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseBody
    public MaxDESCSequenceDto getMaxDESCSequenceOfConsecutiveNumbers(@RequestBody SequenceRequest request) {
        isPossibleToWorkWithArrayOfNumbers(request.getPathFile());
        return maxDESCSequenceService.getMaxDESCSequenceService(integers);
    }

    @SneakyThrows
    @ApiOperation(value = "Return the longest sequence of consecutive numbers that decreases")
    @RequestMapping(
            path = "/",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
    )
    @ResponseBody
    public ResponseDto getRequestedOperation(@RequestBody SequenceOperationRequest request) {
        isPossibleToWorkWithArrayOfNumbers(request.getPathFile());
        return requestValidationService.validateRequest(request.getOperation(), integers);
    }

    private void isPossibleToWorkWithArrayOfNumbers(String pathFile) throws IOException {
        if (CollectionUtils.isEmpty(integers) || !pathFile.equals(currentPathFile)) {
            currentPathFile = pathFile;
            getListOfIntegersFromTextFile(pathFile);
        }
    }
}
