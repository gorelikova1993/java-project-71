package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DifferTest {
    @Test
    void generateJSONFormatPlain() throws IOException {
        var actualPlainJson = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json", "plain");
        var resultPlainJson = readFile("src/test/resources/plainResult.txt");
        assertEquals(actualPlainJson, resultPlainJson);
    }

    @Test
    void generateJsonFormatJson() throws IOException {
        var actualJsonFormat = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json", "json");
        var resultJsonFormat = readFile("src/test/resources/resultJson.json");
        assertEquals(actualJsonFormat, resultJsonFormat);
    }

    @Test
    void generate() throws IOException {
        var actualNewJson2 = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json");
        var resultNewJson2 = readFile("src/test/resources/StylishResult.txt");
        assertEquals(actualNewJson2, resultNewJson2);
    }

    @Test
    void generateJSONFormatStylish() throws IOException {
        var actualNewJson = Differ.generate("src/test/resources/file1.json",
                "src/test/resources/file2.json", "stylish");
        var resultNewJson = readFile("src/test/resources/StylishResult.txt");
        assertEquals(actualNewJson, resultNewJson);
    }

    @Test
    void generateYAMLFormatDefault() throws IOException {
        var actualYmlStylish2 = Differ.generate("src/test/resources/file3.yaml",
                "src/test/resources/file4.yaml");
        var resultYmlStylish2 = readFile("src/test/resources/stylishYmlResult.txt");
        assertEquals(actualYmlStylish2, resultYmlStylish2);
    }

    @Test
    void generateYAMLFormatStylish() throws IOException {
        var actualYmlStylish = Differ.generate("src/test/resources/file3.yaml",
                "src/test/resources/file4.yaml", "stylish");
        var resultYmlStylish = readFile("src/test/resources/stylishYmlResult.txt");
        assertEquals(actualYmlStylish, resultYmlStylish);
    }

    @Test
    void generateYAMLFormatPlain() throws IOException {
        var actualYamlFormatPlain = Differ.generate("src/test/resources/file3.yaml",
                "src/test/resources/file4.yaml", "plain");
        var resultYamlFormatPlain = readFile("src/test/resources/plainResultYml.txt");
        assertEquals(actualYamlFormatPlain, resultYamlFormatPlain);
    }

    @Test
    void generateYAMlFormatJSON() throws IOException {
        var actualYmlJsonFormat = Differ.generate("src/test/resources/file3.yaml",
                "src/test/resources/file4.yaml", "json");
        var resultYmlJsonFormat = readFile("src/test/resources/resultForYmlJson.txt");
        assertEquals(actualYmlJsonFormat, resultYmlJsonFormat);
    }

    public static String readFile(String filepath) throws IOException {
        Path path = Paths.get(filepath);
        String content = Files.readString(path);
        return content;
    }
}
