package com.acme.arquitech.platform.materials.interfaces.rest.resources;

public record UpdateMaterialResource(
        Integer quantity,
        String exitDate
) {
}