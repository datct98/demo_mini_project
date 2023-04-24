package com.example.project_ogini.controller;


import com.example.project_ogini.model.entities.Order;
import com.example.project_ogini.model.entities.OrderDetail;
import com.example.project_ogini.model.dto.OrderDetailDto;
import com.example.project_ogini.model.entities.Product;
import com.example.project_ogini.model.repository.OrderDetailRepository;
import com.example.project_ogini.model.repository.OrderRepository;
import com.example.project_ogini.model.repository.ProductRepository;
import com.example.project_ogini.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orderDetail")
@Slf4j

public class OrderDetailController {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private JWTUtil jwtUtil;

    @Autowired
    private OrderRepository orderRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
    @GetMapping()
    public List<OrderDetail> getAllOrderItem(@RequestHeader (name="Authorization") String token){
        System.out.println("token: "+token);
        Integer userId = jwtUtil.getUserByIdfromJWT(token.replace("Bearer ",""));
        return orderDetailRepository.findAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.POST)
    @PostMapping()
    public OrderDetail insertOrderDetail(@RequestHeader (name="Authorization") String token, @RequestBody OrderDetail orderDetail){
        System.out.println("token123 :" +token);
        Integer userId = jwtUtil.getUserByIdfromJWT(token.replace("Bearer ",""));
        System.out.println("userID :" +userId);

        // step1: find trong table Order xem co Order cua userId = xxx khong
        // step2: khong -> tao moi mot Order voi userId = xxx -> tao OrderDetail
        //        co -> lay duoc Order -> tao them OrderDetail
        Product product = productRepository.findProductById(orderDetail.getProductId());

        Optional<Order> order = orderRepository.findOrder(userId, "WAITING");
        if(order.isPresent()) {
            orderDetail.setOrderId(order.get().getId());
            order.get().setTotalPrice(order.get().getTotalPrice() + product.getProductPriceOut()*orderDetail.getQuantity());
            orderRepository.save(order.get());
        } else {
            Order newOrder = new Order();
            newOrder.setUserId(userId);
            newOrder.setOrderStatus("WAITING");
            newOrder.setTotalPrice(product.getProductPriceOut()*orderDetail.getQuantity());
            newOrder = orderRepository.save(newOrder);
            orderDetail.setOrderId(newOrder.getId());
        }
        return orderDetailRepository.save(orderDetail);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.PATCH)
    @PatchMapping
    public OrderDetail upDateOrderDetail(@RequestBody OrderDetail orderDetail){
        return  orderDetailRepository.save(orderDetail);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
    @GetMapping("/{orderId}")
    public List<OrderDetailDto> getOrderDetail(@PathVariable Integer orderId) {
        System.out.println("orderId: "+ orderId);
        return orderDetailRepository.findByOrderId(orderId);
    }

}
