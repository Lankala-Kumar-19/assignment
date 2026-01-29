package com.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NewsletterResponseDTO {
    private String id;
    private String email;
}
