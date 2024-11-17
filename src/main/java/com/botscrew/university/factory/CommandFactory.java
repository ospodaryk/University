package com.botscrew.university.factory;

import com.botscrew.university.command.Command;
import com.botscrew.university.constant.CommandName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Component
public class CommandFactory {

    private final Map<CommandName, Command> commandMap = new HashMap<>();

    @Autowired
    public CommandFactory(Set<Command> commands) {
        commands.forEach(command -> commandMap.put(command.getCommandName(), command));
    }

    public Optional<Command> getCommand(String input) {
        return commandMap.values().stream()
                .filter(command -> command.canProcess(input))
                .findFirst();
    }
}
