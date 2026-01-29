package com.assignment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProjectResponseDTO {

    private String id;
    private String name;
    private String description;
    private String imageUrl;
}
