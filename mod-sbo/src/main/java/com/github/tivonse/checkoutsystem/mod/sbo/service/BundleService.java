package com.github.tivonse.checkoutsystem.mod.sbo.service;

import com.github.tivonse.checkoutsystem.mod.sbo.model.Bundle;
import com.github.tivonse.checkoutsystem.mod.sbo.repository.BundleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BundleService {

    @Autowired
    private BundleRepository bundleRepository;

    @Autowired
    public BundleService(BundleRepository bundleRepository) {
        this.bundleRepository = bundleRepository;
    }

    public Bundle save(Bundle bundle) {
        return bundleRepository.save(bundle);
    }
}
