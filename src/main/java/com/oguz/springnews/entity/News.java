
package com.oguz.springnews.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Yazilim Laboratuvari II Proje 2
 * @author Oguz Aktas & Mert Var
 */
@Entity
@Table(name = "news")
public class News implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "imageurl")
    private String imageurl;
    @Column(name = "header")
    private String header;
    @Column(name = "content")
    private String content;
    @Column(name = "category")
    private String category;
    @Column(name = "publish_date")
    //Date publishDate;
    private Date publish_date;
    @Column(name = "likes")
    private int likes;
    @Column(name = "dislikes")
    private int dislikes;
    @Column(name = "views")
    private int views;

    public News(Long id, String imageurl, String header, String content, String category, Date publish_date, int likes, int dislikes, int views) {
        this.id = id;
        this.imageurl = imageurl;
        this.header = header;
        this.content = content;
        this.category = category;
        this.publish_date = publish_date;
        this.likes = likes;
        this.dislikes = dislikes;
        this.views = views;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageURL(String imageurl) {
        this.imageurl = imageurl;
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

    public Date getPublishDate() {
        return publish_date;
    }

    public void setPublishDate(Date publish_date) {
        this.publish_date = publish_date;
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
        return "News{" + "id=" + id + ", imageURL=" + imageurl + ", header=" + header + ", content=" + content + ", category=" + category + ", publishDate=" + publish_date + ", likes=" + likes + ", dislikes=" + dislikes + ", views=" + views + '}';
    }
    
}
