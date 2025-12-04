package com.photogallery.controller;

import com.photogallery.model.Gallery;
import com.photogallery.model.Photo;
import com.photogallery.model.Role;
import com.photogallery.model.User;
import com.photogallery.service.GalleryService;
import com.photogallery.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class PageController {

    private final GalleryService galleryService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public PageController(GalleryService galleryService, UserService userService, PasswordEncoder passwordEncoder) {
        this.galleryService = galleryService;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)) {
            return "redirect:/"; //to index
        }
        return "login";
    }

    @GetMapping("/success")
    public String redirectionAfterLogin(HttpServletRequest request, HttpServletResponse response, Authentication authResult) {
        String login = authResult.getName();

        User user = userService.getUserByUsername(login);

        if (user.getRole().toString().equals("ROLE_ADMIN")) {
            return "redirect:/admin/";
        }
        return "redirect:/";
    }

    // ADMIN PAGES ------

    // users

    @GetMapping("/admin/")
    public String homeAdmin() {
        return "admin/admin_index";
    }

    @GetMapping("/admin/users")
    public String manageUsers() {
        return "admin/admin_users";
    }

    @GetMapping("/admin/users/create")
    public String createFormUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());

        return "admin/admin_createuser";
    }

    @PostMapping("/admin/users/create")
    public String createUser(@ModelAttribute User user) {
        // debug
        System.out.println("Login: " + user.getLogin());
        System.out.println("Password: " + user.getPassword());
        System.out.println("Role: " + user.getRole());

        userService.saveUser(user, passwordEncoder);

        // if user creation completed return to the previous page
        return "redirect:/admin/users";
    }

    // galleries

    @GetMapping("/admin/galleries")
    public String manageGalleries(Model model) {
        return "admin/admin_galleries";
    }

    @GetMapping("/admin/galleries/create")
    public String createFormGallery(Model model) {
        Gallery gallery = new Gallery();
        model.addAttribute("gallery", gallery);

        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "admin/admin_creategallery";
    }

    @PostMapping("/admin/galleries/create")
    public String createGallery(@ModelAttribute Gallery gallery, @ModelAttribute("userId") Long userId) {
        System.out.println("Gallery name: " + gallery.getName());
        System.out.println("User ID from form: " + userId);

        User user = userService.getUserById(userId);
        gallery.setUser(user);

        galleryService.saveGallery(gallery);

        return "redirect:/admin/galleries";
    }

    @GetMapping("/admin/galleries/addphotos")
    public String addFormPhotos(Model model) {
        List<Gallery> galleries = galleryService.getAllGalleries();
        model.addAttribute("galleries", galleries);

        return "admin/admin_addphotostogallery";
    }

    public static String UPLOAD_DIRECTORY = "uploads";

    @PostMapping("/admin/galleries/addphotos")
    public String addPhoto(@RequestParam Long galleryId, Model model, @RequestParam("image") MultipartFile file) throws IOException {

        // getting the path to upload the photo to
        Path uploadPath = Paths.get(UPLOAD_DIRECTORY);
        // create if doesnt exist
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String originalFilename = file.getOriginalFilename();
        assert originalFilename != null;
        Path filePath = uploadPath.resolve(originalFilename);
        Files.write(filePath, file.getBytes());

        // getting the chosen gallery
        Gallery gallery = galleryService.getGalleryById(galleryId);

        Photo photo = new Photo(originalFilename, "uploads/" + originalFilename, gallery);

        // saving the photo to gallery uploads it to the database
        galleryService.addPhotoToGallery(gallery, photo);

        return "redirect:/admin/galleries";
    }

    // USER PAGES ------
    @GetMapping("/gallery")
    public String getGalleryByUser(Model model, Authentication authentication) {
        String login = authentication.getName();
        User user = userService.getUserByUsername(login);
        Gallery gallery = galleryService.getGalleryByUser(user);

        model.addAttribute("user", user);
        model.addAttribute("gallery", gallery);

        return "user_gallery";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

}

