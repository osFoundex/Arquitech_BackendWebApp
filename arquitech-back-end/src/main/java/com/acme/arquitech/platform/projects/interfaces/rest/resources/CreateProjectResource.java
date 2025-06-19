package com.acme.arquitech.platform.projects.interfaces.rest.resources;
import com.acme.arquitech.platform.projects.domain.model.valueobjects.ProjectStatus;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
public record CreateProjectResource(
        @NotBlank String name,
        @NotNull @FutureOrPresent LocalDate startDate,
        @NotNull @Future LocalDate endDate,
        @NotNull @DecimalMin("0.00") BigDecimal budget,
        @NotNull ProjectStatus status,
        @NotNull @Positive Long userId,
        @NotNull @Positive Long contractorId,
        String imageUrl) {
}