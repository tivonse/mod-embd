package com.github.tivonse.checkoutsystem.mod.sbo.model.generic;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

@MappedSuperclass
public abstract class EntityObject implements Serializable {
    @Id
    @GeneratedValue
    private UUID id;
}
