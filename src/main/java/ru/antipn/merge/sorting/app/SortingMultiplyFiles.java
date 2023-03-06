package ru.antipn.merge.sorting.app;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class SortingMultiplyFiles {

    private final ParsingArgs parsingArgs;
    private final PreparingArrays preparingArrays;
    private final Sorting sorting;

    public SortingMultiplyFiles(ParsingArgs parsingArgs, PreparingArrays preparingArrays, Sorting sorting) {
        this.parsingArgs = parsingArgs;
        this.preparingArrays = preparingArrays;
        this.sorting = sorting;
    }

    public void sortingIntegerFiles() throws Exception {
        List<?> input = preparingArrays.checkingArray();
        int size = input.size();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = (int) input.get(i);
        }

        Sorting.mergeSortInteger(array, size, preparingArrays.getParsingArgs()[0]);

        List<String> result = Arrays.stream(array).mapToObj(Objects::toString).toList();
        FileSystemWriter outputFile = new FileSystemWriter(preparingArrays.getParsingArgs()[2]);
        outputFile.setLines(result);

    }

    public void sortingStringFiles() throws Exception {

        List<?> input = preparingArrays.checkingArray();
        int size = input.size();
        String[] array = new String[size];
        for (int i = 0; i < size; i++) {
            array[i] = (String) input.get(i);
        }
        Sorting.mergeSortString(array, size, preparingArrays.getParsingArgs()[0]);
        FileSystemWriter outputFile = new FileSystemWriter(preparingArrays.getParsingArgs()[2]);
        outputFile.setLines(Arrays.asList(array));
    }

}
