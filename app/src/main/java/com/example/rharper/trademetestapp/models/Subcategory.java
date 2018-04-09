package com.example.rharper.trademetestapp.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Subcategory {

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
    @SerializedName("AreaOfBusiness")
    @Expose
    public Integer areaOfBusiness;

}
