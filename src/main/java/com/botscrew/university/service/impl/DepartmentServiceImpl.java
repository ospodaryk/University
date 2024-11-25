package com.botscrew.university.service.impl;

import com.botscrew.university.entity.Degree;
import com.botscrew.university.entity.Department;
import com.botscrew.university.repository.DepartmentRepository;
import com.botscrew.university.service.DepartmentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentServiceImpl implements DepartmentService {

    static String DEPARTMENT_NOT_FOUND = "Department with name '%s' not found.";
    DepartmentRepository departmentRepository;

    @Override
    public String getDepartmentHead(String departmentName) {
        return departmentRepository
                .findHeadOfDepartment(departmentName)
                .map(head -> "Head of " + departmentName + " department is " + head)
                .orElse(String.format(DEPARTMENT_NOT_FOUND, departmentName));
    }

    @Override
    public String getDepartmentStatistics(String departmentName) {
        if (!checkDepartmentExist(departmentName)) {
            return String.format(DEPARTMENT_NOT_FOUND, departmentName);
        }

        return Arrays.stream(Degree.values())
                .map(degree -> formatDegreeStatistics(departmentName, degree))
                .collect(Collectors.joining("\n"));
    }

    private boolean checkDepartmentExist(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName).isPresent();
    }

    private String formatDegreeStatistics(String departmentName, Degree degree) {
        long count = departmentRepository.countLectorsByDegreeInDepartment(departmentName, degree);
        return String.format("%s - %d", degree, count);
    }

    @Override
    public String getAverageSalaryByDepartment(String departmentName) {
        return departmentRepository.findAverageSalaryByDepartment(departmentName)
                .map(avg -> "The average salary of " + departmentName + " is " + String.format("%.2f", avg))
                .orElse(String.format(DEPARTMENT_NOT_FOUND, departmentName));
    }

    @Override
    public String getEmployeeCount(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName)
                .map(department -> String.valueOf(department.getLectors().size()))
                .orElse(String.format(DEPARTMENT_NOT_FOUND, departmentName));
    }

    @Override
    public void saveAll(List<Department> departments) {
        departmentRepository.saveAll(departments);
    }
}
