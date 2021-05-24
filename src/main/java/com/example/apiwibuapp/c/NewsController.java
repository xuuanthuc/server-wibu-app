package com.example.apiwibuapp.c;

import com.example.apiwibuapp.m.News;
import com.example.apiwibuapp.s.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    @Autowired
    private INewsService service;


    @GetMapping("")
    public ResponseEntity getNewslist(){
        List<News> newsList = service.getAll();
        return ResponseEntity.ok(newsList);
    }
}
