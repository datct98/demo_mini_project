package com.example.project_ogini.model.repository;

import com.example.project_ogini.model.entities.OrderDetail;
import com.example.project_ogini.model.dto.OrderDetailDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
     @Query(value =" SELECT new com.example.project_ogini.model.dto.OrderDetailDto(OD.id, P.productName,P.productImage,P.productPriceOut, OD.quantity, OD.orderId)" +
      " FROM OrderDetail OD" +
             " JOIN Product P ON P.id = OD.productId" +
             " WHERE OD.orderId = :orderId")
     List<OrderDetailDto> findByOrderId(Integer orderId);


}
