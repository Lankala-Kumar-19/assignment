package com.assignment.controller;

import com.assignment.dto.NewsletterRequestDTO;
import com.assignment.dto.NewsletterResponseDTO;
import com.assignment.service.NewsletterService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/newsletters")
public class NewsletterController {

    private final NewsletterService service;

    public NewsletterController(NewsletterService service) {
        this.service = service;
    }

    @PostMapping("/subscribe")
    public ResponseEntity<NewsletterResponseDTO> subscribe(@Valid @RequestBody NewsletterRequestDTO dto) {
        return ResponseEntity.ok(service.subscribe(dto));
    }

    @GetMapping
    public ResponseEntity<Page<NewsletterResponseDTO>> getAll(Pageable pageable) {
        return ResponseEntity.ok(service.getAllSubscriptions(pageable));
    }

    @DeleteMapping
    public ResponseEntity<NewsletterResponseDTO> delete(@RequestParam String email) {
        return ResponseEntity.ok(service.deleteByEmail(email));
    }
}
