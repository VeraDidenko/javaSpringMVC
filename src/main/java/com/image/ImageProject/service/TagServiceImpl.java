package com.image.ImageProject.service;

import com.image.ImageProject.model.Tag;
import com.image.ImageProject.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<Tag> findAll() {
        return tagRepository.findAll();
    }

    public LinkedHashMap<String, String> getTagsMap() {

        LinkedHashMap<String, String> tagsMap = new LinkedHashMap<>();
        for (Tag tag : findAll()) {
            tagsMap.put(String.valueOf(tag.getTagID()), tag.getTagName());
        }

        return tagsMap;
    }

    @Override
    public Tag getById(Integer id){
        return tagRepository.findByTagID(id);
    }
}
