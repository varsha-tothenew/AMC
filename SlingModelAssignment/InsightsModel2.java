package com.core.mywork.multifieldPractice;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;
import java.util.List;

@Model(adaptables = Resource.class)
public class InsightsModel2 {


    @Inject
    @Optional
    public List<CardBeanModel2> cards;


    public List<CardBeanModel2> getCards() {
        return cards;
    }
}


