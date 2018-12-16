package com.image.ImageProject.service;

import com.image.ImageProject.model.Image;
import java.util.List;

public interface ImageService {

    void save(Image content);
    List<Image> getAllImage();
    Image findById(Integer id);
    List<Image> filterImage(String author, String tag);

}
