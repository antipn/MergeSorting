package ru.antipn.merge.sorting.app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileSystemWriter {
    private String filePath;

    public FileSystemWriter(String filePath) {
        this.filePath = filePath;
    }

    public void setLines(List<String> input) {
        //Path pathFile = Paths.get("src//main//resources//" + filePath);
        Path pathFile = Paths.get(filePath);

        try {
            Files.deleteIfExists(pathFile);
            Files.createFile(pathFile);
            Files.write(pathFile, input);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
