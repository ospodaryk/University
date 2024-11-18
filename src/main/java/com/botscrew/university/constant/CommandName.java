package com.botscrew.university.constant;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.logging.log4j.util.Strings;

@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum CommandName {

    SHOW_DEPARTMENT_AVERAGE_SALARY("Show the average salary for the department"),
    WHO_IS_HEAD_OF_DEPARTMENT("Who is head of department"),
    SHOW_DEPARTMENT_STATISTICS("Show", "statistics"),
    SHOW_COUNT_OF_EMPLOYEE("Show count of employee for"),
    GLOBAL_SEARCH_BY("Global search by");

    final String commandStartsWith;
    String commandEndsWith = Strings.EMPTY;

}