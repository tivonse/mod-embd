package com.github.tivonse.checkoutsystem.mod.sbo.model;

import com.fasterxml.jackson.annotation.*;
import com.github.tivonse.checkoutsystem.mod.sbo.model.generic.EntityObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Product.class/*, resolver = ObjectIdResolver.class*/)
public class Product extends EntityObject {

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "description")
    private String description;

    @Column(name = "bundlable")
    private boolean bundlable;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
//    @JsonManagedReference
//    private Set<Bundle> bundles = new HashSet<>();

    @Column(name = "discountable")
    private boolean discountable;

    @OneToOne
    @JoinColumn(name = "discount_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Discount discount;

}
