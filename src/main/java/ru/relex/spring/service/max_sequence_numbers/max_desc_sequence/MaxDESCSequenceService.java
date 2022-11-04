package ru.relex.spring.service.max_sequence_numbers.max_desc_sequence;

import ru.relex.spring.dto.MaxDESCSequenceDto;

import java.util.ArrayList;

public interface MaxDESCSequenceService {

    MaxDESCSequenceDto getMaxDESCSequenceService(ArrayList<Integer> integers);
}
