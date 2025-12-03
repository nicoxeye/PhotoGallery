package com.photogallery.service;

import com.photogallery.model.Photo;
import com.photogallery.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    @Override
    public List<Photo> getAllPhotos() {
        return photoRepository.findAll();
    }

}
