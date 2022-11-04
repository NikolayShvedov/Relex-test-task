package ru.relex.spring.service;

import ru.relex.spring.dto.MaxASCSequenceDto;

import java.util.ArrayList;

public interface IMaxASCSequenceService {

    MaxASCSequenceDto getMaxASCSequenceService(ArrayList<Integer> integers);
}
