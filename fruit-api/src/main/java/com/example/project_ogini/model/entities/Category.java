package com.example.project_ogini.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="Categories")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
//@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})

public class Category {
    @Id
    @Column(name= "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name= "Category_Name")
    String categoryName;

    @Column(name= "Category_Image")
    String categoryImage;

}

