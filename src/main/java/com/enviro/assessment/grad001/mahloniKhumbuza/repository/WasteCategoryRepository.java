package com.enviro.assessment.grad001.mahloniKhumbuza.repository;

import com.enviro.assessment.grad001.mahloniKhumbuza.entity.WasteCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WasteCategoryRepository extends JpaRepository<WasteCategory, Long> {

    Optional<WasteCategory> findByName(String name);
}
