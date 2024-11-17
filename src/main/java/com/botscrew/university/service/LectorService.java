package com.botscrew.university.service;

import com.botscrew.university.entity.Lector;

import java.util.Set;

public interface LectorService {

    String globalSearchBy(String template);

    void saveAll(Set<Lector> lectors);

}
