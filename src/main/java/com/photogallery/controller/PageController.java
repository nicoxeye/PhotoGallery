package com.photogallery.controller;

import com.photogallery.model.Gallery;
import com.photogallery.model.User;
import com.photogallery.service.GalleryService;
import com.photogallery.service.UserService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    private final GalleryService galleryService;
    private final UserService userService;

    public PageController(GalleryService galleryService, UserService userService) {
        this.galleryService = galleryService;
        this.userService = userService;
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/admin/")
    public String homeAdmin() {
        return "admin_index";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)) {
            return "redirect:/"; //to index
        }
        return "login";

    }

    @GetMapping("/gallery")
    public String getGalleryByUser(Model model, Authentication authentication) {
        String login = authentication.getName();
        User user = userService.getUserByUsername(login);
        Gallery gallery = galleryService.getGalleryByUser(user);

        model.addAttribute("user", user);
        model.addAttribute("gallery", gallery);

        return "user_gallery";
    }

}

