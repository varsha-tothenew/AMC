package com.core.mywork.multifieldPractice;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

import javax.inject.Inject;

@Model(adaptables = Resource.class)
public class CardBeanModel2 {

    @Inject
    @Optional
    public String title;

    @Inject
    @Optional
    public String text;

    @Inject
    @Optional
    public String image;


    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getImage() {
        return image;
    }

}
