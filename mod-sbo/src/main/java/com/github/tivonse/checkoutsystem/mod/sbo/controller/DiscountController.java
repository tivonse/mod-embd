package com.github.tivonse.checkoutsystem.mod.sbo.controller;

import com.github.tivonse.checkoutsystem.mod.sbo.controller.generic.EntityController;
import com.github.tivonse.checkoutsystem.mod.sbo.model.Discount;
import com.github.tivonse.checkoutsystem.mod.sbo.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiscountController extends EntityController<Discount> {

    @Autowired
    private DiscountService discountService;

    @PostMapping(value = "/discounts")
    public ResponseEntity<Discount> createDiscount(@RequestBody Discount discount) {
        return new ResponseEntity<>(discountService.save(discount), HttpStatus.CREATED);
    }

}
