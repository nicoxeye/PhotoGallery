package com.photogallery.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // many galleries to one user i think,,
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //cascade = ALL -> gallery saves all photos automatically
    //orphanRemoval = true -> removing photos deletes them from DB
    @OneToMany(mappedBy = "gallery", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Photo> photos = new ArrayList<Photo>();

    public Gallery() {

    }

    public Gallery(String name, User user) {
        this.name = name;
        this.user = user;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public void addPhoto(Photo photo) {
        photos.add(photo);
    }

    @Override
    public String toString() {
        return "Gallery {" + "id=" + this.id + ", name='" + this.name + ", user login='" + this.user.getLogin() + '}';
    }

}
