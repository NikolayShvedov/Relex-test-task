package ru.relex.spring.service.max_sequence_numbers.max_asc_sequence;

import ru.relex.spring.dto.MaxASCSequenceDto;

import java.util.ArrayList;

public interface MaxASCSequenceService {

    MaxASCSequenceDto getMaxASCSequenceService(ArrayList<Integer> integers);
}
