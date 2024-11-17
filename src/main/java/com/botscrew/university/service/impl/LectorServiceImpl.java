package com.botscrew.university.service.impl;

import com.botscrew.university.entity.Lector;
import com.botscrew.university.repository.LectorRepository;
import com.botscrew.university.service.LectorService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LectorServiceImpl implements LectorService {

    LectorRepository lectorRepository;

    @Override
    public String globalSearchBy(String template) {
        List<String> results = lectorRepository.findNamesByTemplate(template);
        return results.isEmpty() ? "Values not found." : String.join(" , ", results);
    }

    @Override
    public void saveAll(Set<Lector> lectors) {
        lectorRepository.saveAll(lectors);
    }
}
