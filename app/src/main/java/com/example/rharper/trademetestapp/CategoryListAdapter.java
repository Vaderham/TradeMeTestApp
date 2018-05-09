package com.example.rharper.trademetestapp;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.rharper.trademetestapp.models.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder> {

    private List<Category> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;

        private ViewHolder(View v) {
            super(v);
            mTextView = itemView.findViewById(R.id.CatName);
        }
    }

    public CategoryListAdapter(List myDataset) {
        mDataset = myDataset;
    }

    @Override
    public CategoryListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset.get(position).getName());
        Log.v("Updating view with: ", mDataset.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}