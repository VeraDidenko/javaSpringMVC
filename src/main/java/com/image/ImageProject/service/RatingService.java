package com.image.ImageProject.service;

import com.image.ImageProject.model.Image;
import com.image.ImageProject.model.Rating;

import java.util.List;

public interface RatingService {

    void save(Rating rating);
    List<Rating> getAllRatingForImage(Image image);

}
