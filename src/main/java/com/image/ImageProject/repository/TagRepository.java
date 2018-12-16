package com.image.ImageProject.repository;

import com.image.ImageProject.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
    Tag findByTagID(Integer genreID);
}
