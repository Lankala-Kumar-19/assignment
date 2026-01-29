package com.assignment.repository;

import com.assignment.model.Client;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ClientRepository extends MongoRepository<Client, String> {

    Optional<Client> findByNameIgnoreCase(String name);

    boolean existsByNameIgnoreCase(String name);

    void deleteByNameIgnoreCase(String name);
}
