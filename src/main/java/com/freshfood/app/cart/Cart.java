package com.freshfood.app.cart;
import com.freshfood.app.entities.sandwich.Sandwich;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
public class Cart {

    @Id
    @SequenceGenerator(name = "cart_sequence", sequenceName = "cart_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "cart_sequence")
    @Column(updatable = false)

    private Integer id;
   /* @Embedded
    private Address address;
   */
   @Singular
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "cart_sandwiches",
            joinColumns = @JoinColumn(name = "cart", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "sandwich", referencedColumnName = "id")
    )
    private List<Sandwich> sandwiches;
   @Builder.Default
    private Double Price=0D;
}
