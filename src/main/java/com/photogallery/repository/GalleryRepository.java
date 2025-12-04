package com.photogallery.repository;

import com.photogallery.model.Gallery;
import com.photogallery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {
    public Gallery getGalleryByUser(User user);

    // how many galleries a user has
    @Query("SELECT COUNT(g) FROM Gallery g WHERE g.user = :user")
    int getGalleryCountByUser(@Param("user") User user);
}
