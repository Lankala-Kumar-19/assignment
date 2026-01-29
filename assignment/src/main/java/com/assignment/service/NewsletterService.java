package com.assignment.service;

import com.assignment.dto.NewsletterRequestDTO;
import com.assignment.dto.NewsletterResponseDTO;
import com.assignment.exception.DuplicateProjectException; // can reuse for duplicate email
import com.assignment.exception.ResourceNotFoundException;
import com.assignment.mapper.NewsletterMapper;
import com.assignment.model.Newsletter;
import com.assignment.repository.NewsletterRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NewsletterService {

    private final NewsletterRepository repository;
    private final NewsletterMapper mapper;

    public NewsletterService(NewsletterRepository repository, NewsletterMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    // Subscribe email
    public NewsletterResponseDTO subscribe(@Valid NewsletterRequestDTO dto) {

        if (repository.existsByEmailIgnoreCase(dto.getEmail())) {
            throw new DuplicateProjectException("Email '" + dto.getEmail() + "' is already subscribed");
        }

        Newsletter newsletter = mapper.toEntity(dto);
        Newsletter saved = repository.save(newsletter);

        return mapper.toResponse(saved);
    }

    // Get all subscriptions
    public Page<NewsletterResponseDTO> getAllSubscriptions(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toResponse);
    }

    // Delete subscription by email
    public NewsletterResponseDTO deleteByEmail(String email) {
        Newsletter newsletter = repository.findByEmailIgnoreCase(email)
                .orElseThrow(() -> new ResourceNotFoundException("Email '" + email + "' not found"));

        repository.delete(newsletter);
        return mapper.toResponse(newsletter);
    }
}
