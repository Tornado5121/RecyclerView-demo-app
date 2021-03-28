package com.example.recyclerviewtesting.adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.recyclerviewtesting.R;
import com.example.recyclerviewtesting.VideoDetailedItem;

public class VideoItemAdapter extends RecyclerView.Adapter<VideoItemAdapter.MyViewHolder> {

    private String[] mDuration;
    private String[] mProfileName;
    private String[] mViewNumber;
    private String[] mDateCreated;
    private int[] mPlayerView;
    private int[] mProfileView;
    private int[] mDotsMenu;
    private Context context;


    public VideoItemAdapter(Context ct, String[] duration, String[] name, String[] viewNumb, String[] dateCreated,
                            int[] playerView, int[] profileView, int[] dotsmenu) {
        context = ct;
        mDuration = duration;
        mProfileName = name;
        mViewNumber = viewNumb;
        mDateCreated = dateCreated;
        mPlayerView = playerView;
        mProfileView = profileView;
        mDotsMenu = dotsmenu;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.video_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.time.setText(mDuration[position]);
        holder.profileName.setText(mProfileName[position]);
        holder.viewNumber.setText(mViewNumber[position]);
        holder.dateCreated.setText(mDateCreated[position]);
//        holder.playerView.setImageResource(mPlayerView[position]);
        holder.profileView.setImageResource(mProfileView[position]);
        holder.dotsMenu.setImageResource(mDotsMenu[position]);

        holder.dotsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Hello World", Toast.LENGTH_LONG).show();
            }
        });

        holder.clickItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, VideoDetailedItem.class);
//                intent.putExtra("mName", mName[position]);
//                intent.putExtra("mAuth", mAuth[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView time, profileName, viewNumber, dateCreated;
        ImageView profileView, dotsMenu;
        RelativeLayout clickItem;
        VideoView playerView;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);

            time = itemView.findViewById(R.id.duration_view);
            profileName = itemView.findViewById(R.id.profile_name);
            viewNumber = itemView.findViewById(R.id.view_number);
            dateCreated = itemView.findViewById(R.id.date_created);
            playerView = itemView.findViewById(R.id.player_view);
            profileView = itemView.findViewById(R.id.profile_view);
            dotsMenu = itemView.findViewById(R.id.dot_menu);

            clickItem = itemView.findViewById(R.id.LayoutClick);
        }
    }
}