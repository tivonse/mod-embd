package com.github.tivonse.checkoutsystem.mod.sbo.model;

import com.github.tivonse.checkoutsystem.mod.sbo.model.generic.EntityObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product extends EntityObject {

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "description")
    private String description;

    @Column(name = "bundled")
    private boolean bundled;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Bundle> bundles;

    @Column(name = "discounted")
    private boolean discounted;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "product")
    private List<Discount> discounts;

//    @Override
//    public String toString() {
//        return String.format(
//                "Product [id=%s, unitPrice=%s, description=%s,%n" +
//                        "bundled=%b, bundles=%s,%n" +
//                        "discounted=%b, discounts=%s%n]",
//                this.getId(), unitPrice, description,
//                bundled, bundles.stream().map(b -> b.toString()).collect(Collectors.joining(",")),
//                discounted, discounts.stream().map(d -> d.toString()).collect(Collectors.joining(",")));
//    }
}
