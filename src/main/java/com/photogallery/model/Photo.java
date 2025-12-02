package com.photogallery.model;

import jakarta.persistence.*;

@Entity
public class Photo {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "gallery_id")
    private Gallery gallery;

    public Photo() {

    }

    public Photo(String name, Gallery gallery) {
        this.name = name;
        this.gallery = gallery;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gallery getGallery() {
        return gallery;
    }

    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }
}
