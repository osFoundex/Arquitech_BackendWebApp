package com.acme.arquitech.platform.projects.domain.services;

import com.acme.arquitech.platform.projects.domain.model.aggregates.Project;
import com.acme.arquitech.platform.users.domain.model.valueobjects.Role;

import java.util.List;

public interface ProjectQueryService {
    List<Project> findByUserIdAndRole(Long userId, Role role);
}