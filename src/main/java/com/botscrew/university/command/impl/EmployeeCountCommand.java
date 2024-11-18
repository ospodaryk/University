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
public class EmployeeCountCommand implements Command {

    DepartmentService departmentService;

    @Override
    public CommandName getCommandName() {
        return CommandName.SHOW_COUNT_OF_EMPLOYEE;
    }

    @Override
    public String process(String input) {
        try {
            String departmentName = getParamFromInput(input);
            return departmentService.getEmployeeCount(departmentName);
        } catch (ParameterEmptyException e) {
            return e.getMessage();
        }
    }
}