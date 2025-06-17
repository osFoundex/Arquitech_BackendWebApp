package com.acme.arquitech.platform.projects.interfaces.rest;

import com.acme.arquitech.platform.projects.internal.queryservices.ProjectQueryServiceImpl;
import com.acme.arquitech.platform.projects.domain.model.aggregates.Project;
import com.acme.arquitech.platform.projects.interfaces.rest.resources.ProjectResource;
import com.acme.arquitech.platform.shared.interfaces.rest.resources.MessageResource;
import com.acme.arquitech.platform.users.domain.model.valueobjects.Role;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/projects")
@Tag(name = "Projects", description = "Project Management Endpoints")
public class ProjectController {
    private final ProjectQueryServiceImpl projectQueryService;

    public ProjectController(ProjectQueryServiceImpl projectQueryService) {
        this.projectQueryService = projectQueryService;
    }

    @GetMapping("/supervisor/{userId}")
    public ResponseEntity<?> getProjectsBySupervisor(@PathVariable Long userId) {
        List<Project> projects = projectQueryService.findByUserIdAndRole(userId, Role.SUPERVISOR);
        if (projects.isEmpty()) {
            return ResponseEntity.ok(new MessageResource("No projects registered for this supervisor"));
        }
        List<ProjectResource> resources = projects.stream()
                .map(project -> new ProjectResource(
                        project.getId(),
                        project.getName(),
                        project.getStartDate(),
                        project.getEndDate(),
                        project.getBudget(),
                        project.getStatus(),
                        project.getUser().getId(),
                        project.getContractor().getId(),
                        project.getImageUrl()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(resources);
    }
}