package com.botscrew.university.processor;

import com.botscrew.university.exception.ParameterEmptyException;
import com.botscrew.university.factory.CommandFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CommandProcessor {

    CommandFactory commandFactory;

    public String processCommand(String input) {
        try {
            return commandFactory.getCommand(input)
                    .map(command -> command.process(input))
                    .orElse("Unknown command.");
        } catch (ParameterEmptyException e) {
            return e.getMessage();
        }
    }
}
