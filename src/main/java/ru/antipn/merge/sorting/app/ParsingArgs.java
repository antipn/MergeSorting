package ru.antipn.merge.sorting.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

@Component
public class ParsingArgs {
    @Autowired
    private ApplicationArguments args;

    public String[] getArgs() {
        String[] inputArgs;
        String[] myArgs = args.getSourceArgs();

        switch (myArgs[0]) {
            case ("-a"), ("-d") -> {
                inputArgs = new String[myArgs.length];
                inputArgs[0] = myArgs[0];
                inputArgs[1] = myArgs[1];
                for (int i = 2; i < myArgs.length; i++) {
                    inputArgs[i] = myArgs[i];
                }
            }
            default -> {
                inputArgs = new String[myArgs.length + 1];
                inputArgs[0] = "-a";
                inputArgs[1] = myArgs[0];
                for (int i = 1; i < myArgs.length; i++) {
                    inputArgs[i + 1] = myArgs[i];
                }
            }
        }

        return inputArgs;
    }
}
