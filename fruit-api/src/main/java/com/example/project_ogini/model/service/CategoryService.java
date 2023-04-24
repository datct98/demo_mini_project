package com.example.project_ogini.model.service;

import com.example.project_ogini.model.entities.Category;
import com.example.project_ogini.model.entities.Product;
import com.example.project_ogini.model.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public Page<Category> getAllCategoriesAndPage(int pageNo, int pageSize) {
        Pageable pageable1 = PageRequest.of(pageNo, pageSize);
        return categoryRepository.findAll(pageable1);
    }



}
