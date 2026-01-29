package com.assignment.controller;

import com.assignment.dto.ProjectRequestDTO;
import com.assignment.dto.ProjectResponseDTO;
import com.assignment.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    // Create Project (Admin)
    @PostMapping
    public ResponseEntity<ProjectResponseDTO> createProject(
            @Valid @RequestBody ProjectRequestDTO dto) {

        return ResponseEntity.ok(projectService.createProject(dto));
    }

    // Get All Projects (Landing Page + Admin)
    @GetMapping
    public ResponseEntity<Page<ProjectResponseDTO>> getAllProjects(Pageable pageable) {

        return ResponseEntity.ok(projectService.getAllProjects(pageable));
    }

    // Get Project By ID (Optional but clean)
    @GetMapping("/id/{id}")
    public ResponseEntity<ProjectResponseDTO> getProjectById(
            @PathVariable String id) {

        return ResponseEntity.ok(projectService.getProjectById(id));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ProjectResponseDTO> getProjectByName(
            @PathVariable String name) {

        return ResponseEntity.ok(projectService.getProjectByName(name));
    }

    // Update Project (Admin)
    @PutMapping("/update/{id}")
    public ResponseEntity<ProjectResponseDTO> updateProjectById(
            @PathVariable String id,
            @Valid @RequestBody ProjectRequestDTO dto) {

        return ResponseEntity.ok(projectService.updateProjectById(id, dto));
    }

    // Delete Project (Admin)
    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<ProjectResponseDTO> deleteProjectById(
            @PathVariable String id) {

        return ResponseEntity.ok(projectService.deleteProjectById(id));
    }

    @DeleteMapping("/delete/name/{name}")
    public ResponseEntity<ProjectResponseDTO> deleteProjectByName(
            @PathVariable String name) {

        return ResponseEntity.ok(projectService.deleteProjectByName(name));
    }
}
