package com.example.project_ogini.model.repository;

import com.example.project_ogini.model.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>, CrudRepository<Product, Integer> {
    Product findProductById(Integer id);

    @Query("SELECT p FROM Product p WHERE p.productName LIKE CONCAT('%', :productName, '%')")
    List<Product> getProductsByProductName(String productName);
    Page<Product> findProductByDiscountNotNull(Pageable pageable);

    Page<Product> findAll(Pageable pageable);

    @Query(value = "SELECT * FROM Product p ORDER BY p.Review_Product DESC LIMIT 4", nativeQuery = true)
    List<Product> findTop4ProductReview();

    @Query(value = "SELECT * FROM Product p ORDER BY p.Rate_Product DESC LIMIT 4", nativeQuery = true)
    List<Product> findTop4ProductRate();

    @Query(value = "SELECT * FROM Product p ORDER BY p.Product_Created_at DESC LIMIT 4", nativeQuery = true)
    List<Product> findTop4ProductLatestAt();

    List<Product> findProductByCategoryId(Integer categoryId);

}

