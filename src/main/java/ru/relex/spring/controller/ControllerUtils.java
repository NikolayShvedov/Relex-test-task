package ru.relex.spring.controller;

import ru.relex.spring.service.IFileParserService;

import java.io.IOException;
import java.util.ArrayList;

abstract public class ControllerUtils {

    protected static ArrayList<Integer> integers = new ArrayList<>();

    private final IFileParserService fileParserService;

    protected ControllerUtils(IFileParserService fileParserService) {
        this.fileParserService = fileParserService;
    }

    public void getListOfIntegersFromTextFile(String path) throws IOException {
        integers = fileParserService.getListOfIntegersFromTextFile(path);
    }
}
