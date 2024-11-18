package com.botscrew.university.command;

import com.botscrew.university.constant.CommandName;
import com.botscrew.university.exception.ParameterEmptyException;

public interface Command {

    default boolean canProcess(String input) {
        String commandStart = getCommandName().getCommandStartsWith();
        return input.startsWith(commandStart);
    }

    default String getParamFromInput(String input) {
        String commandStart = getCommandName().getCommandStartsWith();
        String trimmed = input.substring(commandStart.length()).trim();
        if (trimmed.isBlank()) {
            throw new ParameterEmptyException();
        }
        return trimmed;
    }

    CommandName getCommandName();

    String process(String input);
}