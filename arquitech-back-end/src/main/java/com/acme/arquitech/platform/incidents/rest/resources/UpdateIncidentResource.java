package com.acme.arquitech.platform.incidents.rest.resources;

import com.acme.arquitech.platform.incidents.domain.model.valueobjects.IncidentSeverity;
import com.acme.arquitech.platform.incidents.domain.model.valueobjects.IncidentStatus;

import java.time.LocalDate;

public record UpdateIncidentResource(
        LocalDate date,
        String incidentType,
        IncidentSeverity severity,
        IncidentStatus status,
        String description,
        String measuresTaken
) {
}