package files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileOperator {

    public static void main(String[] args) throws IOException {
        Path rootPath = Paths.get(".");
        Stream<Path> filesStream = Files.find(rootPath, 2, (path, attributes) -> path.getFileName().endsWith("test"));
        filesStream.forEach(System.out::println);

        Path textFilesPath = Paths.get("D:\\iprojects\\March\\src\\main\\resources\\test.txt");
        Files.lines(textFilesPath).forEach(System.out::println);
        System.out.println(Files.readAllLines(textFilesPath));

        Files.walk(Paths.get(".")).forEach(System.out::println);
    }

}
