package com.example.project_ogini.model.repository;

import com.example.project_ogini.model.entities.Category;
import com.example.project_ogini.model.entities.NewsPage;
import com.example.project_ogini.model.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsPageRepository extends JpaRepository<NewsPage, Integer> {

    Page<NewsPage> findAll(Pageable pageable);

    NewsPage findNewsPageById( Integer id);



}
