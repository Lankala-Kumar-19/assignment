package com.assignment.service;

import com.assignment.dto.ContactFormRequestDTO;
import com.assignment.dto.ContactFormResponseDTO;
import com.assignment.exception.ResourceNotFoundException;
import com.assignment.mapper.ContactFormMapper;
import com.assignment.model.ContactForm;
import com.assignment.repository.ContactFormRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContactFormService {

    private final ContactFormRepository repository;
    private final ContactFormMapper mapper;

    public ContactFormService(ContactFormRepository repository, ContactFormMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // Create contact form entry
    public ContactFormResponseDTO createContactForm(@Valid ContactFormRequestDTO dto) {
        ContactForm form = mapper.toEntity(dto);
        ContactForm saved = repository.save(form);
        return mapper.toResponse(saved);
    }

    // Get all contact forms (paginated)
    public Page<ContactFormResponseDTO> getAllContactForms(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toResponse);
    }

    // Get by ID
    public ContactFormResponseDTO getContactFormById(String id) {
        ContactForm form = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact form not found with id: " + id));
        return mapper.toResponse(form);
    }

    // Delete by ID
    public ContactFormResponseDTO deleteContactFormById(String id) {
        ContactForm form = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact form not found with id: " + id));

        repository.delete(form);
        return mapper.toResponse(form);
    }
}
