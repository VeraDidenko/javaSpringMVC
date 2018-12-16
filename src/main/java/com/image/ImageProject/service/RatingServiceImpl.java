package com.image.ImageProject.service;

import com.image.ImageProject.model.Image;
import com.image.ImageProject.model.Rating;
import com.image.ImageProject.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepository ratingRepository;


    @Override
    public void save(Rating rating) {
        ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRatingForImage(Image image) {
        return ratingRepository.findByImage(image);
    }
}
