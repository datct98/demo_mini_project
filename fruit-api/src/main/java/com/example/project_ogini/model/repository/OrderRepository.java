package com.example.project_ogini.model.repository;

import com.example.project_ogini.model.dto.OrderDTO;
import com.example.project_ogini.model.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>, CrudRepository<Order, Integer> {

    @Query(value =" SELECT * FROM Orders O LEFT JOIN Oder_Detail OD ON OD.Order_Id=O.id WHERE O.User_Id = :userId AND O.Order_Status = :orderStatus ", nativeQuery = true)
    Optional<Order> findOrder(@Param("userId") Integer userId, @Param("orderStatus") String orderStatus);

    @Query(value =" SELECT new com.example.project_ogini.model.dto.OrderDTO(o.id, o.userId, o.orderStatus, o.orderCreatedAt, o.totalPrice) " +
            "FROM Order o WHERE o.userId = :userId AND o.orderStatus = :orderStatus")
    List<OrderDTO> findByUserIdAndOrderStatus(@Param("userId") Integer userId, @Param("orderStatus") String orderStatus);
}
