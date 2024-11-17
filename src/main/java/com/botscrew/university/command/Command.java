package com.botscrew.university.command;

import com.botscrew.university.constant.CommandName;

public interface Command {

    default boolean canProcess(String input) {
        String commandStart = getCommandName().getCommandStartsWith();
        return input.startsWith(commandStart);
    }

    default String getParamFromInput(String input) {
        String commandStart = getCommandName().getCommandStartsWith();
        return input.substring(commandStart.length()).trim();
    }

    CommandName getCommandName();


    String process(String input);
}