package com.assignment.service;

import com.assignment.dto.ProjectRequestDTO;
import com.assignment.dto.ProjectResponseDTO;
import com.assignment.exception.DuplicateProjectException;
import com.assignment.exception.ResourceNotFoundException;
import com.assignment.mapper.ProjectMapper;
import com.assignment.model.Project;
import com.assignment.repository.ProjectRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectService(ProjectRepository projectRepository, ProjectMapper projectMapper){
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    // CREATE
    public ProjectResponseDTO createProject(@Valid ProjectRequestDTO dto) {

        if (projectRepository.existsByNameIgnoreCase(dto.getName())) {
            throw new DuplicateProjectException(
                    "Project with name '" + dto.getName() + "' already exists");
        }

        Project project = new Project();
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setImageUrl(dto.getImageUrl());

        Project saved = projectRepository.save(project);

        return projectMapper.toResponse(saved);
    }

    // GET ALL (Paginated)
    public Page<ProjectResponseDTO> getAllProjects(Pageable pageable) {

        return projectRepository.findAll(pageable)
                .map(projectMapper::toResponse);
    }

    // GET BY ID
    public ProjectResponseDTO getProjectById(String id) {

        Project project = projectRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Project not found with id: " + id));

        return projectMapper.toResponse(project);
    }

    // GET BY NAME
    public ProjectResponseDTO getProjectByName(String name) {

        Project project = projectRepository.findByNameIgnoreCase(name)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Project not found with name: " + name));

        return projectMapper.toResponse(project);
    }

    // UPDATE
    public ProjectResponseDTO updateProjectById(String id, @Valid ProjectRequestDTO dto) {

        Project project = projectRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Project not found with id: " + id));

        // Check duplicate name (excluding current project)
        if (!project.getName().equalsIgnoreCase(dto.getName())
                && projectRepository.existsByNameIgnoreCase(dto.getName())) {

            throw new DuplicateProjectException(
                    "Project with name '" + dto.getName() + "' already exists");
        }

        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setImageUrl(dto.getImageUrl());

        Project updated = projectRepository.save(project);

        return projectMapper.toResponse(updated);
    }

    // DELETE BY ID
    public ProjectResponseDTO deleteProjectById(String id) {

        Project project = projectRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Project not found with id: " + id));

        projectRepository.delete(project);
        return projectMapper.toResponse(project);
    }

    // DELETE BY NAME
    public ProjectResponseDTO deleteProjectByName(String name) {

        Project project = projectRepository.findByNameIgnoreCase(name)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Project not found with name: " + name));

        projectRepository.delete(project);
        return projectMapper.toResponse(project);
    }


}
