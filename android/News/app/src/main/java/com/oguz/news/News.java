package com.oguz.news;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class News {

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("category")
    @Expose
    private String category;

    @SerializedName("header")
    @Expose
    private String header;

    @SerializedName("content")
    @Expose
    private String content;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("imageurl")
    @Expose
    private String urlToImage;

    @SerializedName("publishDate")
    @Expose
    private String publishedAt;

    @SerializedName("likes")
    @Expose
    private String likes;

    @SerializedName("dislikes")
    @Expose
    private String dislikes;

    @SerializedName("views")
    @Expose
    private String views;

    public News(String id, String category, String header, String content, String url, String urlToImage, String publishedAt, String likes, String dislikes, String views) {
        this.id = id;
        this.category = category;
        this.header = header;
        this.content = content;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.likes = likes;
        this.dislikes = dislikes;
        this.views = views;
    }

    public News(String id, String category, String header, String content, String urlToImage, String publishedAt, String likes, String dislikes, String views) {
        this.id = id;
        this.category = category;
        this.header = header;
        this.content = content;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
        this.likes = likes;
        this.dislikes = dislikes;
        this.views = views;
    }

    public News() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getDislikes() {
        return dislikes;
    }

    public void setDislikes(String dislikes) {
        this.dislikes = dislikes;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

}
