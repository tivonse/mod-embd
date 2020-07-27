package com.github.tivonse.checkoutsystem.mod.sbo.repository;

import com.github.tivonse.checkoutsystem.mod.sbo.model.Product;
import com.github.tivonse.checkoutsystem.mod.sbo.repository.generic.EntityRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends EntityRepository<Product> {
}
