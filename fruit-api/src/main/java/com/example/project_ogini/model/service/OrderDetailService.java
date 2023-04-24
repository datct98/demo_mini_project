package com.example.project_ogini.model.service;

import com.example.project_ogini.model.entities.OrderDetail;
import com.example.project_ogini.model.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService {
    @Autowired
    OrderDetailRepository orderDetailRepository;

}
