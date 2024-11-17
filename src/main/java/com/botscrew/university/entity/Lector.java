package com.botscrew.university.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@Entity
@Table
@RequiredArgsConstructor
@NoArgsConstructor
public class Lector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long lectorId;

    @Column(nullable = false)
    @NonNull
    private String lectorName;

    @Column(nullable = false)
    @NonNull
    private String lectorSurname;

    @Column(nullable = false)
    @NonNull
    private Double salary;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @NonNull
    private Degree degree;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Department> departments;

    @Override
    public String toString() {
        return lectorName + ' ' + lectorSurname;
    }
}
