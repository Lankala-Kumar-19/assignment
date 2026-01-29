package com.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClientResponseDTO {

    private String id;
    private String name;
    private String description;
    private String designation;
    private String imageUrl;
}
