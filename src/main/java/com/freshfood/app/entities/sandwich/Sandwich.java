package com.freshfood.app.entities.sandwich;

import com.freshfood.app.enums.Bread;
import com.freshfood.app.enums.Meat;
import com.freshfood.app.enums.Sauce;
import com.freshfood.app.enums.Vegetable;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
public class Sandwich {
    @Id
    @SequenceGenerator(name = "sandwich_sequence", sequenceName = "sandwich_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "sandwich_sequence")
    @Column(updatable = false)
    private Integer id;
    @Column(name = "sandwich_column")
    private String name;
    @Enumerated(value=EnumType.STRING)
    private Bread bread;
    @ElementCollection
    @Singular
    @CollectionTable(name="sandwich_meats",joinColumns = @JoinColumn(name="id"))
    @Enumerated(value=EnumType.STRING)
    private Set<Meat> meats;
    @ElementCollection
    @Singular
    @CollectionTable(name="sandwich_vegetables",joinColumns = @JoinColumn(name="id"))
    @Enumerated(value=EnumType.STRING)
    private Set<Vegetable> vegetables;
    @ElementCollection
    @Singular
    @CollectionTable(name="sandwich_sauces",joinColumns = @JoinColumn(name="id"))
    @Enumerated(value=EnumType.STRING)
    private Set<Sauce> sauces;
    private Double price;


}
