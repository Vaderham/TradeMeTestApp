package com.example.rharper.trademetestapp;

import android.util.Log;
import com.example.rharper.trademetestapp.models.Category;
import java.util.ArrayList;
import java.util.List;

public class CategoryNavigator {

    private ArrayList<List<Category>> history = new ArrayList<>();
    private String currentCatId;

    public CategoryNavigator(ArrayList<Category> Tree) {
        history.clear();
        history.add(Tree);
    }

    public List<Category> moveUp(int position){
        List<Category> newList;
        if (history.get(history.size() -1).get(position).isIsLeaf()){
            Log.v("This is a leaf! ", "Yes.");
            return history.get(history.size() -1);
            // TODO: change this to search in leaf cat.
        }else{
            newList = history.get(history.size() - 1).get(position).getSubcategories();
            currentCatId = history.get(history.size() - 1).get(position).getNumber();
            history.add(newList);
            return newList;
        }
    }

    public List<Category> moveDown() {
        if(history.size() == 2){
            history.remove(history.size() - 1);
            return history.get(0);
        }else{
            ArrayList<Category> newList = (ArrayList<Category>) history.get(history.size() - 2);
            history.remove(history.size() - 1);
            return newList;
        }
    }

    public int getHistorySize() {
        return history.size();
    }

    public String getCurrentCategoryId(){
        return currentCatId;
    }
}
