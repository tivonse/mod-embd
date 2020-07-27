package com.github.tivonse.checkoutsystem.mod.sbo.model;

import com.github.tivonse.checkoutsystem.mod.sbo.model.generic.EntityObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Bundle extends EntityObject {
    private Product product;
    private int quantity;
    private String name;
}
