package streamsFilesAndDirectories.lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class P06SortLines {
    public static void main(String[] args) throws IOException {



        List<String> input = Files.lines(Paths.get("resources/input.txt"))
                .sorted().collect(Collectors.toList());

        Files.write(Path.of("resources/output.txt"), input);


    }
}
