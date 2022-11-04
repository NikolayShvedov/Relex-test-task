package ru.relex.spring.service.parser;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Класс для считывания массива целых чисел из текстового файла "10m.txt"
 * @author Николай Шведов
 * @version 1.0.0
 */
@Component
@RequiredArgsConstructor
public class FileParserServiceImpl implements FileParserService {

    /**
     * Функция для считывания массива целых чисел из текстового файла
     * @param path - путь к файлу 10m.txt
     * @return возвращает массив целых чисел
     * @throws IOException - неправильное чтение файла
     */
    @Override
    public ArrayList<Integer> getListOfIntegersFromTextFile(String path) {

        ArrayList<Integer> integers = new ArrayList<>();
        try {
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Path.of(path)));
            for (String values : lines)
                integers.add(Integer.parseInt(values));
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return integers;
    }
}
