package com.example.rharper.trademetestapp;

import android.util.Log;
import android.widget.Toast;

import com.example.rharper.trademetestapp.models.Category;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class CategoryNavigator {

    private List<List<Category>> history = new ArrayList<>();
    private Stack<String> currentCatId = new Stack<>();

    public CategoryNavigator(ArrayList<Category> Tree) {
        ArrayList<Category> originalTree = new ArrayList(Tree);
        currentCatId.push("0");
        history.add(originalTree);
    }

    public List<Category> moveUp(int position){
        List<Category> newList;
        if (history.get(history.size() -1).get(position).isIsLeaf()){
            Log.v("This is a leaf! ", "Yes.");
            return history.get(history.size() -1);
            // TODO: change this to search in leaf cat.
        }else{
            currentCatId.push(history.get(history.size() - 1).get(position).getNumber());
            newList = history.get(history.size() - 1).get(position).getSubcategories();
            history.add(newList);
            return newList;
        }
    }

    public List<Category> moveDown() {
        if(history.size() == 2){
            currentCatId.pop();
            history.remove(history.size() - 1);
            return history.get(0);
        }else{
            currentCatId.pop();
            ArrayList<Category> newList = (ArrayList<Category>) history.get(history.size() - 2);
            history.remove(history.size() - 1);
            return newList;
        }
    }

    public int getHistorySize() {
        return history.size();
    }

    public String getCurrentCategoryId(){
        return currentCatId.peek();
    }
}