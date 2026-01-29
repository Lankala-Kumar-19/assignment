package com.assignment.repository;

import com.assignment.model.Newsletter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface NewsletterRepository extends MongoRepository<Newsletter, String> {

    boolean existsByEmailIgnoreCase(String email);

    Optional<Newsletter> findByEmailIgnoreCase(String email);
}
