package com.example.apiwibuapp.s;

import com.example.apiwibuapp.m.WallpaperItem;

import java.util.List;

public interface IWallPaperService {
    List<WallpaperItem> getByType(String type);
}
