package com.photogallery.controller;

import com.photogallery.model.Gallery;
import com.photogallery.model.User;
import com.photogallery.repository.UserRepository;
import com.photogallery.service.GalleryService;
import com.photogallery.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/gallery")
public class GalleryController {

    private final GalleryService galleryService;
    private final UserService userService;

    public GalleryController(GalleryService galleryService, UserService userService) {
        this.galleryService = galleryService;
        this.userService = userService;
    }

    @RequestMapping("/")
    public List<Gallery> getAllGalleries() {
        return galleryService.getAllGalleries();
    }

    @RequestMapping("/user-gallery")
    public Gallery getGalleryByUser(Authentication authentication) {
        String login = authentication.getName();
        User user = userService.getUserByUsername(login);

        return galleryService.getGalleryByUser(user);
    }
    
}
