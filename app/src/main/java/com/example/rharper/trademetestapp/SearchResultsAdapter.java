package com.example.rharper.trademetestapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rharper.trademetestapp.models.Listing;
import com.example.rharper.trademetestapp.models.SearchResults;

import java.util.List;

public class SearchResultsAdapter extends RecyclerView.Adapter<SearchResultsAdapter.ViewHolder>{

    private List<Listing> mDataset;
    private static OnRecyclerClickListener recyclerClickListener;


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTitle;
        private ImageView mMainImage;
        private TextView mPrice;

        private ViewHolder(View v) {
            super(v);
            mTitle = itemView.findViewById(R.id.title);
            mMainImage = itemView.findViewById(R.id.mainPhoto);
            mPrice = itemView.findViewById(R.id.price);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            recyclerClickListener.onRecyclerItemClick(getAdapterPosition(), view);
        }
    }

    public SearchResultsAdapter(List myDataset) {
        mDataset = myDataset;
    }

    public void setRecyclerClickListener(OnRecyclerClickListener clickListener){
        SearchResultsAdapter.recyclerClickListener = clickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_result_list_item, parent, false);
        SearchResultsAdapter.ViewHolder vh = new SearchResultsAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTitle.setText(mDataset.get(position).getTitle());
        holder.mPrice.setText(mDataset.get(position).getStartPrice());
        holder.mMainImage.setImageURI(mDataset.get(position).getPictureHref());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}