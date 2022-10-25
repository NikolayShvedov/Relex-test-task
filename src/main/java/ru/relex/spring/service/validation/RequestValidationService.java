package ru.relex.spring.service.validation;

import org.springframework.validation.annotation.Validated;
import ru.relex.spring.dto.ResponseDto;
import ru.relex.spring.dto.request.RequestData;
import ru.relex.spring.dto.request.RequestType;

import java.io.IOException;

@Validated
public interface RequestValidationService {

    ResponseDto validateRequest(RequestData requestData) throws IOException;

}
