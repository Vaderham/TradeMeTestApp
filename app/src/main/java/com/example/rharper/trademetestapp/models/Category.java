package com.example.rharper.trademetestapp.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


    public class Category {

        @SerializedName("Name")
        @Expose
        private String name;
        @SerializedName("Number")
        @Expose
        private String number;
        @SerializedName("Path")
        @Expose
        private String path;
        @SerializedName("Subcategories")
        @Expose
        private List<Category> subcategories = null;
        @SerializedName("HasClassifieds")
        @Expose
        private boolean hasClassifieds;
        @SerializedName("CanHaveSecondCategory")
        @Expose
        private boolean canHaveSecondCategory;
        @SerializedName("CanBeSecondCategory")
        @Expose
        private boolean canBeSecondCategory;
        @SerializedName("IsLeaf")
        @Expose
        private boolean isLeaf;

        public String getName() {
            return name;
        }

        public String getNumber() {
            return number;
        }

        public String getPath() {
            return path;
        }

        public List<Category> getSubcategories() {
            return subcategories;
        }

        public boolean isHasClassifieds() {
            return hasClassifieds;
        }

        public boolean isCanHaveSecondCategory() {
            return canHaveSecondCategory;
        }

        public boolean isCanBeSecondCategory() {
            return canBeSecondCategory;
        }

        public boolean isIsLeaf() {
            return isLeaf;
        }

    }
