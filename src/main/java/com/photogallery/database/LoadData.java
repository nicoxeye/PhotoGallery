package com.photogallery.database;

import com.photogallery.model.Gallery;
import com.photogallery.model.Photo;
import com.photogallery.model.User;
import com.photogallery.repository.GalleryRepository;
import com.photogallery.repository.PhotoRepository;
import com.photogallery.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadData {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, GalleryRepository galleryRepository, PhotoRepository photoRepository) {

        return args -> {
            User johnDoe = new User("JohnDoe", "1234");
            userRepository.save(johnDoe);

            Gallery gallery = new Gallery("Gallery 1 JD", johnDoe);
            galleryRepository.save(gallery);

            photoRepository.save(new Photo("trees", gallery));
        };

    }

}
