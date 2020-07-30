package com.github.tivonse.checkoutsystem.mod.sbo.service;

import com.github.tivonse.checkoutsystem.mod.sbo.model.Discount;
import com.github.tivonse.checkoutsystem.mod.sbo.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    @Autowired
    private DiscountRepository discountRepository;

    @Autowired
    public DiscountService(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    public Discount save(Discount discount) {
        return discountRepository.save(discount);
    }

}
