package com.example.project_ogini.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name ="Product")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})

public class Product implements Serializable {
    @Id
    @Column(name= "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name= "Product_Name")
    String productName;

    @Column(name= "Product_Price_In")
    Integer productPriceIn;

    @Column(name= "Product_Price_Out")
    Integer productPriceOut;

    @Column(name= "Product_Image")
    String productImage;

    @Column(name= "Product_Description")
    String productDescription;

    @Column(name= "Product_Information")
    String productInformation;

    @Column(name= "Discount")
    Integer discount;

    @Column(name= "Product_Created_at")
    Date productCreatedAt;

    @Column(name= "Rate_Product")
    String rateProduct;

    @Column(name= "Review_Product")
    String reviewProduct;

    @Column(name= "Product_Status")
    String productStatus;

    @Column(name = "Category_Id")
    Integer categoryId;


}
