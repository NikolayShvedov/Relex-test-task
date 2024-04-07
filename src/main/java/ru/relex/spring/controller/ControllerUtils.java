package ru.relex.spring.controller;

import ru.relex.spring.service.IFileParserService;

import java.io.IOException;
import java.util.ArrayList;

abstract public class ControllerUtils {

    protected static ArrayList<Integer> integers = new ArrayList<>(1_000_000);

    private final IFileParserService fileParserService;

    protected ControllerUtils(IFileParserService fileParserService) {
        this.fileParserService = fileParserService;
    }

    protected void getListOfIntegersFromTextFile(String path) throws IOException {
        integers = fileParserService.getListOfIntegersFromTextFile(path);
    }
}
