package com.botscrew.university.command.impl;

import com.botscrew.university.command.Command;
import com.botscrew.university.constant.CommandName;
import com.botscrew.university.service.LectorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GlobalSearchCommand implements Command {

    LectorService lectorService;

    @Override
    public CommandName getCommandName() {
        return CommandName.GLOBAL_SEARCH_BY;
    }

    @Override
    public String process(String input) {
        String template = getParamFromInput(input);
        return lectorService.globalSearchBy(template);
    }
}