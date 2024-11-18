package com.botscrew.university.command.impl;

import com.botscrew.university.command.Command;
import com.botscrew.university.constant.CommandName;
import com.botscrew.university.exception.ParameterEmptyException;
import com.botscrew.university.service.DepartmentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentStatisticsCommand implements Command {

    DepartmentService departmentService;

    @Override
    public CommandName getCommandName() {
        return CommandName.SHOW_DEPARTMENT_STATISTICS;
    }

    @Override
    public String process(String input) throws ParameterEmptyException {
        String departmentName = getParamFromInput(input);
        return departmentService.getDepartmentStatistics(departmentName);
    }

    @Override
    public boolean canProcess(String input) {
        CommandName commandName = getCommandName();
        return input.startsWith(commandName.getCommandStartsWith())
                && input.endsWith(commandName.getCommandEndsWith());
    }

    @Override
    public String getParamFromInput(String input) {
        int commandStartsLength = getCommandName().getCommandStartsWith().length();
        String commandEndsWith = getCommandName().getCommandEndsWith();
        String trimmed = input.substring(commandStartsLength, input.indexOf(commandEndsWith)).trim();
        if (trimmed.isBlank()) {
            throw new ParameterEmptyException();
        }
        return trimmed;
    }
}