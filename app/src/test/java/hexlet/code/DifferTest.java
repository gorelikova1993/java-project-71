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
    //    var actual = Differ.generate("src/test/resources/file1.json", "src/test/resources/file2.json", "stylish");
      //  var result = readFile("src/test/resources/result2.txt");
       // assertEquals(actual, result);

        //var actualYaml = Differ.generate("src/test/resources/file3.yaml", "src/test/resources/file4.yaml", "plain");
        //var resultYaml = readFile("src/test/resources/result2.txt");
        //assertEquals(actualYaml, resultYaml);

        //nestedTest
        var actualNewJson = Differ.generate("src/test/resources/file5.json",
                "src/test/resources/file6.json", "stylish");
        var resultNewJson = readFile("src/test/resources/result3.txt");
        assertEquals(actualNewJson, resultNewJson);

        var actualPlainJson = Differ.generate("src/test/resources/file5.json",
                "src/test/resources/file6.json", "plain");
        var resultPlainJson = readFile("src/test/resources/plainResult.txt");
        assertEquals(actualPlainJson, resultPlainJson);

        var actualJsonFormat = Differ.generate("src/test/resources/file5.json",
                "src/test/resources/file6.json", "json");
        var resultJsonFormat = readFile("src/test/resources/resultJson.json");
        assertEquals(actualJsonFormat, resultJsonFormat);
    }

    public static String readFile(String filepath) throws IOException {
        Path path = Paths.get(filepath);
        String content = Files.readString(path);
        return content;
    }
}
