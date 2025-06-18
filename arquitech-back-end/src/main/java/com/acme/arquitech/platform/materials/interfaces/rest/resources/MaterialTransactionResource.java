package com.acme.arquitech.platform.materials.interfaces.rest.resources;

public record MaterialTransactionResource(
        Long id,
        Long projectId,
        String name,
        Integer quantity,
        String provider,
        String date,
        String entryType,
        String exitType,
        String exitDate
) {
}