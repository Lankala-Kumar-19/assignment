package com.assignment.mapper;

import com.assignment.dto.ProjectRequestDTO;
import com.assignment.dto.ProjectResponseDTO;
import com.assignment.model.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {

    public Project toEntity(ProjectRequestDTO dto) {
        Project project = new Project();
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setImageUrl(dto.getImageUrl());
        return project;
    }

    public ProjectResponseDTO toResponse(Project project) {
        return new ProjectResponseDTO(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getImageUrl()
        );
    }
}
