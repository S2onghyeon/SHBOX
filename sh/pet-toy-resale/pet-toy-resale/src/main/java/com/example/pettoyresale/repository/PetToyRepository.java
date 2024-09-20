package com.example.pettoyresale.repository;

import com.example.pettoyresale.model.PetToy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PetToyRepository extends JpaRepository<PetToy, Long> {
    @Query("SELECT p FROM PetToy p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    List<PetToy> searchByKeyword(@Param("keyword") String keyword);
}