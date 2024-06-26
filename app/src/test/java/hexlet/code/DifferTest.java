package hexlet.code;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DifferTest {

    @Test
    void generate() throws IOException {
        var actual = Differ.generate("src/test/resources/file1.json", "src/test/resources/file2.json", "stylish" );
        var result = readFile("src/test/resources/result.json");
        assertEquals(actual, result);
    }

    public static String readFile(String filepath) throws IOException {
        Path path = Paths.get(filepath);
        Stream<String> lines = Files.lines(path);
        String data = lines.collect(Collectors.joining(""));
        lines.close();
        return data;
    }
}
