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
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long departmentId;

    @Column(nullable = false)
    @NonNull
    private String departmentName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Lector headOfDepartment;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Lector> lectors;
}
