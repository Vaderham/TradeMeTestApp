package com.example.rharper.trademetestapp.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "categories")
public class Category {

        @SerializedName("Name")
        @Expose
        private String name;

        @PrimaryKey
        @SerializedName("Number")
        @Expose
        @NonNull
        private String  number;

        @SerializedName("Path")
        @Expose
        private String path;

        @SerializedName("Subcategories")
        @Expose
        @android.arch.persistence.room.TypeConverters(CatListConverter.class)
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

        public void setName(String name) {
                this.name = name;
        }

        public void setNumber(String number) {
                this.number = number;
        }

        public void setPath(String path) {
                this.path = path;
        }

        public void setHasClassifieds(boolean hasClassifieds) {
                this.hasClassifieds = hasClassifieds;
        }

        public void setCanHaveSecondCategory(boolean canHaveSecondCategory) {
                this.canHaveSecondCategory = canHaveSecondCategory;
        }

        public void setCanBeSecondCategory(boolean canBeSecondCategory) {
                this.canBeSecondCategory = canBeSecondCategory;
        }

        public void setLeaf(boolean leaf) {
                isLeaf = leaf;
        }

        public void setSubcategories(List<Category> subcategories) {
                this.subcategories = subcategories;
        }
}
