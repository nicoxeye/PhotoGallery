package com.photogallery.repository;

import com.photogallery.model.Gallery;
import com.photogallery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {
    public Gallery getGalleryByUser(User user);
}
