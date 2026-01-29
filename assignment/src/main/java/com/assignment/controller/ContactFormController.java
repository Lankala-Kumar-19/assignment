package com.assignment.controller;

import com.assignment.dto.ContactFormRequestDTO;
import com.assignment.dto.ContactFormResponseDTO;
import com.assignment.service.ContactFormService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact-forms")
public class ContactFormController {

    private final ContactFormService service;

    public ContactFormController(ContactFormService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ContactFormResponseDTO> createContactForm(
            @Valid @RequestBody ContactFormRequestDTO dto) {
        return ResponseEntity.ok(service.createContactForm(dto));
    }

    @GetMapping
    public ResponseEntity<Page<ContactFormResponseDTO>> getAllContactForms(Pageable pageable) {
        return ResponseEntity.ok(service.getAllContactForms(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactFormResponseDTO> getContactFormById(@PathVariable String id) {
        return ResponseEntity.ok(service.getContactFormById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ContactFormResponseDTO> deleteContactFormById(@PathVariable String id) {
        return ResponseEntity.ok(service.deleteContactFormById(id));
    }
}
