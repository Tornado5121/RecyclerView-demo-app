package com.example.recyclerviewtesting.adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewtesting.R;


public class CategoryItemAdapter extends RecyclerView.Adapter<CategoryItemAdapter.MyViewHolder> {

    private int[] mIcons;
    private int[] mBgs;
    private String[] mName;
    private Context context;


    public CategoryItemAdapter(Context ct, int[] icons, int[] bgs, String[] name) {
        mIcons = icons;
        mBgs = bgs;
        mName = name;
        context = ct;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.category_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bg.setImageResource(mBgs[position]);
        holder.icon.setImageResource(mIcons[position]);
        holder.name.setText(mName[position]);
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView bg, icon;
        TextView name;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            bg = itemView.findViewById(R.id.bg_category);
            icon = itemView.findViewById(R.id.icon_category);
            name = itemView.findViewById(R.id.category_name);
        }
    }
}
