package com.assignment.repository;

import com.assignment.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProjectRepository extends MongoRepository<Project, String> {

    Optional<Project> findByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCase(String name);

    void deleteByNameIgnoreCase(String name);
}
