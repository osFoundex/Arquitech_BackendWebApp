package com.acme.arquitech.platform.materials.interfaces.rest.resources;

import java.math.BigDecimal;

public record CreateMaterialResource(
        Long projectId,
        String name,
        Integer quantity,
        BigDecimal unitPrice,
        String unit,
        String provider,
        String providerRuc,
        String date,
        String receiptNumber,
        String paymentMethod,
        String entryType
) {
}