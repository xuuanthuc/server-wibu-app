package com.example.apiwibuapp;

public class news {
    private Integer id;
    private Integer commentsCount;
    private String content;
    private String description;
    private Integer type;
    private Integer views;
    private String title;
    private String thumbnail;
    private String publishedAt;
    private String genre;

    public news() {
    }

    public news(Integer id, Integer commentsCount, String content, String description, Integer type, Integer views, String title, String thumbnail, String publishedAt, String genre) {
        this.id = id;
        this.commentsCount = commentsCount;
        this.content = content;
        this.description = description;
        this.type = type;
        this.views = views;
        this.title = title;
        this.thumbnail = thumbnail;
        this.publishedAt = publishedAt;
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
