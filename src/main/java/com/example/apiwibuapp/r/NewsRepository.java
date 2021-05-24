package com.example.apiwibuapp.r;

import com.example.apiwibuapp.m.Genre;
import com.example.apiwibuapp.m.News;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NewsRepository extends BaseRepository{
    String[] columns = new String[]{
            "id" , "type" , "title" , "description" , "commentsCount" , "views" , "hasVideos" ,
            "isFeatured" , "slug" , "thumbnail" , "publishedAt" ,"content", "genre" , "thumbnailSmall",
    };

    public List<News> getAll() {
        List<News> newsList = new ArrayList<>();
        appDatabase.connect(connection -> {
            try {
                Statement statement = connection.createStatement();
                String query = String.format("SELECT * FROM %s" , appStorage.config.database.table.news);
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    News news = new News();
                    Type listGenre = new TypeToken<List<Genre>>() {}.getType();
                    news.id = resultSet.getInt("id");
                    news.type = resultSet.getInt("type");
                    news.title = resultSet.getString("title");
                    news.description = resultSet.getString("description");
                    news.commentsCount = resultSet.getInt("commentsCount");
                    news.views = resultSet.getInt("views");
                    news.hasVideos = resultSet.getBoolean("hasVideos");
                    news.isFeatured = resultSet.getBoolean("isFeatured");
                    news.slug = resultSet.getString("slug");
                    news.thumbnail = resultSet.getString("thumbnail");
                    news.publishedAt = resultSet.getString("publishedAt");
                    news.content = resultSet.getString("content");
                    news.genre = gson.fromJson(resultSet.getString("genre") , listGenre);
                    news.thumbnailSmall = resultSet.getString("thumbnailSmall");


                    newsList.add(news);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return newsList;
    }
}
