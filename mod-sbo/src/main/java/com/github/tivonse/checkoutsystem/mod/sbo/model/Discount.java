package com.github.tivonse.checkoutsystem.mod.sbo.model;

import com.fasterxml.jackson.annotation.*;
import com.github.tivonse.checkoutsystem.mod.sbo.model.generic.EntityObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "discount")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Discount.class/*, resolver = ObjectIdResolver.class*/)
public class Discount extends EntityObject {

    @Column(name = "purchased_count")
    private int purchasedCount;

    @Column(name = "nth")
    private int nth;

    @Column(name = "rate")
    private BigDecimal rate;

    @Column(name = "effective")
    private boolean effective;

}
