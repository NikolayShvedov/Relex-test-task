package ru.relex.spring.service;

import ru.relex.spring.dto.MedianDto;

import java.util.ArrayList;

public interface IMedianService {

    MedianDto getMedian(ArrayList<Integer> integers);
}
