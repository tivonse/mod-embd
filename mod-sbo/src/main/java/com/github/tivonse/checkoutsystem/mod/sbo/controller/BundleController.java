package com.github.tivonse.checkoutsystem.mod.sbo.controller;

import com.github.tivonse.checkoutsystem.mod.sbo.controller.generic.EntityController;
import com.github.tivonse.checkoutsystem.mod.sbo.model.Bundle;
import com.github.tivonse.checkoutsystem.mod.sbo.service.BundleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BundleController extends EntityController<Bundle> {

    @Autowired
    private BundleService bundleService;

    @PostMapping(value = "/bundles")
    public ResponseEntity<Bundle> createBundle(@RequestBody Bundle bundle) {
        return new ResponseEntity<>(bundleService.save(bundle), HttpStatus.CREATED);
    }
}
