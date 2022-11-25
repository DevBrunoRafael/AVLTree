package com.devbrunorafael;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

public class Publication {

    private Integer id;
    private String author;
    private String description;
    private Object media;
    private LocalDateTime createdAt;

    public Publication(Integer id, String author, String description, Object media) {
        this.id = id;
        this.author = author;
        this.description = description;
        this.media = media;
        this.createdAt = LocalDateTime.now();
    }

    public Publication() {
        super();
    }

    public Publication(Integer id, String author, String description, Object media, LocalDateTime createdAt) {
        this.id = id;
        this.author = author;
        this.description = description;
        this.media = media;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getMedia() {
        return media;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
