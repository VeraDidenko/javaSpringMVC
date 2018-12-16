package com.image.ImageProject.service;

import com.image.ImageProject.model.Tag;

import java.util.LinkedHashMap;
import java.util.List;

public interface TagService {

    List<Tag> findAll();
    LinkedHashMap<String, String> getTagsMap();
    Tag getById(Integer id);

}
