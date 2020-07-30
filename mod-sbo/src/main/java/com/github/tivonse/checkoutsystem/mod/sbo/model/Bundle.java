package com.github.tivonse.checkoutsystem.mod.sbo.model;

import com.fasterxml.jackson.annotation.*;
import com.github.tivonse.checkoutsystem.mod.sbo.model.generic.EntityObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bundle")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id", scope = Bundle.class/*, resolver = ObjectIdResolver.class*/)
public class Bundle extends EntityObject {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonBackReference
    private Product product;

    @Column(name = "purchased_count")
    private int purchasedCount;

    @Column(name = "bundled_count")
    private int bundledCount;

    @Column(name = "name")
    private String description;
}
