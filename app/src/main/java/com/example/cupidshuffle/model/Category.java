package com.example.cupidshuffle.model;

import java.util.List;

public class Category {
    private String id;
    private String name;
    private String pluralName;
    private String shortName;
    private MajorCategoryIcon icon;
    private List<Category> categories;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPluralName() {
        return pluralName;
    }

    public String getShortName() {
        return shortName;
    }

    public MajorCategoryIcon getIcon() {
        return icon;
    }

    public List<Category> getCategories() {
        return categories;
    }
}
