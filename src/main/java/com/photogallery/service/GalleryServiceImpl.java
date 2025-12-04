package com.photogallery.service;

import com.photogallery.model.Gallery;
import com.photogallery.model.User;
import com.photogallery.repository.GalleryRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalleryServiceImpl implements GalleryService {

    @Autowired
    private GalleryRepository galleryRepository;

    public List<Gallery> getAllGalleries() {
        return galleryRepository.findAll();
    }

    @Override
    public Gallery getGalleryByUser(User user) {
        return galleryRepository.getGalleryByUser(user);
    }

    @Override
    public void saveGallery(Gallery gallery) {

        if (gallery.getUser() == null) {
            throw new IllegalArgumentException("gallery user is null");
        }

        int count = galleryRepository.getGalleryCountByUser(gallery.getUser());

        if (count == 0) {
            galleryRepository.save(gallery);
        } else {
            System.out.println("Gallery already exists for user: " + gallery.getUser().getLogin());
        }

    }

}
