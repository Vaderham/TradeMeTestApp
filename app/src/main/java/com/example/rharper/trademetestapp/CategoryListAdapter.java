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

public class CategoryListAdapter extends RecyclerView.Adapter<CategoryListAdapter.ViewHolder>{

    private List<Category> mDataset;
    private static OnRecyclerClickListener recyclerClickListener;


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTextView;

        private ViewHolder(View v) {
            super(v);
            mTextView = itemView.findViewById(R.id.CatName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            recyclerClickListener.onRecyclerItemClick(getAdapterPosition(), view);
        }
    }

    public CategoryListAdapter(List myDataset) {
        mDataset = myDataset;
    }

    public void setRecyclerClickListener(OnRecyclerClickListener clickListener){
        CategoryListAdapter.recyclerClickListener = clickListener;
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
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}