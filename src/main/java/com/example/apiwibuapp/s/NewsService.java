package com.example.apiwibuapp.s;

import com.example.apiwibuapp.m.News;
import com.example.apiwibuapp.r.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NewsService implements  INewsService{

    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<News> getAll(){
        return newsRepository.getAll();
    }

    @Override
    public List<News> getByType(String type) {
        return newsRepository.getByType(type);
    }

}
