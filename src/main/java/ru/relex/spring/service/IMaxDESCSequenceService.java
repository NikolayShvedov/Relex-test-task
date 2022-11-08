package ru.relex.spring.service;

import ru.relex.spring.dto.MaxDESCSequenceDto;

import java.util.ArrayList;

public interface IMaxDESCSequenceService {

    MaxDESCSequenceDto getMaxDESCSequenceService(ArrayList<Integer> integers);
}
