package com.example.triphelper.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.triphelper.R;
import com.example.triphelper.struct.ShortDescription;

import java.util.ArrayList;
import java.util.List;

public class ShortDescriptionAdapter extends RecyclerView.Adapter<ShortDesctiptionViewHolder> {
    List<ShortDescription> descriptionList = new ArrayList<>();
    public void setItems(List<ShortDescription> descriptionListCurr) {
        descriptionList.addAll(descriptionListCurr);
        notifyDataSetChanged();
    }

    public void clearItems() {
        descriptionList.clear();
        notifyDataSetChanged();
    }
    @Override
    public ShortDesctiptionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.short_decription_layout, parent, false);
        return new ShortDesctiptionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShortDesctiptionViewHolder holder, int position) {
        holder.bind(descriptionList.get(position));
    }

    @Override
    public int getItemCount() {
        return descriptionList.size();
    }
}
