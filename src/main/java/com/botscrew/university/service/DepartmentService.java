package com.botscrew.university.service;

import com.botscrew.university.entity.Department;

import java.util.List;

public interface DepartmentService {

    String getDepartmentHead(String departmentName);

    String getDepartmentStatistics(String departmentName);

    String getEmployeeCount(String departmentName);

    void saveAll(List<Department> departments);

    String getAverageSalaryByDepartment(String departmentName);
}
