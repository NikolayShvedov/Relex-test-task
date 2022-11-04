package ru.relex.spring.service.median;

import ru.relex.spring.dto.MedianDto;

import java.util.ArrayList;

public interface MedianService {

    MedianDto getMedian(ArrayList<Integer> integers);
}
