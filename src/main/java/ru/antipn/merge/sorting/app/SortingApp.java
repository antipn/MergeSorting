package ru.antipn.merge.sorting.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.antipn.merge.sorting.app.exception.SpaceFoundException;

@SpringBootApplication
public class SortingApp {

    public static void main(String[] args) throws Exception {

        ConfigurableApplicationContext context = SpringApplication.run(SortingApp.class, args);

        SortingMultiplyFiles main = context.getBean(SortingMultiplyFiles.class);

        ParsingArgs parsingArgs = context.getBean(ParsingArgs.class);
        try {
            switch (parsingArgs.getArgs()[1]) {
                case ("-i") -> {
                    main.sortingIntegerFiles();
                }
                case ("-s") -> {
                    main.sortingStringFiles();
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Illegal format of data for sorting Integer values, please, check files");
        } catch (SpaceFoundException e) {
            System.out.println(e.getMessage() + " ?space detected in file, please remove spaces");
        }
    }
}
