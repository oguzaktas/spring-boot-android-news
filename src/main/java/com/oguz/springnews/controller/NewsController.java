/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oguz.springnews.controller;

import com.oguz.springnews.entity.News;
import com.oguz.springnews.repository.NewsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author oguz
 */
@RestController
@RequestMapping("/rest/news")
public class NewsController {
    
    private final NewsRepository newsRepository;
    
    @Autowired
    public NewsController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }
    
    @GetMapping
    public List<News> listNews() {
        return newsRepository.findAll();
    }
    
    @PostMapping(value = "/load")
    public List<News> persist(@RequestBody final News news) {
        newsRepository.save(news);
        return newsRepository.findAll();
    }
}
