package com.example.apiwibuapp.c;

import com.example.apiwibuapp.m.WallpaperItem;
import com.example.apiwibuapp.s.IWallPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/wallpaper")
public class WallpaperController {
    @Autowired
    private IWallPaperService service;

    //
//    @GetMapping("")
//    public ResponseEntity getNewslist(){
//        List<News> newsList = service.getAll();
//        return ResponseEntity.ok(newsList);
//    }
    @GetMapping("")
    public ResponseEntity getTypeWallpaper(@RequestParam("type") String type){
        List<WallpaperItem> wallpaperItemList = service.getByType(type);
        return ResponseEntity.ok(wallpaperItemList);
    }

}
