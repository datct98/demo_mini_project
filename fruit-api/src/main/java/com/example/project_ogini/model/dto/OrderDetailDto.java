package com.example.project_ogini.model.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class OrderDetailDto {
    Integer id;
    String productName;

    String productImage;

    Integer productPriceOut;
    Integer quantity;
    Integer orderId;

    public OrderDetailDto(Integer id,  String productName,String productImage, Integer productPriceOut, Integer quantity, Integer orderId) {
        this.id = id;
        this.productName = productName;
        this.productImage= productImage;
        this.productPriceOut = productPriceOut;
        this.quantity = quantity;
        this.orderId = orderId;
    }
}
