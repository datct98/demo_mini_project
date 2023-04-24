package com.example.project_ogini.model.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name ="News_Page")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NewsPage {
    @Id
    @Column(name= "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name= "News_Title")
    String newsTitle;

    @Column(name= "News_Content")
    String newsContent;

    @Column(name= "News_Description")
    String newsDescription;

    @Column(name= "News_Image")
    String newsImage;

    @Column(name= "News_Creat_At")
    Date newsCreatAt;

    @Column(name= "News_Status")
    Boolean newsStatus;
}
