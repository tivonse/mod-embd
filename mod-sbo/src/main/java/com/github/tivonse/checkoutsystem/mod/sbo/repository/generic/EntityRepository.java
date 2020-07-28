package com.github.tivonse.checkoutsystem.mod.sbo.repository.generic;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface EntityRepository<T> extends CrudRepository<T, UUID> {
}
