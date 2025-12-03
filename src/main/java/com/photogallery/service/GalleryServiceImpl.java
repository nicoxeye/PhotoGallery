package com.photogallery.service;

import com.photogallery.model.Gallery;
import com.photogallery.model.User;
import com.photogallery.repository.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

}
