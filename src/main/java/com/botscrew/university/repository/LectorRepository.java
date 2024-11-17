package com.botscrew.university.repository;

import com.botscrew.university.entity.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LectorRepository extends JpaRepository<Lector, Long> {

    @Query("SELECT CONCAT(l.lectorName , ' ' , l.lectorSurname) FROM Lector l WHERE l.lectorName LIKE %:template% OR l.lectorSurname LIKE %:template%")
    List<String> findNamesByTemplate(@Param("template") String template);

}
