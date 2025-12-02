package com.photogallery.model;

import jakarta.persistence.*;

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

    @Override
    public String toString() {
        return "Gallery {" + "id=" + this.id + ", name='" + this.name + ", user login='" + this.user.getLogin() + '}';
    }

}
