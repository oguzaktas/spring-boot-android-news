/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oguz.springnews.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author oguz
 */
@Entity
@Table(name = "news")
public class News implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "imageURL")
    private String imageURL;
    @Column(name = "header")
    private String header;
    @Column(name = "content")
    private String content;
    @Column(name = "category")
    private String category;
    @Column(name = "publishDate")
    //Date publishDate;
    private String publishDate;
    @Column(name = "likes")
    private int likes;
    @Column(name = "dislikes")
    private int dislikes;
    @Column(name = "views")
    private int views;

    public News(int id, String imageURL, String header, String content, String category, String publishDate, int likes, int dislikes, int views) {
        this.id = id;
        this.imageURL = imageURL;
        this.header = header;
        this.content = content;
        this.category = category;
        this.publishDate = publishDate;
        this.likes = likes;
        this.dislikes = dislikes;
        this.views = views;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
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

    @Override
    public String toString() {
        return "News{" + "id=" + id + ", imageURL=" + imageURL + ", header=" + header + ", content=" + content + ", category=" + category + ", publishDate=" + publishDate + ", likes=" + likes + ", dislikes=" + dislikes + ", views=" + views + '}';
    }
    
}
