package com.image.ImageProject.repository;

import com.image.ImageProject.model.Image;
import com.image.ImageProject.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

    List<Rating> findByImage(Image image);

}
