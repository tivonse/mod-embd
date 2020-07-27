package com.github.tivonse.checkoutsystem.mod.sbo.repository.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface EntityRepository<T> extends JpaRepository<T, UUID> {
}
