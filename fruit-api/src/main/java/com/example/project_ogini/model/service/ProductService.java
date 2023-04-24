package com.example.project_ogini.model.service;

import com.example.project_ogini.model.entities.Product;
import com.example.project_ogini.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class ProductService  {
    @Autowired
    private ProductRepository productRepository;

    public Page<Product> getAllProductAndPage(int pageNo, int pageSize) {
        Pageable pageable1 = PageRequest.of(pageNo, pageSize);
        return productRepository.findAll(pageable1);
    }

    public Page<Product> getProductDiscount(int pageNo, int pageSize) {
        Pageable pageable1 = PageRequest.of(pageNo, pageSize);
        return productRepository.findProductByDiscountNotNull(pageable1);
    }

    public Page<Product> getProductsByPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return productRepository.findAll(pageable);
    }

}
