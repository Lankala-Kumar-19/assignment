package com.assignment.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClientRequestDTO {

    @NotBlank(message = "Client name is required")
    private String name;

    @NotBlank(message = "Client description is required")
    private String description;

    @NotBlank(message = "Client designation is required")
    private String designation;

    @NotBlank(message = "Client image URL is required")
    private String imageUrl;
}
