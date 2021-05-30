package com.example.apiwibuapp.r;


import com.example.apiwibuapp.m.WallpaperItem;
import com.example.apiwibuapp.m.WallpaperSize;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class WallpaperRepository extends BaseRepository{
    String[] columns = new String[]{
            "id", "type", "contentType", "downloadCount", "title", "tags", "authorId",
            "authorName", "authorAvatarUrl", "shareUrl", "thumbUrl", "downloadReference", "size", "licenseType","previewUrl", "wallpaperSize"
    };

//    public List<News> getAll() {
//        List<News> newsList = new ArrayList<>();
//        appDatabase.connect(connection -> {
//            try {
//                Statement statement = connection.createStatement();
//                String query = String.format("SELECT * FROM %s ORDER BY id DESC"  , appStorage.config.database.table.news);
//                System.out.println(query);
//                System.out.println(appStorage.config.database.table.news);
//                ResultSet resultSet = statement.executeQuery(query);
//                while (resultSet.next()) {
//                    News news = new News();
//                    Type listGenre = new TypeToken<List<Genre>>() {}.getType();
//                    news.id = resultSet.getInt("id");
//                    news.type = resultSet.getInt("type");
//                    news.title = resultSet.getString("title");
//                    news.description = resultSet.getString("description");
//                    news.commentsCount = resultSet.getInt("commentsCount");
//                    news.views = resultSet.getInt("views");
//                    news.hasVideos = resultSet.getBoolean("hasVideos");
//                    news.isFeatured = resultSet.getBoolean("isFeatured");
//                    news.slug = resultSet.getString("slug");
//                    news.thumbnail = resultSet.getString("thumbnail");
//                    news.publishedAt = resultSet.getString("publishedAt");
//                    news.content = resultSet.getString("content");
//                    news.genre = gson.fromJson(resultSet.getString("genre") , Genre.class);
//                    news.thumbnailSmall = resultSet.getString("thumbnailSmall");
//                    newsList.add(news);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//        return newsList;
//    }
    public List<WallpaperItem> getByType(String type) {
        List<WallpaperItem> wallpaperItemList = new ArrayList<>();
        appDatabase.connect(connection -> {
            try {
                Statement statement = connection.createStatement();
                String query = String.format("SELECT * FROM %s WHERE type = " + type + " ORDER By downloadCount DESC", appStorage.config.database.table.wallpaper);
                System.out.println(query);
                System.out.println(appStorage.config.database.table.wallpaper);
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    WallpaperItem wallpaperItem = new WallpaperItem();
                    Type listSize = new TypeToken<List<WallpaperSize>>() {}.getType();
                    wallpaperItem.id = resultSet.getString("id");
                    wallpaperItem.type = resultSet.getInt("type");
                    wallpaperItem.contentType = resultSet.getString("contentType");
                    wallpaperItem.downloadCount = resultSet.getLong("downloadCount");
                    wallpaperItem.title = resultSet.getString("title");
                    wallpaperItem.tags = Collections.singletonList(resultSet.getString("tags"));
                    wallpaperItem.authorId = resultSet.getString("authorId");
                    wallpaperItem.authorName = resultSet.getString("authorName");
                    wallpaperItem.authorAvatarUrl = resultSet.getString("authorAvatarUrl");
                    wallpaperItem.shareUrl = resultSet.getString("shareUrl");
                    wallpaperItem.thumbUrl = resultSet.getString("thumbUrl");
                    wallpaperItem.downloadReference = resultSet.getString("downloadReference");
                    wallpaperItem.size = resultSet.getLong("size");
                    wallpaperItem.licenseType = resultSet.getLong("licenseType");
                    wallpaperItem.previewUrl = resultSet.getString("previewUrl");
                    wallpaperItem.wallpaperSize = gson.fromJson(resultSet.getString("wallpaperSize") , WallpaperSize.class);
                    wallpaperItemList.add(wallpaperItem);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return wallpaperItemList;
    }
}
