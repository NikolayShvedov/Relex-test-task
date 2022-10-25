package ru.relex.spring.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.spring.dto.*;
import ru.relex.spring.dto.request.RequestData;
import ru.relex.spring.service.arithmetic_mean.ArithmeticMeanService;
import ru.relex.spring.service.max_sequence_numbers.max_asc_sequence.MaxASCSequenceService;
import ru.relex.spring.service.max_sequence_numbers.max_desc_sequence.MaxDESCSequenceService;
import ru.relex.spring.service.max_value.MaxValueService;
import ru.relex.spring.service.median.MedianService;
import ru.relex.spring.service.min_value.MinValueService;
import ru.relex.spring.service.parser.FileParserService;
import ru.relex.spring.service.validation.RequestValidationService;

import java.io.IOException;
import java.util.ArrayList;


@Slf4j
@Api(tags = {"Number sequence processing part"})
@RestController
@RequestMapping("/api")
public class SequenceProcessingController {

    private final MaxValueService maxValueService;
    private final MinValueService minValueService;
    private final MedianService medianService;
    private final ArithmeticMeanService arithmeticMeanService;
    private final FileParserService fileParserService;
    private final MaxASCSequenceService maxASCSequenceService;
    private final MaxDESCSequenceService maxDESCSequenceService;
    private final RequestValidationService requestValidationService;

    public SequenceProcessingController(FileParserService fileParserService,
                                        MaxValueService maxValueService,
                                        MinValueService minValueService,
                                        MedianService medianService,
                                        ArithmeticMeanService arithmeticMeanService,
                                        MaxASCSequenceService maxASCSequenceService,
                                        MaxDESCSequenceService maxDESCSequenceService,
                                        RequestValidationService requestValidationService) {
        this.fileParserService = fileParserService;
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
            produces = {MediaType.APPLICATION_JSON_VALUE }
    )
    @ResponseBody
    public MaxValueDto getMaxValue(@RequestBody RequestData request) {
        return maxValueService.getMaxValue(getFileData(request.getPath_file()));
    }

    @SneakyThrows
    @ApiOperation(value = "Return the minimum value in a file")
    @RequestMapping(
            path = "/get_min_value",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public MinValueDto getMinValue(@RequestBody RequestData request) {
        return minValueService.getMinValue(getFileData(request.getPath_file()));
    }

    @SneakyThrows
    @ApiOperation(value = "Return the median in a file")
    @RequestMapping(
            path = "/get_median",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public MedianDto getMedian(@RequestBody RequestData request) {
        return medianService.getMedian(getFileData(request.getPath_file()));
    }

    @SneakyThrows
    @ApiOperation(value = "Return the arithmetic mean in a file")
    @RequestMapping(
            path = "/get_arithmetic_mean",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ArithmeticMeanDto getArithmeticMean(@RequestBody RequestData request) {
        return arithmeticMeanService.getArithmeticMean(getFileData(request.getPath_file()));
    }

    @SneakyThrows
    @ApiOperation(value = "Return the longest sequence of consecutive numbers that increases")
    @RequestMapping(
            path = "/get_max_asc_sequence",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public MaxASCSequenceDto getMaxASCSequenceOfConsecutiveNumbers(@RequestBody RequestData request) {
        return maxASCSequenceService.getMaxASCSequenceService(getFileData(request.getPath_file()));
    }

    @SneakyThrows
    @ApiOperation(value = "Return the longest sequence of consecutive numbers that decreases")
    @RequestMapping(
            path = "/get_max_desc_sequence",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public MaxDESCSequenceDto getMaxDESCSequenceOfConsecutiveNumbers(@RequestBody RequestData request) {
        return maxDESCSequenceService.getMaxDESCSequenceService(getFileData(request.getPath_file()));
    }

    @SneakyThrows
    @ApiOperation(value = "Return the longest sequence of consecutive numbers that decreases")
    @RequestMapping(
            path = "/",
            method = RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseBody
    public ResponseDto getRequestedOperation(@RequestBody RequestData request) {
        return requestValidationService.validateRequest(request);
    }

    private ArrayList<Integer> getFileData(String file_path) throws IOException {
        return fileParserService.getListOfIntegersFromTextFile(file_path);
    }
}
