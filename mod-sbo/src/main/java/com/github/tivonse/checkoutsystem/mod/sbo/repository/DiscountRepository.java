package com.github.tivonse.checkoutsystem.mod.sbo.repository;

import com.github.tivonse.checkoutsystem.mod.sbo.model.Discount;
import com.github.tivonse.checkoutsystem.mod.sbo.repository.generic.EntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountRepository extends EntityRepository<Discount> {
}
