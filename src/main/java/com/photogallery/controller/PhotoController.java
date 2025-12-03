package com.photogallery.controller;

import com.photogallery.model.Photo;
import com.photogallery.service.PhotoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/photos")
public class PhotoController {

    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @RequestMapping("/")
    public List<Photo> getAllPhotos() {
        return photoService.getAllPhotos();
    }

}
