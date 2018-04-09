package com.example.rharper.trademetestapp.models;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class Category {

        @SerializedName("Name")
        @Expose
        public String name;
        @SerializedName("Number")
        @Expose
        public String number;
        @SerializedName("Path")
        @Expose
        public String path;
        @SerializedName("Subcategories")
        @Expose
        public List<Subcategory> subcategories = null;
        @SerializedName("CanHaveSecondCategory")
        @Expose
        public Boolean canHaveSecondCategory;
        @SerializedName("CanBeSecondCategory")
        @Expose
        public Boolean canBeSecondCategory;
        @SerializedName("IsLeaf")
        @Expose
        public Boolean isLeaf;

        public String getName() {
            return name;
        }

        public String getNumber() {
            return number;
        }

        public String getPath() {
            return path;
        }

        public List<Subcategory> getSubcategories() {
            return subcategories;
        }

        public Boolean getCanHaveSecondCategory() {
            return canHaveSecondCategory;
        }

        public Boolean getCanBeSecondCategory() {
            return canBeSecondCategory;
        }

        public Boolean getLeaf() {
            return isLeaf;
        }

        @Override
        public String toString() {
            return "Category{" +
                    "name='" + name + '\'' +
                    ", number='" + number + '\'' +
                    ", path='" + path + '\'' +
                    ", subcategories=" + subcategories +
                    ", canHaveSecondCategory=" + canHaveSecondCategory +
                    ", canBeSecondCategory=" + canBeSecondCategory +
                    ", isLeaf=" + isLeaf +
                    '}';
        }
    }
