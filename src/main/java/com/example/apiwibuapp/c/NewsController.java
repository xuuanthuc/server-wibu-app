package com.example.apiwibuapp.c;

import com.example.apiwibuapp.m.News;
import com.example.apiwibuapp.s.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewsController {
    @Autowired
    private NewsService service;
    @GetMapping("/news")
    public List<News> list(){
        return service.listAll();
    }
}
