package com.example.apiwibuapp.s;


import com.example.apiwibuapp.m.WallpaperItem;
import com.example.apiwibuapp.r.WallpaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WallpaperService implements  IWallPaperService{

    @Autowired
    private WallpaperRepository wallpaperRepository;

    @Override
    public List<WallpaperItem> getByType(String type) {
        return wallpaperRepository.getByType(type);
    }

}
