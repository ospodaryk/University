package com.botscrew.university.initialiser;

import com.botscrew.university.entity.Degree;
import com.botscrew.university.entity.Department;
import com.botscrew.university.entity.Lector;
import com.botscrew.university.service.DepartmentService;
import com.botscrew.university.service.LectorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DataInitializer {

    LectorService lectorService;
    DepartmentService departmentService;

    private static Lector getRandomLector(Set<Lector> lecturers, Random random) {
        return new ArrayList<>(lecturers).get(random.nextInt(lecturers.size()));
    }

    public void populateDatabase() {
        Set<Lector> lectors = Set.of(
                new Lector("John", "Snow", 50000.0, Degree.ASSISTANT),
                new Lector("Jim", "Dorthy", 55000.0, Degree.ASSOCIATE_PROFESSOR),
                new Lector("Angela", "Helms", 60000.0, Degree.PROFESSOR),
                new Lector("Emily", "Davis", 52000.0, Degree.ASSISTANT),
                new Lector("Robert", "Lieberstein", 58000.0, Degree.ASSOCIATE_PROFESSOR),
                new Lector("Anna", "Wilson", 62000.0, Degree.PROFESSOR),
                new Lector("Steve", "Taylor", 49000.0, Degree.ASSISTANT),
                new Lector("Laura", "Halpert", 53000.0, Degree.ASSOCIATE_PROFESSOR),
                new Lector("Jenna", "Thomas", 61000.0, Degree.PROFESSOR),
                new Lector("Sophia", "Bernard", 50500.0, Degree.ASSISTANT),
                new Lector("Christopher", "Smith", 57500.0, Degree.ASSOCIATE_PROFESSOR),
                new Lector("Emma", "Beesly", 61500.0, Degree.PROFESSOR),
                new Lector("Oliver", "Clark", 49500.0, Degree.ASSISTANT),
                new Lector("Isabella", "Martin", 54500.0, Degree.ASSOCIATE_PROFESSOR),
                new Lector("Kate", "Walker", 62500.0, Degree.PROFESSOR)
        );

        lectorService.saveAll(lectors);

        List<Department> departments = List.of(
                new Department("Computer Science"),
                new Department("Physics"),
                new Department("Mathematics"),
                new Department("Chemistry"),
                new Department("Biology")
        );

        departmentService.saveAll(departments);

        Random random = new Random();

        departments.forEach(department -> {
            Set<Lector> departmentLectors = new HashSet<>();
            IntStream.range(1, 5).forEach(iterator -> departmentLectors.add(getRandomLector(lectors, random)));
            department.setLectors(departmentLectors);
            department.setHeadOfDepartment(getRandomLector(departmentLectors, random));
        });

        departmentService.saveAll(departments);
    }
}