package com.devbrunorafael;

import java.time.LocalDateTime;

public class Publication {

    private LocalDateTime createdAt;
    private String author;
    private String description;
    private Object media;

    public Publication(String author, String description, Object media) {
        this.author = author;
        this.description = description;
        this.media = media;
        this.createdAt = LocalDateTime.now();
    }

    public Publication() {
        super();
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
