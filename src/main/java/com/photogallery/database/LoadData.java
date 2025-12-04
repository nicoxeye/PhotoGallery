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
            User janeAusten = new User("JaneAusten", encoder.encode("1234"), Role.ROLE_USER);
            userRepository.save(janeAusten);

            User anneRice = new User("AnneRice", encoder.encode("1234"), Role.ROLE_USER);
            userRepository.save(anneRice);

            User adminTemp = new User("admin", encoder.encode("999"), Role.ROLE_ADMIN);
            userRepository.save(adminTemp);

            Gallery galleryJA = new Gallery("Jane Austen Nature", janeAusten);
            Photo photo = new Photo("trees.jpg", "uploads/trees.jpg", galleryJA);
            Photo photo2 = new Photo("sunflowers.jpg", "uploads/sunflowers.jpg", galleryJA);

            Gallery galleryAR = new Gallery("Anne Rice's Dog", anneRice);
            Photo photo3 = new Photo("sillydog.jpg", "uploads/sillydog.jpg", galleryAR);

            galleryJA.addPhoto(photo);
            galleryJA.addPhoto(photo2);
            galleryAR.addPhoto(photo3);

            galleryRepository.save(galleryJA);
            galleryRepository.save(galleryAR);
        };

    }

}
