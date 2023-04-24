package com.example.project_ogini.controller;

import com.example.project_ogini.model.entities.Product;

import com.example.project_ogini.model.entities.User;
import com.example.project_ogini.model.repository.ProductRepository;
import com.example.project_ogini.model.service.ProductService;
import com.example.project_ogini.model.service.UserService;
import com.example.project_ogini.util.JWTUtil;
import com.example.project_ogini.util.RoleName;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/product")
@Slf4j
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @Autowired
    private JWTUtil jwtUtil;

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
    @GetMapping()
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
    @GetMapping("/paginations")
    public  Page<Product> getAllProductPage( @RequestParam int pageNo, @RequestParam int pageSize) {
        return productService.getAllProductAndPage(pageNo, pageSize);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
    @GetMapping("/discount")
    public  Page<Product> getAllProductDiscount(@RequestParam int pageNo, @RequestParam int pageSize) {
        return productService.getProductDiscount(pageNo, pageSize);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productRepository.findProductById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.POST)
    @PostMapping
    public Product creatProduct(@RequestHeader (name="Authorization") String token,@RequestBody Product product) {
        Integer userId = jwtUtil.getUserByIdfromJWT(token.replace("Bearer ",""));
        User user= userService.getUserById(userId);
        System.out.println("user: "+ user.getValueId());
        try {
            if(user.getValueId() == 2) {
                return productRepository.save(product);
            } else {
                throw new Exception("Admin moi co the them san pham");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.PUT)
    @PutMapping
    public Product updateProduct(@RequestBody Product p) {
        return productRepository.save(p);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.DELETE)
    @DeleteMapping("{id}")
    public Product deleteProduct(@PathVariable("id") Integer id) {
        Product p = productRepository.findProductById(id);
        if (p != null) {
            productRepository.deleteById(id);
            System.out.println("Da xoa thanh cong");
        }
        return null;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
    @GetMapping("/name/{productName}")
    public ResponseEntity<List<Product>> getProductByName(@PathVariable String productName){
        return ResponseEntity.ok().body(productRepository.getProductsByProductName(productName));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
    @GetMapping("/reviewsProduct")
    public ResponseEntity<List<Product>> getProductByReviewProduct(){
        return ResponseEntity.ok().body(productRepository.findTop4ProductReview());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
    @GetMapping("/rateProduct")
    public ResponseEntity<List<Product>> getProductByRateProduct(){
        return ResponseEntity.ok().body(productRepository.findTop4ProductRate());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
    @GetMapping("/latestProduct")
    public ResponseEntity<List<Product>> getProductByLatestProduct(){
        return ResponseEntity.ok().body(productRepository.findTop4ProductLatestAt());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
    @GetMapping("/nameCate/{categoryId}")
    public ResponseEntity<List<Product>> getProductByCategoryID(@PathVariable Integer categoryId){
        return ResponseEntity.ok().body(productRepository.findProductByCategoryId(categoryId));
    }



}
