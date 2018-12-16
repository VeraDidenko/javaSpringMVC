package com.image.ImageProject.controller;

import com.image.ImageProject.model.Account;
import com.image.ImageProject.model.Image;
import com.image.ImageProject.model.Rating;
import com.image.ImageProject.service.AccountService;
import com.image.ImageProject.service.ImageService;
import com.image.ImageProject.service.RatingService;
import com.image.ImageProject.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@Controller
public class ImageController {

    @Autowired
    private ImageService imageService;

    @Autowired
    private TagService tagService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private RatingService ratingService;

    @RequestMapping(value = "/createNew", method = RequestMethod.GET)
    public String createNewStory(Model model) {
        model.addAttribute("imageForm", new Image());
        model.addAttribute("options", tagService.getTagsMap());
        return "createImage";
    }


    @RequestMapping(value = "/createNew", method = RequestMethod.POST)
    public String saveNewStory(@Valid @ModelAttribute("imageForm") Image imageForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            return "createImage";
        }

        imageService.save(imageForm);

        return "redirect:saved";
    }

    @RequestMapping(value = "/viewAll", method = RequestMethod.GET)
    public String viewAllImage(Model model) {

        List<Image> allImage = imageService.getAllImage();

        if (!allImage.isEmpty()) {
            model.addAttribute("elements", allImage);
        } else {
            model.addAttribute("notFound", "Nothing was found!");
        }
        model.addAttribute("options", tagService.findAll());

        return "commonImage";
    }

    @RequestMapping(value = "/saved", method = RequestMethod.GET)
    public String login(Model model) {
        return "savedSuccessfully";
    }

    @RequestMapping(value = "/filterImage", method = RequestMethod.GET)
    public String filterImage(@RequestParam(value = "author", required = false) String author, @RequestParam(value = "tag", required = false) String tag, Model model) {

        List<Image> allImage = imageService.filterImage(author, tag);

        model.addAttribute("elements", allImage);
        model.addAttribute("options", tagService.findAll());

        return "commonImage";
    }

    @RequestMapping(value = "/showOne", method = RequestMethod.GET)
    public String showOneImage(@RequestParam("imageID") String imageId, Model model) {

        Image image = imageService.findById(Integer.valueOf(imageId));

        List<Rating> allImageRating = ratingService.getAllRatingForImage(image);
        Collections.reverse(allImageRating);
        model.addAttribute("image", image);
        model.addAttribute("ratings", allImageRating);

        return "oneImageView";
    }

    @RequestMapping(value = "/addRating", method = RequestMethod.POST)
    public String addRating(@RequestParam(value = "mark", required = false) String mark, @RequestParam(value = "ratingText", required = false) String ratingText, @RequestParam(value = "imageID", required = false) String imageID, @RequestParam(value = "login", required = false) String login, Model model) {

        Image image = imageService.findById(Integer.valueOf(imageID));
        model.addAttribute("image", image);

        if (StringUtils.isEmpty(mark) || StringUtils.isEmpty(ratingText) || StringUtils.isEmpty(login)) {
            model.addAttribute("error", "Fields can't be empty");
            return "oneImageView";
        }

        Account account = accountService.findByLogin(login);

        if (account == null) {
            model.addAttribute("error", "Account with such login doesn't exist");
            return "oneImageView";
        }

        Rating rating = new Rating();
        rating.setMark(Integer.valueOf(mark));
        rating.setRatingComment(ratingText);
        rating.setAccount(account);
        rating.setImage(image);

        ratingService.save(rating);

        List<Rating> allImageRating = ratingService.getAllRatingForImage(image);
        Collections.reverse(allImageRating);
        model.addAttribute("ratings", allImageRating);

        return "oneImageView";
    }

}
