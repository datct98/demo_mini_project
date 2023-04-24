package com.example.project_ogini.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name ="User")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})

public class User {
    @Id
    @Column(name= "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name= "username")
    String username;

    @Column(name= "password")
    String password;

    @Column(name= "phone")
    String phone;

    @Column(name= "address")
    String address;

    @Column(name= "email")
    String email;

    @Column(name= "created_at")
    String createdAt;

    @Column(name= "Value_Id")
    Integer valueId;

    }
