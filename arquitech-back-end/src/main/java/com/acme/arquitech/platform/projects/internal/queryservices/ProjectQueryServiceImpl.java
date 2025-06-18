package com.acme.arquitech.platform.projects.internal.queryservices;

import com.acme.arquitech.platform.projects.domain.model.aggregates.Project;
import com.acme.arquitech.platform.projects.domain.services.ProjectService;
import com.acme.arquitech.platform.projects.infrastructure.persistence.jpa.repositories.ProjectRepository;
import com.acme.arquitech.platform.users.domain.model.valueobjects.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectQueryServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectQueryServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> findByUserIdAndRole(Long userId, Role role) {
        return projectRepository.findByUserIdAndRole(userId, role);
    }
}