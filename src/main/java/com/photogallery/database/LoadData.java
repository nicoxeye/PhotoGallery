package com.photogallery.database;

import com.photogallery.model.Gallery;
import com.photogallery.model.Photo;
import com.photogallery.model.Role;
import com.photogallery.model.User;
import com.photogallery.repository.GalleryRepository;
import com.photogallery.repository.PhotoRepository;
import com.photogallery.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class LoadData {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, GalleryRepository galleryRepository, PhotoRepository photoRepository, PasswordEncoder encoder) {

        return args -> {
            User johnDoe = new User("JohnDoe", encoder.encode("1234"), Role.ROLE_USER);
            userRepository.save(johnDoe);

            User janeDoe = new User("JaneDoe", encoder.encode("4321"), Role.ROLE_USER);
            userRepository.save(janeDoe);

            User adminTemp = new User("admin", encoder.encode("999"), Role.ROLE_ADMIN);
            userRepository.save(adminTemp);

            Gallery gallery = new Gallery("Gallery 1 JohnD", johnDoe);
            Photo photo = new Photo("trees", "trees.jpg", gallery);

            Gallery gallery2 = new Gallery("Gallery 2 JaneD", janeDoe);

            gallery.addPhoto(photo);
            galleryRepository.save(gallery);
            galleryRepository.save(gallery2);
        };

    }

}
