package com.example.project_ogini.controller;

import com.example.project_ogini.model.entities.Category;
import com.example.project_ogini.model.entities.Product;
import com.example.project_ogini.model.repository.CategoryRepository;
import com.example.project_ogini.model.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@Slf4j
public class CategoriesController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
    @GetMapping()
    public List<Category> getAllCategories(){
       return categoryRepository.findAll();
   }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
    @GetMapping ("/{categoryName}")
    public List<Category> getProductByCategoryName(@PathVariable String categoryName){
        return categoryRepository.getProductsByCategory(categoryName);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
    @GetMapping("/paginations")
    public Page<Category> getAllCategoriesPage(@RequestParam int pageNo, @RequestParam int pageSize) {
        return categoryService.getAllCategoriesAndPage(pageNo, pageSize);
    }


}
