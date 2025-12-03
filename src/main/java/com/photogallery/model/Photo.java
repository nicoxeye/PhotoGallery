package com.photogallery.model;

import jakarta.persistence.*;

@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String path;
    // Many Photos To One Gallery
    @ManyToOne
    @JoinColumn(name = "gallery_id")
    private Gallery gallery;

    public Photo() {

    }

    public Photo(String name, String path, Gallery gallery) {
        this.name = name;
        this.path = path;
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Gallery getGallery() {
        return gallery;
    }

    public void setGallery(Gallery gallery) {
        this.gallery = gallery;
    }


    @Override
    public String toString() {
        return "Photo {" + "id=" + this.id + ", gallery name='" + this.gallery.getName() + '}';
    }
}
