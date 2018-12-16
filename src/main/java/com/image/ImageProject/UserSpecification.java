package com.image.ImageProject;

import com.image.ImageProject.model.Image;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class UserSpecification implements Specification<Image> {

    private SearchCriteria criteria;

    public UserSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate
            (Root<Image> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        if (criteria.getKey().equals("author") && !StringUtils.isEmpty(criteria.getValue())) {
            String author = ((String) criteria.getValue()).toLowerCase();
            return builder.equal(builder.lower(root.get(criteria.getKey())), author);
        }

        if (criteria.getKey().equals("tag") && criteria.getValue() != null) {
            if (root.get("tags") != null) {
                return builder.isMember(criteria.getValue(), root.get("tags"));
            }
        }
        return null;
    }
}
