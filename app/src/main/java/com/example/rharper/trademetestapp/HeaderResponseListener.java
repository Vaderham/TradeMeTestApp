package com.example.rharper.trademetestapp;


import com.example.rharper.trademetestapp.models.Category;
import com.example.rharper.trademetestapp.models.CategoryRequestHeader;

import java.util.List;

public interface HeaderResponseListener {
    void headerResponseCallback(List<Category> list);
}
