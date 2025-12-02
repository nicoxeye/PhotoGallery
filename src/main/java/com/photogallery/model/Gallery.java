package com.photogallery.model;

import jakarta.persistence.*;

@Entity
public class Gallery {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @OneToOne
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
