package com.acme.arquitech.platform.machinery.application.internal.commandservices;

import com.acme.arquitech.platform.machinery.domain.model.aggregates.Machinery;
import com.acme.arquitech.platform.machinery.domain.service.MachineryService;
import com.acme.arquitech.platform.machinery.infrastructure.persistence.jpa.repositories.MachineryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MachineryCommandServiceImpl implements MachineryService {

    private final MachineryRepository machineryRepository;

    public MachineryCommandServiceImpl(MachineryRepository machineryRepository) {
        this.machineryRepository = machineryRepository;
    }

    @Override
    public Machinery create(Machinery machinery) {
        machineryRepository.findByLicensePlate(machinery.getLicensePlate())
                .ifPresent(m -> {
                    throw new IllegalArgumentException("Machinery with license plate " + machinery.getLicensePlate() + " already exists");
                });
        return machineryRepository.save(machinery);
    }

    @Override
    public Optional<Machinery> getById(Long id) {
        return machineryRepository.findById(id);
    }

    @Override
    public List<Machinery> getAll() {
        return machineryRepository.findAll();
    }
}