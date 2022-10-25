package ru.relex.spring.service.parser;

import java.io.IOException;
import java.util.ArrayList;

public interface FileParserService {

    ArrayList<Integer> getListOfIntegersFromTextFile(String path) throws IOException;
}
