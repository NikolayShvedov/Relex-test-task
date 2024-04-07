package ru.relex.spring.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.relex.spring.service.IFileParserService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Класс для считывания массива целых чисел из текстового файла "10m.txt"
 *
 * @author Николай Шведов
 * @version 1.0.1
 */
@Component
@RequiredArgsConstructor
public class FileParserServiceImpl implements IFileParserService {

    /**
     * Функция для считывания массива целых чисел из текстового файла
     *
     * @param path - путь к файлу 10m.txt
     * @return возвращает массив целых чисел
     * @throws IOException - неправильное чтение файла
     */
    @Override
    public ArrayList<Integer> getListOfIntegersFromTextFile(String path) {

        ArrayList<Integer> integers = new ArrayList<>();
        try {
            integers = (ArrayList<Integer>) Files.readAllLines(Path.of(path))
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return integers;
    }
}
