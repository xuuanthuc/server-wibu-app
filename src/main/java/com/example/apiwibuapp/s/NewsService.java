package com.example.apiwibuapp.s;

import com.example.apiwibuapp.m.News;
import com.example.apiwibuapp.r.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepo;
    public List<News> listAll(){
        return newsRepo.findAll();
    }
    public void save(News news){
        newsRepo.save(news);
    }
    public News get(Integer id){
        return newsRepo.findById(id).get();
    }
    public void delete(Integer id){
        newsRepo.deleteById(id);
    }
}
