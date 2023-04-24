package com.example.project_ogini.controller;

import com.example.project_ogini.model.dto.OrderDTO;
import com.example.project_ogini.model.dto.OrderDetailDto;
import com.example.project_ogini.model.entities.Order;
import com.example.project_ogini.model.entities.Product;
import com.example.project_ogini.model.entities.User;
import com.example.project_ogini.model.repository.OrderDetailRepository;
import com.example.project_ogini.model.repository.OrderRepository;
import com.example.project_ogini.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

@RestController
@RequestMapping(value = "/order")
@Slf4j

public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private JWTUtil jwtUtil;

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
    @GetMapping()
    public List<Order> getAllOrder(){
        return orderRepository.findAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
    @GetMapping("{id}")
    public Optional<Order> getOne(@PathVariable Integer id){
        return orderRepository.findById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
    @GetMapping("/find")
    public List<OrderDTO> findByUserIdAndOrderStatus(@RequestHeader (name="Authorization") String token,@RequestParam String orderStatus){
        Integer userId = jwtUtil.getUserByIdfromJWT(token.replace("Bearer ",""));
        List<OrderDTO> orderDTOs = orderRepository.findByUserIdAndOrderStatus(userId, orderStatus);
        orderDTOs.stream().map(orderDTO ->  {
            List<OrderDetailDto> orderDetails = orderDetailRepository.findByOrderId(orderDTO.getId());
            orderDTO.setOrderDetails(orderDetails);
            return orderDTO;
        }).collect(Collectors.toList());
        return orderDTOs;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.POST)
    @PostMapping()
    public Order insertOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }


}
