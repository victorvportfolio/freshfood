package com.freshfood.app.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;


@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride(
                name = "streetAddress",
                column = @Column(name = "street_address")
        ),
        @AttributeOverride(
                name = "postalCode",
                column = @Column(name = "postal_code")
        ),
        @AttributeOverride(
                name = "province",
                column = @Column(name = "province")
        ),
        @AttributeOverride(
                name = "country",
                column = @Column(name = "country")
        )
})

public final class Address {

        private String streetAddress;
        private String postalCode;
        private String province;
        private String country;

}