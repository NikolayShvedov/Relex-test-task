package ru.relex.spring.service;

import org.springframework.validation.annotation.Validated;
import ru.relex.spring.dto.ResponseDto;

import java.util.ArrayList;

@Validated
public interface IRequestValidationService {

    ResponseDto validateRequest(String operation, ArrayList<Integer> integers);

}
