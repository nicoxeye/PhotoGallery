package com.photogallery.service;

import com.photogallery.model.Gallery;
import com.photogallery.model.Photo;
import com.photogallery.model.User;

import java.util.List;

public interface GalleryService {
    public abstract List<Gallery> getAllGalleries();

    public abstract Gallery getGalleryByUser(User user);

    public abstract void saveGallery(Gallery gallery);

    public abstract void addPhotoToGallery(Gallery gallery, Photo photo);

    Gallery getGalleryById(Long galleryId);
}