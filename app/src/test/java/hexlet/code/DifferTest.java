package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DifferTest {

    @Test
    void generate() throws IOException {
        //nestedTest
        //8 тестов (6 штук) + 2 без указания форматтера
        var actualNewJson = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json", "stylish");
        var resultNewJson = readFile("src/test/resources/StylishResult.txt");
        assertEquals(actualNewJson, resultNewJson);

        var actualNewJson2 = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json");
        var resultNewJson2 = readFile("src/test/resources/StylishResult.txt");
        assertEquals(actualNewJson2, resultNewJson2);

        var actualPlainJson = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json", "plain");
        var resultPlainJson = readFile("src/test/resources/plainResult.txt");
        assertEquals(actualPlainJson, resultPlainJson);

        var actualJsonFormat = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json", "json");
        var resultJsonFormat = readFile("src/test/resources/resultJson.json");
        assertEquals(actualJsonFormat, resultJsonFormat);


    }

    public static String readFile(String filepath) throws IOException {
        Path path = Paths.get(filepath);
        String content = Files.readString(path);
        return content;
    }
}
