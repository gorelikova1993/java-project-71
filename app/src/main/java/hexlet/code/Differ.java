package hexlet.code;

import hexlet.code.formatters.Formatter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws IOException {
        String content1 = readFile(filepath1);
        String content2 = readFile(filepath2);

        String fileFormat1 = getFileType(filepath1);
        String fileFormat2 = getFileType(filepath2);

        Map<String, Object> file1 = Parser.parse(content1, fileFormat1);
        Map<String, Object> file2 = Parser.parse(content2, fileFormat2);

        List<Map<String, Object>> compareResult = Comparator.compare(file1, file2);
        return Formatter.format(compareResult, format);
    }

    public static String generate(String filepath1, String filepath2) throws IOException {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String readFile(String filepath) throws IOException {
        Path path = Paths.get(filepath);
        String content = Files.readString(path);
        return content;
    }

    private static String getFileType(String filepath) {
        var type = filepath.substring(filepath.lastIndexOf(".") + 1);
        return type;
    }
}
