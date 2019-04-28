package com.oguz.newsapp2;

import java.sql.Date;

/**
 * Yazilim Laboratuvari II Proje 2
 * @author Oguz Aktas & Mert Var
 */
public class Model {

    private String header;
    private String content;
    private String category;
    private String imageurl;
    private int likes;
    private int dislikes;
    private int views;
    private Date publishDate;

    public Model(String header, String content, String category, String imageurl, int likes, int dislikes, int views, Date publishDate) {
        this.header = header;
        this.content = content;
        this.category = category;
        this.imageurl = imageurl;
        this.likes = likes;
        this.dislikes = dislikes;
        this.views = views;
        this.publishDate = publishDate;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

}