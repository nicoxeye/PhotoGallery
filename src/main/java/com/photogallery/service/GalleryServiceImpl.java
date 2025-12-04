package com.photogallery.service;

import com.photogallery.model.Gallery;
import com.photogallery.model.Photo;
import com.photogallery.model.User;
import com.photogallery.repository.GalleryRepository;
import com.photogallery.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalleryServiceImpl implements GalleryService {

    @Autowired
    private GalleryRepository galleryRepository;
    @Autowired
    private PhotoRepository photoRepository;

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

    @Override
    public void addPhotoToGallery(Gallery gallery, Photo photo) {
        photoRepository.save(photo);
        gallery.addPhoto(photo);
        galleryRepository.save(gallery);
    }

    @Override
    public Gallery getGalleryById(Long galleryId) {
        return galleryRepository.findById(galleryId).orElseThrow();
    }

}
