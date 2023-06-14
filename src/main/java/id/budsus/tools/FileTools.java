package id.budsus.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileTools {
    public static void writeStringToFile(final String fileName, final String s) throws IOException {
        Files.writeString(
                Path.of(fileName),
                s + System.lineSeparator(),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}
