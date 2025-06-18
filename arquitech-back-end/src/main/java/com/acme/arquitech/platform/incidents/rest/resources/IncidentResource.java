package com.acme.arquitech.platform.incidents.rest.resources;

import com.acme.arquitech.platform.incidents.domain.model.valueobjects.IncidentSeverity;
import com.acme.arquitech.platform.incidents.domain.model.valueobjects.IncidentStatus;

import java.time.LocalDate;
import java.util.Date;

public record IncidentResource(
        Long id,
        LocalDate date,
        String incidentType,
        IncidentSeverity severity,
        IncidentStatus status,
        String description,
        String measuresTaken,
        Long projectId,
        Date createdAt,
        Date updatedAt
) {
}