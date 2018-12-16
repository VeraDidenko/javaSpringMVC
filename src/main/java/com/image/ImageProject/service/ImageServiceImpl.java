package com.image.ImageProject.service;

import com.image.ImageProject.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository ImageRepository;

    @Autowired
    private TagService tagService;

    @Override
    public void save(Image Image) {
        ImageRepository.save(Image);
    }

    @Override
    public List<Image> getAllImage() {
        return ImageRepository.findAll();
    }

    @Override
    public Image findById(Integer id) {
        return ImageRepository.findByImageID(id);
    }

    @Override
    public List<Image> filterImage(String author, String tag) {

        Tag tagOb = tagService.getById(Integer.valueOf(tag));

        UserSpecification spec1 = new UserSpecification(new SearchCriteria("author", author));
        UserSpecification spec2 = new UserSpecification(new SearchCriteria("tag", tagOb));

        return ImageRepository.findAll(spec2.and(spec1));
    }


}
