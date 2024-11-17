package com.botscrew.university.repository;

import com.botscrew.university.entity.Degree;
import com.botscrew.university.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("SELECT d FROM Department d LEFT JOIN FETCH d.lectors WHERE d.departmentName = :departmentName")
    Optional<Department> findByDepartmentName(@Param("departmentName") String departmentName);

    @Query("SELECT AVG(l.salary) FROM Department d LEFT JOIN d.lectors l WHERE d.departmentName = :departmentName")
    Optional<Double> findAverageSalaryByDepartment(@Param("departmentName") String departmentName);

    @Query("SELECT CONCAT(d.headOfDepartment.lectorName , ' ' , d.headOfDepartment.lectorSurname) FROM Department d WHERE d.departmentName = :departmentName")
    Optional<String> findHeadOfDepartment(@Param("departmentName") String departmentName);

    @Query("SELECT COUNT(1) FROM Department d LEFT JOIN d.lectors l WHERE d.departmentName = :departmentName AND l.degree= :lectorDegree")
    Long countLectorsByDegreeInDepartment(@Param("departmentName") String departmentName, @Param("lectorDegree") Degree lectorDegree);

    @Query("SELECT COUNT(1) FROM Department d LEFT JOIN d.lectors l WHERE d.departmentName = :departmentName")
    Long countLectorsInDepartment(@Param("departmentName") String departmentName);
}
