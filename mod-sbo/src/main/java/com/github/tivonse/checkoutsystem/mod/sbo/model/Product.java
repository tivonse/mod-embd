package com.github.tivonse.checkoutsystem.mod.sbo.model;

import com.github.tivonse.checkoutsystem.mod.sbo.model.generic.EntityObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product extends EntityObject {
    private String name;
    private BigDecimal unitPrice;
    private String description;

    private boolean bundled;
    private List<Bundle> bundles;
    private boolean discounted;
    private List<Discount> discounts;
}
