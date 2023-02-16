package ru.antipn.merge.sorting.app;


import ru.antipn.merge.sorting.app.exception.ErrorRowCatcher;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileSystemReader {
    private String filePath;

    public FileSystemReader(String filePath) {
        this.filePath = filePath;
    }

    public List<String> getLines() throws Exception {
        Path pathFile = Paths.get("src//main//resources//" + filePath);
        boolean exists = Files.exists(pathFile);
        if (exists) {
            try {
                return Files.readAllLines(pathFile);
            } catch (Exception e) {
                System.out.println("There is problem with file " + pathFile.getFileName());
            }
        }
        throw new ErrorRowCatcher("File is not exist" + pathFile.getFileName());
    }

    public String getFilename() {
        return Paths.get(filePath).getFileName().toString();
    }

    public ArrayList<String> makeArray(List<String> input) {
        return null;
    }
}