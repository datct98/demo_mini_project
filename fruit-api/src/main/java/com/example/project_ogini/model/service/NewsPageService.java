package com.example.project_ogini.model.service;

import com.example.project_ogini.model.entities.NewsPage;
import com.example.project_ogini.model.repository.NewsPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NewsPageService {

    @Autowired
    private NewsPageRepository newsPageRepository;

    public Page<NewsPage> getAllNewsPage(int pageNo, int pageSize) {
        Pageable pageable1 = PageRequest.of(pageNo, pageSize);
        return newsPageRepository.findAll(pageable1);
    }


}
