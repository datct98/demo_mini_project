package com.example.project_ogini.model.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="Orders")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    @Id
    @Column(name= "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name= "User_id")
    Integer userId;

    @Column(name= "Order_Status")
    String orderStatus;

    @Column(name= "Order_Created_at")
    Date orderCreatedAt;

    @Column(name= "Total_Price")
    Integer totalPrice;



}
