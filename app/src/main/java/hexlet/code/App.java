package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command (
        name = "gendiff",
        description = "Compares two configuration files and shows a difference.",
        mixinStandardHelpOptions = true
)

public class App implements Callable<Integer> {
    @Parameters(index = "0", paramLabel = "filepath1",
    description = "path to first file")
    private String filepath1;
    @Parameters(index = "1", paramLabel = "filepath1",
            description = "path to second file")
    private String filepath2;
    @Option(names = {"-f", "--format"}, paramLabel = "format", defaultValue = "stylish",
    description = "output format [default: stylish]")
    private String format;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
    }

    @Override
    public Integer call() throws Exception {
        return 0;
    }
}
