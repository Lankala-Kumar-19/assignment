package com.assignment.mapper;

import com.assignment.dto.ContactFormRequestDTO;
import com.assignment.dto.ContactFormResponseDTO;
import com.assignment.model.ContactForm;
import org.springframework.stereotype.Component;

@Component
public class ContactFormMapper {

    public ContactForm toEntity(ContactFormRequestDTO dto) {
        ContactForm form = new ContactForm();
        form.setFullName(dto.getFullName());
        form.setEmail(dto.getEmail());
        form.setMobileNumber(dto.getMobileNumber());
        form.setCity(dto.getCity());
        return form;
    }

    public ContactFormResponseDTO toResponse(ContactForm form) {
        return new ContactFormResponseDTO(
                form.getId(),
                form.getFullName(),
                form.getEmail(),
                form.getMobileNumber(),
                form.getCity()
        );
    }
}
