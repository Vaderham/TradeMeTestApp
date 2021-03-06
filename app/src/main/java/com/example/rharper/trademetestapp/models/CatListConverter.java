package com.example.rharper.trademetestapp.models;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

    public class CatListConverter {

        @TypeConverter
        public static List<Category> fromString(String value) {
            Type listType = new TypeToken<List<Category>>() {}.getType();
            return new Gson().fromJson(value, listType);
        }

        @TypeConverter
        public static String fromList(List<Category> list) {
            Gson gson = new Gson();
            String json = gson.toJson(list);
            return json;
        }
    }
