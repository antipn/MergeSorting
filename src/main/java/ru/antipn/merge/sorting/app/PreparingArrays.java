package ru.antipn.merge.sorting.app;

import org.springframework.stereotype.Service;
import ru.antipn.merge.sorting.app.exception.ErrorRowCatcher;
import ru.antipn.merge.sorting.app.exception.SpaceFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class PreparingArrays {
    private final ParsingArgs parsingArgs;

    public PreparingArrays(ParsingArgs parsingArgs) {
        this.parsingArgs = parsingArgs;
    }

    public String[] getParsingArgs() {
        return parsingArgs.getArgs();
    }

    public List<String> getArrayFromFile(FileSystemReader file) {
        try {
            List<String> lines = file.getLines();
            if (lines == null) {
                throw new ErrorRowCatcher("There is no data in file " + file.getFilename());
            }
            return lines;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    public List<?> checkingArray() { //type sorting -i -s
        String[] args = getParsingArgs();
        switch (args[1]) {
            case ("-i"): {
                List<Integer> result = new ArrayList<>();
                for (int i = 3; i < args.length; i++) {
                    //System.out.println("Making Integer" + (i - 2) + "/" + (args.length - 3) + " array from file: " + args[i]);
                    List<String> arrayFromFile = getArrayFromFile(new FileSystemReader(args[i]));
                    try {
                        for (int j = 0; j < arrayFromFile.size(); j++) {
                            result.add(Integer.parseInt(arrayFromFile.get(j)));
                        }
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException("File with data contains non Integer values");
                    }
                }
                return result;
            }
            case ("-s"): {
                List<String> result = new ArrayList<>();
                for (int i = 3; i < args.length; i++) {
                    //System.out.println("Making String " + (i - 2) + "/" + (args.length - 3) + " array from file: " + args[i]);
                    List<String> arrayFromFile = getArrayFromFile(new FileSystemReader(args[i]));
                    for (int j = 0; j < arrayFromFile.size(); j++) {
                        String[] split = arrayFromFile.get(j).split("");
                        for (String ch : split) {
                            if (ch.equals(" ")) {
                                throw new SpaceFoundException("Spaces are prohibited for using");
                            }
                            result.add(ch);
                        }
                    }
                }
                return result;
            }
        }
        return null;
    }
}


