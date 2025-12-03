package com.photogallery.apicontroller;

import com.photogallery.model.User;
import com.photogallery.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //@PreAuthorize("hasRole('ADMIN')") <- cool way to authorize
    @RequestMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
