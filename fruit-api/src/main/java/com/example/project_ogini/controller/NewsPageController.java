package com.example.project_ogini.controller;

import com.example.project_ogini.model.entities.NewsPage;
import com.example.project_ogini.model.repository.NewsPageRepository;
import com.example.project_ogini.model.service.NewsPageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/newsPage")
@Slf4j

public class NewsPageController {
    @Autowired
    private NewsPageRepository newsPageRepository;

    @Autowired
    private NewsPageService newsPageService;

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
    @GetMapping()
    public List<NewsPage> getAllNewsPage(){
        return newsPageRepository.findAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
    @GetMapping("/paginations")
    public Page<NewsPage> getAllNewsPage(@RequestParam int pageNo, @RequestParam int pageSize) {
        return newsPageService.getAllNewsPage(pageNo, pageSize);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*", methods = RequestMethod.GET)
    @GetMapping("/{id}")
    public NewsPage getNewsPageById(@PathVariable Integer id) {
        return newsPageRepository.findNewsPageById(id);
    }





}
