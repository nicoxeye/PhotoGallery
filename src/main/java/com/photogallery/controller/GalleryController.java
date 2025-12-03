package com.photogallery.controller;

import com.photogallery.model.Gallery;
import com.photogallery.service.GalleryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/gallery")
public class GalleryController {

    private final GalleryService galleryService;

    public GalleryController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    @RequestMapping("/")
    public List<Gallery> getGallery() {
        return galleryService.getAllGalleries();
    }
    
}
