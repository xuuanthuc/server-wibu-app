package com.example.apiwibuapp.r;

import com.example.apiwibuapp.m.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News,Integer> {

}
