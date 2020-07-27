package com.github.tivonse.checkoutsystem.mod.sbo.model;

import com.github.tivonse.checkoutsystem.mod.sbo.model.generic.EntityObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Discount extends EntityObject {
    private String name;
    private BigDecimal rate;
    private boolean valid;
}
