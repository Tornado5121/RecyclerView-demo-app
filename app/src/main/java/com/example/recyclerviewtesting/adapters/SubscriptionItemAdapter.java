package com.example.recyclerviewtesting.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewtesting.R;

public class SubscriptionItemAdapter extends RecyclerView.Adapter<SubscriptionItemAdapter.MyViewHolder> {

    private String[] mNameArray;
    private int[] mPhotoArray;
    private Context context;


    public SubscriptionItemAdapter(Context ct, String[] nameArray, int[] photoArray) {
        context = ct;
        mNameArray = nameArray;
        mPhotoArray = photoArray;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.subscription_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(mNameArray[position]);
        holder.photo.setImageResource(mPhotoArray[position]);

    }

    @Override
    public int getItemCount() {
        return 9;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView photo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.subscription_name);
            photo = itemView.findViewById(R.id.subscription_photo);
        }
    }
}
