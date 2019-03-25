package com.ttn.assignment.Services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "ClassConfigurationService", description = "Service Configuration")
//Creating configurable properties
public @interface ClassConfigurationService {
    //    Declare properties that you would like to configure via @AttributeDefinition
    @AttributeDefinition(name = "isClassLimitReached")
    int classLimit() default 30;

    @AttributeDefinition(name = "passingMarks")
    int passingMarks() default 40;
}
