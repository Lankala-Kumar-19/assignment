package com.assignment.repository;

import com.assignment.model.ContactForm;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ContactFormRepository extends MongoRepository<ContactForm, String> {
}
