package com.example.recyclerviewtesting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class VideoDetailedItem extends AppCompatActivity {

    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detailed_item);

        textView1 = findViewById(R.id.title_text_view3);
        textView1.setText("Hello,World");

    }
}
