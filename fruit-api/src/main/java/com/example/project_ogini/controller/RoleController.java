package com.example.project_ogini.controller;

import com.example.project_ogini.model.entities.Role;
import com.example.project_ogini.model.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
@Slf4j

public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
    @GetMapping()
    public List<Role> getAllRole(){
        return roleRepository.findAll();
    }


}
