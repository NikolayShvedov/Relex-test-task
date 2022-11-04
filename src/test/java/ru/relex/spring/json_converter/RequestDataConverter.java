package ru.relex.spring.json_converter;

import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class RequestDataConverter {

    @SneakyThrows
    public static String convertJsonRequestDataToString(String path) {
        return new String(Files.readAllBytes(Paths.get(new ClassPathResource(path).getURI())));
    }

    @SneakyThrows
    public static String convertXMLRequestDataToString(String path) {
        String fullPath = String.valueOf(Paths.get(new ClassPathResource(path).getURI()));
        BufferedReader br = new BufferedReader(new FileReader(fullPath));
        return br.lines().collect(Collectors.joining("\n"));
    }
}
