package com.freshfood.app.entities.sandwich;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SandwichRepository extends JpaRepository<Sandwich,Integer> {
}
