package com.example.rharper.trademetestapp;

import android.util.Log;
import com.example.rharper.trademetestapp.models.Category;
import java.util.ArrayList;
import java.util.List;

public class CategoryNavigator {

    private ArrayList<Category> originalTree = new ArrayList<>();
    private ArrayList<Category> workingTree;
    private ArrayList<List<Category>> history = new ArrayList<>();

    public CategoryNavigator(ArrayList<Category> workingTree) {
        this.workingTree = workingTree;
        originalTree.addAll(workingTree);
    }

    public List<Category> moveUp(int position){
        if (history.size() == 0){
            List<Category> newList = workingTree.get(position).getSubcategories();
            history.add(newList);
            return workingTree.get(position).getSubcategories();
        }else if (history.get(history.size() -1).get(position).isIsLeaf()){
            Log.v("This is a leaf! ", "Yes.");
            return history.get(history.size() -1);
            // TODO: change this to search in leaf cat.
        }else{
            List<Category> currentList = history.get(history.size() - 1);
            history.add(currentList.get(position).getSubcategories());
            return currentList.get(position).getSubcategories();
        }
    }

    public List<Category> moveDown() {
        if(history.size() <= 1){
            history.remove(history.size() - 1);
            return originalTree;
        }else{
            ArrayList<Category> newList = (ArrayList<Category>) history.get(history.size() - 2);
            history.remove(history.size() - 1);
            return newList;
        }
    }

    public int getHistorySize() {
        return history.size();
    }
}
