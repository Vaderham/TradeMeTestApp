package com.example.rharper.trademetestapp;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.example.rharper.trademetestapp.models.CatListConverter;
import com.example.rharper.trademetestapp.models.Category;
import com.example.rharper.trademetestapp.models.CategoryRequestHeader;

@Database(entities = {Category.class}, version = 1)
@TypeConverters({CatListConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract DbDao dbDao();
}
