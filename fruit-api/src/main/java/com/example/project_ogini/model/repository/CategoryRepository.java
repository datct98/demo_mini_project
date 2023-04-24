package com.example.project_ogini.model.repository;

import com.example.project_ogini.model.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Page<Category> findAll(Pageable pageable);

    @Query("SELECT p FROM Category p WHERE p.categoryName LIKE CONCAT('%', :categoryName, '%')")
    List<Category> getProductsByCategory(String categoryName);



}
