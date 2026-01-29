package com.assignment.mapper;

import com.assignment.dto.NewsletterRequestDTO;
import com.assignment.dto.NewsletterResponseDTO;
import com.assignment.model.Newsletter;
import org.springframework.stereotype.Component;

@Component
public class NewsletterMapper {

    public Newsletter toEntity(NewsletterRequestDTO dto) {
        Newsletter newsletter = new Newsletter();
        newsletter.setEmail(dto.getEmail());
        return newsletter;
    }

    public NewsletterResponseDTO toResponse(Newsletter newsletter) {
        return new NewsletterResponseDTO(
                newsletter.getId(),
                newsletter.getEmail()
        );
    }
}
