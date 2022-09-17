package com.freshfood.app.entities.sandwich;

import com.freshfood.app.enums.Bread;
import com.freshfood.app.enums.Meat;
import com.freshfood.app.enums.Sauce;
import com.freshfood.app.enums.Vegetable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SandwichConfiguration {
    @Bean
    CommandLineRunner sandwichinitializer(SandwichRepository sandwichRepository)
    {
        return args -> {
            sandwichRepository.saveAll(List.of(
                    Sandwich.builder()
                            .name("BLT")
                            .bread(Bread.WHITE)
                            .meat(Meat.BACON)
                            .vegetables(List.of(Vegetable.LETTUCE,Vegetable.TOMATO))
                            .sauce(Sauce.BBQ)
                            .price(7D)
                            .build(),

                    Sandwich.builder()
                            .name("ColdMeat")
                            .bread(Bread.WHOLE_WHEAT)
                            .meat(Meat.HAM)
                            .vegetable(Vegetable.TOMATO)
                            .sauce(Sauce.MAYO)
                            .price(10D)
                            .build(),

                    Sandwich.builder()
                            .name("Salami")
                            .bread(Bread.PARMISAN)
                            .meat(Meat.SALAMI)
                            .vegetables(List.of(Vegetable.LETTUCE,Vegetable.TOMATO,Vegetable.OLIVE))
                            .sauce(Sauce.BBQ)
                            .price(8.90D)
                            .build(),

                    Sandwich.builder()
                            .name("Meat Ball")
                            .bread(Bread.MULTIGRAIN)
                            .meat(Meat.MEATBALL)
                            .sauce(Sauce.KETCHUP)
                            .price(12.99D)
                            .build(),

                    Sandwich.builder()
                            .name("Steak")
                            .bread(Bread.GLUTEN_FREE)
                            .meat(Meat.STEAK)
                            .vegetable(Vegetable.TOMATO)
                            .sauce(Sauce.BBQ)
                            .price(14.99D)
                            .build()
                    )
            );
        };
    }
}
