package com.example.project_ogini.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    Integer id;
    Integer userId;

    String orderStatus;

    Date orderCreatedAt;

    Integer totalPrice;

    List<OrderDetailDto> orderDetails;

    public OrderDTO(Integer id, Integer userId, String orderStatus, Date orderCreatedAt, Integer totalPrice) {
        this.id = id;
        this.userId = userId;
        this.orderStatus = orderStatus;
        this.orderCreatedAt = orderCreatedAt;
        this.totalPrice = totalPrice;
    }
}
