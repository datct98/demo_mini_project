package com.example.project_ogini.model.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name ="Oder_Detail")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OrderDetail {
    @Id
    @Column(name= "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name= "Product_Id")
    Integer productId;

    @Column(name= "Quantity")
    Integer quantity;

    @Column(name= "Order_Id")
    Integer orderId;

}
