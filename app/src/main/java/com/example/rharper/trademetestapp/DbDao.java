package com.example.rharper.trademetestapp;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;

import com.example.rharper.trademetestapp.models.Category;
import com.example.rharper.trademetestapp.models.CategoryRequestHeader;

import java.util.List;

import retrofit2.http.Query;

@Dao
public interface DbDao {

    @android.arch.persistence.room.Query("SELECT * FROM category_request_header")
    CategoryRequestHeader getHeader();

    @Insert
    void insertNewHeader(CategoryRequestHeader categoryResponseHeader);

    @android.arch.persistence.room.Query("DELETE FROM category_request_header")
    void deleteOldHeader();

    @android.arch.persistence.room.Query("DELETE FROM CATEGORIES")
    void deleteCategoryTree();

    @Insert
    void insertNewCategoryTree(List<Category> categories);
}
