package com.image.ImageProject.repository;

import com.image.ImageProject.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ImageRepository extends JpaRepository<Image, Integer>, JpaSpecificationExecutor<Image> {

    Image findByImageID(Integer imageID);
}
