package com.image.ImageProject.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Image")
public class Image {

    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imageID;

    @Column(name = "author")
    @NotBlank(message = "Author can't be empty")
    private String author;

    @Column(name = "description")
    private String description;

    @Column(name = "image_name")
    @NotBlank(message = "Image name can't be empty")
    private String imageName;

    //TODO define image object type
    @Column(name = "image")
    @NotBlank(message = "Image can't be empty")
    private String image;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private List<Rating> ratingList;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="content_genre",
            joinColumns = @JoinColumn(name="content_fk"),
            inverseJoinColumns = @JoinColumn(name = "genre_fk")
    )
    private List<Tag> tags;


    public Integer getImageID() {
        return imageID;
    }

    public void setImageID(Integer imageID) {
        this.imageID = imageID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void add(Rating rating) {

        if (ratingList == null) {
            ratingList = new ArrayList<>();
        }

        ratingList.add(rating);
    }

    public void add(Tag tag) {

        if (tags == null) {
            tags = new ArrayList<>();
        }

        tags.add(tag);
    }

}
