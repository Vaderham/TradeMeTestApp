package com.example.rharper.trademetestapp;

import com.example.rharper.trademetestapp.models.Category;

import org.w3c.dom.Node;

import java.util.ArrayList;

public class CategoryTreeParser {
    public ArrayList<Category> originalList;
    public ArrayList<Category> parsedList;

    public CategoryTreeParser(ArrayList<Category> originalList) {
        this.originalList = originalList;
    }

    public void allocateParentsToNodes(ArrayList<Category> originalList){

    }
}
