package ru.relex.spring.service;

import java.io.IOException;
import java.util.ArrayList;

public interface IFileParserService {

    ArrayList<Integer> getListOfIntegersFromTextFile(String path) throws IOException;
}
